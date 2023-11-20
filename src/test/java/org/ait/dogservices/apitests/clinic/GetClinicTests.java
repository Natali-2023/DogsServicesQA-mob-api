package org.ait.dogservices.apitests.clinic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ait.dogservices.api.ClinicDto;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetClinicTests extends TestBaseApi {
    @BeforeMethod
    public void precondition(){
        String username = "nat@mail.com";
        String password = "Qwerty8888!";

        Response authResponse = RestAssured.given()
                .param("username", username)
                .param("password", password)
                .post("login");

    }
    @Test
    public void getClinicByIdSuccessTest() {

            int existingClinicId = 10;

            ClinicDto retrievedClinic = given()
                    .pathParam("id", existingClinicId)
                    .when()
                    .get("clinics/{id}")
                    .then()
                    .assertThat().statusCode(200)
                    .extract().response().as(ClinicDto.class);


            Assert.assertEquals(existingClinicId, retrievedClinic.getId());

    }

    @Test
    public void getClinicByWrongIdNegativeTest() {
            int existingClinicId = 144;

            ErrorDto errorDto = given()
                    .pathParam("id", existingClinicId)
                    .when()
                    .get("clinics{id}")
                    .then()
                   .assertThat().statusCode(404)
                    .extract().response().as(ErrorDto.class);


            Assert.assertEquals(errorDto.getMessage(), "Clinic with id <144> not found");
            System.out.println(errorDto.getMessage());


}



}
