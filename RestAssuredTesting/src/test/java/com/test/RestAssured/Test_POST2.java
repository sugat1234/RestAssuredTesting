package com.test.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.http.ContentType;

public class Test_POST2 
{
	public void emp()
	{
		given().
		when().
			get("http://localhost:3000/emp").
		then().
			statusCode(200).
		assertThat().
			body("name",equalTo("John"));
		
		System.out.println("Sucess");
	}
	
	public void emp_POST()
	{
		JSONObject request=new JSONObject();
		
		request.put("name4", "Sugat4");
		
		given().
			header("Content-Type", "application/json").
//			contentType(ContentType.JSON).
//			accept(ContentType.JSON).
			body(request.toString()).
		when().
			patch("http://localhost:3000/emp").
		then().
			statusCode(200);
		
		System.out.println("Patched Successfully");		
	}
	
	public void emp_DELETE()
	{
		given().
		when().
			delete("http://localhost:3000/array1/2").
		then().
			statusCode(200);

		System.out.println("Deleted Successfully");	
	}
	
	
	public static void main(String[] args) 
	{
		Test_POST2 obj=new Test_POST2();
		
		obj.emp_POST();
		
		//obj.emp_DELETE();
	}

}
