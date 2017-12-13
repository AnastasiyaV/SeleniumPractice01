import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;


public class WebDriverSettings {
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    public WebDriver driver;
    public String baseUrl;
    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://skillsup.ua/";
        driver.manage().timeouts().implicitlyWait(DriverConfig.myMap.get("wait"), TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
