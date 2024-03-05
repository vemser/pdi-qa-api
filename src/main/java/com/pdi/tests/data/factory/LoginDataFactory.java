package com.pdi.tests.data.factory;

import com.github.javafaker.Faker;
import com.pdi.tests.model.Login;
import com.pdi.tests.utils.Manipulation;

import java.util.Locale;
import java.util.Properties;

public class LoginDataFactory {
    private static final Properties props = Manipulation.getProp();
    private static final Faker faker = new Faker(new Locale("pt-BR"));

    public LoginDataFactory() {}

    public static Login dadosAdmin() {
        return new Login(props.getProperty("USERNAME_ADMIN"), props.getProperty("PASSWORD_ADMIN"));
    }

    public static Login dadosCoordenador() {
        return new Login(props.getProperty("USERNAME_GESTOR"), props.getProperty("PASSWORD_GESTOR"));
    }

    public static Login dadosInstrutor() {
        return new Login(props.getProperty("USERNAME_INSTRUTOR"), props.getProperty("PASSWORD_INSTRUTOR"));
    }

    public static Login dadosGP() {
        return new Login(props.getProperty("USERNAME_GP"), props.getProperty("PASSWORD_GP"));
    }

    public static Login dadosColaborador() {
        return new Login(props.getProperty("USERNAME_COLABORADOR"), props.getProperty("PASSWORD_COLABORADOR"));
    }

    public static Login dadosEstagiario() {
        return new Login(props.getProperty("USERNAME_ALUNO"), props.getProperty("PASSWORD_ALUNO"));
    }

    public static Login dadosLoginInvalido() {
        return new Login(faker.name().username(), faker.internet().password());
    }
}
