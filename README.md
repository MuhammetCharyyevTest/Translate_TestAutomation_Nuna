# Translate_TestAutomation_Nuna

Herewith you may find automation test of Google Translate web page which I had to test with certain tast:

Based on Page Object Model, create automated test for the scenario: Using Google Translate application (https://translate.google.com/)
▪ select source language from the drop-down menu on the left 
▪ select translation language from the drop-down menu on the right
▪ enter the initial text in the input field on the left ▪ make sure that the actual translation result in the right field is correct

Source, Translation languages, initial text and expected result should be taken from a separate data file (.json, .yaml, or .xlsx), for example (but not necessarily the exact word!): ▪ source language: German ▪ translation language: Spanish ▪ initial text: "Demokratien" ▪ expected result: "Democracias"

-Add scenario: click swap languages button and verify the result.

-Add scenario: clear the input field, click "select input tool" button, select "screen keyboard" and enter "Hi!"

-Share the link of your framework repository on GitHub with us. It should be public.

-Make sure you follow each step precisely. Works in which at least one step is omitted are not subject to consideration.


This BDD Cucumber-JUnit framework was build in Maven which has pom.xml file that allows me to manage my dependencies and updates;
With Java as programming language, automated with Selenium WebDriver. to increase code reusability and have a more readable framework,
I used Page Object Model as my design pattern to create page objects; store webElements and their methods/actions.

I used Page Factory Design Pattern to instantiate the webElement using @FindBy annotation which makes it easier and convenient.

I also have a Utility package where I keep all global and most frequently used codes such as browser utils, Driver, cofiguration reader.

I created a Driver class in a utility package that uses the singleton pattern to create and use only one universal webdriver.

I created a configuration properties file to avoid hard coding and to store sensitive and reusable data such as URL(environment), browser name.

I have found several non-compliance of criteria with the actual result. For example, when I checked this test case manually 
I have not found any non-compliance but during the automation test I found that expected result: "Democracias" does not match to the actual
one "Democracia". After swapping languages there is also a non-compliance defect that show "Demokratie" instead of "Demokratien" and "Democracia" 
instead of expected "Democracias". All the rest is working properly.
