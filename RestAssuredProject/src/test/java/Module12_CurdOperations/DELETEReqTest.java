package Module12_CurdOperations;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DELETEReqTest {
  @Test
  public void f() {
	  
	  RestAssured.basePath="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  Response resp = given().contentType(ContentType.JSON).log().all().delete("/101");
	  
	  resp.prettyPrint();
	  
	  
  }
}
