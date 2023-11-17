package org.ait.dogservices.apitests.kennels;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateKennelTests extends TestBaseApi {

    @Test
    public void updateKennelByDescription() {
        Response authResponse = login();
        if (authResponse.getStatusCode() == 200) {

    KennelDto kennelDto = KennelDto.builder()
            .id(22)
            .name("Hunde kennel")
            .description("Kennel for small and big dogs")
            .webSite("https://kennel-hunde.de")
            .country("Germany")
            .kennelCity("Berlin")
            .postCode("01611")
            .address("Pragstrasse 7")
            .telephoneNumber("+4917211887987")
            .build();
    String newDescription = "Updated kennel description";

    kennelDto.setDescription(newDescription);

    given()
            .contentType(ContentType.JSON)
            .body(kennelDto)
            .when()
            .put("kennels/{id}",kennelDto.getId())
            .then()
            .assertThat().statusCode(200);

    KennelDto updatedKennel = getKennelById(kennelDto.getId());
    Assert.assertEquals(newDescription,updatedKennel.getDescription());

   } else {
            System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
        }
    }

   @Test
    public void updateKennelWebsiteTest() {
       Response authResponse = login();
       if (authResponse.getStatusCode() == 200) {

        KennelDto kennelDto = KennelDto.builder()
            .id(23)
            .name("Hunde kennel")
            .description("Kennel for small and big dogs")
            .webSite("https://kennel-hunde.de")
            .country("Germany")
            .kennelCity("Berlin")
            .postCode("01611")
            .address("Pragstrasse 7")
            .telephoneNumber("+4917211887987")
            .build();
        String newWebsite = "https://updated-kennel-website.com";

        kennelDto.setWebSite(newWebsite);

        given()
        .contentType(ContentType.JSON)
        .body(kennelDto)
        .when()
        .put("kennels/{id}", kennelDto.getId())
        .then()
        .assertThat().statusCode(200);

        KennelDto updatedKennel = getKennelById(kennelDto.getId());
        Assert.assertEquals(newWebsite, updatedKennel.getWebSite());

        } else {
          System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
    }
}

    public KennelDto getKennelById(int kennelId) {
        return given()
                .pathParam("id", kennelId)
                .when()
                .get("kennels/{id}")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(KennelDto.class);
    }

    @Test
    public void updateKennelByWrongIdTest() {
        int existingKennelId = 88;

        ErrorDto errorDto = given()
                .pathParam("id", existingKennelId)
                .when()
                .put("kennels/{id}")
                .then()
                .assertThat().statusCode(400)
                .extract().response().as(ErrorDto.class);


      //  Assert.assertEquals(errorDto.getMessage(), "Kennel with id <88> not found");
        System.out.println(errorDto.getMessage());

    }
}
