package com.futbol.controlador;

import com.futbol.modelo.Jugador;
import com.futbol.servicio.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@Tag(name = "Jugadores", description = "Operaciones sobre los jugadores de la liga")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @Operation(summary = "Listar todos los jugadores", description = "Devuelve la lista completa de jugadores de la liga")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public List<Jugador> listarTodos() {
        return jugadorService.listarTodos();
    }

    @Operation(summary = "Buscar jugador por ID", description = "Devuelve un jugador a partir de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Jugador encontrado"),
            @ApiResponse(responseCode = "404", description = "Jugador no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Jugador> buscarPorId(
            @Parameter(description = "ID del jugador", required = true) @PathVariable Long id) {
        return jugadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un jugador", description = "Crea un nuevo jugador en la liga")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Jugador creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Jugador crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del jugador a crear", required = true)
            @RequestBody Jugador jugador) {
        return jugadorService.crear(jugador);
    }

    @Operation(summary = "Eliminar un jugador", description = "Elimina un jugador por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Jugador eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Jugador no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del jugador a eliminar", required = true) @PathVariable Long id) {
        jugadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar jugadores por equipo", description = "Devuelve todos los jugadores de un equipo")
    @ApiResponse(responseCode = "200", description = "Lista de jugadores del equipo")
    @GetMapping("/equipo/{equipoId}")
    public List<Jugador> buscarPorEquipo(
            @Parameter(description = "ID del equipo", required = true) @PathVariable Long equipoId) {
        return jugadorService.buscarPorEquipo(equipoId);
    }

    @Operation(summary = "Buscar jugadores por posición", description = "Devuelve todos los jugadores de una posición (Portero, Defensa, Centrocampista, Delantero)")
    @ApiResponse(responseCode = "200", description = "Lista de jugadores en esa posición")
    @GetMapping("/posicion/{posicion}")
    public List<Jugador> buscarPorPosicion(
            @Parameter(description = "Posición del jugador", required = true, example = "Delantero") @PathVariable String posicion) {
        return jugadorService.buscarPorPosicion(posicion);
    }
}