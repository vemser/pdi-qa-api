package com.pdi.tests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.pdi.tests.model.enums.StatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Modulo {
    public Integer id;
    public Integer idTrilha;
    public String nome;
    public String descricao;
    public StatusEnum status;
    public boolean ativo;
    public Feedback feedback;
}
