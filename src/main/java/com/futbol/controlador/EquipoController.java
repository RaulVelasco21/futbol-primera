package com.futbol.controlador;

import com.futbol.modelo.Equipo;
import com.futbol.servicio.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> listarTodos() {
        return equipoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarPorId(@PathVariable Long id) {
        return equipoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Equipo crear(@RequestBody Equipo equipo) {
        return equipoService.crear(equipo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Equipo> buscarPorCiudad(@PathVariable String ciudad) {
        return equipoService.buscarPorCiudad(ciudad);
    }
}
