package myproject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage     {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //1) метод для выполнения джаваскрипта в бейс пейдж
    public Object jsExecutorWithReturnedObject(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }
    String title = (String) jsExecutorWithReturnedObject("return document.title");

    public void jsExecutorWithoutReturningResult (String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }
    //for example js.executeScript("onItemClick();");
    /*   todo
     public Object jsExecutorWithResultList(){
     } */
    //2) метод на ожидание любого елемента на странице
    public void waitForElement(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
     //3) написать метод который ждет появления алерта на странице
    public void waitForAlert (int timeToWait){
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
