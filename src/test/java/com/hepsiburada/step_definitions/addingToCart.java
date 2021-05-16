package com.hepsiburada.step_definitions;

import com.hepsiburada.pages.CartPage;
import com.hepsiburada.pages.DashboardPage;
import com.hepsiburada.pages.LoginPage;
import com.hepsiburada.pages.SearchResultPage;
import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.ConfigurationReader;
import com.hepsiburada.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class addingToCart {
    DashboardPage dashboardPage = new DashboardPage();
    LoginPage loginPage = new LoginPage();


    @Given("The user goes to application page")
    public void theUserGoesToApplicationPage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        BrowserUtils.waitFor(5);

    }

    @And("The user logins to account")
    public void theUserLoginsToAccount() {
        dashboardPage.navigateToLogin();
        String email = ConfigurationReader.get("email");
        String password = ConfigurationReader.get("password");
        loginPage.login(email, password);
        BrowserUtils.waitFor(5);
    }

    @And("The user searches for {string}")
    public void theUserSearchesFor(String item) {
        dashboardPage.searchBox.sendKeys(item);
        dashboardPage.searchButton.click();
    }

    @And("The user selects any row")
    public void theUserSelectsAnyRow() {
        new SearchResultPage().itemResultClick();
    }


    @And("The user selects the same item from two different vendors")
    public void theUserSelectsTheSameItemFromTwoDifferentVendors() {
        dashboardPage.addToCartSuggestItem.click();
        dashboardPage.isItemOnCart();
        dashboardPage.secondItemAdding();
        dashboardPage.isItemOnCart();
    }

    @Then("The items is added to cart")
    public void theItemsIsAddedToCart() {
        dashboardPage.myCart();
        new CartPage().cartSizeWithLogin();

        BrowserUtils.waitFor(5);

    }

    @And("The user goes to {string} {string}")
    public void theUserGoesTo(String tab, String module ) {
        dashboardPage.navigateToModule(tab, module);
    }

    @And("The user selects {string}")
    public void theUserSelects(String str) {
        new  SearchResultPage().itemSelect(str);
        dashboardPage.addToCartSuggestItem.click();
        dashboardPage.isItemOnCart();
    }

    @And("The items is added to cart without login")
    public void theItemsIsAddedToCartWithoutLogin() {
        dashboardPage.myCart();
        new CartPage().cartSizeWithoutLogin();

        BrowserUtils.waitFor(5);
    }
}
