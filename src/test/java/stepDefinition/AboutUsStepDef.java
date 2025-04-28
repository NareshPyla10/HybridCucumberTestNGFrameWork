package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.AboutUsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class AboutUsStepDef {
    private final TextContext textContext;

    public AboutUsStepDef(TextContext textContext){
        this.textContext = textContext;
    }

    @Given("verifying the about us button is displayed or not")
    public void verifyingTheButtonIsDisplayedOrNot(){
        assertThat(textContext.getPageObjectManager().getHomePage().waitForPageLoad()).isTrue();
        assertThat(textContext.getPageObjectManager().getHomePage().verifyAboutUsButton()).isTrue();
    }

    @When("clicking the about us text button")
    public void clickingTheAboutUsTextButton() {
        textContext.getPageObjectManager().getHomePage().clickAboutUsButton();
    }

    @When("clicking the close text button")
    public void clickingTheCloseTextButton() {
        assertThat(textContext.getPageObjectManager().getAboutUsPage().waitForPageLoad()).isTrue();
        textContext.getPageObjectManager().getAboutUsPage().closingButton();
    }
}
