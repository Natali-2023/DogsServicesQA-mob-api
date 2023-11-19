package org.ait.dogservices.apitests.clinic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteClinicTest extends TestBaseApi {
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
    public void deleteClinicByIdSuccessTest() {

            int existingClinicId = 8;

            given()
                    .pathParam("id", existingClinicId)
                    .when()
                    .delete("clinics/{id}")
                    .then()
                    .assertThat().statusCode(200);

            given()
                    .pathParam("id", existingClinicId)
                    .when()
                    .get("clinics/{id}")
                    .then()
                    .assertThat().statusCode(404);

}



    @Test
    public void deleteClinicByWrongIdNegativeTest() {

        int existingKennelId = 88;

        ErrorDto errorDto = given()
                .pathParam("id", existingKennelId)
                .when()
                .delete("kennels/{id}")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);


        Assert.assertEquals(errorDto.getMessage(), "Kennel with id <88> not found");
        System.out.println(errorDto.getMessage());

    }
}
