package com.futbol.controlador;

import com.futbol.modelo.Estadio;
import com.futbol.servicio.EstadioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadios")
public class EstadioController {

    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @GetMapping
    public List<Estadio> listarTodos() {
        return estadioService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estadio> buscarPorId(@PathVariable Long id) {
        return estadioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Estadio crear(@RequestBody Estadio estadio) {
        return estadioService.crear(estadio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        estadioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
