-- ===== ESTADIOS (sin foreign keys, van primero) =====
INSERT INTO estadios (nombre, ciudad, capacidad) VALUES
('Santiago Bernabéu', 'Madrid', 81000),
('Camp Nou', 'Barcelona', 99000),
('Metropolitano', 'Madrid', 68000),
('Ramón Sánchez-Pizjuán', 'Sevilla', 43000);

-- ===== EQUIPOS (dependen de estadios) =====
INSERT INTO equipos (nombre, ciudad, estadio_id) VALUES
('Real Madrid', 'Madrid', 1),
('FC Barcelona', 'Barcelona', 2),
('Atlético de Madrid', 'Madrid', 3),
('Sevilla FC', 'Sevilla', 4);

-- ===== JUGADORES (dependen de equipos) =====
INSERT INTO jugadores (nombre, posicion, dorsal, equipo_id) VALUES
('Vinicius Jr', 'Delantero', 7, 1),
('Bellingham', 'Centrocampista', 5, 1),
('Lamine Yamal', 'Delantero', 19, 2),
('Pedri', 'Centrocampista', 8, 2),
('Griezmann', 'Delantero', 7, 3),
('Koke', 'Centrocampista', 6, 3),
('Lukebakio', 'Delantero', 11, 4),
('Saúl', 'Centrocampista', 8, 4);

-- ===== PARTIDOS (dependen de equipos y estadios) =====
INSERT INTO partidos (fecha, equipo_local_id, equipo_visitante_id, estadio_id, goles_local, goles_visitante) VALUES
('2024-10-26T21:00:00', 1, 2, 1, 2, 1),
('2024-11-10T18:30:00', 3, 1, 3, 1, 1),
('2024-11-24T16:15:00', 2, 3, 2, 3, 0),
('2024-12-07T21:00:00', 4, 1, 4, 0, 2);