package org.ait.dogservices.apitests.kennels;

import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllKennelsTest extends TestBaseApi {

    @Test
    public void getAllKennelsSuccessTest(){
        List<KennelDto> kennels = given()
                .when()
                .get("kennels")
                .then()
                .assertThat().statusCode(200)
                .extract().body().jsonPath().getList(".", KennelDto.class);

        for (KennelDto kennel : kennels) {
            System.out.println(kennel.getId() + "***" + kennel.getName());
            System.out.println("=========================================");
        }

    }



}


