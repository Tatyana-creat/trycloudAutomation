package com.trycloud.step_definitions;


import com.trycloud.pages.BasePage;
import com.trycloud.pages.CommonWebElementPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.RemovesFilePage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class US6_7_StepDefinitions {

    RemovesFilePage removesFilePage = new RemovesFilePage();
    LoginPage loginPage = new LoginPage();
    CommonWebElementPage commonWebElementPage = new CommonWebElementPage();


    String expected;


    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginBy(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));

    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        BrowserUtils.waitFor(5);
        commonWebElementPage.headerModule(string);
    }

    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {


        BrowserUtils.waitFor(3);
        commonWebElementPage.iconButton.click();


    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        expected = commonWebElementPage.favoriteList.get(0).getText();
        commonWebElementPage.removeFavorites.click();
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        commonWebElementPage.sideModule(string);
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        Assert.assertFalse("jhdfgd", removesFilePage.verifyRemove(expected));


    }


    @When("the user clicks the add icon on the top")
    public void theUserClicksTheAddIconOnTheTop() {
        BrowserUtils.waitFor(3);

        commonWebElementPage.addIcon.click();
    }

    @And("users uploads file with the “upload file” option")
    public void usersUploadsFileWithTheUploadFileOption() {
        //Actions actions = new Actions(Driver.getDriver());
        String file = "C:\\Users\\sinem\\Downloads\\Java_Interview_Questions_ALL.docx";
        BrowserUtils.highlight(commonWebElementPage.uploadFile);
        commonWebElementPage.uploadFile.sendKeys(file);
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitForPageToLoad(5);
    }


    @Then("verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        String expected = "Java_Interview_Questions_ALL";
        //BrowserUtils.highlight(removesFilePage.uploadedFileLocation);
        BrowserUtils.waitFor(3);
        Assert.assertTrue(removesFilePage.verifyRemovee(expected));
    }

    @And("user clicks the add icon on the top")
    public void userClicksTheAddIconOnTheTop() {
        BrowserUtils.waitFor(5);
        commonWebElementPage.addIcon.click();
    }


    @And("user click \"new folder”")
    public void userClickNewFolder() {
        commonWebElementPage.folderName.click();
    }


    @And("user write a {string}")
    public void userWriteA(String string) {
        commonWebElementPage.folderNameInputBox.clear();
        commonWebElementPage.folderNameInputBox.sendKeys(string);
    }

    @When("the user click submit icon")
    public void theUserClickSubmitIcon() {
        commonWebElementPage.iconConfirmButton.click();
    }


    @Then("Verify the folder {string} is displayed on the page")
    public void verifyTheFolderIsDisplayedOnThePage(String string) {
        BrowserUtils.waitFor(3);
        Assert.assertTrue(removesFilePage.verifyRemovee(string));

    }
}

