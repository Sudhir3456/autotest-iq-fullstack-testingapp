package com.autotestiq.autotest_iq.service;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autotestiq.autotest_iq.model.TestStep;
import com.autotestiq.autotest_iq.repository.TestStepRepository;

@Service
public class SeleniumExecutorService {

	@Autowired
	private TestStepRepository testStepRepository;

	public void executeTest(Long testCaseId) throws InterruptedException {

		
		if (testCaseId == 20) {
			
			
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			Thread.sleep(9000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			driver.get("https://demowebshop.tricentis.com/search?q=computer&pagesize=12");
			Thread.sleep(9000);


			WebElement searchBox = driver.findElement(By.id("small-searchterms"));
			Thread.sleep(9000);


			searchBox.sendKeys("Computer");

			WebElement SearchButton = driver.findElement(By.xpath("//input[@type='submit']"));
			Thread.sleep(9000);


			SearchButton.click();
			
			System.out.println("debWebShop Run seccesfully....");

			driver.close();
			
		} 
		
		else if (testCaseId == 21) {
			
			
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			Thread.sleep(9000);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			driver.get("https://sudhir3456.github.io/sudhir-portfolio/");
			Thread.sleep(9000);


			System.out.println("Portfilo test run seccesfully....");
 			
 

			
		}
		else {

			System.out.println("Somthing is wrong");
		}
		
		
	
	}

	private void executeStep(WebDriver driver, TestStep step) {
		try {

			System.out.println("Enter in EcecuteStep !");
			String action = step.getAction().toLowerCase();
			System.out.println("Enter in EcecuteStep 2");

			// Step: openUrl (direct navigation)
			if (action.equals("openurl") && step.getUrl() != null) {
				System.out.println("Enter in EcecuteStep 3");

				driver.get(step.getUrl());
				Thread.sleep(9000);
				return;
			}
			System.out.println("Enter in EcecuteStep 4");

			// Step: locate element
			WebElement element = null;
			switch (step.getLocatorType().toLowerCase()) {
			case "id":
				element = driver.findElement(By.id(step.getLocatorValue()));
				break;
			case "name":
				element = driver.findElement(By.name(step.getLocatorValue()));
				break;
			case "xpath":
				element = driver.findElement(By.xpath(step.getLocatorValue()));
				break;
			case "css":
				element = driver.findElement(By.cssSelector(step.getLocatorValue()));
				break;
			}

			// Step: perform action on element
			if (element != null) {
				switch (action) {
				case "click":
					element.click();
					break;
				case "sendkeys":
					element.sendKeys(step.getInputData());
					break;
				// Add more actions here as needed
				}
			}

			Thread.sleep(1000); // optional delay for stability

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}