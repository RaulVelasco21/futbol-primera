package com.futbol.servicio;

import com.futbol.modelo.Partido;
import com.futbol.repositorio.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {

    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> listarTodos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> buscarPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public Partido crear(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void eliminar(Long id) {
        partidoRepository.deleteById(id);
    }

    public List<Partido> buscarPorEquipoLocal(Long equipoId) {
        return partidoRepository.findByEquipoLocalId(equipoId);
    }

    public List<Partido> buscarPorEquipoVisitante(Long equipoId) {
        return partidoRepository.findByEquipoVisitanteId(equipoId);
    }
}
