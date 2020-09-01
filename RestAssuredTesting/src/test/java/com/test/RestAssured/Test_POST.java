package com.test.RestAssured;

import org.testng.annotations.Test;

import com.base.RestAssured.Data;
import java.util.Map.Entry;

import static io.restassured.RestAssured.*;
import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

public class Test_POST 
{
	
	Data obj=new Data();
	HashMap<String, String> data;
	
	@Test
	public void postTest_01() throws IOException
	{		
		//Get data from Excel in form of HashMap
		obj.getData("Colors2", 1);
		data=obj.getHashMap();
		
		//Convert the HashMap into JSONObject
		JSONObject jsonRequest=new JSONObject(data);
		
		System.out.println(jsonRequest);

		//Submit the HashMap as POST request
		given()
			.header("Content-Type", "application/json")
			.body(jsonRequest.toString())
		.when()
			.post("http://localhost:3000/colors2")
		.then()
			.statusCode(201);
		
		System.out.println("Post Request submitted");
		
	}


}
