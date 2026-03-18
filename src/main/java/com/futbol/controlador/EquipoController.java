package com.futbol.controlador;

import com.futbol.modelo.Equipo;
import com.futbol.servicio.EquipoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@Tag(name = "Equipos", description = "Operaciones sobre los equipos de la liga")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @Operation(summary = "Listar todos los equipos", description = "Devuelve la lista completa de equipos de la liga")
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public List<Equipo> listarTodos() {
        return equipoService.listarTodos();
    }

    @Operation(summary = "Buscar equipo por ID", description = "Devuelve un equipo a partir de su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipo encontrado"),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Equipo> buscarPorId(
            @Parameter(description = "ID del equipo", required = true) @PathVariable Long id) {
        return equipoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un equipo", description = "Crea un nuevo equipo en la liga")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Equipo creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Equipo crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del equipo a crear", required = true)
            @RequestBody Equipo equipo) {
        return equipoService.crear(equipo);
    }

    @Operation(summary = "Eliminar un equipo", description = "Elimina un equipo por su ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Equipo eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Equipo no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "ID del equipo a eliminar", required = true) @PathVariable Long id) {
        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar equipos por ciudad", description = "Devuelve todos los equipos de una ciudad")
    @ApiResponse(responseCode = "200", description = "Lista de equipos en esa ciudad")
    @GetMapping("/ciudad/{ciudad}")
    public List<Equipo> buscarPorCiudad(
            @Parameter(description = "Nombre de la ciudad", required = true) @PathVariable String ciudad) {
        return equipoService.buscarPorCiudad(ciudad);
    }
}