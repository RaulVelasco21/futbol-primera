package com.futbol.servicio;

import com.futbol.modelo.Estadio;
import com.futbol.repositorio.EstadioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadioService {

    private final EstadioRepository estadioRepository;

    public EstadioService(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    public List<Estadio> listarTodos() {
        return estadioRepository.findAll();
    }

    public Optional<Estadio> buscarPorId(Long id) {
        return estadioRepository.findById(id);
    }

    public Estadio crear(Estadio estadio) {
        return estadioRepository.save(estadio);
    }

    public void eliminar(Long id) {
        estadioRepository.deleteById(id);
    }
}