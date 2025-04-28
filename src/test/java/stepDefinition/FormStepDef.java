package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class FormStepDef {

    WebDriver driver;

    @Given("launching the form page")
    public void launchingPage(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
        Assert.assertEquals("DEMOQA",driver.getTitle());
    }

    @When("the form is submitted by filling the required details")
    public void formSubmitting(){
        driver.findElement(By.xpath("//h1[@class='text-center']")).isDisplayed();
        System.out.println("Practice Form title is displayed");

        driver.findElement(By.id("firstName")).sendKeys("Naresh");
        driver.findElement(By.id("lastName")).sendKeys("Pyla");
        driver.findElement(By.id("userEmail")).sendKeys("naresh123@gmail.com");
        WebElement radioButton = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", radioButton);
        radioButton.click();
        driver.findElement(By.id("userNumber")).sendKeys("1234567890");
        driver.findElement(By.id("dateOfBirthInput")).click();
        Select select = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        select.selectByValue("2000");

        Select selectMonth = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        selectMonth.selectByValue("9");

        driver.findElement(By.xpath("//div[text()='10']")).click();
//        driver.findElement(By.id("subjectsInput")).sendKeys("English");
//        driver.findElement(By.xpath("//*[text()='English']")).click();
        driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();

        WebElement addFile = driver.findElement(By.id("uploadPicture"));
        addFile.sendKeys("C:\\Users\\nares\\Downloads\\kakashi.jpeg");

        WebElement submitButton = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();

    }

    @Then("the form is successfully submitted")
    public void theFormIsSuccessfullySubmitted() {
        driver.findElement(By.className("modal-content")).isDisplayed();
        System.out.println("form submitted successfully");
        driver.quit();
    }

    @Given("This is a test precondition")
    public void thisIsATestPrecondition() {
        System.out.println("This is a test precondition");
    }

    @When("This is a test action")
    public void thisIsATestAction() {
        System.out.println("This is a test action");

    }

    @Then("This is a test result")
    public void thisIsATestResult() {
        System.out.println("This is a test result");
    }
}
