package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor extends Base{
	@Test
	void javaScriptExecutor() {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement message=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		//message.sendKeys("Hello");
		//js.executeScript("arguments[0].value='value';", webelementname);
		js.executeScript("arguments[0].value='Hello';", message);
		WebElement show=driver.findElement(By.id("button-one"));
		//show.click();
		//js.executeScript("arguments[0].click();", webelementname);
		js.executeScript("arguments[0].click();", show);
	}
	@Test
	void scroll() {
		driver.navigate().to("https://www.amazon.in/");
		JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,150)","");
		js.executeScript("window.scrollBy(0,-100)", "");
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");	
	}

}
