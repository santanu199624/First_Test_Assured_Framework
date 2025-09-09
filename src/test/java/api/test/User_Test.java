package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Usre_endpoints;
import api.payloads.User_pojo;
import io.restassured.response.Response;

public class User_Test {
	
	Faker faker;
	User_pojo userPayload;
	
	@BeforeClass
	public void setUpData() {
		faker = new Faker();
		userPayload = new User_pojo();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	
	@Test(priority = 1)
	public void testPostUser(){
		Response response = Usre_endpoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority = 2)
	public void testGetUserByName(){
		Response response = Usre_endpoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
