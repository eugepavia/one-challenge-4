package com.eugepavia.challenge4.domain.model;

import com.eugepavia.challenge4.infra.service.ValidaDatosException;

// Clase Enumerated para el curso al que corresponden los tópicos

public enum Curso {
    HTTP("HTTP en la web"),
    JAVA("Introducción a Java"),
    SPRING("Springboot Framework"),
    JAVASCRIPT("POO con Javascript"),
    HTML_CSS("HTML y CSS en la web"),
    LOGICA_PROGRAMACION("Lógica de programación"),
    BUENAS_PRACTICAS("Buenas prácticas"),
    OTROS("Otros");

    private String tituloCompleto;

    // CONSTRUCTORES
    Curso(String tituloCompleto) {
        this.tituloCompleto = tituloCompleto;
    }

    // Método para convertir el nombre del curso "tituloCompleto" a objeto Enum Curso
    public static Curso fromTitulo(String texto) {
        for (Curso curso : Curso.values()) {
            if (curso.tituloCompleto.equalsIgnoreCase(texto)) {
                return curso;
            }
        }
        String mensaje = """
                Curso no válido. Ingresar una de las siguientes opciones:
                - HTTP en la web
                - Introducción a Java
                - Springboot Framework
                - POO con Javascript
                - HTML y CSS en la web
                - Lógica de programación
                - Buenas prácticas
                - Otros""";
        throw new ValidaDatosException(mensaje);
    }

    // GETTERS
    public String getTituloCompleto() {
        return tituloCompleto;
    }
}
