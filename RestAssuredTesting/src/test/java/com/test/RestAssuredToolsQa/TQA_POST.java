package com.test.RestAssuredToolsQa;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class TQA_POST 
{
	static JSONObject obj;
	static JSONArray arr;
	
	public void empBody()
	{
		obj=new JSONObject();
				
		obj.put("name", "John");
		obj.put("age", 30);
		obj.put("car","null");
		obj.put("name2","Sugat");
		obj.put("name4","Sugat4");
		obj.put("email", "yutani.ini@gmail.com");
		obj.put("address.email", "yutani.ini@gmail.com");
		
	}
	
	public void empArr()
	{
		arr=new JSONArray();
		
		JSONObject rec1=new JSONObject();
		
		rec1.put("name", "ABC");
		rec1.put("age", 24);
		rec1.put("height", 152.33);
		rec1.put("isMarried", true);
		rec1.put("hasInsurance", "null");
		
		JSONObject rec2=new JSONObject();
		
		rec2.put("name", "PQR");
		rec2.put("age", 32);
		rec1.put("height", 185.85);
		rec2.put("isMarried", false);
		rec2.put("hasInsurance", "null");
		
		arr.put(rec1);
		arr.put(rec2);
		
	}
	
	public void request_POST()
	{
		given().
			header("content-type", "application/json").
			body(arr.toString()).
		when().
			patch("http://localhost:3000/emp").
		then().
			statusCode(200);
	
		System.out.println("Success");
	}
	
	
	public static void main(String[] args) 
	{
		TQA_POST obj=new TQA_POST();
		
		//obj.empBody();
		
		obj.empArr();
		
		obj.request_POST();
		
	}

}
