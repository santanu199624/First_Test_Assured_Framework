package api.endpoints;

import org.testng.annotations.Test;

import api.payloads.User_pojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// This is user endpoints class
// created for CRUD operations

public class Usre_endpoints {
	
	
	public static Response createUser(User_pojo payload){

		Response response = RestAssured
		.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_url);
		
		return response;
		
		
	}
	
	public static Response readUser(String username){
		Response response = RestAssured
		.given()
			.pathParam("username", username)
		.when()
			.get(Routes.get_url);
			
		return response;
		
	}
	
	public static Response updateUser(String username, User_pojo payload) {
		Response response = RestAssured
		.given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", username)
			.body(payload)
		.when()
			.put(Routes.update_url);
		
		return response;
	}
	
	public static Response deleteUser(String username) {
		Response response = RestAssured
		.given()
			.pathParam("username", username)
		.when()
			.delete(Routes.delete_url);
		
		return response;
	}

}
