#@selenium
Feature: Register a new user on https://forumet.vimla.se/register
  In order to have acsess to forum
  As a new user
  I want to create an account

  #Skapa användare​
  #Skapa användare – långt användarnamn (mer än 16 tecken)​
  #Skapa användare – lösenord och bekräfta lösenord skiljer sig​
  #Skapa användare – E-postadress är redan använd​

  Scenario: register a user
    Given #{email} And {username} And {password} And {confirmedPassword} And {expectedResult}
    "mawercom" And "TestUserName" And "aaasss" And "aaasss" And "TC1:result"
    When I enter input into the fields and click on Registrera nu button
    Then I get the "TC1:result"




