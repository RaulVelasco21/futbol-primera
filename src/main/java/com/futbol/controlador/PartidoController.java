package com.futbol.controlador;

import com.futbol.modelo.Partido;
import com.futbol.servicio.PartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public List<Partido> listarTodos() {
        return partidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partido> buscarPorId(@PathVariable Long id) {
        return partidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Partido crear(@RequestBody Partido partido) {
        return partidoService.crear(partido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        partidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/local/{equipoId}")
    public List<Partido> buscarPorEquipoLocal(@PathVariable Long equipoId) {
        return partidoService.buscarPorEquipoLocal(equipoId);
    }

    @GetMapping("/visitante/{equipoId}")
    public List<Partido> buscarPorEquipoVisitante(@PathVariable Long equipoId) {
        return partidoService.buscarPorEquipoVisitante(equipoId);
    }
}