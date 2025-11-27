package testscript;

import java.awt.AWTException;
import org.openqa.selenium.NoSuchElementException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload extends Base {
	@Test
	void fileUploadUsingSendKeys() {
		driver.navigate().to("https://the-internet.herokuapp.com/upload");
		WebElement choosefile=driver.findElement(By.xpath("//input[@id='file-upload']"));
		choosefile.sendKeys("C:\\Users\\Saritha R S\\Downloads\\Selenium notes (2).pdf");
		WebElement upload=driver.findElement(By.xpath("//input[@id='file-submit']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//Explicit Wait
		wait.until(ExpectedConditions.elementToBeClickable(upload));
		upload.click();
	}
	@Test
	void fileUploadUsingRobotCLass() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement selectpdf=driver.findElement(By.xpath("//span[text()='Select PDF file']"));
		//Fluent Wait
		Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(selectpdf));
		selectpdf.click();
		//to give filepath use StringSelection
		StringSelection s=new StringSelection("C:\\Users\\Saritha R S\\Downloads\\Selenium notes (2).pdf");
		//these methods are inside toolkit, to copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);//to copy
		Robot r=new Robot();//to paste//to perform keyboard events
		r.delay(2500);//time taken to copy and paste
		//Classes inside Robot
		//Constants inside KeyEvent
		//VK-Virtual Key
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
