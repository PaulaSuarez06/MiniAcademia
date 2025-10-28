-- =========================================
-- CREACIÓN DE TABLAS
-- =========================================

CREATE TABLE profesor (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100) NOT NULL,
                          email VARCHAR(150) UNIQUE NOT NULL
);

CREATE TABLE asignatura (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            nombre VARCHAR(100) NOT NULL,
                            curso VARCHAR(50),
                            id_profesor INT,
                            FOREIGN KEY (id_profesor) REFERENCES profesor(id)
);

-- =========================================
-- DATOS DE EJEMPLO
-- =========================================

INSERT INTO profesor (nombre, apellido, email) VALUES
                                                   ('Laura', 'Gómez', 'laura.gomez@instituto.es'),
                                                   ('Carlos', 'Pérez', 'carlos.perez@instituto.es'),
                                                   ('María', 'López', 'maria.lopez@instituto.es');

INSERT INTO asignatura (nombre, curso, id_profesor) VALUES
                                                        ('Programación', '1º DAW', 1),
                                                        ('Bases de Datos', '1º DAW', 1),
                                                        ('Sistemas Informáticos', '1º DAW', 2),
                                                        ('Lenguajes de Marcas', '1º DAW', 3);
