package Module13_LoginMethods;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestLoggingMethods {
	
  @Test
  public void f() {
	  
	  //loggingAll();
	 //loggingHeader();
	  //loggingParam();
	  loggingPostReq();
  }
  
  //Logging All
  public void loggingAll(){
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  Response resp = given().contentType(ContentType.JSON).log().all().get("/100");
	  
	  resp.prettyPrint();
  }
  
  //Logging Header part 
  public void loggingHeader(){
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  Response resp = given().headers("X","Y").contentType(ContentType.JSON).log().headers().get("/100");
	  
	  resp.prettyPrint();
  }
  
  //logging Paramaters
  public void loggingParam(){
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  Response resp=given().param("programmer", "computer science").contentType(ContentType.JSON).log().params().get("/100");
  
	  resp.prettyPrint();
}
  
  //Status code validation
  public void loggingPostReq(){
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  File file = new File("/Users/venkatneppalli/Documents/Workspace_RestAssured_Venkat/RestAssuredProject/Student.json");
	  
	  given().contentType(ContentType.JSON).log().ifValidationFails().body(file).post().then().statusCode(200);
	  
  }
  
  public void loggingHeadersValidation(){
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  given().contentType(ContentType.JSON).get("/100").then().log().headers();
	  
	  
  }
  
}