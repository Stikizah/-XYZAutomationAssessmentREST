package XYZRest_API;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class POSTUser 
{
	JSONObject request;
	
	//@Test
	public void Test1()
	{
		//POST a new user to the /users 
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("name", "Nhlakanipho");
		map.put("username", "Mthalane");
		map.put("email", "Nhlaka.sticks@outlook.com");;
		map.put("street", "Kulas Light");
		map.put("suite", "Suite 879");
		map.put("city", "Wisokyburgh");
		map.put("zipcode", "90566-7771");
		
		request = new JSONObject(map);
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().post("https://jsonplaceholder.typicode.com/users").then().statusCode(201);
		
	}
	
//	@Test
	public void TestTwo()
	{
		Response response = get("https://jsonplaceholder.typicode.com/users/2");
		
		given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().get("https://jsonplaceholder.typicode.com/users/").then().statusCode(200).
			body("id[1]", equalTo(2)).
			log();

		String body = response.getBody().asString();
		
		System.out.println(body);
		
	}
	
	@Test
	public void TestThree()
	{
		Response response = get("https://jsonplaceholder.typicode.com/users/");
		
		given().header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().response().then().statusCode(200).
			log();

		String body = response.getBody().asString();
		
		System.out.println(body);
		
	}
}
