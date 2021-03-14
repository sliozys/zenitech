package lt.zenitech.taskTest;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

public class WebElementHandleTest {

    @BeforeEach
    void startTest() {
//        Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
        Configuration.headless = true;
        Configuration.savePageSource = false;

        File file = new File("src/main/resources/QA_Home_Assignment.html");
        String fullPath = file.getAbsolutePath();

        open(fullPath);
    }

    @Test
    void iconChangesColour(){
        String zenButton = ".mainGrid > div:nth-child(1) > div:nth-child(1)";
        $(zenButton).shouldHave(attribute("active", "true"));
    }

    @Test
    void externalLinkOpens(){
       $(By.linkText("ISTQB Foundation Level Syllabus")).click();
       switchTo().window(1);
    }


}
