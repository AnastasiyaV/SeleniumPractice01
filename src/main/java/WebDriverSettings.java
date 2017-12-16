import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;


public class WebDriverSettings {

    private boolean acceptNextAlert = true;//?
    public WebDriver driver;
    public String baseUrl;
    private List <String> testErrorList= new ArrayList <> ();

    public void gatherError (String errorDescription){
      testErrorList.add(errorDescription);
    }


    @Before
        public void setUp() throws Exception {
        testErrorList.clear();
        driver = new FirefoxDriver();
        baseUrl = "http://skillsup.ua/"; //?or .navigate().to("http://skillsup.ua/"); ??or .get
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
