package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.Catalogo;

import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Buscar cliente por nombre de usuario
    Optional<Cliente> findByUsuario(String usuario);

    // Buscar cliente por usuario y contraseña (uso temporal, mejor reemplazar por autenticación segura)
    Optional<Cliente> findByUsuarioAndContrasena(String usuario, String contrasena);

    // Verificar si un usuario ya existe (para evitar duplicados)
    boolean existsByUsuario(String usuario);
}
