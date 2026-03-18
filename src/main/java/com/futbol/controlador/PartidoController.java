package com.futbol.controlador;

import com.futbol.modelo.Partido;
import com.futbol.servicio.PartidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidos")
@Tag(name = "Partidos", description = "Operaciones sobre los partidos de la temporada 2025/26")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @Operation(summary = "Listar todos los partidos", description = "Devuelve la lista completa de partidos de la temporada")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public List<Partido> listarTodos() {
        return partidoService.listarTodos();
    }

    @Operation(summary = "Buscar partido por ID", description = "Devuelve un partido a partir de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Partido encontrado"),
            @ApiResponse(responseCode = "404", description = "Partido no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Partido> buscarPorId(
            @Parameter(description = "ID del partido", required = true) @PathVariable Long id) {
        return partidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un partido", description = "Registra un nuevo partido en la temporada")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Partido creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Partido crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del partido a crear", required = true)
            @RequestBody Partido partido) {
        return partidoService.crear(partido);
    }

    @Operation(summary = "Eliminar un partido", description = "Elimina un partido por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Partido eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Partido no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del partido a eliminar", required = true) @PathVariable Long id) {
        partidoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar partidos por equipo local", description = "Devuelve todos los partidos en los que un equipo jugó como local")
    @ApiResponse(responseCode = "200", description = "Lista de partidos como local")
    @GetMapping("/local/{equipoId}")
    public List<Partido> buscarPorEquipoLocal(
            @Parameter(description = "ID del equipo local", required = true) @PathVariable Long equipoId) {
        return partidoService.buscarPorEquipoLocal(equipoId);
    }

    @Operation(summary = "Buscar partidos por equipo visitante", description = "Devuelve todos los partidos en los que un equipo jugó como visitante")
    @ApiResponse(responseCode = "200", description = "Lista de partidos como visitante")
    @GetMapping("/visitante/{equipoId}")
    public List<Partido> buscarPorEquipoVisitante(
            @Parameter(description = "ID del equipo visitante", required = true) @PathVariable Long equipoId) {
        return partidoService.buscarPorEquipoVisitante(equipoId);
    }
}