package com.test.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Test_GET2 
{
	
	public void colors2()
	{
		given().
		when().
			get("http://localhost:3000/colors2").
		then().
			statusCode(200).
		assertThat().
			body("Black", equalTo("#000000")).
			body("list2[0].INDIANRED",equalTo("#CD5C5C")).
			body("list2[1].LIGHTCORAL",equalTo("#F08080")).
			body("list2[2].SALMON",equalTo("#FA8072")).
			body("list2[3].DARKSALMON",equalTo("#E9967A")).
			body("list2[4].LIGHTSALMON",equalTo("#FFA07A")).
		and().
			header("Content-Type", equalTo("application/json; charset=utf-8")).
			header("ETag",equalTo("W/\"14a-oO8MzCSYAn/HcJczvXdMXXX9pAo\""));
		
	}
	
	public void webapp()
	{
		given().
		when().
			get("http://localhost:3000/web-app").
		then().
			statusCode(200).
		assertThat().
			body("servlet[0].servlet-name",equalTo("cofaxCDS")).
			body("servlet[0].servlet-class",equalTo("org.cofax.cds.CDSServlet")).
			body("servlet[0].init-param.templateProcessorClass",equalTo("org.cofax.WysiwygTemplate"));
		
	
		Response response=RestAssured.request(Method.GET, "http://localhost:3000/web-app");
		
		JSONObject obj=new JSONObject(response.asString());
				
		System.out.println(obj.getJSONArray("servlet").getJSONObject(0).getJSONObject("init-param").get("configGlossary:installationAt"));
		
		
	}
	
	public void example2()
	{
		given().
		when().
			get("http://localhost:3000/example2").
		then().
			statusCode(200).log().all().
		assertThat().
			body("id",equalTo("0001")).
			body("type",equalTo("donut")).
			body("name",equalTo("Cake")).
			body("batters.batter[0].id",equalTo("1001"));
	}
	
	
	
	public static void main(String[] args) 
	{
		Test_GET2 obj=new Test_GET2();
		//obj.colors2(); 
		
		obj.webapp();
		
		//obj.example2();
		
		System.out.println("Test Success");
	}

}
