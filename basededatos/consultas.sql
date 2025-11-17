#A. Trigger que, al ingresarse una salida, se deben verificar que se cumplan todas las condiciones requeridas para ese modelo de auto
 delimiter //
create trigger verificar_condicion_para_modelo before insert on trayecto
for each row
begin
	declare cantidad_conductores int;
	declare membresia_cliente int;
	declare membresia_auto int;
    select cliente.membresia, auto.membresia, auto.minimoConductores into membresia_cliente, membresia_auto, cantidad_conductores from reserva join cliente on reserva.id_cliente =cliente.id join auto on auto.id=reserva.id_auto where reserva.id=new.id_reserva;
    
    if membresia_auto>membresia_cliente then
		signal sqlstate '45000'
		set message_text="Error: La membresía del cliente no es suficiente para este modelo de auto1";
    end if;
     if new.cant_conductores<cantidad_conductores then
		signal sqlstate '45000'
		set message_text="Error: La cantidad de conductores es menor a la requerida";
    end if;
    
end//
delimiter ; 	


#B Trigger que, al ingresarse un auto en aleras cambie el esatdo d las reservas activAs de ese auto 
delimiter //
create trigger cancelar_reserva_si_alerta after insert on alerta for each row
begin

update reserva set estado="EN ALERTA" where reserva.id = new.reserva_id;

end//
delimiter ;

#c. Procedimiento que, dado un auto y una fecha, determine si el auto estará disponible o no.
delimiter //

create procedure verificar_disponibilidad_auto(
    in p_id_auto int,
    in p_fecha date
)
begin
    declare v_estado varchar(20);
    
    -- Verificar si el auto está disponible
    if exists(
        select 1 from auto 
        where id = p_id_auto 
        and disponible = 1
        and not exists (
            select 1 from reserva 
            where id_auto = p_id_auto 
            and estado in ('PENDIENTE', 'CONFIRMADA')
            and p_fecha between fecha_inicio and fecha_fin
        )
    ) then
        set v_estado = 'DISPONIBLE';
    else
        set v_estado = 'NO DISPONIBLE';
    end if;
    
    select v_estado as estado;
end//

delimiter ;

#D, Procedimiento que devuelve la cantidad de reservas que tuvo cada modelo en un rango d fechas
delimiter //
create procedure cantidad_reservas_entre_fechas (in f_menor date, in f_mayor date)
begin

select auto.modelo, count(*)  from reserva join auto on id_auto=auto.id where fecha_inicio<=f_mayor and fecha_fin >= f_menor group by auto.modelo;

end//
delimiter ; 	



#e. Evento que, cada mes, elimine a los conductores que hace más de 6 meses que no 
#registran entradas y salidas.

delimiter //

create event eliminar_conductores_inactivos 
on schedule every 1 month
starts current_timestamp
do
begin
    delete from cliente 
    where id in (select id_cliente from (
	select cliente.id as id_cliente, max(reserva.fecha_inicio) as ultima_reserva from cliente left join
    reserva on cliente.id = reserva.id_cliente group by cliente.id having  ultima_reserva < date_sub(current_date(), interval 6 month)) as sub);
end//

delimiter ;


#F Evento que consulte autos que salieron, pero no han vuelto en 24 horas y los registre en una tabla alertas.
delimiter //
create event no_han_vuelto_en_24hs on schedule every 1 day starts now() do
begin
	insert into alerta (idreserva,estado) select reserva.id, "no se localiza hace mas de 24hs" from reserva where reserva.estado="CONFIRMADA" and current_date()> date_add(reserva.fecha_fin, interval 1 day) and reserva.id not in (select idreserva from alerta) and reserva.id in (select trayacto.id_reserva from trayecto);
end//
delimiter ;

