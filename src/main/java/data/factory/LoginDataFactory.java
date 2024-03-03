package data.factory;

import model.Login;
import utils.Manipulation;

import java.util.Properties;

public class LoginDataFactory {
    private static final Properties props = Manipulation.getProp();

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
}
