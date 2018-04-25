package testing;


import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static org.hamcrest.Matchers.*;





public class GroupKtTests {
	
	@Test(enabled=false)
	public void getStateInfo(){
		Response response = 
		given()
		.when().get("http://services.groupkt.com/state/get/IND/UP");
		
		System.out.println("body content = " + response.getBody().asString());//return whole body
		//System.out.println("content type = " +response.getContentType());
		//System.out.println("header is " +response.getHeaders());
		
		//Validation
		response.then().assertThat().statusCode(200);
		response.then().assertThat().time(lessThan(3000L));
		//json path for id in the response  $.RestResponse.result.id
		response.then().body("RestResponse.result.id", equalTo(82));
		response.then().body("RestResponse.result.country",is("IND"));
	}
	
	@Test(enabled=false)
	public static void getStateInfo1(){
		when()
		.get("http://services.groupkt.com/state/get/IND/UP")
		.then()
			.statusCode(200)
			.time(lessThan(3000L))
			.body("RestResponse.result.id", equalTo(82))
			.body("RestResponse.result.country",is("IND"));//written in single step	
			
	}
	
	@Test(enabled=true)
	public static void getStateInfoPath(){
		given()
			.pathParam("CountryCode","IND")
			.pathParam("stateCode", "UP")
			.log().body()
		.when()	
			.get("http://services.groupkt.com/state/get/{CountryCode}/{stateCode}")
		.then()
		.log().ifValidationFails()
			.statusCode(200)
			.time(lessThan(3000L))
			.contentType(ContentType.JSON)
			.body("RestResponse.result.id",equalTo(82))
			.body("RestResponse.result.country",is("IND"))
			.body(matchesJsonSchemaInClasspath("GroupktSchema.json"))
			.extract().response().prettyPrint();
			
	}
	
}
