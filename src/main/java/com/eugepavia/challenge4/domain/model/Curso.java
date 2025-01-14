package com.eugepavia.challenge4.domain.model;

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

    private Curso(String tituloCompleto) {
        this.tituloCompleto = tituloCompleto;
    }

    // Método para convertir el nombre del curso de TopicoEntradaDTO a objeto Enum Curso
    public static Curso fromTitulo(String texto) {
        for (Curso curso : Curso.values()) {
            if (curso.tituloCompleto.equalsIgnoreCase(texto)) {
                return curso;
            }
        }
        return Curso.OTROS;
    }


}