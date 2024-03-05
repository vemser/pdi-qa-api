package com.pdi.tests.functional;

import com.pdi.tests.client.LoginClient;
import com.pdi.tests.data.factory.LoginDataFactory;
import com.pdi.tests.model.responses.ErrorResponse;
import com.pdi.tests.utils.TokenManipulation;
import io.qameta.allure.*;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginFunctionalTest {
    private final LoginClient loginClient = new LoginClient();
    private final LoginDataFactory loginDataFactory = new LoginDataFactory();

    @Test
    @Epic("Login")
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar login simples - ADMIN")
    public void testASimpleValidLoginLikeAdmin() {
        var admin = loginDataFactory.dadosAdmin();

        var tokenGenerated  = loginClient.login(admin)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().asString()
                ;

        var isTheExpectedRole = TokenManipulation.isTheExpectedRole(tokenGenerated, "ROLE_ADMIN");

        Assertions.assertNotNull(tokenGenerated);
        Assertions.assertTrue(isTheExpectedRole);

        // TODO: implementar futuramente em todos os testes um logout para invalidar o token e não estourar a sessão por tipo de usuário
    }

    @Test
    @Epic("Login")
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar login simples - GESTOR")
    public void testASimpleValidLoginLikeGestor() {
        var gestor = LoginDataFactory.dadosCoordenador();

        var tokenGenerated = loginClient.login(gestor)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().asString()
                ;

        var isTheExpectedRole = TokenManipulation.isTheExpectedRole(tokenGenerated, "ROLE_GESTOR");

        Assertions.assertNotNull(tokenGenerated);
        Assertions.assertTrue(isTheExpectedRole);
    }

    @Test
    @Epic("Login")
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar login simples - INSTRUTOR")
    public void testASimpleValidLoginLikeInstrutor() {
        var instrutor = LoginDataFactory.dadosInstrutor();

        var tokenGenerated = loginClient.login(instrutor)
                .then()
                .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().asString()
                ;

        var isTheExpectedRole = TokenManipulation.isTheExpectedRole(tokenGenerated, "ROLE_INSTRUTOR");

        Assertions.assertNotNull(tokenGenerated);
        Assertions.assertTrue(isTheExpectedRole);
    }

    @Test
    @Epic("Login")
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar login simples - GP")
    public void testASimpleValidLoginLikeGP() {
        var gp = LoginDataFactory.dadosGP();

        var tokenGenerated = loginClient.login(gp)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().asString()
                ;

        var isTheExpectedRole = TokenManipulation.isTheExpectedRole(tokenGenerated, "ROLE_GESTAO_DE_PESSOAS");

        Assertions.assertNotNull(tokenGenerated);
        Assertions.assertTrue(isTheExpectedRole);
    }

    @Test
    @Epic("Login")
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar login simples - COLABORADOR")
    public void testASimpleValidLoginLikeColaborador() {
        var colaborador = LoginDataFactory.dadosColaborador();

        var tokenGenerated = loginClient.login(colaborador)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().asString()
                ;

        var isTheExpectedRole = TokenManipulation.isTheExpectedRole(tokenGenerated, "ROLE_COLABORADOR");

        Assertions.assertNotNull(tokenGenerated);
        Assertions.assertTrue(isTheExpectedRole);
    }

    @Test
    @Epic("Login")
    @Severity(SeverityLevel.CRITICAL)
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @DisplayName("Validar login simples - ALUNO/ESTAGIÁRIO")
    public void testASimpleValidLoginLikeAluno() {
        var aluno = LoginDataFactory.dadosEstagiario();

        var tokenGenerated = loginClient.login(aluno)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().asString()
                ;

        var isTheExpectedRole = TokenManipulation.isTheExpectedRole(tokenGenerated, "ROLE_ALUNO");

        Assertions.assertNotNull(tokenGenerated);
        Assertions.assertTrue(isTheExpectedRole);
    }

    @Test
    @Epic("Login")
    @Story("US002 - Login")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Realizar login com dados inválidos")
    public void testAInvalidLogin() {
        var loginInvalido = LoginDataFactory.dadosLoginInvalido();

        ErrorResponse loginResponse = loginClient.login(loginInvalido)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract().as(ErrorResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertEquals("login e senha inválidos!", loginResponse.errors.get(0)),
                () -> Assertions.assertEquals(400, loginResponse.status)
        );
    }
}
