package com.test.RestAssuredToolsQa;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class TQA_POST_employee24 
{
	static JSONObject employee24;
	
	public void employee24_data()
	{
		employee24=new JSONObject();
		
		employee24.put("firstName", "Jack");
		employee24.put("lastName", "Smith");
		employee24.put("age", 32);
		employee24.put("address", "B-54,Sector-4,Airoli,NaviMumbai");
		employee24.put("postcode",400708);
		
		JSONObject data1=new JSONObject();
		
		data1.put("dept", "IT");
		data1.put("deptCode", "DEPT85");
		data1.put("compCode", 8485);
		
		JSONObject data2=new JSONObject();
		
		data2.put("name", "GitHub");
		data2.put("email","noreply@github.com");
        data2.put("date","2020-07-13T03:11:11Z");
        
        JSONObject data2Sub=new JSONObject();
        data2Sub.put("limit", 30);
        data2Sub.put("offset", 150);
        data2Sub.put("total", 30);
        
        data2.put("lim2", data2Sub);

		JSONObject arr1=new JSONObject();
        
		arr1.put("driverId", "michael_schumacher");
		arr1.put("code", "MSC");
        arr1.put("url","http://en.wikipedia.org/wiki/Michael_Schumacher");
        arr1.put("givenName", "Michael");
        arr1.put("familyName", "Schumacher");
        arr1.put("dateOfBirth", "1969-01-03");
        arr1.put("nationality", "German");
        arr1.put("id", 1);

		JSONObject arr2=new JSONObject();
		arr2.put("driverId", "barrichello");
		arr2.put("code", "BAR");
		arr2.put("url", "http://en.wikipedia.org/wiki/Rubens_Barrichello");
		arr2.put("givenName",  "Rubens");
		arr2.put("familyName", "Barrichello");
		arr2.put("dateOfBirth", "1972-05-23");
		arr2.put("nationality", "Brazilian");
		arr2.put("id", 2);
		
        JSONArray arr=new JSONArray();
        
        arr.put(arr1);
        arr.put(arr2);
        
        JSONObject dataComp=new JSONObject();
        
        dataComp.put("record_1", data1);
        dataComp.put("record_2", data2);
               
		employee24.put("department", dataComp);
		employee24.put("arrays", arr);
		
		JSONObject rec3=new JSONObject();
		
		rec3.put("driverId", "alonso");
		rec3.put("permanentNumber", "14");
		rec3.put( "code", "ALO");
		rec3.put("url", "http://en.wikipedia.org/wiki/Fernando_Alonso");
		rec3.put("givenName", "Fernando");
		rec3.put("familyName", "Alonso");
		rec3.put("dateOfBirth", "1981-07-29");
		rec3.put("nationality", "Spanish");
		
		//employee24.put("arrays",rec3);
		
		
	}
	
	
	public void POSTRequest(JSONObject obj, String URI)
	{
		given().
			header("content-type","application/json").
			body(obj.toString()).
		when().
			post(URI).
		then().
			statusCode(201);
	}
	
	
	public static void main(String[] args) 
	{
		TQA_POST_employee24 request=new TQA_POST_employee24();
		
		request.employee24_data();
		request.POSTRequest(employee24,"http://localhost:3000/employee24");
		
		System.out.println("Success");
		
	
	}

}
