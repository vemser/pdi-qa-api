package model.responses;

import lombok.Data;
import model.Login;

@Data
public class LoginResponse extends Login {
    private String token;
}
