package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactStepDef {


    WebDriver driver = new ChromeDriver();
    WebElement element;

    @Given("clicking the contact text")
    public void clickingTheText(){
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()='Contact']")).click();
    }
    @When("Entering the details")
    public void EnteringDetails(){
        driver.findElement(By.xpath("//input[@id='recipient-email']")).sendKeys("naresh@gmail.com");
        driver.findElement(By.xpath("//input[@id='recipient-name']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//textarea[@id='message-text']")).sendKeys("Good Bye");;
    }

    @Then("closing the pop up")
    public void closingThePopUp(){
        element = driver.findElement(By.xpath("//button[text() = 'Send message']/preceding-sibling::button"));
        element.click();
        driver.quit();
    }
}
