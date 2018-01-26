import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RunJSTest extends WebDriverSettings {
    private By memberLocator = By.className("member");
    @Test
    public void executeFirstMethodJs () throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(baseUrl + "/about/our-team/");
        //TODO move to base page  = create method дождаться элемента на любой странице, который будет принимать локатор и время
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(memberLocator));
        //List<WebElement> listMemberWebElements = driver.findElements(memberLocator);

//        WebElement firstTutorOlya = (WebElement)js.executeScript("return document.getElementsByClassName('member')[0];");
//        String firstTutorOlyaName = firstTutorOlya.findElement(By.className("name")).getText();
//        System.out.println("firstTutorOlyaName = "+firstTutorOlyaName);

        // String firstTutorOlyaPosition = firstTutorOlya.findElement( By.className("position")).getText();
        // Thread.sleep(5000L);

    }
}
