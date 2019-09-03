package Module14_ExtractRespJSON;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractionExampTest {

	@Test
	public void getStudentInfo() {
		//getAllStudentsList_Extract();
		getSingleStudentName_Extract();		
	}
	
	public void getAllStudentsList_Extract(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";

		//Response resp = given().contentType(ContentType.JSON).log().all().get("/102");
		//resp.prettyPrint();
		
		ArrayList<String> arr =given().log().all().get("/list").then().extract().path("firstName");
		
		System.out.println(arr);

	}
	
	public void getSingleStudentName_Extract(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		
		String fName=given().contentType(ContentType.JSON).log().all().get("/102").then().extract().path("firstName");
		System.out.println(fName);
	}
	
	public void getStudentList_JSONPath(){
		
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		
		Response resp = given().contentType(ContentType.JSON).log().all().get("/102");
		
		JsonPath jp = resp.jsonPath();
		
		String fName = jp.get("firstName");
		String fname = jp.getString("lastName");
		
		
	}
}
