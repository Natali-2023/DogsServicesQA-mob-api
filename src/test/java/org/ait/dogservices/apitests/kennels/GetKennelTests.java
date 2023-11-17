package org.ait.dogservices.apitests.kennels;

import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetKennelTests extends TestBaseApi {
    @Test
    public void getKennelByIdSuccessTest() {
        Response authResponse = login();

        if (authResponse.getStatusCode() == 200) {

            int existingKennelId = 4;

            KennelDto retrievedKennel = given()
                    .header("Authorization", "Bearer " + authResponse.getBody().jsonPath().getString("token"))
                    .pathParam("id", existingKennelId)
                    .when()
                    .get("kennels/{id}")
                    .then()
                    .assertThat().statusCode(200)
                    .extract().response().as(KennelDto.class);

            Assert.assertEquals(existingKennelId, retrievedKennel.getId());

        } else {
            System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
        }
    }
    @Test
    public void getKennelByWrongIdTest() {

        Response authResponse = login();

        if (authResponse.getStatusCode() == 200) {
            int existingKennelId = 44;

            ErrorDto errorDto = given()
                    .header("Authorization", "Bearer " + authResponse.getBody().jsonPath().getString("token"))
                    .pathParam("id", existingKennelId)
                    .when()
                    .get("kennels{id}")
                    .then()
                    .assertThat().statusCode(404)
                    .extract().response().as(ErrorDto.class);


            Assert.assertEquals(errorDto.getMessage(), "Kennel with id <44> not found");
            System.out.println(errorDto.getMessage());

        } else

        {
            System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
        }

    }

    @Test
    public void getKennelUnregisteredUserTest() {
        int existingKennelId = 4;

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
