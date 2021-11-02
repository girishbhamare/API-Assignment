package com.qa.rest.tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import com.pojo.TestObject;



public class GetObjectBDD {

	@Test(priority=0)	
	public void get_Object(){				

		TestObject testObject =
				given().log().all().
				header("Authorization","Bearer 1234").   // Optional : if Authorization needed.
				when().
				get("/your/endpoint").
				then().				
				extract().as(TestObject.class);
		
		System.out.println("Return Testobject value is " +testObject);
		System.out.println("Name is : " +testObject.getName().contains("Girish"));
		System.out.println("Description is :" +testObject.getDescription().contains("IBM Demo"));
		System.out.println("Id is :" +testObject.getId());			
		
	}
}