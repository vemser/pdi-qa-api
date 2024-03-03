package data.factory;

import com.github.javafaker.Faker;
import model.Acompanhamento;
import model.enums.StatusEnum;

import java.util.Locale;
import java.util.Random;

public class AcompanhamentoDataFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static Random generateRandom = new Random();

    public static Acompanhamento acompanhamento(boolean wrongObject) {
        Acompanhamento acompanhamento = new Acompanhamento();

        if(!wrongObject) {
            acompanhamento.setIdAcompanhamento(-1);
            acompanhamento.setIdEstagiario(-1);
            acompanhamento.setNomeEstagiario("");
            acompanhamento.setTrilha("");
            acompanhamento.setEmail("");
            acompanhamento.setDataInicio("");
            acompanhamento.setDataFim("");
            acompanhamento.setStatus(StatusEnum.ABERTO);
            acompanhamento.setNome("");
            acompanhamento.setTitulo("");
            acompanhamento.setHorarioInicio("");
            acompanhamento.setHorarioFim("");
            acompanhamento.setDuracao(1);
            acompanhamento.setDescricao("");
        }

        // TODO: objeto mock para testes (tornar dinâmico futuramente)
        acompanhamento.setIdAcompanhamento(1);
        acompanhamento.setIdEstagiario(1);
        acompanhamento.setNomeEstagiario("João Melo Almeida de socorro br");
        acompanhamento.setTrilha("Frontend");
        acompanhamento.setEmail("joaomelo@dbccompany.com.br");
        acompanhamento.setDataInicio("2024-04-25");
        acompanhamento.setDataFim("2024-05-02");
        acompanhamento.setStatus(StatusEnum.FECHADO);
        acompanhamento.setNome("VemSer 12");
        acompanhamento.setTitulo("acompanhamento teste");
        acompanhamento.setHorarioInicio("10:00:00");
        acompanhamento.setHorarioFim("20:00:00");
        acompanhamento.setDuracao(10);
        acompanhamento.setDescricao("acompanhamento pontual");

        return acompanhamento;
    }
}
