package lt.zenitech.task;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.TimeoutException;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Tasks {

    public boolean isAlertPresent() {
        try {
            switchTo().alert().accept();
            return true;
        }
        catch (Throwable t) {
            return false;
        }
    }

    public boolean isNewWindowOpened(){
        int numberOfWindows = WebDriverRunner.getWebDriver().getWindowHandles().size();
        return numberOfWindows == 2;


    }


    public void inputSquareSizeInt(int size){
        switchTo().alert().sendKeys(String.valueOf(size));
        switchTo().alert().accept();
    }

    public void inputSquareSizeString(String word) {
        switchTo().alert().sendKeys(word);
        switchTo().alert().accept();
    }
    
    public boolean isSquareCorrectSize(int size){
        ElementsCollection rows = $$(".mainGrid .row");
        if(rows.size() != size) {
            return false;
        }

            for (SelenideElement row : rows) {
                ElementsCollection columns = row.$$(".icon");
                if(columns.size() != size){
                    return false;
                }
            }
            return true;
    }
    
    public void fillSquare(int size){
        ElementsCollection locations = $$(".mainGrid .icon");
        locations.forEach(SelenideElement::click);
    }

    public void fillOuterBoundaries(int size) {
        ElementsCollection firstRow = $$(".mainGrid .row:first-of-type .icon");
        ElementsCollection lastRow = $$(".mainGrid .row:last-of-type .icon");
        firstRow.forEach(SelenideElement::click);
        lastRow.forEach(SelenideElement::click);

        for(int row = 2; row<size; row++){
                String rightColumnLocator = ".mainGrid > div:nth-child(" + row + ") > div:nth-child(1)";
                String leftColumnLocator = ".mainGrid > div:nth-child(" + row + ") > div:nth-child("+ size + ")";

                $(rightColumnLocator).click();
                $(leftColumnLocator).click();
        }
    }


}
