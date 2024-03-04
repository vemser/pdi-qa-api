package com.pdi.tests.model;

import com.pdi.tests.model.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trilha {
    public Integer idTrilha;
    public String nome;
    public String descricao;
    public StatusEnum status;
    public Boolean ativo;
    public Integer idPrograma;
    public String link;
}