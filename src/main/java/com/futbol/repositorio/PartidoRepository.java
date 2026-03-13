package com.futbol.repositorio;

import com.futbol.modelo.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {

    List<Partido> findByEquipoLocalId(Long equipoId);

    List<Partido> findByEquipoVisitanteId(Long equipoId);

    List<Partido> findByEstadioId(Long estadioId);
}