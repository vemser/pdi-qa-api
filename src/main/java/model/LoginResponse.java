package model;

import lombok.Data;

@Data
public class LoginResponse extends Login{
    private String message;
    private String authorization;
}
