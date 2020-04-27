package org.vimla;

import cucumber.api.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class NewUserTest {
    String email;
    String username;
    String password;
    String confirmedPassword;
    String expectedResult;
    String actualResult;

    @Given("^\"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\" And \"([^\"]*)\"$")
    public void andAndAndAnd(String arg0, String arg1, String arg2, String arg3, String arg4) throws Throwable {
        this.email = arg0;
        this.username = arg1;
        this.password = arg2;
        this.confirmedPassword = arg3;
        this.expectedResult = arg4;
    }

    @When("I enter input into the fields and click on Registrera nu button")
    public void iEnterInputIntoTheFieldsAndClickOnRegistreraNuButton() {
        // get actualResult from Selenium
        actualResult = SeleniumNewUser.createUser(email, username, password, confirmedPassword, expectedResult);
    }

    @Then("^I get the \"([^\"]*)\"$")
    public void iGetThe(String arg0) throws Throwable {
        Assert.assertEquals(arg0, actualResult);
    }

//    @Given("\\{email} And \\{username} And \\{password} And \\{confirmedPassword} And \\{expectedResult}")
//            //("<email> And <username> And <password> And <confirmedPassword> And <expectedResult>")
//    //public void emailAndUsernameAndPasswordAndConfirmedPasswordAndExpectedResult(List data) {
//    public void emailAndUsernameAndPasswordAndConfirmedPasswordAndExpectedResult(String email, String username, String password, String confirmedPassword, String expectedResult) {
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.confirmedPassword = confirmedPassword;
//        this.expectedResult = expectedResult;
//    }
//
//    @When("I enter input into the fields and click on Registrera nu button")
//    public void iEnterInputIntoTheFieldsAndClickOnRegistreraNuButton() {
//        // get actualResult from Selenium
//        actualResult = SeleniumNewUser.createUser(email, username, password, confirmedPassword, expectedResult);
//    }

//    @Then("I get the {5}")
//    public void iGetTheExpectedResult() {
//        // Assert it matches with actualResult
//        Assert.assertEquals(expectedResult, actualResult);
//    }



}
