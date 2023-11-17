package org.ait.dogservices.apitests.clinic;

import io.restassured.response.Response;
import org.ait.dogservices.api.ClinicDto;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetClinicTests extends TestBaseApi {
    @Test
    public void getClinicByIdSuccessTest() {

        Response authResponse = login();

        if (authResponse.getStatusCode() == 200) {

            int existingClinicId = 4;


            ClinicDto retrievedClinic = given()
                    .header("Authorization", "Bearer " + authResponse.getBody().jsonPath().getString("token"))
                    .pathParam("id", existingClinicId)
                    .when()
                    .get("clinics/{id}")
                    .then()
                    .assertThat().statusCode(200)
                    .extract().response().as(ClinicDto.class);


            Assert.assertEquals(existingClinicId, retrievedClinic.getId());

        } else {
            System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
        }

    }

    @Test
    public void getClinicByWrongIdTest() {

        Response authResponse = login();

        if (authResponse.getStatusCode() == 200) {
            int existingClinicId = 44;

            ErrorDto errorDto = given()
                    .header("Authorization", "Bearer " + authResponse.getBody().jsonPath().getString("token"))
                    .pathParam("id", existingClinicId)
                    .when()
                    .get("clinics{id}")
                    .then()
                    .assertThat().statusCode(404)
                    .extract().response().as(ErrorDto.class);


            Assert.assertEquals(errorDto.getMessage(), "Clinic with id <44> not found");
            System.out.println(errorDto.getMessage());

      } else

    {
        System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
    }

}

    @Test
    public void getClinicUnregisteredUserTest() {
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
