package com.politecnicosYfuriosos.Politecnicos_y_furiosos.Dto.Conductor;

import com.fasterxml.jackson.annotation.JsonProperty; // <-- IMPORTA ESTO

public class SuscripcionDTO {

    private Integer clienteId;

    // --- ESTA ES LA CLAVE ---
    // Le decimos a Spring: "Cuando veas 'clienteId' en el JSON,
    // pon ese valor en ESTE campo (clienteId)".
    @JsonProperty("clienteId")
    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    // El getter normal
    public Integer getClienteId() {
        return clienteId;
    }
}