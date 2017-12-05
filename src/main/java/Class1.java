import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Class1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://skillsup.ua/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testExample3() throws Exception {
        driver.get(baseUrl + "/about/our-team/");
        //driver.findElement(By.xpath("(//img[@alt='photo'])[1]")).click();
//        driver.findElement(By.xpath("(//img[@alt='photo'])[2]")).click();
//        driver.findElement(By.xpath("(//img[@alt='photo'])[3]")).click();
        driver.findElement(By.linkText("Ольга Симчак\n            \n            \n              тренер, PSPO, PSM")).click();
        driver.navigate().back();
        driver.findElement(By.linkText("Анастасия Педоренко\n            \n            \n              тренер, PSPO")).click();
        driver.navigate().back();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


//        FirefoxDriver wd;
//
//        @Before
//        public void setUp() throws Exception {
//            wd = new FirefoxDriver();
//            wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//        }
//
//        @Test
//        public void BaseTest() {
//            wd.get("http://skillsup.ua/about/our-team/");
//            wd.findElement(By.linkText("Ольга Симчак\n            \n            \n              тренер, PSPO, PSM")).click();
//            wd.navigate().back();
//            wd.findElement(By.linkText("Анастасия Педоренко\n            \n            \n              тренер, PSPO")).click();
//            wd.findElement(By.xpath("//div[@class='text']//a[.='Погружение в Scrum']")).click();
//            wd.navigate().back();
//            wd.navigate().back();
//            wd.findElement(By.linkText("Виктория Писаренко\n            \n            \n              тренер, PSM, ISTQB CTFL")).click();
//            wd.findElement(By.xpath("//div[@class='text']//a[.='Погружение в Scrum']")).click();
//            wd.navigate().back();
//            wd.navigate().back();
//        }
//
//        @After
//        public void tearDown() {
//            wd.quit();
//        }
//
//        public static boolean isAlertPresent(FirefoxDriver wd) {
//            try {
//                wd.switchTo().alert();
//                return true;
//            } catch (NoAlertPresentException e) {
//                return false;
//            }
//        }









}
