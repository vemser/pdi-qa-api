package com.pdi.tests.model.responses;

import com.pdi.tests.model.Estagiario;

import java.util.ArrayList;

public class EstagiarioResponse extends BaseResponse {
    public Estagiario estagiario;
    public ArrayList<Estagiario> content = new ArrayList<Estagiario>();
}
