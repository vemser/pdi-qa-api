package com.pdi.tests.contract;

import com.pdi.tests.client.LoginClient;
import com.pdi.tests.data.factory.LoginDataFactory;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginContractTest {
    private final LoginClient loginClient = new LoginClient();

    @Test
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Bruno Moraes Scarpari")
    @Story("US002 - Login")
    @DisplayName("Validar login simples - ADMIN")
    public void testASimpleValidLoginLikeColaborador() {
        var colaborador = LoginDataFactory.dadosColaborador();

        var tokenGenerated = loginClient.login(colaborador)
                .then()
                .log().body()
                .assertThat().statusCode(HttpStatus.SC_OK)
                .extract().asString()
                ;

        Assertions.assertNotNull(tokenGenerated);
    }


    @Test
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Bruno Moraes Scarpari")
    @Story("US002 - Login")
    @DisplayName("Validar o contrato de login com dados inválidos")
    public void testAInvalidLoginContract() {
        var loginInvalido = LoginDataFactory.dadosLoginInvalido();

       loginClient.login(loginInvalido)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/login/login_invalido.json"))
                ;
    }
}
