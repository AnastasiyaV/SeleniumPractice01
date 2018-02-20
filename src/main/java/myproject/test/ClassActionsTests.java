package myproject.test;

import myproject.WebDriverSettings;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ClassActionsTests extends WebDriverSettings {


    @Test
    public void selectTestW3School() throws InterruptedException {
       Actions a = new Actions (driver);
       driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        Thread.sleep(2000L);
        driver.switchTo().frame("iframeResult");
       Select select = new Select (driver.findElement(By.xpath("html/body/select")) );
       select.selectByValue("opel");
       Thread.sleep(1000L);
    }
    @Test
    public void selectTestBootStrap() throws InterruptedException {
        driver.get("http://getbootstrap.com/docs/3.3/components/#btn-dropdowns-single");
        WebElement locatorDefault = driver.findElement((By.xpath("html/body/div[2]/div/div[1]/div[4]/div[2]/div[1]/button")));
        WebElement locatorDropDownSmtElse = driver.findElement((By.xpath("html/body/div[2]/div/div[1]/div[4]/div[2]/div[1]/ul/li[2]/a")));

        Thread.sleep(3000L);
        Actions builder = new Actions(driver);
        builder.moveToElement(locatorDefault).click().moveToElement(locatorDropDownSmtElse);
        Thread.sleep(2000L);
    }
       // builder.contextClick(webElement).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();    }



}
