package Module13_CreateJSONfilePOSTreq;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONTest {

	@Test
	public void testFiles() {

		// jsonobject_jsonarray();
		// jsonCollections();
		jsonOOPS();

	}

	public void jsonobject_jsonarray() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		RestAssured.basePath = "/student";

		JSONObject obj = new JSONObject();
		obj.put("firstName", "Kalyan");
		obj.put("lastName", "Malik");
		obj.put("email", "kalyanmalik@gmail.com");
		obj.put("programmer", "Computer Science");
		obj.put("programme", "CS");

		JSONArray arr = new JSONArray();
		arr.put("c");
		arr.put("c++");
		arr.put("java");

		// System.out.println(obj.put("course", arr));

		Response resp = given().contentType(ContentType.JSON).log().body().body(obj.toString()).post();
		resp.prettyPrint();
	}

	public void jsonCollections() {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("firstName", "Venkat");
		map.put("lastName", "Neppalli");
		map.put("email", "emailQA@gmail.com");
		map.put("programme", "SDK");

		List<String> list = new ArrayList<String>();
		list.add("Python");
		list.add("javascrpt");
		list.add("java");

		map.put("courses", list);
		// System.out.println(map);

		Response resp = given().contentType(ContentType.JSON).log().body().body(map).post();
		resp.prettyPrint();
	}

	public void jsonOOPS() {

		JsonOOPSTest js = new JsonOOPSTest("Ram", "Neppalli", "ramn@gmail.com", "CS");

		js.setCourses("java");
		js.setCourses("c");
		js.setCourses("c++");
		// System.out.println(js);

		Response resp = given().contentType(ContentType.JSON).log().body().body(js).post();
		resp.prettyPrint();

	}

}
