package com.futbol.modelo;

import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ciudad;

    private int capacidad;
}
