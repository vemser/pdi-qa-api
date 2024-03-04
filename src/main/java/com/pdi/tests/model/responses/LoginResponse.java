package com.pdi.tests.model.responses;

import lombok.Data;
import com.pdi.tests.model.Login;

@Data
public class LoginResponse extends Login {
    private String token;
}
