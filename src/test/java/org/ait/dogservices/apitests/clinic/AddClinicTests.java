package org.ait.dogservices.apitests.clinic;

import io.restassured.http.ContentType;
import org.ait.dogservices.api.ClinicDto;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class AddClinicTests extends TestBaseApi {
    @Test
    public void addNewClinicSuccessTest() {
        int i = new Random().nextInt(1000) + 1000;
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


        String message = given()
                .contentType(ContentType.JSON)
                .body(clinicDto)
                .post("clinics")
                .then()
                .assertThat().statusCode(201)
                .extract().path("message");
        System.out.println(message);
    }

    @Test
    public void addNewClinicWithoutNameTest() {
        KennelDto kennelDto = KennelDto.builder()
                .description("Clinic for small and big pets")
                .webSite("https://clinic-hunde.de")
                .country("Germany")
                .kennelCity("Berlin")
                .postCode("01611")
                .address("Hauptrasse 7")
                .telephoneNumber("+4917211887121")
                .build();

        ErrorDto errorDto = given()
                .contentType(ContentType.JSON)
                .body(kennelDto)
                .post("clinics")
                .then()
                .assertThat().statusCode(400)
                .extract().response().as(ErrorDto.class);


        String errorMessage = errorDto.getMessage();
        if (errorMessage != null) {
            System.out.println(errorMessage);
            Assert.assertTrue(errorMessage.contains("name=must not be blank"));
        } else {
            Assert.fail("Error message is null");
        }

    }
    @Test
    public  void addNewClinicInvalidPhoneTest(){
        KennelDto kennelDto = KennelDto.builder()
                .name("Hunde clinic")
                .description("Clinic for small and big pets")
                .webSite("https://clinic-hunde.de")
                .country("Germany")
                .kennelCity("Berlin")
                .postCode("01611")
                .address("Pragstrasse 7")
                .telephoneNumber("491721")
                .build();

        given()
                .contentType(ContentType.JSON)
                .body(kennelDto)
                .post("clinics")
                .then()
                .assertThat().statusCode(400);
               // .assertThat().body("message.phone",
                       // containsString("Phone number must contain only digits! And length min 10, max 15!"));




    }


}
