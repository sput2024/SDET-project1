package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    @FindBy(id = "locationSelect")    //option select for moon/planet
    private WebElement optionValue;

    @FindBy(className= "submit-button")
    private WebElement submitButton;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(tagName="td")
    private List<WebElement> tableCols;

    @FindBy(tagName = "celestialTable")
    private List<WebElement> celestialTable;



    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

    public String getOptionSelectedValue(){
        return optionValue.getText();
    }

    public void submit(){
        submitButton.click();
    }

    public void enterPlanetName(String planetName){
        planetNameInput.sendKeys(planetName);
    }



    public Integer getCelestialTableColsSize(){
        return tableCols.size();

    }

    public List<WebElement> getCelestialTableCols(){
        return tableCols;

    }


}
