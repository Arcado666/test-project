package utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DataDrivenByCSVFile {
	/**
	 * 读取csv文件里面的数据  并返回一个object对象的二维数组
	 * @param fileName  csv文件的路径
	 * @return
	 * @throws IOException
	 */
	public static Object[][] getTestData(String fileName) throws IOException{
		List<Object[]> records = new ArrayList<Object[]>();
		String record;
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
		//忽略csv文件的第一行
		file.readLine();
		
		while ((record=file.readLine()) != null) {
			
			String fields[] = record.split(",");
			records.add(fields);
			
		}
		file.close();
		Object[][] results = new Object[records.size()][];
		for (int i = 0;i <records.size(); i++){
			results[i] = records.get(i);
		}
		return results;
	}
	public static void main(String[] args){
		Object string[][] ;
		try {
			string = DataDrivenByCSVFile.getTestData("C:\\Users\\shiqiang\\Desktop\\1.csv");
			for(int i = 0 ;i <string.length;i++){
				for(int j= 0 ;j < string[i].length;j++){
					System.out.println(string[i][j]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
