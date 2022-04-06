package com.trycloud.pages;


import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class RemovesFilePage {

    CommonWebElementPage commonWebElementPage = new CommonWebElementPage();
    public static Actions actions = new Actions(Driver.getDriver());

    public static void verifyFolder(String folderName) {
        String name = "//div/span[.='" + folderName + "']";
        WebElement element = Driver.getDriver().findElement(By.xpath(name));
        Assert.assertTrue("kdfdg", element.isDisplayed());

    }


    public boolean verifyRemovee(String fileName) {
        for (WebElement each : commonWebElementPage.favoriteList) {
            if (each.getText().equals(fileName)) {
                return true;
            }
        }
        return false;
    }


    public void uploadFile(String file) {

        actions.moveToElement(commonWebElementPage.uploadFile).sendKeys(file).perform();
    }


    public List<String> listText() {
        List<String> favList = new ArrayList<>();
        for (WebElement eachFavorite : commonWebElementPage.favoriteList) {
            favList.add(eachFavorite.getText());
        }

        return favList;

    }


    public boolean verifyRemove(String fileNme) {
        boolean result = false;
        for (WebElement each : commonWebElementPage.favoriteList) {
            if (each.getText().equals(fileNme)) {
                result = true;
            }
            result = false;
        }
        return result;
    }


    public static void waitExplicit(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), 10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFile;


    @FindBy(xpath = "//*[@id=\"fileList\"]//span[.='HOME']")
    public WebElement uploadedFileLocation;


}


