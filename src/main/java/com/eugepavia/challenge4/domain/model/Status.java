package com.eugepavia.challenge4.domain.model;

import com.eugepavia.challenge4.infra.service.ValidaDatosException;

// Clase Enumerated para el status de resolución de los tópicos

public enum Status {
    SIN_RESOLVER("Sin resolver"),
    RESUELTO("Resuelto");

    private String statusCompleto;


    // CONSTRUCTORES
    Status(String statusCompleto) {
        this.statusCompleto = statusCompleto;
    }

    // Método para convertir el status "statusCompleto" a objeto Enum Status
    public static Status fromStatus(String texto) {
        for (Status status : Status.values()) {
            if (status.statusCompleto.equalsIgnoreCase(texto)) {
                return status;
            }
        }
        String mensaje = """
                Status no válido. Ingresar una de las siguientes opciones:
                - Sin resolver
                - Resuelto""";
        throw new ValidaDatosException("Status no válido");
    }


    // GETTERS
    public String getStatusCompleto() {
        return statusCompleto;
    }
}
