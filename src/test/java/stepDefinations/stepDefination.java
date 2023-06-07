package stepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import dataProperty.DataBuilder;
import dataProperty.Enumclass;
import dataProperty.Utiliti;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class stepDefination extends Utiliti{
	Response post;
	public String respo;
	RequestSpecification gv;
	static String place_id;
	DataBuilder data=new DataBuilder();
	Utiliti ut=new Utiliti();
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
		gv = given().spec(ut.RequestSpecificatio()).body(data.data(name,language,address));
	}

	@When("send the https {string} request and hit the server by using {string}")
	public void send_the_https_request_and_hit_the_server_by_using(String endpoint,String methods) {
		Enumclass Endpoints = Enumclass.valueOf(endpoint);
		if(methods.equalsIgnoreCase("POST"))
		post = gv.when().post(Endpoints.getendpoint());
		else if (methods.equalsIgnoreCase("GET")) 
			post = gv.when().get(Endpoints.getendpoint());			
	}

	@Then("^It should give successful response$")
	public void it_should_give_successful_response() throws Throwable {
		respo = post.then().spec(ut.ResponseSpecificatio())
		.extract().response().asString();
	}

	@Then("the response {string} code should be {string}")
	public void the_response_code_should_be(String key, String value) {
		assertEquals(getJsonPath(respo,key), value);

	}
	@Then("After Addplace Validate through {string} that {string} is added")
	public void after_addplace_validate_through_that_is_added(String endpoint, String expectedname) throws IOException {
		place_id = getJsonPath(respo,"place_id");
		System.out.println(place_id);
		gv = given().spec(ut.RequestSpecificatio()).queryParam("place_id", place_id);
		send_the_https_request_and_hit_the_server_by_using(endpoint,"GET");
		JsonPath js=new JsonPath(post.asString());
		String name = js.getString("name");
		System.out.println(name);
	}
	@Given("Delete place payload")
	public void delete_place_payload() throws IOException {
		gv=given().spec(ut.RequestSpecificatio()).body("{\r\n"
				+ "    \"place_id\":\""+place_id+"\"\r\n"
				+ "}");
	}


}
