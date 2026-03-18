package com.futbol.controlador;

import com.futbol.modelo.Estadio;
import com.futbol.servicio.EstadioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadios")
@Tag(name = "Estadios", description = "Operaciones sobre los estadios de la liga")
public class EstadioController {

    private final EstadioService estadioService;

    public EstadioController(EstadioService estadioService) {
        this.estadioService = estadioService;
    }

    @Operation(summary = "Listar todos los estadios", description = "Devuelve la lista completa de estadios")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public List<Estadio> listarTodos() {
        return estadioService.listarTodos();
    }

    @Operation(summary = "Buscar estadio por ID", description = "Devuelve un estadio a partir de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estadio encontrado"),
            @ApiResponse(responseCode = "404", description = "Estadio no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Estadio> buscarPorId(
            @Parameter(description = "ID del estadio", required = true) @PathVariable Long id) {
        return estadioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un estadio", description = "Crea un nuevo estadio")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Estadio creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Estadio crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del estadio a crear", required = true)
            @RequestBody Estadio estadio) {
        return estadioService.crear(estadio);
    }

    @Operation(summary = "Eliminar un estadio", description = "Elimina un estadio por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Estadio eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Estadio no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del estadio a eliminar", required = true) @PathVariable Long id) {
        estadioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}