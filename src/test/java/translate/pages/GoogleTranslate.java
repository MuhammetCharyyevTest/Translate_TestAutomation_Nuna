package translate.pages;

import translate.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object Model to store WebElements for whole Google Translate page
 */

public class GoogleTranslate {

    public GoogleTranslate(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //locate the left dropdown menu
    @FindBy(xpath = "//div[@class='aCQag']//div[2]/button[1]/div[3]")
    public WebElement dropdownMenuLeftButton;
    //locate the right dropdown menu
    @FindBy (xpath = "//div[@class='aCQag']//div[5]/button[1]/div[3]")
    public WebElement dropdownMenuRightButton;
    //locate field to input source language
    @FindBy (xpath = "//div[@class='aCQag']//div[@class='OoYv6d']//input[1]")
    public WebElement inputGermanLanguage;
    //locate button with German option to click
    @FindBy (xpath = "//span[@class='hBxMjb']")
    public WebElement clickGermanLanguage;
    //locate field to input translation language
    @FindBy (xpath = "//div[@class='aCQag']//div[@class='ykTHSe']//input[1]")
    public WebElement inputSpanishLanguage;
    //locate button with Spanish option to click
    @FindBy (xpath = "//span[@class='hBxMjb']")
    public WebElement clickSpanishLanguage;
    //locate input text area
    @FindBy (xpath = "//textarea[@aria-label='Source text']")
    public WebElement inputTextArea;
    //locate translation text area
    @FindBy (xpath = "//span[@class='Q4iAWc']")
    public WebElement translationTextArea;
    //locate swap languages button
    @FindBy (xpath = "//div[@class='aCQag']//button[@jsname='dnDxad']/div[3]")
    //div[@class='aCQag']/c-wiz[1]/div[1]/c-wiz[1]/div[3]
    public WebElement swapLanguagesButton;
    //locate clear source button
    @FindBy (xpath = "//div[@class='DVHrxd']//div[@class='VfPpkd-Bz112c-RLmnJb']")
    public WebElement clearSourceTextButton;
    //locate turn on virtual keyboard button
    @FindBy (xpath = "//span[@class='ita-kd-img ita-icon-0 ita-kd-icon ita-kd-icon-span']")
    public WebElement turnOnVirtKeyboardButton;
    //locate Virtual Keyboard as itself
    @FindBy (xpath = "//div[@id='kbd']")
    public WebElement virtKeyboard;
    //locate shift button on virtual keyboard
    @FindBy (xpath = "//span[@class='vk-cap ita-kd-img vk-sf-b vk-sf-c16']")
    public WebElement shiftKey;
    //locate 'H' letter button on virtual keyboard
    @FindBy (xpath = "//span[text()='H']")
    public WebElement uppercaseHKey;
    //locate 'i' letter button on virtual keyboard
    @FindBy (xpath = "//span[text()='i']")
    public WebElement lowercaseIKey;
    //locate '!' button on virtual keyboard
    @FindBy (xpath = "//span[text()='!']")
    public WebElement exclamationMarkKey;
    //locate closeVirtual Keyboard button
    @FindBy (xpath = "//div[@class='vk-t-btn ita-kd-img vk-sf-cl']")
    public WebElement closeVirtKeyboard;
    //locate input  textbox after swapping
    @FindBy (xpath = "//span[@ssk='6:FCIgBe']")
    public WebElement inputTextBoxSwap;
    //locate input text box after entering word
    @FindBy (xpath = "//span[@jsname='BvKnce']")
    public WebElement virtKeyboardSourceTextBox;
    // locate traslation box after entering word
    @FindBy (xpath = "//span[@class='Q4iAWc']")
    public WebElement virtKeyboardTraslTextBox;







}
