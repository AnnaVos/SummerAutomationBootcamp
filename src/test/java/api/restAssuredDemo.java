package api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.protocol.HTTP;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class restAssuredDemo {

@Test
public void demo() {

    given().when().get("http://ergast.com/api/f1/current/last/results").then().statusCode(200);

    RestAssured.baseURI = "http://ergast.com/api";
    RequestSpecification httpRequest = given();
    Response response = httpRequest.get("/f1/current/last/results");
    int statusCode = response.getStatusCode();

    Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");
}


    @Test
    public void driverIDMax() {

        given().when().get("http://ergast.com/api/f1/2016/drivers/max_verstappen/results").then().
                assertThat().body("MRData.RaceTable.driverId", containsString ("max_verstappen"));

    }

    private static String season = "2017";
    private static String race = "last";

    @Test
    public void pathParameter() {

    given().pathParam("season", season).pathParam("race", race).when().post("http://ergast.com/api/f1/(season)" +
            "/(race)/results.xml").then().statusCode(200);

    }
}



