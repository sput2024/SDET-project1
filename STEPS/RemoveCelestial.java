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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveCelestial {
    public static class SharedResource {
        public static int planetIndex = 0;
    }
    @And("the user provides planet data for deletion {string}")
    public void the_user_provides_planet_data_for_deletion(String string) {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> tCols = TestRunner.homePage.getCelestialTableCols();
        SharedResource.planetIndex=0;
        for (int i = 0; i < tCols.size(); i++) {
            if (tCols.get(i).getText().equals(string)) {
                SharedResource.planetIndex=i-1;
                break;}

        }
        TestRunner.homePage.deleteInput(string);


    }


    @And("the user hits submit to delete")
    public void theUserHitsSubmitToDelete() {
        TestRunner.homePage.deleteClick();
    }

    @Then("the celestial object is deleted and the table refreshes {string}")
    public void theCelestialObjectIsDeletedAndTheTableRefreshes(String arg0) {
        List<WebElement> tCols = TestRunner.homePage.getCelestialTableCols();
        int count = 0;

        for (int i = 0; i < tCols.size(); i++) {
            if (tCols.get(i).getText().equals(arg0)) {
                count = count +1;
                System.out.println("Celestial object not deleted");
                break;}

        }
        if (count==0){
            System.out.println("Celestial object deleted successfully");
        }
        int altCount=0;
        for (int k=4; k<tCols.size(); k+=4) {
            if (tCols.get(k).getText().equals(SharedResource.planetIndex)) {
                altCount = altCount + 1;
                System.out.println("Moon not deleted");
            }
        }
        if (altCount==0) {
            System.out.println(" Planet's Moon also deleted");
        }
    }

    @And("the user provides moon data for deletion {string}")
    public void theUserProvidesMoonDataForDeletion(String arg0) {
        TestRunner.homePage.deleteInput(arg0);
    }
}
