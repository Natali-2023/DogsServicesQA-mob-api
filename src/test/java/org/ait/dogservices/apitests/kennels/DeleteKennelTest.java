package org.ait.dogservices.apitests.kennels;

import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteKennelTest extends TestBaseApi {
    @Test
        public void deleteKennelByIdSuccessTest() {

        Response authResponse = login();

        if (authResponse.getStatusCode() == 200) {
            int existingKennelId = 18;

            given()
                    .header("Authorization", "Bearer " + authResponse.getBody().jsonPath().getString("token"))
                    .pathParam("id", existingKennelId)
                    .when()
                    .delete("kennels/{id}")
                    .then()
                    .assertThat().statusCode(200);

            given()
                    .header("Authorization", "Bearer " + authResponse.getBody().jsonPath().getString("token"))
                    .pathParam("id", existingKennelId)
                    .when()
                    .get("kennels/{id}")
                    .then()
                    .assertThat().statusCode(404);
        } else {
            System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
        }
    }
    @Test
    public void deleteKennelByWrongIdTest(){
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
