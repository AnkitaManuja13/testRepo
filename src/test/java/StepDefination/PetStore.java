package StepDefination;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.ImeActivationFailedException;
import org.openqa.selenium.json.Json;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetStore {


    @Test
    @Given("To verify the Get Request for PetStore for Available Pets")
    public void getAvailablePet()

    {

        ArrayList<String> arrayList = new ArrayList<String >();
        RestAssured.baseURI="https://petstore.swagger.io/v2/pet/findByStatus";
        String response= given().queryParam("status","available").when().get().then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js= new JsonPath(response);
        String responsestatus =js.getString("status");
        String[] responsearray= responsestatus.split(",");
        for(int i=0;i<responsearray.length;i++)
        {
            Assert.assertTrue(responsearray[i].contains("available"));
        }


    }
    @Then("To verify the Post request for PetStore by adding a new Pet")
    public void PostAvailablePet() {
        RestAssured.baseURI="https://petstore.swagger.io";
       String Response= RestAssured.given().header("Content-Type","application/json").body("{\n" +
             "  \"id\": 16,\n" +
             "  \"category\": {\n" +
             "    \"id\": 16,\n" +
             "    \"name\": \"string\"\n" +
             "  },\n" +
             "  \"name\": \"doggie\",\n" +
             "  \"photoUrls\": [\n" +
             "    \"string\"\n" +
             "  ],\n" +
             "  \"tags\": [\n" +
             "    {\n" +
             "      \"id\": 16,\n" +
             "      \"name\": \"string\"\n" +
             "    }\n" +
             "  ],\n" +
             "  \"status\": \"available\"\n" +
             "}")
                .when().post("/v2/pet").then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js=new JsonPath(Response);
       Assert.assertEquals("16",js.getString("id"));



    }
    @Then("To verify the PUT Request for PetStore by updating the Status to Sold")
    public void updateStatus()
    {
        RestAssured.baseURI="https://petstore.swagger.io";
     String response =   RestAssured.given().header("Content-Type","application/json").body("{\n" +
                "  \"id\": 16,\n" +
                "  \"category\": {\n" +
                "    \"id\": 16,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"doggie\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 16,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"sold\"\n" +
                "}")
                .when().put("/v2/pet").then().log().all().assertThat().statusCode(200).extract().response().asString();
              JsonPath js = new JsonPath(response);
              Assert.assertEquals("sold",js.getString("status"));
    }
    @Then("To verify the Delete Request for PetStore by deleting the pet")
    public void deletePet()
    {
        RestAssured.baseURI="https://petstore.swagger.io/v2/pet/16";
        String response=RestAssured.given().header("Content-Type","application/json").when().delete().then().log().all().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(response);
        Assert.assertEquals("16",js.getString("message"));
    }
}
