package com.hepsiburada.pages;

import com.hepsiburada.utilities.BrowserUtils;
import com.hepsiburada.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage{

    @FindBy(xpath = "//li[@class='search-item col lg-1 md-1 sm-1  custom-hover not-fashion-flex']")
    public List<WebElement> itemList;

    public void itemResultClick(){
        if (itemList.size()<1){
            System.out.println("No Item");
        }else if (itemList.size()>=1) {
            itemList.get(0).click();
        }
        BrowserUtils.waitFor(8);
    }
    public void itemSelect(String str){
        WebElement item = Driver.get().findElement(By.xpath("(//*[contains(text(),'"+str+"')])[3]"));
        BrowserUtils.scrollToElement(item);
        BrowserUtils.waitForClickablility(item, 5);
        item.click();
    }
}
