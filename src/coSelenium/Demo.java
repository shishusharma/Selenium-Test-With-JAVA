package coSelenium;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public Demo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		try {
			String arr[][]= {{"s@gmail.com","12345"},{"shisu@gmail.com","12456"}};
			for(int i = 0; i<2;i++) {
				System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver\\chromedriver.exe");
				driver=new ChromeDriver();
			
				driver.get("http://localhost/userdashboard/login.php");
				
				driver.manage().window().maximize();
				driver.findElement(By.name("uemail")).sendKeys(arr[i][0]);
				Thread.sleep(2000);
				driver.findElement(By.name("password")).sendKeys(arr[i][1]);
				Thread.sleep(2000);
				driver.findElement(By.name("login")).click();
				Thread.sleep(2000);
				
				String at=driver.getTitle();
				String et="Dashboard | Registration and Login System";

				if(!(at.equalsIgnoreCase(et))) {
					System.out.println("Test UnSuccessfull Check Id and Password");
					driver.close();
					break;
				}

				
				
				driver.findElement(By.id("chis")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("logout")).click();	
				Thread.sleep(2000);
				at=driver.getTitle();
				et="PHP PROJECT";
				driver.close();
				if(at.equalsIgnoreCase(et)) {
					System.out.println("Test Successfull");
				}else{
					System.out.println("Test UnSuccessfull");
				}
			}
		
		}catch(Exception ex) {
			System.out.println("Test UnSuccessFull");
			driver.close();
		}

	}

}
