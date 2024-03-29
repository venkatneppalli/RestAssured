package Module12_CurdOperations;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETReqTest {
  @Test
  public void f() {
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
		  
	  Response req =given().contentType(ContentType.JSON).header("X","Y").log().all().get("/list?programme=Financial Analysis&limit=2");
	  
	  System.out.println("getContentType:= "+req.getContentType());
	  System.out.println("getHeaders:= "+req.getHeaders());
	  System.out.println("getStatusCode:= "+req.getStatusCode());
	  System.out.println("getTime:= "+req.getTime());
	  
	  
	  //response.print();
	  req.prettyPrint();
  }
}
