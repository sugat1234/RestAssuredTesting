package com.test.RestAssuredToolsQa;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TQA_GET2 
{
	
	public static void displayHeaders(String uri)
	{
		Response resp=RestAssured.get(uri);
		
		Headers header=resp.getHeaders();
		
		for(Header s:header)
		{
			System.out.println(s.getName()+"\t"+s.getValue());
		}
		
	}
	
	public static void displayBody(String uri)
	{
		Response resp=RestAssured.get(uri);
		
		System.out.println(resp.getBody().asString());
	}
	
	
	public static void gitHub1()
	{
		given().
		when().
			get("https://api.github.com/users/hadley/orgs").
		then().
			statusCode(200).
		assertThat().
			body("[0].login", equalTo("ggobi")).
			body("[0].id", equalTo(423638)).
			body("[0].node_id",equalTo("MDEyOk9yZ2FuaXphdGlvbjQyMzYzOA==")).
			body("[0].url",equalTo("https://api.github.com/orgs/ggobi")).
		and().
			header("content-type", equalTo("application/json; charset=utf-8"));

		System.out.println("Success");
	}
	
	public static void gitHub2()
	{
		given().
		when().
			get("https://api.github.com/users/hadley/repos").
		then().
			statusCode(200).
		assertThat().
			body("[0].id",equalTo(40423928)).
			body("[0].private",equalTo(false)).
			body("[0].owner.id",equalTo(4196)).
			body("[0].owner.site_admin",equalTo(false)).
			body("[0].owner.type",equalTo("User")).
			body("[0].owner.avatar_url",equalTo("https://avatars3.githubusercontent.com/u/4196?v=4")).
			body("[0].stargazers_count",equalTo(23)).
		and().
			header("content-type", "application/json; charset=utf-8");

		System.out.println("Success");
	}
	
	public static void gitHub3()
	{
		given().
		when().
			get("https://api.github.com/repositories/19438/commits").
		then().
			statusCode(200).
		assertThat().
			body("[0].sha", equalTo("a3019f96d61fb4768e2bbd9e6d9c485636012a08")).
			body("[0].commit.author.date", equalTo("2020-07-13T03:11:11Z")).
			body("[0].commit.committer.name", equalTo("GitHub")).
			body("[0].commit.url", equalTo("https://api.github.com/repos/tidyverse/ggplot2/git/commits/a3019f96d61fb4768e2bbd9e6d9c485636012a08")).
			body("[0].author.id", equalTo(1978793));
		
		System.out.println("Success");
	}
	
	public static void employee24()
	{
		Response resp=RestAssured.get("http://localhost:3000/employee24");
		
		JSONObject obj=new JSONObject(resp.asString());
		
		//System.out.println(obj.getJSONArray("arrays").getJSONObject(0).toString());
		
		System.out.println(obj.getJSONObject("department").getJSONObject("record_2").toString());
		
	}
	
	public static void main(String[] args) 
	{
		//gitHub1();
			
		//gitHub2();
		
		//gitHub3();		
		
		String uri="http://localhost:3000/array1";
		//getHeaders(uri);
		//displayBody(uri);
		
		employee24();
	}

}
