package com.qa.rest.tests;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import resources.TestDataBuild;



public class PostObjectBDD {

	TestDataBuild data =new TestDataBuild();	

	//Create New Object with out Auth.
	@Test(priority=0)	
	public void post_Object_WithAuth(){

		String response =
				given().log().all().
				header("Authorization","Bearer 1234").
				header("Content-Type","application/json").
				body(data.addObjectPayLoad("Girish", "IBMDemo", 1)).
				when().post("Your EndPoint").
				then().
				assertThat().
				statusCode(201).extract().response().asString();
		
		System.out.println(response);

		JsonPath js = new JsonPath(response); // Parsing Json response.
		String name = js.getString("name");
		String description = js.getString("description");
		int id = js.getInt("id");

		//Validation.
		Assert.assertEquals(name, "Girish");
		Assert.assertEquals(description, "IBMDemo");
		Assert.assertEquals(id, "1");
	}


	//Create New Object with out Auth Validate 401 Status code.
	@Test(priority=1)	
	public void post_Object_WithNoAuth(){

		String response =given().log().all().				
				header("Content-Type","application/json").
				body(data.addObjectPayLoad("Girish", "IBMDemo", 1)).
				when().post("https://EndPoint").
				then().
				assertThat().
				statusCode(401).extract().response().asString();
		System.out.println(response);

	}
}
