package utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageComparison {
	/**
	 * 对比两张图片是否一致
	 * @param expect 预期图片路径
	 * @param actual 实际图片路径
	 * @return
	 * @throws IOException
	 */
	public boolean isImageComparison(String expect,String actual) throws IOException{
		File fileIput =new File(expect);
		File fileOutput = new File(actual);
		BufferedImage bufileInput = ImageIO.read(fileIput);
		DataBuffer dafileIput = bufileInput.getData().getDataBuffer();
		int sizefileInput = dafileIput.getSize();
		BufferedImage bufileOutput = ImageIO.read(fileOutput);
		DataBuffer dafileOutput = bufileOutput.getData().getDataBuffer();
		int sizefileOutput = dafileOutput.getSize();
		boolean matchFlag = true;
		if(sizefileInput == sizefileOutput){
			for(int j = 0;j<sizefileInput;j++){
				if(dafileIput.getElem(j) != dafileOutput.getElem(j)){
					matchFlag = false;
					break;
				}
			}
		} else {
			matchFlag = false;
		}
		return matchFlag;
	}
	
	public static void main(String[] args){
		try {
			System.out.println(new ImageComparison().isImageComparison("C:\\Users\\shiqiang\\Desktop\\1.jpg", "C:\\Users\\shiqiang\\Desktop\\2.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
