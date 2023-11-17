package org.ait.dogservices.apitests.clinic;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ait.dogservices.api.ClinicDto;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateClinicTests extends TestBaseApi {

    @Test
    public void updateClinicByIdDescription() {
        Response authResponse = login();
        if (authResponse.getStatusCode() == 200) {
            int existingClinicId = 16;

            ClinicDto updatedClinicDto = ClinicDto.builder()
                    .id(existingClinicId)
                    .name("Hunde clinic")
                    .description("Updated clinic description")
                    .webSite("https://clinic-hunde.de")
                    .country("Germany")
                    .clinicCity("Berlin")
                    .postCode("01611")
                    .address("Pragstrasse 7")
                    .telephoneNumber("+4917211887987")
                    .build();

            given()
                    .contentType(ContentType.JSON)
                    .body(updatedClinicDto)
                    .when()
                    .put("clinics/{id}", existingClinicId)
                    .then()
                    .assertThat().statusCode(200);


            ClinicDto retrievedClinic = getClinicById(existingClinicId);
            Assert.assertEquals("Updated clinic description", retrievedClinic.getDescription());
        } else {
            System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
        }
    }

        private ClinicDto getClinicById(int clinicId) {
        return given()
                .pathParam("id", clinicId)
                .when()
                .get("kennels/{id}")
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(ClinicDto.class);
    }



   @Test
    public void updateClinicByIdWebsiteTest() {
       Response authResponse = login();
       if (authResponse.getStatusCode() == 200) {

       int existingClinicId = 16;

       ClinicDto updatedClinicDto = ClinicDto.builder()
               .id(existingClinicId)
               .name("Hunde clinic")
               .description("Updated clinic description")
               .webSite("https://clinic_hunde.de")
               .country("Germany")
               .clinicCity("Berlin")
               .postCode("01611")
               .address("Pragstrasse 7")
               .telephoneNumber("+4917211887987")
               .build();

       given()
               .contentType(ContentType.JSON)
               .body(updatedClinicDto)
               .when()
               .put("clinics/{id}", existingClinicId)
               .then()
               .assertThat().statusCode(200);

       ClinicDto retrievedClinic = getClinicById(existingClinicId);
       Assert.assertEquals("https://clinic_hunde.de", retrievedClinic.getWebSite());
    }else {
           System.out.println("Ошибка авторизации. Код ответа: " + authResponse.getStatusCode());
       }
   }

    @Test
    public void updateClinicByWrongIdTest() {
        int existingKennelId = 88;

        ErrorDto errorDto = given()
                .pathParam("id", existingKennelId)
                .when()
                .put("kennels/{id}")
                .then()
                .assertThat().statusCode(400)
                .extract().response().as(ErrorDto.class);

       // Assert.assertEquals(errorDto.getMessage(), "Kennel with id <88> not found");
        System.out.println(errorDto.getMessage());

    }


}
