package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ExemploSpecs {
    private ExemploSpecs(){
    }
    public static RequestSpecification exemploReqSpecs(){
        return new RequestSpecBuilder()
            .addRequestSpecification(InicialExemploSpecs.setup()) //merge das especificacoes do InicialExemploSpecs
            .setContentType(ContentType.JSON)// especifica o tipo de requisição (JSON)
            .build();
    }
}
