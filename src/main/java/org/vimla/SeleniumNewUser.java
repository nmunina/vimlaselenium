package org.vimla;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SeleniumNewUser {
    protected WebDriver driver;
    protected static WebDriverWait wait;
    protected static JavascriptExecutor js;

    static String email = "mmawer30475@johnderasia.com";
    static String username = "mawer";
    static String password = "aabbbbb123";
    static String confirmedPassword = password;

    static String expectedResult = "TC1:mytestcase";
    static String[] testCase;
    static String actualResult;
    static String message;

    //@Test //to run Selenium separatly uncomment lines 26, 28, 87, 90
    //comment lines 29, 86, 91
    //public void  createUser() {
    public static String createUser(String email, String username, String password, String confirmedPassword, String expectedResult) {
        Random rnd = new Random();

        //select scenario
        // if it is not the T4 case, generate random e-mail: add random int before email
        if (!testCase[0].equals("T4")) {
            email = rnd.nextInt() + email;
        }

        //setup
        System.setProperty("webdriver.chrome.driver", "/Users/nmunina/dev/chromedriver2");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://forumet.vimla.se/register");
        sleep(4);

        // confirm cookies
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-continue-btn"))).click();
        //driver.findElement(By.id("cookie-continue-btn")).click();
        sleep(2);

        //This is just to show different types of element location.
        //Normally I would use only By.id() function in most cases.
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.cssSelector("form > div:nth-of-type(3) > div > input")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name='password-confirm']")).sendKeys(confirmedPassword);
        sleep(2);

        //submit form
        driver.findElement(By.id("register")).click();
        sleep(2);

        //get the test case
        testCase = expectedResult.split(":");
        switch (testCase[0]) {
            case "TC1": //#Skapa användare​
                message = driver.getCurrentUrl();
                actualResult = "TC1:" + message;
                break;

            case "TC2": //#Skapa användare – långt användarnamn (mer än 16 tecken)​
                message = driver.findElement(By.id("username-notify")).getText();
                actualResult = "TC2:" + message;
                break;

            case "TC3": //#Skapa användare – lösenord och bekräfta lösenord skiljer sig​
                message = driver.findElement(By.id("password-confirm-notify")).getText();
                actualResult = "TC3:" + message;
                break;

            case "TC4": //#Skapa användare – E-postadress är redan använd​
                message = driver.findElement(By.id("email-notify")).getText();
                actualResult = "TC4:" + message;
                break;
        }
        //System.out.println(actualResult);
        return actualResult;
        //driver.close();

    }

    //protected void sleep ( int i) {
    protected static void sleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

