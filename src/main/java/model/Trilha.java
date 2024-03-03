package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.StatusEnum;

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