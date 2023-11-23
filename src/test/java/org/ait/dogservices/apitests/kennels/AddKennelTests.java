package org.ait.dogservices.apitests.kennels;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.ait.dogservices.api.ErrorDto;
import org.ait.dogservices.api.KennelDto;
import org.ait.dogservices.apitests.TestBaseApi;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class AddKennelTests extends TestBaseApi {
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
    public void addNewKennelSuccessTest() {
        int i = new Random().nextInt(1000) + 1000;
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

        String message = given()
                .contentType(ContentType.JSON)
                .body(kennelDto)
                .post("kennels")
                .then()
                .assertThat().statusCode(201)
                .extract().path("message");
        System.out.println(message);
    }

    @Test
    public void addNewKennelWithoutNameNegativeTest() {
        KennelDto kennelDto = KennelDto.builder()
                .description("Kennel for small and big dogs")
                .webSite("https://kennel-hunde.de")
                .country("Germany")
                .kennelCity("Berlin")
                .postCode("01611")
                .address("Pragstrasse 7")
                .telephoneNumber("+4917211887121")
                .build();

        Response response = given()
                .contentType(ContentType.JSON)
                .body(kennelDto)
                .post("kennels");

        response.then()
                .statusCode(400)
                .assertThat()
                .body("errors[0].field", equalTo("name"))
                .body("errors[0].message", equalTo("must not be null"));
    }

//    @Test
//    public  void addNewKennelWithInvalidPhoneNegativeTest(){
//        KennelDto kennelDto = KennelDto.builder()
//                .name("Hunde kennel")
//                .description("Kennel for small and big dogs")
//                .webSite("https://kennel-hunde.de")
//                .country("Germany")
//                .kennelCity("Berlin")
//                .postCode("01611")
//                .address("Pragstrasse 7")
//                .telephoneNumber("491721!")
//                .build();
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(kennelDto)
//                .post("kennels")
//                .then()
//                .assertThat().statusCode(400)
//                .assertThat().body("message.phone",
//                        containsString("Phone number must contain only digits! And length min 10, max 15!"));
//
//
//
//
//    }


}
