package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static Actions actions = new Actions(Driver.getDriver());

    public static void headerModule(String head) {
        String s = "//span[normalize-space(text())='" + head + "']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(s))).click().perform();
    }


    public static void sideModule(String moduleName) {
        String sf = "//li[starts-with(@class,'nav')]/a[text()='" + moduleName + "']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(sf))).click().perform();
    }


}
