# Selenium + cucumber project
Educational task to test registration form on Vimla forum with the BDD approach.

## Requirements for exercise
På forumet https://forumet.vimla.se/register kan man registrera sig som användare

Skriv testfall som testar denna registreringsfunktion

**Testfall**

- Skapa användare

- Skapa användare – långt användarnamn (mer än 16 tecken)

- Skapa användare – lösenord och bekräfta lösenord skiljer sig

- Skapa användare – E-postadress är redan använd

**Krav på testfall**

- Verifiering skall ske på varje testfall med minst en Junit assert. Verifieringen skall vara på ett sådant sätt att den även upptäcker när testfallet går fel

- Testfallen skall skapas genom en Scenario Outline ifrån en feature-fil

- Feature-filen skall vara skapad enligt BDD och innehålla en tydlig beskrivning

## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/)
* [Maven](https://maven.apache.org/)
* [JUnit](https://junit.org/)
* [Cucubmer](https://cucumber.io/)
* [Gherkin Syntax](https://cucumber.io/docs/gherkin/)
* [Selenium WebDriver](https://www.selenium.dev/)

## SetUp tips for development
https://www.youtube.com/watch?v=55vJUqHSbkQ

https://www.baeldung.com/cucumber-data-tables


#@selenium
Feature: Register a new user on https://forumet.vimla.se/register
  In order to have acsess to forum
  As a new user
  I want to create an account

  #Skapa användare​
  #Skapa användare – långt användarnamn (mer än 16 tecken)​
  #Skapa användare – lösenord och bekräfta lösenord skiljer sig​
  #Skapa användare – E-postadress är redan använd​


#
  Scenario Outline: register a user
    Given #{email} And {username} And {password} And {confirmedPassword} And {expectedResult}
    <email> And <username> And <password> And <confirmedPassword> And <expectedResult>
    When I enter input into the fields and click on Registrera nu button
    Then I get the {expectedResult}

    #randome number will be added to email in Selenim test part
    Examples:
      | email                         | username            |  password   | confirmedPassword  | expectedResult                                                   |
      |"mawer30474@johnderasia.com"   |	"TestUserName"	    |	"aaasss"  |	"aaasss"	       |  "TC1:https://forumet.vimla.se/"                                 |
      |	"123@fd.com"                  |	"TestLong18UserName"|	"aaaddd"  |	"aaaddd"	       |  "TC2:Användarnamnet är för långt"                               |
      |	"mawer30374@johnderasia.com"  |	"TestUserDiffPass"	|	"aaaddd"  |	"aaasss"	       |  "TC3:Lösenorden är inte likadana. Var god skriv dem på nytt."   |
      |	"mawer30474@johnderasia.com"  |	"TestUserDiffMail"	|	"bbbddd"  |	"bbbddd"	       |  "TC4:Denna mailadress finns redan registrerad på ett forumkonto"|