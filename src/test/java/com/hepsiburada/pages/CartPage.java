package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(xpath = "//li[@id]")
    public List<WebElement> cartItems;

    @FindBy(tagName = "h1")
    public WebElement subtitle;

    public void cartSizeWithLogin(){
        BrowserUtils.waitForVisibility( subtitle, 5);
        System.out.println("cartItems.size() = " + cartItems.size());
        Assert.assertEquals(2, cartItems.size());

    }
    public void cartSizeWithoutLogin(){
        BrowserUtils.waitForVisibility( subtitle, 5);
        System.out.println("cartItems.size() = " + cartItems.size());
        Assert.assertEquals(1, cartItems.size());

    }
}
