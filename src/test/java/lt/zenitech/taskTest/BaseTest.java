package lt.zenitech.taskTest;

import com.codeborne.selenide.Configuration;
import lt.zenitech.task.Tasks;
import org.junit.jupiter.api.BeforeEach;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    public Tasks task = new Tasks();


    @BeforeEach
    void startTest() {

        Configuration.screenshots = false;
//        Configuration.headless = true;
        Configuration.savePageSource = false;


        File file = new File("src/main/resources/QA_Home_Assignment.html");
        String fullPath = file.getAbsolutePath();

        open(fullPath);
    }
}
