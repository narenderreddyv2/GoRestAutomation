package api.Endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints4 {
	
	static ResourceBundle getURL(){
		ResourceBundle resources = ResourceBundle.getBundle("routes");
		return resources;
	}
	
	public static Response createUser(User payload)
	{
		String Post_url=getURL().getString("Post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Authorization","Bearer 7d5f36f2b012c42c3e3d78275821ec13602a026ebbedbd71a9dc25ff1856e074")
		.body(payload)
		
	
		.when()
		.post(Post_url);
		
		return response;
	}
	public static Response listUsers()
	{
		String Get_url=getURL().getString("Get_url");
		Response response=given()
				.header("Authorization","Bearer 7d5f36f2b012c42c3e3d78275821ec13602a026ebbedbd71a9dc25ff1856e074")
				
		.when()
		.get(Get_url);
		
		return response;
	}
		public static Response GetUser(int id)
		{
			String GetUser_url=getURL().getString("GetUser_url");
			Response response=given()
					.pathParam("id",id)
					.header("Authorization","Bearer 7d5f36f2b012c42c3e3d78275821ec13602a026ebbedbd71a9dc25ff1856e074")
					
			.when()
			.get(GetUser_url);
			
			return response;
	}
	public static Response putUser(int id, User payload)
	{
		String Put_url=getURL().getString("Put_url");
		Response response=given()
				.header("Authorization","Bearer 7d5f36f2b012c42c3e3d78275821ec13602a026ebbedbd71a9dc25ff1856e074")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.pathParam("id",id)
				
		.when()
		.put(Put_url);
		
		return response;
	}
	public static Response deleteUser(int id)
	{
		String Delete_url=getURL().getString("Delete_url");
		Response response=given()
				.header("Authorization","Bearer 7d5f36f2b012c42c3e3d78275821ec13602a026ebbedbd71a9dc25ff1856e074")
				.pathParam("id",id)
				
		.when()
		.delete(Delete_url);
		
		return response;
	}
}
