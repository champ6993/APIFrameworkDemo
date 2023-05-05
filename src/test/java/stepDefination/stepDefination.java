package stepDefination;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import Resources.APIResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils {

	RequestSpecification request;
	ResponseSpecification res;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;	

	
	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		request = given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		APIResources resourceAPI = APIResources.valueOf(resource); 
		
		System.out.println("Changes done by ANiket to check in git");
		System.out.println(resourceAPI.getResource());
		
		res =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(method.equalsIgnoreCase("POST"))
		response = request.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
			response = request.when().get(resourceAPI.getResource());
		}
	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in response body is {string}")
	public void response_body_is(String statusKey, String statusValue) {
		
		assertEquals(getJsonPath(response,statusKey), statusValue);
	}
	
	@Then("verify place_Id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String Expectedname, String resource) throws IOException {
	    
		place_id = getJsonPath(response,"place_id");
		request = given().spec(requestSpecification()).queryParam("place_id",place_id);
		user_calls_with_http_request(resource, "GET");
		String actualname = getJsonPath(response,"name");
		assertEquals(Expectedname,actualname);
	}
	
	
	@Given("DeletePlace payload")
	public void delete_place_payload() throws IOException {

		request =  given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
	}

}
