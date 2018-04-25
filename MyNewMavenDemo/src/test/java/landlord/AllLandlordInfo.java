package landlord;

import static com.jayway.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AllLandlordInfo {

	/*
	 * @BeforeTest public void setUp(){
	 * RestAssured.baseURI="http://localhost:8080/landlords"; }
	 * 
	 * 
	 */
//2 Ans.
	
	@Test(enabled = false)
	public void getAllLandlordInfo() {
		Response response = given().when().get(
				"http://localhost:8080/landlords");

		// Validate status code is 200

		// to validate for the empty list
		response.then().assertThat().body("isEmpty()", Matchers.is(false));
		response.then().assertThat().statusCode(200);
	}
	
	
//	3 Ans

	@Test(enabled = false)
	public void addLandlordWithPojo() {
		String[] apt = new String[] { "empty" };
		LandlordPojo obj = new LandlordPojo("53ASHANA", "aana", "false", apt,
				"sa");
		Response res = given().body(obj).when()
				.get("http://localhost:8080/landlords/");
		// .contentType(ContentType.JSON)
		res.then().and()

		.statusCode(200) // validating the status code
				.extract().response().prettyPrint();

	}
	
	

	// new id 4LgiwS6L
	@Test(enabled = false)
	public void validateLandlordSchema() {
		Response response = given().body("4LgiwS6L").when()
				.get("http://localhost:8080/landlords/4LgiwS6L");
		response.then().assertThat()
				.body(matchesJsonSchemaInClasspath("LandlordSchema.json"));

		// schema validation

		// validate status code is 201
		// response.then().assertThat().statusCode(201);

	}
	
//4 Ans.

	// http://localhost:8080/landlords/4LgiwS6L/apartments
	@Test(enabled = false)
	public void updateLandlord() {
		Response response = given().when().get(
				"http://localhost:8080/landlords/4LgiwS6L");

		// to validate for the empty list
		response.then().assertThat().body("isEmpty()", Matchers.is(false));
		// Validate status code is 200
		response.then().assertThat().statusCode(200);
		response.then().assertThat().and();
		response.then().assertThat()
				.body(matchesJsonSchemaInClasspath("landlordSchema2.json"));
				response.then().assertThat().and()
				.extract().response().prettyPrint();
		// System.out.println("Land lord with id  4LgiwS6L is "+
		// response.body().asString());

	}
	
	

	
	// id is 4DKlS34
	@Test(enabled = false)
	public void updateLandlord2() {
		Response response = given().when().get(
				"http://localhost:8080/landlords/4DKIS34");

		// to validate for the empty list
		// response.then().assertThat().body("isEmpty()", Matchers.is(false));

		// Validate status code is 400
		response.then().assertThat().statusCode(404);

		response.then().assertThat().and()

		// validate message
				.extract().response().prettyPrint();
		//System.out.println("Message is" + response.body().asString());
		
		// response.body().asString());
	}
	
	
	
	
	//id is 4LgiwS6L
	@Test(enabled=false)
	public void getUniqueLandlord() {
		Response response = given().when().get(
				"http://localhost:8080/landlords/4LgiwS6L");

		// to validate for the empty list
		//response.then().assertThat().body("isEmpty()", Matchers.is(false));
		// Validate status code is 200	
		response.then().assertThat().statusCode(200);
		response.then().assertThat().and();
	}
	
	
//5 Ans	
	
	@Test(enabled = true)
	public void getIdLandlord() {
			Response res = 	when()
				.get("http://localhost:8080/landlords/4LgiwS6L");

		// Validate status code is 200
			//.then()
			res.then().assertThat().statusCode(200);
			res.then().assertThat().and()
				//response.then().assertThat().and()
				//.extract().jsonPath().
				.extract().response().prettyPrint();
				
	}
		
}
