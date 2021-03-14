package lt.zenitech.task;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.TimeoutException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class Tasks {

    public boolean isAlertPresent() {
        try {
            switchTo().alert();
            return true;
        }
        catch (Throwable t) {
            // take screenshot, output results
            if(t instanceof InterruptedException){
                return false;
            }
            return false;
        }
    }

    public boolean inputSquareSizeInt(int size){
        switchTo().alert().sendKeys(String.valueOf(size));
        switchTo().alert().accept();
        return confirmSize(size);
    }
    
    public boolean confirmSize(int size){
        ElementsCollection rows = $$(".mainGrid >.row");
        if(rows.size() == size){
            for (SelenideElement row:
                 rows) {
                ElementsCollection columns = row.$$(".icon");
                if(columns.size() != size){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public void fillSquare(int size){
        for(int r = 1; r <= size; r++){
                for(int c = 1; c <= size; c++){
                    String zenButton = ".mainGrid > div:nth-child(" + r + ") > div:nth-child(" + c + ")";
                    $(zenButton).click();
                }
        }
    }

    public void fillOuterBoundaries() {
        for(int r = 1; r<=4; r++){
            if(r==1 || r==4) {
                for(int c = 1; c <=4; c++){
                    String zenButton = ".mainGrid > div:nth-child(" + r + ") > div:nth-child(" + c + ")";
                    $(zenButton).click();
                }
            }else {
                String rightColumn = ".mainGrid > div:nth-child(" + r + ") > div:nth-child("+ 1 + ")";
                String leftColumn = ".mainGrid > div:nth-child(" + r + ") > div:nth-child("+ 4 + ")";
                $(rightColumn).click();
                $(leftColumn).click();
            }
        }
    }

    public void inputSquareSizeString(String word) {
        switchTo().alert().sendKeys(String.valueOf(word));
        switchTo().alert().accept();
    }
}
