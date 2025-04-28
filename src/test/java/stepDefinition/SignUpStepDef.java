package stepDefinition;

import fileReader.Customer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;


public class SignUpStepDef {

    private TextContext textContext;

    public SignUpStepDef(TextContext textContext){
        this.textContext = textContext;
    }

    @When("user tries to signUp existing user {string} and {string}")
    public void userTriesToSignUpExistingUserAnd(String name, String password) {
        textContext.getPageObjectManager().getSignUpPage().clickSignInButton();
        assertThat(textContext.getPageObjectManager().getSignUpPage().waitForPageLoad()).isTrue();
        textContext.getPageObjectManager().getSignUpPage().signUp(name, password);

    }

    @Then("user should see existing user error")
    public void userShouldSeeExistingUserError() {
        textContext.getPageObjectManager().getSignUpPage().handlingExistingUserAlert();
        textContext.getPageObjectManager().getSignUpPage().closeSignUpPrompt();
    }

    @When("new user tries to signUp")
    public void newUserTriesToSignUp() {
        textContext.getPageObjectManager().getSignUpPage().clickSignInButton();
        assertThat(textContext.getPageObjectManager().getSignUpPage().waitForPageLoad()).isTrue();
        Customer customer = textContext.getFileReaderManager().getJsonFileReader().getCustomerByName("Lakshay");
        textContext.getPageObjectManager().getSignUpPage().signUp(customer.userName+ new Random().nextInt(10000), customer.password);
    }

    @Then("user should be signed up successfully")
    public void userShouldBeSignedUpSuccessfully() {
        textContext.getPageObjectManager().getSignUpPage().handlingNewUserAlert();
    }

    @When("user logs into the application with {string} and {string}")
    public void userLogsIntoTheApplicationWithAnd(String name, String password) {
        assertThat(textContext.getPageObjectManager().getHomePage().verifyLogInButton()).isTrue();
        textContext.getPageObjectManager().getHomePage().clickLogInButton();
        assertThat(textContext.getPageObjectManager().getLogInPage().waitForPageLoad()).isTrue();
        textContext.getPageObjectManager().getLogInPage().passingDetails(name,password);
    }

    @Then("user should be signedIn successfully")
    public void userShouldBeSignedInSuccessfully() {
        textContext.getPageObjectManager().getLogInPage().verifyingWelcomeButton();
    }

    @And("verifying logout button")
    public void verifyingLogoutButton() {
        textContext.getPageObjectManager().getLogInPage().verifyingLogoutButton();
    }
}
