package com.test.RestAssuredToolsQa;

import static io.restassured.RestAssured.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TQA_POST_example2 
{
	public static void main(String[] args) 
	{	
		
		JSONObject obj1=new JSONObject();
		
		obj1.put("val1", "abc");
		obj1.put("val2", 23);		

		JSONObject obj2=new JSONObject();
		obj2.put("val1", "pqr");
		obj2.put("val2", 28);
		
		JSONArray arr=new JSONArray();
		arr.put(obj1);
		arr.put(obj2);
		
		JSONObject example2=new JSONObject();
		example2.put("topping2", arr);
		
		
		given().
			header("content-type","application/json").
			body(example2.toString()).
		when().
			patch("http://localhost:3000/example2").
		then().
			statusCode(200);
		
		
		System.out.println("Success");
		
		Response resp=RestAssured.get("http://localhost:3000/example2");
		
		JSONObject obj=new JSONObject(resp.asString());
		
		System.out.println(obj.getJSONArray("topping2").get(0));
		
		JSONObject obj3=new JSONObject();
		obj3.put("val1", "lmn");
		obj3.put("val2", 45);
		
		JSONArray arr3=new JSONArray();
		arr3.put(obj3);
		
		JSONObject exam2=new JSONObject();
		exam2.put("topping2", obj3);
		
/*		given().
		header("content-type","application/json").
		body(exam2.toString()).
	when().
		patch("http://localhost:3000/example2").
	then().
		statusCode(200);
		
		
		System.out.println("Success2");
		
*/
	}

}
