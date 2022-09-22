package translate.excel;

import org.junit.Test;
import translate.pages.GoogleTranslate;
import translate.utilities.BrowserUtil;
import translate.utilities.ConfigReader;
import translate.utilities.Driver;

public class test {


    @Test

    public void test1(){
        GoogleTranslate googleTranslate = new GoogleTranslate();

        Driver.getDriver().get(ConfigReader.read("googleTranslateUrl"));

        googleTranslate.clearSourceTextButton.click();
        googleTranslate.turnOnVirtKeyboardButton.click();

        //switch to the required window with the virtual keyboard
        BrowserUtil.switchToWindow("Español");

        googleTranslate.shiftKey.click();
        googleTranslate.uppercaseHKey.click();
        googleTranslate.lowercaseIKey.click();
        googleTranslate.shiftKey.click();
        googleTranslate.exclamationMarkKey.click();

    }
}
