package RestAssured_Basics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllStudentsTest {
  @Test
  public void f() {
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student/list";
	  
	  RequestSpecification req =given();
	  
	  req=req.contentType(ContentType.JSON);
	  req=req.header("X","Y");
	  
	  Response response = req.get();
	  
	  System.out.println("getContentType:= "+response.getContentType());
	  System.out.println("getHeaders:= "+response.getHeaders());
	  System.out.println("getStatusCode:= "+response.getStatusCode());
	  System.out.println("getTime:= "+response.getTime());
	  
	  
	  //response.print();
	  response.prettyPrint();
  }
}
