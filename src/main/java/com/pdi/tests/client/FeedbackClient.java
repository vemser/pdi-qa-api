package com.pdi.tests.client;

import com.pdi.tests.model.Feedback;
import com.pdi.tests.specs.InitialPDISpecs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FeedbackClient {
    private static final String PATH = "/api/pdi/v1/feedback-modulo";
    private static final String ID = "/{id}";

    public FeedbackClient() {}

    // TODO: implementar futuramente método de listar todos os feedbacks
    public Response searchAll() {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                .when()
                        .get(PATH)
                ;
    }

    public Response addFeedback(Feedback feedback) {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                        .body(feedback)
                .when()
                        .post(PATH)
                ;
    }

    public Response updateFeedback(String id) {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                        .pathParam("id", id)
                .when()
                        .put(PATH + ID)
                ;
    }

    public Response deleteFeedback(String id) {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                        .pathParam("id", id)
                .when()
                        .delete(PATH + ID)
                ;
    }
}
