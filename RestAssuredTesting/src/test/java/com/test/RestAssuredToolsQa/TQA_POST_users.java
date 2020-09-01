package com.test.RestAssuredToolsQa;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class TQA_POST_users 
{
	public static void main(String[] args) {
		
		
		JSONObject obj=new JSONObject();
		
		obj.put("name", "sugat shivsharan");
		obj.put("address", "B-54, sector-4, airoli, navi mumbai");
		obj.put("phoneNo", "9814445552");
		
		JSONArray arr=new JSONArray();
		
		arr.put(obj);
		
		given().
			header("content-type", "application/json").
			body(arr.toString()).
		when().
			patch("http://localhost:3000/users").
		then().
			statusCode(200);
		
		
	}

}
