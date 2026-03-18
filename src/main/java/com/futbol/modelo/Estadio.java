package com.futbol.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Table(name = "estadios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "La ciudad no puede estar vacía")
    @Column(nullable = false)
    private String ciudad;

    @Positive(message = "La capacidad debe ser un número positivo")
    private int capacidad;
}