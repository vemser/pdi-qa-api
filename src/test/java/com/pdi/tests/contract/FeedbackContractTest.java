package com.pdi.tests.contract;

import com.pdi.tests.client.FeedbackClient;
import com.pdi.tests.data.factory.FeedbackDataFactory;
import com.pdi.tests.model.Feedback;
import com.pdi.tests.model.responses.FeedbackResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FeedbackContractTest {
    private final FeedbackClient feedbackClient = new FeedbackClient();
    private final FeedbackDataFactory feedbackDataFactory = new FeedbackDataFactory();


    // TODO: implementar futuramente método de listar todos os feedbacks
//    @Test
//    @Epic("Feedback")
//    @Owner("Bruno Moraes Scarpari")
//    @DisplayName("Validar contrato do retorno de todos os feedbacks")
//    public void testValidateAValidCaseOfListAllFeedbacksContract() {
//        feedbackClient.searchAll()
//                .then()
//                    .log().body()
//                    .assertThat().statusCode(HttpStatus.SC_OK)
//                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/feedback/listar_feedback.json"))
//                ;
//    }

    @Test
    @Epic("Feedback")
    @Owner("Bruno Moraes Scarpari")
    @DisplayName("Validar contrato do retorno ao adicionar um feedback válido")
    public void testValidateAValidCaseOfAddFeedbackContract() {
        var feedback = feedbackDataFactory.feedbackValido();
        var feedbackId = String.valueOf(feedback.getIdFeedbackModulo());

        feedbackClient.addFeedback(feedback)
                .then()
                    .log().body()
                    //.assertThat().statusCode(HttpStatus.SC_CREATED) // OBS.: boas práticas = retornar 201 futuramente
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/feedback/adicionar_feedback.json"))
                ;

        feedbackClient.deleteFeedback(feedbackId);
    }

    @Test
    @Epic("Feedback")
    @Owner("Bruno Moraes Scarpari")
    @DisplayName("Validar contrato do retorno ao atualizar um feedback válido")
    public void testValidateAValidCaseOfUpdateFeedbackContract() {
        var feedback = feedbackDataFactory.feedbackValido();
        var feedbackId = String.valueOf(feedback.getIdFeedbackModulo());

        feedbackClient.updateFeedback(feedbackId)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/feedback/atualizar_feedback.json"))
                ;

        feedbackClient.deleteFeedback(feedbackId);
    }

    @Test
    @Epic("Feedback")
    @Owner("Bruno Moraes Scarpari")
    @DisplayName("Validar contrato do retorno ao deletar um feedback válido")
    public void testValidateAValidCaseOfDeleteFeedbackContract() {
        Feedback feedback = feedbackDataFactory.feedbackValido();

        System.out.println("feedback: " + feedback.toString());

        FeedbackResponse feedbackResponse = feedbackClient.addFeedback(feedback)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(FeedbackResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(feedbackResponse)
        );

        var feedbackId = String.valueOf(feedbackResponse.feedback.getIdFeedbackModulo());

        feedbackClient.deleteFeedback(feedbackId)
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/feedback/deletar_feedback.json"))
                ;
    }
}
