package com.revature.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.revature.TestRunner;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.revature.TestRunner.driver;

public class AddCelestial {
    int rows = TestRunner.homePage.getNumberOfCelestialRows();

    @When("the user selects the planet option")
    public void the_user_selects_the_planet_option() {

    Select dropdown = new Select(driver.findElement(By.id("locationSelect")));
    dropdown.selectByVisibleText("Planet");
    }

    @And("the user provides new valid planet data {string}")
    public void the_user_provides_new_valid_planet_data(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetName(string);
    }

    @When("the user hits submit")
    public void the_user_hits_submit() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.submit();
    }
    @Then("the table refreshes {string}")
    public void the_table_refreshes(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));

        Integer rows = TestRunner.homePage.getNumberOfCelestialRows();
        Integer cols = TestRunner.homePage.getCelestialTableColsSize();
        List<WebElement> tCols = TestRunner.homePage.getCelestialTableCols();

        for (int i = 0; i < tCols.size(); i++) {
            if (tCols.get(i).getText().equals(string)) {
                System.out.println("planet added successfully");
                break;}
        }


    }
    @Then("the user is redirected to the homepage")
    public void the_user_is_redirected_to_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertEquals("Welcome to the Home Page Batman", TestRunner.homePage.getHomePageGreeting());
    }

    @And("the user provides invalid planet data {string}")
    public void the_user_provides_invalid_planet_data(String string) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.enterPlanetName(string);
    }


    @Then("the user should get a browser alert {string}")
    public void the_user_should_get_a_browser_alert(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }



}
