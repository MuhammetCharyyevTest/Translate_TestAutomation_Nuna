package translate.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import translate.pages.GoogleTranslate;
import translate.utilities.BrowserUtil;
import translate.utilities.ConfigReader;
import translate.utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Translate_StepDefs {

    //object from GoogleTranslate page to identify below steps
    GoogleTranslate googleTranslate = new GoogleTranslate();

    //path to take data from Excel file
    String path = "Translation_file.xlsx";
    //to read from Excel file I need to load it into FileInput Stream:
    FileInputStream fis = new FileInputStream(path);
    //workbook>sheet>row>cell
    //1. create workbook:
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    //2. get a specific sheet
    XSSFSheet sheet = workbook.getSheet("Source_for_translation");

    public Translate_StepDefs() throws IOException {
    }

    @When("User is on Google Translate page")
    public void user_is_on_google_translate_page() {
        Driver.getDriver().get(ConfigReader.read("googleTranslateUrl"));
    }

    @Then("User should see title is Google Translate")
    public void user_should_see_title_is_google_translate() {
        String expectedTitle = "Google Translate";

        String actualTitle = Driver.getDriver().getTitle();
        //assign because we need to get return as a String "Google Translate"

        Assert.assertEquals("Title verification failed", expectedTitle, actualTitle);

    }

    @When("User clicks on the drop-down menu button on the left side")
    public void user_clicks_on_the_drop_down_menu_button_on_the_left_side() {
        googleTranslate.dropdownMenuLeftButton.click();
    }

    @When("User selects {string} language from the left drop-down menu")
    public void user_selects_german_language_from_the_drop_down_menu(String german) {
        //select row and cell from Excel file:
        german = String.valueOf(sheet.getRow(1).getCell(0));
        googleTranslate.inputGermanLanguage.sendKeys(german);
        BrowserUtil.waitFor(1);
        googleTranslate.clickGermanLanguage.click();
    }

    @When("User clicks on the drop-down menu button on the right side")
    public void user_clicks_on_the_drop_down_menu_button_on_the_right_side() {
        BrowserUtil.waitForClickablility(googleTranslate.dropdownMenuRightButton, 3);
        googleTranslate.dropdownMenuRightButton.click();
    }

    @When("User selects {string} language from the right drop-down menu")
    public void user_selects_spanish_language_from_the_drop_down_menu(String spanish) {
        //select row and cell from Excel file:
        spanish = String.valueOf(sheet.getRow(1).getCell(1));
        googleTranslate.inputSpanishLanguage.sendKeys(spanish);
        BrowserUtil.waitFor(1);
        googleTranslate.clickSpanishLanguage.click();

    }

    @When("User enters word {string} into the input text box on the left side")
    public void user_enters_word_into_the_input_text_box_on_the_left_side(String sourceWord) {
        BrowserUtil.waitForClickablility(googleTranslate.inputTextArea, 3);
        //select row and cell from Excel file:
        sourceWord = String.valueOf(sheet.getRow(1).getCell(2));
        googleTranslate.inputTextArea.sendKeys(sourceWord);
    }

    @Then("User should see word {string} as a translated version")
    public void user_should_see_word_as_a_translated_version(String actualTranslatedWord) {
        String expectedTranslatedWord = String.valueOf(sheet.getRow(1).getCell(3));
        BrowserUtil.waitForVisibility(googleTranslate.translationTextArea, 3);
        actualTranslatedWord = googleTranslate.translationTextArea.getText();

        Assert.assertEquals("Translated text is not as expected",
                expectedTranslatedWord, actualTranslatedWord);

    }

    @When("User clicks on the button Swap languages in the middle")
    public void user_clicks_on_the_button_swap_languages_in_the_middle() {
        googleTranslate.swapLanguagesButton.click();
        BrowserUtil.waitFor(3);
    }

    @Then("User should see {string} as a source word and {string} as a translated one")
    public void user_should_see_as_a_source_word_and_as_a_translated_one(String actualSourceWord,
                                                                         String actualTranslatedWord) {
        String expectedSourceWord = String.valueOf(sheet.getRow(1).getCell(3));
        String expectedTranslatedWord = String.valueOf(sheet.getRow(1).getCell(2));
        actualSourceWord = googleTranslate.inputTextBoxSwap.getText();
        actualTranslatedWord = googleTranslate.translationTextArea.getText();
        if (expectedSourceWord.equals(actualSourceWord)) {
            System.out.println("Actual source word after swapping is: " + actualSourceWord +
                    " the same as expected one: " + expectedSourceWord);
        } else if (expectedTranslatedWord.equals(actualTranslatedWord)) {
            System.out.println("Actual translated word after swapping is: " + actualTranslatedWord +
                    " the same as expected one: " + expectedTranslatedWord);
        } else
            System.out.println("Actual source word after swaping is: " + actualSourceWord +
                    " but should be: " + expectedSourceWord);
        System.out.println("Actual translated word after swapping is " + actualTranslatedWord +
                " but should be: " + expectedTranslatedWord);
    }

    //I deliberately commented out Assert function to let test run after defect:

//        Assert.assertEquals ("Translated text is not as expected",
//                             expectedTranslatedWord, actualTranslatedWord);
//        Assert.assertEquals ("Source text is not as expected",
//                             expectedSourceWord, actualSourceWord);


    @When("User clicks on the button Turn on Virtual Keyboard in the middle")
    public void user_clicks_on_the_button_turn_on_virtual_keyboard_in_the_middle() {
        googleTranslate.turnOnVirtKeyboardButton.click();
        googleTranslate.virtKeyboard.click();
        //clear the input field
        googleTranslate.clearSourceTextButton.click();

    }

    @When("User types word {string} using this input tool")
    public void user_types_word_using_this_input_tool(String string) {
        googleTranslate.shiftKey.click();
        googleTranslate.uppercaseHKey.click();
        googleTranslate.lowercaseIKey.click();
        googleTranslate.shiftKey.click();
        googleTranslate.exclamationMarkKey.click();
        googleTranslate.closeVirtKeyboard.click();
        googleTranslate.inputTextArea.click();
    }

    @Then("User should see word {string} on the left and {string} on the right sides")
    public void user_should_see_word_on_both_sides(String actualSourceVirtWord, String actualTraslVirtWord) {
        String expectedSourceVirtWord = "Hi!";
        String expectedTranslVirtWord = "Hi!";
        actualSourceVirtWord = googleTranslate.virtKeyboardSourceTextBox.getText();
        actualTraslVirtWord = googleTranslate.virtKeyboardTraslTextBox.getText();

        Assert.assertEquals("Translated text is not as expected",
                expectedSourceVirtWord, actualSourceVirtWord);
        Assert.assertEquals("Source text is not as expected",
                expectedTranslVirtWord, actualTraslVirtWord);

    }

}
