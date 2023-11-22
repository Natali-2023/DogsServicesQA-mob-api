package org.ait.dogservices.apitests.kennels;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetKennelTests extends TestBaseApi {
    @BeforeMethod
    public void precondition(){
        String username = "admin@ait-tr.de";
        String password = "Qwerty007!";


        Response authResponse = RestAssured.given()
                .param("username", username)
                .param("password", password)
                .post("login");

    }
    @Test
    public void getKennelByIdSuccessTest() {

            int existingKennelId = 10;

            KennelDto retrievedKennel = given()
                    .pathParam("id", existingKennelId)
                    .when()
                    .get("kennels/{id}")
                    .then()
                    .assertThat().statusCode(200)
                    .extract().response().as(KennelDto.class);

            Assert.assertEquals(existingKennelId, retrievedKennel.getId());

    }
    @Test
    public void getKennelByWrongIdNegativeTest() {

            int existingKennelId = 144;

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
