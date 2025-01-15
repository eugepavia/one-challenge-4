package com.eugepavia.challenge4.domain.model;

public enum Status {
    SIN_RESOLVER("Sin resolver"),
    RESUELTO("Resuelto");

    private String statusCompleto;

    private Status(String statusCompleto) {
        this.statusCompleto = statusCompleto;
    }

    // GETTERS
    public String getStatusCompleto() {
        return statusCompleto;
    }
}
