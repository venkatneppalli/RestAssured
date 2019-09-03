package Module12_CurdOperations;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class POSTReqTest {
  @Test
  public void f() {
	  
	  RestAssured.baseURI="http://localhost";
	  RestAssured.port=8080;
	  RestAssured.basePath="/student";
	  
	  File file = new File("/Users/venkatneppalli/Documents/Workspace_RestAssured_Venkat/RestAssuredProject/Student.json");
	  
	  Response resp = given().contentType(ContentType.JSON).log().all().body(file).post();
	  
	  resp.prettyPrint();
	  
  }
}