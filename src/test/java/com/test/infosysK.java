package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

public class infosysK {

	@Test
	public void getUrl() {
		// System.setProperty(null, null)

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// 1.Launching of browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// 2.Navigate to URL
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();

		// 3.to check page is loaded successfully or not

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		Object temp = js1.executeScript("return document.readyState");

		if ("complete".equalsIgnoreCase(temp.toString())) {
			System.out.println("page loaded successfully");
		}

		boolean displayButtom = false;

		WebElement loginButton = driver.findElement(By.xpath("//a[@href=\"/login\"]"));
		displayButtom = loginButton.isDisplayed();
		Assert.assertTrue(displayButtom, "login button is not visible");

		// click on Login button
		if (displayButtom) {
			loginButton.click();

			// verify new user displayed or not
			boolean displaySignupHeader = driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
			Assert.assertTrue(displaySignupHeader, "Sign up header is not visible");

			if (displaySignupHeader) {

				// Enter name and username

				driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("Sonali");
				driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("Sonalimhakave14@gmail.com");
				WebElement button;
				button = driver.findElement(By.xpath("//button[text()='Signup']"));
				// Click on signup button
				button.click();

				// verify that entered account details is visible

				WebElement name, email;
				name = driver.findElement(By.xpath("//input[@id='name']"));
				email = driver.findElement(By.xpath("//input[@id='email']"));

				boolean isNameDisplayed, isEmailDisplayed;
				isNameDisplayed = name.isDisplayed();
				isEmailDisplayed = email.isDisplayed();

				WebElement title, password, days, month, year, country;
				if (isNameDisplayed == true && isEmailDisplayed == true) {
					title = driver.findElement(By.xpath("//input[@id='id_gender2']"));
					title.click();
					password = driver.findElement(By.xpath("//input[@id='password']"));
					password.sendKeys("Iwilldo15#");
					days = driver.findElement(By.xpath("//select[@name='days']"));
					days.sendKeys("15");
					month = driver.findElement(By.xpath("//select[@name='months']"));
					month.sendKeys("1");
					year = driver.findElement(By.xpath("//select[@name='years']"));
					year.sendKeys("1995");
					driver.findElement(By.xpath("//span/input[@name='newsletter']")).click();
					driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Sonali");
					driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("mhakave");
					driver.findElement(By.xpath("//input[@name='company']")).sendKeys("vashi");
					driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("vashi1");
					country = driver.findElement(By.xpath("//select[@id='country']"));
					Select s = new Select(country);
					s.selectByIndex(1);
					driver.findElement(By.xpath("//input[@name='state']")).sendKeys("maharashtra");
					driver.findElement(By.xpath("//input[@name='city']")).sendKeys("pune");
					driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("400000");
					driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys("10000709");
					driver.findElement(By.xpath("//button[text()='Create Account']")).click();
					driver.findElement(By.xpath("//a[text()='Continue']")).click();
					driver.findElement(By.xpath("//a[text()=\" Delete Account\"]")).click();

				}

			}
		}

		driver.close();
	}

}
