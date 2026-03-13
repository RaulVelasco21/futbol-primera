package com.futbol.servicio;

import com.futbol.modelo.Jugador;
import com.futbol.repositorio.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<Jugador> listarTodos() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> buscarPorId(Long id) {
        return jugadorRepository.findById(id);
    }

    public Jugador crear(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void eliminar(Long id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> buscarPorEquipo(Long equipoId) {
        return jugadorRepository.findByEquipoId(equipoId);
    }

    public List<Jugador> buscarPorPosicion(String posicion) {
        return jugadorRepository.findByPosicion(posicion);
    }
}
