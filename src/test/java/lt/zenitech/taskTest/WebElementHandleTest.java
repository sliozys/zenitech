package lt.zenitech.taskTest;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebElementHandleTest extends BaseTest{

    @Test
    void iconChangesColour(){
        String locator = ".mainGrid .row:first-of-type .icon:first-of-type";
        $(locator).click();
        $(locator).shouldHave(attribute("active", "true"));
    }

    @Test
    void externalLinkOpens(){
       $(By.linkText("ISTQB Foundation Level Syllabus")).click();
//       switchTo().window(1);
       boolean actual = task.isNewWindowOpened();
        assertTrue(actual);

    }

}
