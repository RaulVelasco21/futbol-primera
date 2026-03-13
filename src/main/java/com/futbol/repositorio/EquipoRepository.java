package com.futbol.repositorio;

import com.futbol.modelo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    List<Equipo> findByNombre(String nombre);

    List<Equipo> findByCiudad(String ciudad);
}
