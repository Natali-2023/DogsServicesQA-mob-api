package org.ait.dogservices.apitests.clinic;

import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetClinicUnregisteredUserTest extends TestBaseApi {
    @Test
    public void getClinicUnregisteredUserNegativeTest() {
        int existingClinicId = 4;

        ErrorDto errorDto = given()
                .pathParam("id", existingClinicId)
                .when()
                .get("clinics{id}")
                .then()
                .assertThat().statusCode(401)
                .extract().response().as(ErrorDto.class);


        Assert.assertEquals(errorDto.getMessage(), "User unauthorized");
        System.out.println(errorDto.getMessage());

    }
}
