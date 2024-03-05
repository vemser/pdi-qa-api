package com.pdi.tests.data.factory;

import com.github.javafaker.Faker;
import com.pdi.tests.model.Feedback;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Random;

public class FeedbackDataFactory {
    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static Random generateRandom = new Random();

    public FeedbackDataFactory() {}

    public static Feedback feedbackValido() {
        return createNewFeedback(false);
    }

    public static Feedback feedbackComDadosInvalidos() {
        return createNewFeedback(true);
    }

    private static Feedback createNewFeedback(boolean wrongObject) {
        // TODO: futuramente implementar um fluxo completo e automatizado:
        // ou seja, que cria um estágiário mockado somente para um feedback
        Feedback feedback = new Feedback();

        if (wrongObject) {
            feedback.setId(generateRandom.nextInt(-10, -1));
            feedback.setFeedback(StringUtils.EMPTY);
        } else {
            feedback.setId(generateRandom.nextInt(1, 10));
            feedback.setFeedback(faker.lorem().characters(50));
        }

        return feedback;
    }
}
