package api.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Endpoints.UserEndpoints2;
import api.Payload.User;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	User userpayload;
	int id;
	Logger logger;

	@BeforeClass
	public void setUp() {

		faker = new Faker();
		userpayload = new User();
		userpayload.setName(faker.name().fullName());
		userpayload.setGender("male");
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setStatus("active");
		
		logger=LogManager.getLogger(this.getClass());
		

	}

	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("**********Creating User*************");

		Response response = UserEndpoints2.createUser(userpayload);
		response.then().log().all();
		id = response.jsonPath().getInt("id");
		System.out.println(id);

		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		logger.info("**********User Created*************");
	}

	//@Test(priority = 2)
	public void testListUser() {
		logger.info("**********Reading Users info*************");

		Response response = UserEndpoints2.listUsers();
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		logger.info("************Users Info displayed*************");
	}
	@Test(priority = 3)
	public void testGetUser() {
		logger.info("**********Reading User info*************");

		Response response = UserEndpoints2.GetUser(id);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		logger.info("************User Info displayed*************");
	}
	@Test(priority = 4)
	public void testUpdateUser() {
		logger.info("**********Updating User*************");

		userpayload.setName(faker.name().fullName());

		userpayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndpoints2.putUser(id, userpayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		logger.info("**********User Updated*************");
	}

	@Test(priority = 5)
	public void testDeleteUser() {
		logger.info("**********Deleting User*************");
		Response response = UserEndpoints2.deleteUser(id);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 204);

		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 204 No Content");
		logger.info("**********User Deleted*************");
	}

}
