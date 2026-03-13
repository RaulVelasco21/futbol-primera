package com.futbol.repositorio;

import com.futbol.modelo.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {

    List<Estadio> findByNombre(String nombre);

    List<Estadio> findByCiudad(String ciudad);
}