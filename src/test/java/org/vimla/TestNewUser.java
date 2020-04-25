package org.vimla;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import sun.security.util.PendingException;

import java.util.List;

public class TestNewUser {
    String email;
    String username;
    String password;
    String confirmedPassword;
    String expectedResult;
    String actualResult;

    @Given("<email> And <username> And <password> And <confirmedPassword> And <expectedResult>")
    //public void emailAndUsernameAndPasswordAndConfirmedPasswordAndExpectedResult(List data) {
    public void emailAndUsernameAndPasswordAndConfirmedPasswordAndExpectedResult(String email, String username, String password, String confirmedPassword, String expectedResult) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmedPassword = confirmedPassword;
        this.expectedResult = expectedResult;
    }

    @When("I enter input into the fields and click on Registrera nu button")
    public void iEnterInputIntoTheFieldsAndClickOnRegistreraNuButton() {
        // get actualResult from Selenium
        actualResult = SeleniumNewUser.createUser(email, username, password, confirmedPassword, expectedResult);
    }

    @Then("I get the <expectedResult>")
    public void iGetTheExpectedResult() {
        // Assert it matches with actualResult
        Assert.assertEquals(expectedResult, actualResult);
    }
}
