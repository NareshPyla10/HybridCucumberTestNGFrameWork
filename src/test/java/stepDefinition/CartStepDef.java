package stepDefinition;

import fileReader.Customer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.flogger.Flogger;

import static org.assertj.core.api.Assertions.assertThat;

public class CartStepDef {
    private TextContext textContext;

    public CartStepDef(TextContext textContext){
        this.textContext = textContext;
    }


    @When("verifying cart button functionality")
    public void verifyingCartButtonFunctionality() {
        textContext.getPageObjectManager().getCartPage().verifyingCartButton();
    }



    @Then("placing an order with clicking purchase button")
    public void placingAnOrderWithClickingPurchaseButton() {
        textContext.getPageObjectManager().getCartPage().clickingPlaceOrderButton();
        Customer customer = textContext.getFileReaderManager().getJsonFileReader().getCustomerByName("Lakshay");
        textContext.getPageObjectManager().getCartPage().placingOrder(customer.name, customer.country, customer.city, customer.creditCard , customer.month, customer.year);
        textContext.getPageObjectManager().getCartPage().clickPurchaseButton();
    }

    @Then("placing an order with clicking close button")
    public void placingAnOrderWithClickingCloseButton() {
        textContext.getPageObjectManager().getCartPage().clickingPlaceOrderButton();
        Customer customer = textContext.getFileReaderManager().getJsonFileReader().getCustomerByName("Lakshay");
        textContext.getPageObjectManager().getCartPage().placingOrder(customer.name, customer.country, customer.city, customer.creditCard , customer.month, customer.year);
        textContext.getPageObjectManager().getCartPage().clickCartCloseButton();
    }

    @Then("selecting the required category {string}")
    public void selectingTheRequiredCategory(String category) {
        assertThat(textContext.getPageObjectManager().getHomePage().isRequiredProductDisplayed(category)).isTrue();
        textContext.getPageObjectManager().getHomePage().clickTheReqProduct(category);
    }

    @Then("selecting the required product {string}")
    public void selectingTheRequiredProduct(String product) {
        assertThat(textContext.getPageObjectManager().getHomePage().isRequiredProductDisplayed(product)).isTrue();
        textContext.getPageObjectManager().getHomePage().clickTheReqProduct(product);
        textContext.getPageObjectManager().getCartPage().clickAddToCartButtonAndGoToCartPage();
        textContext.getPageObjectManager().getCartPage().verifyingCartButton();
        textContext.getPageObjectManager().getCartPage().verifyingProduct(product);
    }

    @And("placing the order")
    public void placingTheOrder() {
        textContext.getPageObjectManager().getCartPage().clickingPlaceOrderButton();
    }


    @Then("clicking the place order button")
    public void clickingThePlaceOrderButton() {
        textContext.getPageObjectManager().getCartPage().clickingPlaceOrderButton();
    }

    @And("user details passing through data table")
    public void userDetailsPassingThroughDataTable(DataTable userCredentials) {
        textContext.getPageObjectManager().getCartPage().userEnterDetailsThroughDataTables(userCredentials);
        textContext.getPageObjectManager().getCartPage().clickPurchaseButton();
    }

    @And("deleting the order")
    public void deletingTheOrder() {
        textContext.getPageObjectManager().getCartPage().deleteTheOrder();
    }

//    @And("product verifying also placing an order")
//    public void productVerifyingAlsoPlacingAnOrder() {
//        textContext.getPageObjectManager().getCartPage().verifyingProduct("Samsung galaxy s6");
//    }
}
