CREATE TABLE topicos(

    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(1000),
    fechaCreacion DATETIME NOT NULL,
    status VARCHAR(100) NOT NULL,
    autorId BIGINT NOT NULL,

    PRIMARY KEY (id)

);

CREATE TABLE respuestas(

    id BIGINT NOT NULL AUTO_INCREMENT,
    topico_id BIGINT NOT NULL,
    mensaje VARCHAR(1000),
    fechaCreacion DATETIME NOT NULL,
    autorId BIGINT NOT NULL,

    PRIMARY KEY (id)

);

CREATE TABLE usuarios(

    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    contrasena VARCHAR(300) NOT NULL,

    PRIMARY KEY (id)

);


