package Module15_ValidationAssersion;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateRespTest {
  @Test
  public void f() {
	  
	  
	  
  }
  
  public void validateExp1(){
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
		  
	  Response resp =given().contentType(ContentType.JSON).header("X","Y").log().all().get("/list?programme=Financial Analysis&limit=2");
	  resp.prettyPrint();
  }
}
