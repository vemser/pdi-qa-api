package com.pdi.tests.login;

import client.ExemploLoginClient;
import data.factory.ExemploLoginDataFactory;
import model.Login;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;

public class LoginFuncionalTest {
    ExemploLoginClient loginClient = new ExemploLoginClient();

    @Test
    public void testLogarComSucesso(){
        Login login = ExemploLoginDataFactory.dados();//Instancia um Objeto Login
        loginClient.fazerLogin(login)//given() e when()
            .then()//Response da requisição
                .statusCode(200)//Status code esperado da resposta
                .body("message",equalTo("Login realizado com sucesso"))//Procura no body da response a chave "message" e valida se é igual ao valor dentro de equalTo()
        ;
    }
}
