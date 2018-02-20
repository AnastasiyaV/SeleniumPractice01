package myproject;

import myproject.driver.DriverConfig;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

public class WebDriverSettings {
    private boolean acceptNextAlert = true;//?
    public WebDriver driver;
    public String baseUrl;
    private List <String> testErrorList= new ArrayList <String> ();

    public void gatherError (String errorDescription){
      testErrorList.add(errorDescription);
    }

    @Before
        public void setUp() throws Exception {
        testErrorList.clear();
        System.setProperty("webdriver.chrome.myproject.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "http://skillsup.ua/"; //?or .navigate().to("http://skillsup.ua/"); .get - напрямую
        driver.manage().timeouts().implicitlyWait(DriverConfig.WAIT_SEC, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        boolean testIsFailed = !testErrorList.isEmpty();
        if (testIsFailed){
            fail(testErrorList.toString());
        }

    }
}
