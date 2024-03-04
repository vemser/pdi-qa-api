package com.pdi.tests.model.responses;

import com.pdi.tests.model.Acompanhamento;

import java.util.ArrayList;

public class AcompanhamentoResponse extends BaseResponse {

    public Acompanhamento acompanhamento;
    public ArrayList<Acompanhamento> content = new ArrayList<Acompanhamento>();
}
