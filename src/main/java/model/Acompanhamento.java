package model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.StatusEnum;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Acompanhamento {
    public Integer idAcompanhamento;
    public Integer idEstagiario;
    public String nomeEstagiario;
    public String trilha;
    public String email;
    public String dataInicio;
    public String horarioInicio;
    public String dataFim;
    public String horarioFim;
    public String nome;
    public String titulo;
    public String descricao;
    public Integer duracao;
    public StatusEnum status;
}
