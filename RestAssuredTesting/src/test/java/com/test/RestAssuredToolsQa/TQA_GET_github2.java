package com.test.RestAssuredToolsQa;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TQA_GET_github2 
{

	public void getData() throws IOException
	{
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\sugat\\Google Drive\\API Testing\\RestAssured2.xlsx");
		
		XSSFSheet sheet1=book.getSheet("github2");
		
		XSSFCell jsonkey, jsonvalue;
		
		for (int i = 0; i < sheet1.getPhysicalNumberOfRows(); i++) 
		{
			jsonkey=sheet1.getRow(i).getCell(0);
			jsonvalue=sheet1.getRow(i).getCell(1);
			
			System.out.println(jsonkey+"\t"+jsonvalue);
		}
		
	}
	
	public static void main(String[] args) throws IOException 
	{
		XSSFWorkbook book=new XSSFWorkbook("C:\\Users\\sugat\\Google Drive\\API Testing\\RestAssured2.xlsx");
		
		XSSFSheet sheet1=book.getSheet("github2");
		XSSFCell type, jsonkey, jsonvalue;
		
		/*arraylist type, key, value
		 * add data to each arraylist
		 * and run the arraylisty	T	00000	 * 
		 * 
		 * */
		
		for (int i = 0; i < sheet1.getPhysicalNumberOfRows(); i++) 
		{
			jsonkey=sheet1.getRow(i).getCell(0);
			jsonvalue=sheet1.getRow(i).getCell(1);
			
			System.out.println(jsonkey+"\t"+jsonvalue);
			
			given().
			when().
				get("https://api.github.com/users/hadley/repos").
			then().
				statusCode(200).
			assertThat().
				body(jsonkey.getStringCellValue(), equalTo(jsonvalue));
		}
		
		
		
		System.out.println("Success");
	
		
	/*	
		TQA_GET_github2 obj=new TQA_GET_github2();
		
		obj.getData();
		*/
	}

}
