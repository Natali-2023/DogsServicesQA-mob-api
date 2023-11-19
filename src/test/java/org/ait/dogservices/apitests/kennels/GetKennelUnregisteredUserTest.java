package org.ait.dogservices.apitests.kennels;

import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetKennelUnregisteredUserTest extends TestBaseApi {

    @Test
    public void getKennelUnregisteredUserNegativeTest() {
        int existingKennelId = 12;

        ErrorDto errorDto = given()
                .pathParam("id", existingKennelId)
                .when()
                .get("kennels{id}")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);


        Assert.assertEquals(errorDto.getMessage(), "User unauthorized");
        System.out.println(errorDto.getMessage());

    }

}
