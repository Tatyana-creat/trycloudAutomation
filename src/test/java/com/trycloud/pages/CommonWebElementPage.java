package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonWebElementPage extends BasePage{

    @FindBy(css = "#appmenu li[data-id='dashboard'] svg")
    public WebElement dashboard;

    @FindBy(css = "#appmenu li[data-id='files'] svg")
    public WebElement files;

    @FindBy(css = "#appmenu li[data-id='photos'] svg")
    public WebElement photos;

    @FindBy(css = "#appmenu li[data-id='activity'] svg")
    public WebElement activity;

    @FindBy(css = "#appmenu li[data-id='spreed'] svg")
    public WebElement talk;

    @FindBy(css = "#appmenu li[data-id='mail'] a")
    public WebElement mail;

    @FindBy(css = "#appmenu li[data-id='contacts'] svg")
    public WebElement contacts;

    @FindBy(css = "#appmenu li[data-id='circles'] a")
    public WebElement circles;

    @FindBy(css = "#appmenu li[data-id='calendar'] svg")
    public WebElement calendar;

    @FindBy(css = "#appmenu li[data-id='deck'] svg")
    public WebElement deck;

    @FindBy(xpath = "//a[@class='action action-menu permanent']/span[@class='icon icon-more']")
    public WebElement iconButton;

    @FindBy(xpath = "//label/span[.='Select']")
    public WebElement checkBox;

    @FindBy(xpath = "//a/span[@class='icon icon-add']")
    public WebElement addIcon;

    @FindBy(xpath = "//a/span[text()='Add to favorites']")
    public WebElement addFavorites;

    @FindBy(xpath = "//a/span[text()='Remove from favorites']")
    public WebElement removeFavorites;

    @FindBy(xpath = "//h2[.='No favorites yet']")
    public WebElement verifiyNoFile;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement uploadFile;

    @FindBy(xpath = "//span[@class='nametext']/span[1]")
    public List<WebElement> favoriteList;

    @FindBy(xpath = "//span[.='New folder']")
    public WebElement folderName;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement folderNameInputBox;

    @FindBy(xpath = "//input[@class='icon-confirm']")
    public WebElement iconConfirmButton;


    public static void headerModule(String head) {
        Actions actions = new Actions(Driver.getDriver());
        String s = "//span[normalize-space(text())='" + head + "']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(s))).click().perform();
    }


    public static void sideModule(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String sf = "//li[starts-with(@class,'nav')]/a[text()='" + moduleName + "']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(sf))).click().perform();
    }



}
