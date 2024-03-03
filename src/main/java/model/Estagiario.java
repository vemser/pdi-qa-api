package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.StatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estagiario {
    public Integer idEstagiario;
    public String nome;
    public String trilha;
    public String email;
    public String programa;
    public StatusEnum status;
}