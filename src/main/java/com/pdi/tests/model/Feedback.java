package com.pdi.tests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
    public Integer idFeedbackModulo;
    public Integer idEstagiario;
    public Integer idInstrutor;
    public Integer idModulo;
    public String feedback;
}
