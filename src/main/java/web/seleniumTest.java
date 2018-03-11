package web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumTest {
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.jd.com/");
    }
}
  