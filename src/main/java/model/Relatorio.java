package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relatorio {
    public String nomeEstagiario;
    public String linkedin;
    public String nomeTrilha;
    public String nomePrograma;
    public ArrayList<Modulo> modulos;
    public ArrayList<Feedback> feedbacks;
}