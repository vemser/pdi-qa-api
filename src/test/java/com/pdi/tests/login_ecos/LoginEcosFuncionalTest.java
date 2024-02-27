package com.pdi.tests.login_ecos;

import client.LoginEcosClient;
import data.factory.LoginEcosDataFactory;
import model.Login;
import org.junit.jupiter.api.Test;

public class LoginEcosFuncionalTest {
    LoginEcosClient loginEcosClient = new LoginEcosClient();
    @Test
    public void logarEcosComoAdminComSucesso(){
        Login loginAdmin = LoginEcosDataFactory.dadosAdmin();
        loginEcosClient.fazerLogin(loginAdmin)
            .then()
                .statusCode(200)
            ;
    }
}
