package stepDefinations;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@deleteplace")
	public void before() throws Throwable
	{
		if(stepDefination.place_id==null)
		{
		stepDefination m = new stepDefination();
		m.add_place_payload_with("Sania", "Marathi", "Mumbai");
		m.send_the_https_request_and_hit_the_server_by_using("AddPlace", "post");
		m.it_should_give_successful_response();
		m.after_addplace_validate_through_that_is_added("getPlace", "Rabina");
		}
	}
	

}
