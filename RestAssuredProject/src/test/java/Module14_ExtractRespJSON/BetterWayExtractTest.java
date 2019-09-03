package Module14_ExtractRespJSON;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class BetterWayExtractTest {

	@Test
	public void f() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";

		Response resp = given().contentType(ContentType.JSON).log().all().get("/list");

		ArrayList<Integer> ids = resp.then().extract().path("id");
		ArrayList<String> firstName = resp.then().extract().path("firstName");
		ArrayList<String> lastName = resp.then().extract().path("lastName");
		ArrayList<String> programme = resp.then().extract().path("programme");
		ArrayList<String> email = resp.then().extract().path("email");

		// System.out.println(firstName.get(1));

		for (int i = 0; i < ids.size(); i++) {
			System.out.println(ids.get(i));
			System.out.println(firstName.get(i));
			System.out.println(lastName.get(i));
			System.out.println(programme.get(i));
			System.out.println(email.get(i));
			System.out.println("_________________________");
		}
	}
}
