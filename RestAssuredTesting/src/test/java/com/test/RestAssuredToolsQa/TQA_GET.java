package com.test.RestAssuredToolsQa;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;


public class TQA_GET 
{
	public static void main(String[] args) 
	{
				
		Response response=RestAssured.request(Method.GET, "http://localhost:3000/emp");
		
		JSONObject obj=new JSONObject(response.asString());
		
		System.out.println(obj.get("age"));
		
		
		System.out.println(response.body().asString());
		
		System.out.println(response.getStatusCode());
		
		System.out.println(response.getStatusLine());
		
		//System.out.println(response.getHeaders());
		
		/*
		System.out.println("\n");
		Headers allHeaders=response.headers();
		
		for (Header val:allHeaders) 
		{
			System.out.println(val.getName());
		}
		*/
		
		
		given().
		when().
			get("http://localhost:3000/emp").
		then().
			statusCode(200).
		assertThat().
			body("name", equalTo("John")).
			body("age",equalTo(30)).
			body("car",equalTo(null)).
			body("name2",equalTo("Sugat")).
		and().
			header("Content-Type", "application/json; charset=utf-8");
		
		System.out.println("Test Successful");
			
	}

}