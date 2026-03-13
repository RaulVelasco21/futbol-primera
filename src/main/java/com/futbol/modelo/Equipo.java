package com.futbol.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "equipos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String ciudad;

    @OneToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;
}