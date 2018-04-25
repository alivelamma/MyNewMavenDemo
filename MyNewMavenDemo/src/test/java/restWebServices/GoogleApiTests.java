package restWebServices;

//jsonviewer.stack.hu----- gives complete structured json path showing the lists and keys, helps to write xpath effieciently
//jsonpath.com---helps to verify json path and the outcome of that particular path after copying the json path 

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testing.MyPojo;
import testing.ResToPojo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class GoogleApiTests {
	public static String placeId;
	
	/*@BeforeTest
	public void setUp(){
		RestAssured.baseURI="https://maps.googleapis.com";
		RestAssured.basePath="/maps/api";
	}
	
	@Test(enabled=false)
	public void GetDistanceMatrix(){
		given()
		.queryParameter("origins", "newyork")
		.queryParameter("destinations", "SanFrancisco")
		.queryParameter("mode", "bycycling")
		.queryParameter("language", "fr-FR")
		.queryParameter("key", "AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
		.when()
			.get("/distancematrix/json")
			.then()
			.statusCode(200)
			.and()
			.assertThat().body("rows[0].elements[0].distance.value", Matchers.equalTo(4676417));
			//.extract().response().prettyPrint();		
	}
	
	@Test(priority=1, enabled=false)
	public void addPlaces(){
		Response res = given()
				.queryParam("key", "AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
				.contentType(ContentType.JSON)
				.body("{"
				+ "\"location\": {"
				+ "\"lat\": -33.8669810,"
				+ "\"lng\": 151.1958790"
				+ "},"
				+ "\"accuracy\": 50,"
				+ "\"name\": \"tekarch new place1\","
				+ "\"phone_number\": \"(02) 9374 4000\","
				+ "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","
				+ "\"types\": [\"shoe_store\"],"
				+ "\"website\": \"http://www.google.com.au/\","
				+ "\"language\": \"en-AU\""
				+ "}")
				.when()
				.post("/place/add/json");
					placeId = res.body().path("place_id");//path method to extract something from the body
					System.out.println("place id = " + placeId);
				 
					res.then()
						.statusCode(200)
						.extract().response().prettyPrint();
		
	}
	
	
	@Test(priority=1)
	public void AddPlaceswithPojo(){
		//converting json into my pojo class obj
		Location loc=new Location(-33.8669710,151.1958750); 
		//String[] type = new String[]{"shoe_store"};
		List<String> types=new ArrayList<String>();
		//above three steps are for conversion
		types.add("shoe_store");
		MyPojo places=new MyPojo(loc, 50, "my new shop", "3435","dfjsd dkfjsdkf",types,"www.type.com","english");
		Response res=
		given()
			.queryParam("key","AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
			.contentType(ContentType.JSON)
			.body(places)//// converting java pojo to json request-->serialization
		.when()
			.post("/place/add/json");
		
		placeId=res.body().path("place_id");//retrieving place_id from json body and storing in placeId
		
		// converting json response to java pojo-->de serialization
		ResToPojo resObj=res.as(ResToPojo.class);
		System.out.println("scope of response="+resObj.scope);
		
		res.then()
			.statusCode(200)	//validating thestatus code
			.extract().response().prettyPrint(); //printing the response to console
	}
	
	@Test(priority=2)
	public void getDetailsOnPlace(){
		Response res = given()
				.queryParam("key", "AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
				.queryParam("placeid", placeId)
		.when()
				.get("/place/details/json");
		res.prettyPrint();
					System.out.println("new place id = " + placeId);
	}
	
	@Test(priority=3)
	public void deleteNewlyAddedPlace(){
		Response res = given()
				.queryParam("key", "AIzaSyD09tZhBvJp2rwEz7UzaQlRcjjGeP3kZMM")
				.contentType(ContentType.JSON)
				.body("{\"place_id\": \""+placeId+"\"}")
				
		.when()
				.post("/place/delete/json");
		//res.then().statusCode(200);
		res.prettyPrint();
		
	}*/
	//pojo.sodhanalibrary.com for converting json to pojo
	
}
