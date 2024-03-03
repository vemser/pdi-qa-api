package model.responses;

import model.Acompanhamento;

import java.util.ArrayList;

public class AcompanhamentoResponse extends BaseResponse {

    public Acompanhamento acompanhamento;
    public ArrayList<Acompanhamento> content = new ArrayList<Acompanhamento>();
}
