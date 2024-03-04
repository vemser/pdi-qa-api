package com.pdi.tests.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class LoginEcosSpecs {
    public LoginEcosSpecs(){

    }
    public static RequestSpecification loginEcosReqSpecs(){
        return new RequestSpecBuilder()
            .addRequestSpecification(InicialEcosSpecs.setup())
            .setContentType(ContentType.JSON)
            .build();
    }
}
