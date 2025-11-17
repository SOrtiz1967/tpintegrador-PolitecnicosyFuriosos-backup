package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Repository.ModeloAutorizado;


import com.politecnicosYfuriosos.Politecnicos_y_furiosos.Modelo.ModeloAutorizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloAutorizadoRepository extends JpaRepository<ModeloAutorizado, Long> {
}
