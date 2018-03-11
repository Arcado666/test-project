package TestNGtest;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.DataDrivenByCSVFile;
import utils.DataDrivenByExcelFile;

public class testDataDriven {
	@DataProvider(name = "testDateCSV")
	public static Object[][] CSVwords() throws IOException{
		return DataDrivenByCSVFile.getTestData("C:\\Users\\shiqiang\\Desktop\\1.csv");
	}
	@DataProvider(name = "testDateExcel")
	public static Object[][] testDataDrivenByExcelFile() throws IOException{
		return DataDrivenByExcelFile.getTestDate("C:\\Users\\shiqiang\\Desktop\\123.xlsx", "Sheet1");
	}
	@Test(dataProvider = "testDateCSV")
	public void testCSV(String word1,String word2){
		System.out.println(word1+" "+word2);
		
	}
	@Test(dataProvider = "testDateExcel")
	public void testExcel(String word1,String word2){
		System.out.println(word1+" "+word2);
	}

}
