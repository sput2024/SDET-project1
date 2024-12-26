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
      //  int rowsUpdated = TestRunner.homePage.getNumberOfCelestialRows();
        //int expectedRows = rows+1;
       // Assert.assertEquals(expectedRows,rowsUpdated);
        Integer rows = TestRunner.homePage.getCelestialTableRowsSize();
        //List<WebElement> cols = TestRunner.homePage.getCelestialCols(rows);
        System.out.println(rows);
     //   for (int i = 0; i < rows.size(); i++) {
      //      if (rows.get(i).getText().equals(string)) {
       //         System.out.println("it's working!!!");
        //    }
       // }
        //List<String> newRow = new ArrayList<>(rows.get(1));
        //System.out.println(rows.get(1).getText());
        //System.out.println(rows);
        System.out.println("testing");
       // List<WebElement>  ols = rows.get(i).findElements(By.tagName("td"));
       // Assert.assertEquals(string, driver.findElement(By.id(string)));
    }
    @Then("the user is redirected to the homepage")
    public void the_user_is_redirected_to_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals("Expected 'Welcome to the Home Page Batman", driver.findElement(By.tagName("h1")));
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
