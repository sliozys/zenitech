package lt.zenitech.taskTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class AlertHandleTest extends BaseTest {
    public String expected = "Not a good size!";

    @BeforeEach
    void baseTestConditions(){
        task.fillOuterBoundaries(4);
    }

    @Test
    void alertAppears(){
        assertTrue(task.isAlertPresent());
    }

//    Test boundaries
    @Test
    void confirmSquareMinSize(){
        int size = 3;
        task.inputSquareSizeInt(size);
        boolean actual = task.isSquareCorrectSize(size);
        assertTrue(actual);
    }

    @Test
    void confirmSquareMaxSize(){
        int size = 9;
        task.inputSquareSizeInt(size);
        boolean actual = task.isSquareCorrectSize(size);
        assertTrue(actual);
    }

    @Test
    void checkSmallerThen3(){
        int number = 2;
        task.inputSquareSizeInt(number);
        String actual = switchTo().alert().getText();
        switchTo().alert().accept();
        assertEquals(expected,actual);
    }

    @Test
    void checkBiggerThen9(){
        int number = 10;
        task.inputSquareSizeInt(number);
        String actual = switchTo().alert().getText();
        switchTo().alert().accept();
        assertEquals(expected,actual);
    }

    @Test
    void inputAWord(){
        String word = "word";
        task.inputSquareSizeString(word);
        boolean actual = task.isAlertPresent();
        assertTrue(actual);
    }

    @Test
    void fillWholeSquare(){
        int size = 5;
        task.inputSquareSizeInt(size);
        task.fillSquare(size);
        boolean actual = task.isAlertPresent();
        assertFalse(actual);
    }

}
