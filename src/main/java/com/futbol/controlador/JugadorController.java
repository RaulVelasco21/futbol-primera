package com.futbol.controlador;

import com.futbol.modelo.Jugador;
import com.futbol.servicio.JugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> listarTodos() {
        return jugadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jugador> buscarPorId(@PathVariable Long id) {
        return jugadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Jugador crear(@RequestBody Jugador jugador) {
        return jugadorService.crear(jugador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        jugadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> buscarPorEquipo(@PathVariable Long equipoId) {
        return jugadorService.buscarPorEquipo(equipoId);
    }

    @GetMapping("/posicion/{posicion}")
    public List<Jugador> buscarPorPosicion(@PathVariable String posicion) {
        return jugadorService.buscarPorPosicion(posicion);
    }
}