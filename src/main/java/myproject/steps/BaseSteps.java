package myproject.steps;
import myproject.driver.DriverConfig;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected static WebDriver driver;

    @BeforeStory
    public void driverStart() throws Exception {
        System.setProperty(DriverConfig.config.get("name"), DriverConfig.config.get("path"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

//        System.setProperty("webdriver.chrome.myproject.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
//        myproject.driver = new ChromeDriver();
//        baseUrl = "http://skillsup.ua/"; //?or .navigate().to("http://skillsup.ua/"); .get - напрямую
//        myproject.driver.manage().timeouts().implicitlyWait(myproject.driver.DriverConfig.WAIT_SEC, TimeUnit.SECONDS);

    @AfterStory
    public void driverStop() {
        driver.quit();
    }
}
