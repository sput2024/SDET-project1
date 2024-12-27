package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.revature.TestRunner.driver;
import static java.nio.file.Files.copy;

public class LoginSteps {


    @Then("the password will never be visible in plain text")
    public void the_password_will_never_be_visible_in_plain_text() {
        // Write code here that turns the phrase above into concrete actions

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Path screenshotDestination = Paths.get("src/test/resources/screenshot/screentemp.jpeg");
        try {
            Files.copy(scrFile.toPath(),screenshotDestination,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
       }

        System.out.println("See Screenshot");

    }

    @When("then the user has logged out of the secure environment")
    public void then_the_user_has_logged_out_of_the_secure_environment() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.logout();
    }
    @Then("the user can't see the homepage")
    public void the_user_can_t_see_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        //Assert.assertNotEquals("Home", TestRunner.Homepage.getHomePageGreeting());
        Assert.assertNotEquals("Expected 'Welcome to the Home Page Batman", driver.findElement(By.tagName("h1")));
    }



 /*
 Provide one ore more invalid credentials - can't log in
  */












}
