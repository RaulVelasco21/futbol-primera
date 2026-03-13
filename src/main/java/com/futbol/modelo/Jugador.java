package com.futbol.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "jugadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String posicion;

    private int dorsal;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;
}