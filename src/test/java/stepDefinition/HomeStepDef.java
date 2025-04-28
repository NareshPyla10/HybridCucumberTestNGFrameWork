package stepDefinition;

import fileReader.Customer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeStepDef {

   private  TextContext textContext;

   public  HomeStepDef(TextContext textContext){
       this.textContext = textContext;
   }

   @Given("checking the home text")
   public void checkingTheElement(){
       assertThat(textContext.getPageObjectManager().getHomePage().verifyHomeButton()).isTrue();
   }

   @When("clicking the home text button")
   public void clickingTheButton(){
      textContext.getPageObjectManager().getHomePage().clickHomeButton();
   }

   @Then("quitting the driver")
   public void quit(){
      textContext.getWebDriverManager().quitDriver();
   }



    @And("demo website launched")
    public void demoWebsiteLaunched() {
       assertThat( textContext.getPageObjectManager().getHomePage().launchWebsite(textContext.getFileReaderManager().getPropertyFileReader().getProperty("url"))).contains("STORE");
    }



    @And("user navigates to {string} category")
    public void userNavigatesToCategory(String category) {
       textContext.getPageObjectManager().getHomePage().clickReqCategory(category);
    }

    @And("user clicks on the {string} product")
    public void userClicksOnTheProduct(String product) {
        assertThat(textContext.getPageObjectManager().getHomePage().isRequiredProductDisplayed(product)).isTrue();
        textContext.getPageObjectManager().getHomePage().clickTheReqProduct(product);
    }

    @And("user is on home page")
    public void userIsOnHomePage() {
       assertThat(textContext.getPageObjectManager().getHomePage().verifyHomeButton()).isTrue();
    }

}
