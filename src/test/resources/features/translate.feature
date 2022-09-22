@wip
Feature: Google Translate App translation functionality
  As a User, when I'm on a Google Translate page,
  I should be able to enter German word "Demokratien" and get
  a correct translation to the Spanish.
  As User I should able to swamp these two languages and get
  adequate translation
  As User I should turn on a Virtual Keyboard and type "Hi!"
  and verify the result


  Scenario: Google Translate page title verification
    When User is on Google Translate page
    Then User should see title is Google Translate
    When User clicks on the drop-down menu button on the left side
    And User selects "German" language from the left drop-down menu
    And User clicks on the drop-down menu button on the right side
    And User selects "Spanish" language from the right drop-down menu
    And User enters word "Demokratien" into the input text box on the left side
    Then User should see word "Democracias" as a translated version
    When User clicks on the button Swap languages in the middle
    Then User should see "Democracias" as a source word and "Demokratien" as a translated one
    When User clicks on the button Turn on Virtual Keyboard in the middle
    And User types word "Hi!" using this input tool
    Then User should see word "Hi!" on the left and "Hi!" on the right sides





