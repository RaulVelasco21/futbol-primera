package com.futbol.servicio;

import com.futbol.modelo.Equipo;
import com.futbol.repositorio.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> listarTodos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> buscarPorId(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipo crear(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void eliminar(Long id) {
        equipoRepository.deleteById(id);
    }

    public List<Equipo> buscarPorCiudad(String ciudad) {
        return equipoRepository.findByCiudad(ciudad);
    }
}
