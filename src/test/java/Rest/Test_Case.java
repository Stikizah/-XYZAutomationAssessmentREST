package Rest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test_Case {
//	@Test
	public void TestOne()
	{
		Response response = get("https://www.kurtosys.com");

		given().header("Content-Type", "application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().response().then().statusCode(200).
		log();

		String body = response.getBody().asString();

		System.out.println(body);

	}
	
	@Test
	public void TestTwo()
	{
		Response response = get("https://www.kurtosys.com");

		given().header("Content-Type", "application/json").
		and().header("Content-Length",equalTo("2000")).
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().response().then().statusCode(200).
		log();

		// By default response time is given in milliseconds
		long responseTime1 = response.getTime();
		System.out.println("Response time in ms using getTime():"+responseTime1);

	}
	
	@Test
	public void TestThree()
	{
		Response response = get("https://www.kurtosys.com");

		given().header("Content-Type", "application/json").
		and().header("value", "cloudflare").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		when().response().then().statusCode(200).
		log();

		String body = response.getBody().asString();

		System.out.println(body);

	}
}
