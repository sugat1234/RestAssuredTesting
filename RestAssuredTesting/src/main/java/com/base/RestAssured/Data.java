package com.base.RestAssured;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

public class Data 
{
	XSSFWorkbook book;
	public XSSFSheet sheet;
	XSSFCell fieldType,fieldName, fieldValue;
	HashMap<String, String> testData;
	public ArrayList<String> fieldTypeList,fieldNameList, fieldValueList ;
	
    public void getData(String sheetName, int col) throws IOException
    {
    	book=new XSSFWorkbook("C:\\Users\\sugat\\Google Drive\\API Testing\\RestAssured.xlsx");
    	
    	sheet=book.getSheet(sheetName);
    	
    	testData=new HashMap<String, String>();
    	
    	fieldTypeList=new ArrayList<String>();
    	fieldNameList=new ArrayList<String>();
    	fieldValueList=new ArrayList<String>();
    		
    	for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) 
    	{
    		fieldType=sheet.getRow(i).getCell(0);
    		fieldName=sheet.getRow(i).getCell(1);
    		fieldValue=sheet.getRow(i).getCell(col);
    		
    //		System.out.println(fieldName.getStringCellValue()+" "+fieldValue.getStringCellValue());
    		
    		testData.put(fieldName.getStringCellValue(), fieldValue.getStringCellValue());
    		
    		fieldTypeList.add(fieldType.getStringCellValue());
    		fieldNameList.add(fieldName.getStringCellValue());
    		fieldValueList.add(fieldValue.getStringCellValue());
    		
		}
    	
    }
   
    
    public HashMap<String, String> getHashMap() throws IOException
    {	
    	return testData;
    }
    
    public void showTestData()
    {    	
    	for (Entry<String, String> entry : testData.entrySet()) 
    	{
    	    System.out.println(entry.getKey() + ":" + entry.getValue().toString());
    	}  
    }
    
    public void showFieldNames()
    {
    	for (int i = 0; i < fieldNameList.size(); i++) 
    	{
        	System.out.println(fieldNameList.get(i)+" "+fieldValueList.get(i));	
		}

    }
	
	
	public static void main( String[] args ) throws IOException
    {
		Data obj=new Data();
		
		String sheetName="Employee24";
		int col=2;
		
		obj.getData(sheetName, col);
		
		//obj.showTestData();
		
		obj.showFieldNames();
		
    }
}
