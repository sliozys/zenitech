package lt.zenitech.taskTest;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import lt.zenitech.task.Tasks;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlertHandleTest {
    private Tasks task = new Tasks();
    private String expected = "Not a good size!";


    @BeforeEach
    void startTest(){
      Configuration.holdBrowserOpen = true;
        Configuration.screenshots = false;
//        Configuration.headless = true;
        Configuration.savePageSource = false;

        File file = new File("src/main/resources/QA_Home_Assignment.html");
        String fullPath = file.getAbsolutePath();

        open(fullPath);

        task.fillOuterBoundaries();
    }

    @Test
    void alertAppears(){
        assertTrue(task.isAlertPresent());
    }

//    Test boundaries
    @Test
    void confirmSquareMinSize(){
        int size = 3;
        boolean answer = task.inputSquareSizeInt(size);
        assertTrue(answer);
    }

    @Test
    void confirmSquareMaxSize(){
        int size = 9;
        boolean answer = task.inputSquareSizeInt(size);
        assertTrue(answer);
    }

    @Test
    void checkSmallerThen3(){
        String word = "2";
        task.inputSquareSizeString(word);
        String actual = switchTo().alert().getText();
        switchTo().alert().accept();
        assertEquals(expected,actual);
    }

    @Test
    void checkBiggerThen9(){
        String word = "10";
        task.inputSquareSizeString(word);
        String actual = switchTo().alert().getText();
        switchTo().alert().accept();
        assertEquals(expected,actual);
    }

    @Test
    void inputAWord(){
        String word = "word";
        task.inputSquareSizeString(word);
        boolean actual = task.isAlertPresent();
        assertFalse(actual);
    }

    @Test
    void fillWholeSquare(){
        int size = 5;
        task.inputSquareSizeInt(size);
        task.fillSquare(size);
        boolean confirm = task.isAlertPresent();
        assertFalse(confirm);
    }



//    TODO: @Test when clicked on icon it changes color to red
//    TODO: @Test which creates new square and then clicks outer perimter icons and then creates new defined square

//TODO: does not address when words are entered or clicked cancel

//TODO: external links should open on a new window
}
