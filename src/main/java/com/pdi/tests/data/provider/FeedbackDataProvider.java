package com.pdi.tests.data.provider;

import com.github.javafaker.Faker;
import com.pdi.tests.data.factory.FeedbackDataFactory;
import com.pdi.tests.model.Feedback;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Locale;
import java.util.stream.Stream;

public class FeedbackDataProvider {
    private static Faker faker = new Faker(new Locale("PT-BR"));

    /**
     * Gera a massa de dados para o cadastro de um produto com valores válidos
     *
     * @return Stream<Arguments>
     */
    static Stream<Arguments> feedbackValidoDataProvider() {
        return Stream.of(
                Arguments.of(FeedbackDataFactory.feedbackValido()),
                Arguments.of(new Feedback(1, "Feedback válido"))
        );
    }

    /**
     * Gera a massa de dados para o cadastro de um produto com valores inválidos
     *
     * @return Stream<Arguments>
     */
    static Stream<Arguments> feedbackInvalidoDataProvider() {
        return Stream.of(
                Arguments.of(FeedbackDataFactory.feedbackComDadosInvalidos()),
                Arguments.of(new Feedback(-10, "Feedback inválido")),
                Arguments.of(new Feedback(1, StringUtils.EMPTY)),
                Arguments.of(new Feedback(1, faker.lorem().characters(256)))
        );
    }

    /**
     * Gera a massa de dados para o cadastro de um produto com valores que
     * ultrapassam os limites (maiores/menores)
     *
     * @return Stream<Arguments>
     */
    static Stream<Arguments> feedbackLimiteDataProvider() {
        return Stream.of(
                Arguments.of(new Feedback(Integer.MIN_VALUE, "Feedback válido")),
                Arguments.of(new Feedback(Integer.MAX_VALUE, "Feedback válido")),
                Arguments.of(new Feedback(1, "Feedback válido")),
                Arguments.of(new Feedback(1,"")),
                Arguments.of(new Feedback(1, faker.lorem().characters(256)))
        );
    }
}
