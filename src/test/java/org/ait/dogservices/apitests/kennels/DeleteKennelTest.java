package org.ait.dogservices.apitests.kennels;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class DeleteKennelTest extends TestBaseApi {
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
        public void deleteKennelByIdSuccessTest() {

        Integer number = new Random().nextInt(1000) + 1000;
        String i = number.toString();
        KennelDto kennelDto = KennelDto.builder()
                .name("Hunde kennel")
                .description("Kennel for small and big dogs")
                .webSite("https://kennel-hunde.de")
                .country("Germany")
                .kennelCity("Berlin")
                .postCode("01611")
                .address("Pragstrasse 7")
                .telephoneNumber("+4917211887"+i)
                .build();

        String kennelId = given()
                .contentType(ContentType.JSON)
                .body(kennelDto)
                .post("kennels")
                .then()
                .assertThat().statusCode(201)
                .extract().path("id")
                .toString();

        given()
                .pathParam("id", kennelId)
                .delete("kennels/{id}")
                .then()
                .assertThat().statusCode(200);

            given()
                    .pathParam("id", kennelId)
                    .when()
                    .get("kennels/{id}")
                    .then()
                    .assertThat().statusCode(404);

    }
    @Test
    public void deleteKennelByWrongIdNegativeTest(){
        int existingKennelId = 88;

        ErrorDto errorDto = given()
                .pathParam("id", existingKennelId)
                .when()
                .get("kennels/{id}")
                .then()
                .assertThat().statusCode(404)
                .extract().response().as(ErrorDto.class);


        Assert.assertEquals(errorDto.getMessage(), "Kennel with id <88> not found");
        System.out.println(errorDto.getMessage());


    }

}
