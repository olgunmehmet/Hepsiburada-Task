package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {
    @FindBy(xpath = "//input")
    public WebElement searchBox;

    @FindBy(xpath = "//*[text()='ARA']")
    public WebElement searchButton;

    //@FindBy(xpath = "//span[text()='Giriş Yap']")// "//span[@class='sf-OldMyAccount-PhY-T']"
    @FindBy(xpath = "//span[@class='sf-OldMyAccount-PhY-T']")
    public WebElement loginHover;

    @FindBy(xpath = "//*[@id='login']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='shoppingCart']")
    public WebElement shoppingCartMain;

    @FindBy(xpath = "//*[@id='addToCart']")
    public WebElement addToCartSuggestItem;

    @FindBy(xpath = "//div[@class='addToCart']")
    public WebElement addToCartOtherSeller;

    @FindBy(xpath = "//*[text()=' Ürün sepetinizde']")
    public WebElement itemOnCartNotification;

    @FindBy(xpath = "//*[text()='Onarım paketi istemiyorum']")
    public WebElement rejectRepairPackage;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToModule(String tab, String module) {
        String tabLocator = "//*[text()='"+tab+"']";
        String moduleLocator = "//*[text()='"+module+"']";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)), 5);
        }
    }
    public void navigateToLogin(){
        try {
            BrowserUtils.waitForClickablility(loginHover, 5);
            new Actions(Driver.get()).moveToElement(loginHover).pause(200).build().perform();
        } catch ( Exception e){
            BrowserUtils.clickWithWait((By) loginHover, 5);
        }

        try {
            BrowserUtils.waitForPresenceOfElement((By) login, 5);
            BrowserUtils.waitForVisibility(login, 5);
            BrowserUtils.scrollToElement(login);
            login.click();
        } catch (Exception e) {
            BrowserUtils.clickWithTimeOut(login, 5);
        }
    }
    public void secondItemAdding(){

        try {

            BrowserUtils.waitForClickablility(addToCartOtherSeller, 5);
            BrowserUtils.scrollToElement(addToCartOtherSeller);
            addToCartOtherSeller.click();
        }catch (Exception e){
            BrowserUtils.clickWithWait((By) addToCartOtherSeller, 5);
        }

        try {
            BrowserUtils.waitForClickablility(rejectRepairPackage, 5);
            rejectRepairPackage.click();
        }catch (Exception e){
            BrowserUtils.clickWithTimeOut(rejectRepairPackage,5);
        }
    }
    public void isItemOnCart(){
        BrowserUtils.waitForVisibility(itemOnCartNotification, 5);
        Assert.assertEquals("Ürün sepetinizde", itemOnCartNotification.getText());
        Driver.get().findElement(By.xpath("//a[@class='checkoutui-Modal-2iZXl']")).click();

    }
    public void myCart(){
        BrowserUtils.scrollToElement(shoppingCartMain);
        shoppingCartMain.click();
    }
}
