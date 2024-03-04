package com.pdi.tests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstagiarioPorTrilha {
    public Integer idAgrupamento;
    public String programa;
    public String trilha;
    public Integer quantidade;
}
