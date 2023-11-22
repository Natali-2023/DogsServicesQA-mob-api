package org.ait.dogservices.apitests.clinic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ait.dogservices.api.ClinicDto;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

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
        Integer number = new Random().nextInt(1000) + 1000;
        String i = number.toString();
        ClinicDto clinicDto = ClinicDto.builder()
                .name("Pets clinic")
                .description("Clinic for small and big pets")
                .webSite("https://clinic-hunde.de")
                .country("Germany")
                .clinicCity("Berlin")
                .postCode("01611")
                .address("Hauptstrasse 7")
                .telephoneNumber("+4917211887"+i)
                .build();

        String clinicId = given()
                .contentType(ContentType.JSON)
                .body(clinicDto)
                .post("clinics")
                .then()
                .assertThat().statusCode(201)
                .extract().path("id")
                        .toString();

            given()
                .pathParam("id", clinicId)
                .delete("clinics/{id}")
                .then()
                .assertThat().statusCode(200);


            given()
                    .pathParam("id", clinicId)
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
