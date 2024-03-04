package com.pdi.tests.model.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstagiarioTrilhaResponse {
    public int idAgrupamento;
    public String programa;
    public String trilha;
    public int quantidade;
}