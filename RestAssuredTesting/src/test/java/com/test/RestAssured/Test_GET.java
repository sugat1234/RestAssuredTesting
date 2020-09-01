package com.test.RestAssured;

import org.hamcrest.collection.HasItemInArray;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import com.base.RestAssured.Data;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;

public class Test_GET 
{
	Data obj=new Data();
	HashMap<String, String> data;
	
	@Test
	public void test_01()
	{
		Response response=RestAssured.get("http://localhost:3000/employee24");
		
		//System.out.println(response.asString());
		
		//Status Code
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
		//Header Details
/*		System.out.println(response.getHeader("X-Powered-By"));
		System.out.println(response.getHeader("Vary"));
		System.out.println(response.getHeader("Access-Control-Allow-Credentials"));
		System.out.println(response.getHeader("Cache-Control"));
		System.out.println(response.getHeader("Pragma"));
		System.out.println(response.getHeader("Expires"));
		System.out.println(response.getHeader("X-Content-Type-Options"));
		System.out.println(response.getHeader("Content-Type"));
		System.out.println(response.getHeader("Content-Length"));
		System.out.println(response.getHeader("ETag"));
		System.out.println(response.getHeader("Date"));
		System.out.println(response.getHeader("Connection"));
	*/
	}
	
	@Test
	public void test_02_employee24() throws IOException
	{
		obj.getData("Employee24", 2);
		
		data=obj.getHashMap();
		 
		for (int i = 0; i < obj.fieldNameList.size(); i++) 
		{
			if(obj.fieldTypeList.get(i).equalsIgnoreCase("int"))
			{
				given()
				.get("http://localhost:3000/employee24")
				.then()
					.statusCode(200)
					.assertThat()
					.body(obj.fieldNameList.get(i), equalTo(Integer.parseInt(obj.fieldValueList.get(i))));				
			}
			else
			{
				given()
				.get("http://localhost:3000/employee24")
				.then()
					.statusCode(200)
					.assertThat()
					.body(obj.fieldNameList.get(i), equalTo(obj.fieldValueList.get(i)));				
			}
			

		}
		
		/*
			.body("firstName", equalTo(data.get("firstName")))
			.body("lastName",equalTo(data.get("lastName")))
			.body("gender",equalTo(data.get("gender")))
			.body("address.streetAddress", equalTo(data.get("address.streetAddress")))
			.body("address.city", equalTo(data.get("address.city")))
			.body("address.state", equalTo(data.get("address.state")))
			.body("address.postalCode", equalTo(data.get("address.postalCode")))
			.body("phoneNumbers[0].type", equalTo(data.get("phoneNumbers[0].type")))
			.body("phoneNumbers[0].number", equalTo(data.get("phoneNumbers[0].number")));
		*/
	}
	
	@Test
	public void test_03_users() throws IOException
	{
		obj.getData("Users", 2);
		
		data=obj.getHashMap();
		
		given()
			.get("http://localhost:3000/users")
		.then()
		.statusCode(200)
		.assertThat()
			.body("[0].id", equalTo(Integer.parseInt(data.get("[0].id"))))
			.body("[0].name", equalTo(data.get("[0].name")))
			.body("[0].address", equalTo(data.get("[0].address")))
			.body("[0].phoneNo", equalTo(data.get("[0].phoneNo")))
			.body("[1].id", equalTo(Integer.parseInt(data.get("[1].id"))))
			.body("[1].name", equalTo(data.get("[1].name")))
			.body("[1].address", equalTo(data.get("[1].address")))
			.body("[1].phoneNo", equalTo(data.get("[1].phoneNo")))
			.body("[2].id", equalTo(Integer.parseInt(data.get("[2].id"))))
			.body("[2].name", equalTo(data.get("[2].name")))
			.body("[2].address", equalTo(data.get("[2].address")))
			.body("[2].phoneNo", equalTo(data.get("[2].phoneNo")))
			.body("[3].id", equalTo(Integer.parseInt(data.get("[3].id"))))
			.body("[3].name", equalTo(data.get("[3].name")))
			.body("[3].address", equalTo(data.get("[3].address")))
			.body("[3].phoneNo", equalTo(data.get("[3].phoneNo")));
	}
	
	@Test
	public void test_04_Example2() throws IOException
	{
		obj.getData("Example2", 2);
		
		data=obj.getHashMap();
		
		given()
			.get("http://localhost:3000/Example2")
		.then() 
			.statusCode(200)
		.assertThat()
			.body("id", equalTo(data.get("id")))
			.body("type", equalTo(data.get("type")))
			.body("name", equalTo(data.get("name")))
		//	.body("ppu", equalTo(new Double(data.get("ppu"))))
			.body("batters.batter[0].id", equalTo(data.get("batters.batter[0].id")))
			.body("batters.batter[0].type", equalTo(data.get("batters.batter[0].type")))
			.body("topping[0].id", equalTo(data.get("topping[0].id")))
			.body("topping[0].type", equalTo(data.get("topping[0].type")));
	}
	
	
	@Test
	public void test_05_colors() throws IOException
	{
		obj.getData("Colors",2);
		
		data=obj.getHashMap();
		
		given()
			.get("http://localhost:3000/colors")
		.then()
			.statusCode(200)
		.assertThat()
			.body("[0].color", equalTo(data.get("[0].color")))
			.body("[0].category", equalTo(data.get("[0].category")))
			.body("[0].type", equalTo(data.get("[0].type")))
			.body("[0].code.hex", equalTo(data.get("[0].code.hex")))
			.body("[0].code.rgba[0]", equalTo(Integer.parseInt(data.get("[0].code.rgba[0]"))))
			.body("[0].code.rgba[1]", equalTo(Integer.parseInt(data.get("[0].code.rgba[1]"))))
			.body("[0].code.rgba[2]", equalTo(Integer.parseInt(data.get("[0].code.rgba[2]"))))
			.body("[0].code.rgba[3]", equalTo(Integer.parseInt(data.get("[0].code.rgba[3]"))));
	}
	
	@Test
	public void test_06_colors2() throws IOException
	{
		obj.getData("Colors2",2);
		
		data=obj.getHashMap();
		
		for (int j = 0; j < obj.fieldNameList.size(); j++) 
		{
			given()
			.get("http://localhost:3000/colors2")
		.then()
			.statusCode(200)
		.assertThat()
			.body(obj.fieldNameList.get(j), equalTo(obj.fieldValueList.get(j)));		
			
        	System.out.println(obj.fieldNameList.get(j)+" : "+obj.fieldValueList.get(j));	
		}
		
		/*
		given()
			.get("http://localhost:3000/colors2")
		.then()
			.statusCode(200)
		.assertThat()
			.body("aliceblue", equalTo(data.get("aliceblue")))
			.body("antiquewhite",equalTo(data.get("antiquewhite")))
			.body("aqua",equalTo(data.get("aqua")))
			.body("aquamarine", equalTo(data.get("aquamarine")))
			.body("azure",equalTo(data.get("azure")))
			.body("beige",equalTo(data.get("beige")))
			.body("bisque",equalTo(data.get("bisque")))
			.body("black",equalTo(data.get("black")))
			.body("blanchedalmond",equalTo(data.get("blanchedalmond")))
			.body("blue",equalTo(data.get("blue")))
			.body("blueviolet",equalTo(data.get("blueviolet")))
			.body("brown",equalTo(data.get("brown")));
		*/
	}

}
