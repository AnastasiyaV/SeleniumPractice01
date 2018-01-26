import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends WebDriverSettings  {
//to do constructor  и передавать туда драйвер
//    public BasePage(WebDriver driver) {
//        this.driver = driver;
//    }

    //1) Написать метод для выполнения джаваскрипта в бейс пейдж
    public Object jsExecutorWithReturnedResult(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript(script);
    }
    String title = (String) jsExecutorWithReturnedResult("return document.title");
    //what if jsExecutor method will return list of objects
//    public Object jsExecutorWithResultList(){
//
//    }
//    public Object jsExecutorWithNoResult(){
//        //js.executeScript("onItemClick();");
//    }

    //2) дописать метод на ожидание любого елемента на странице
    public void waitForElement (){

    }

    //3) написать метод который ждет появления алерта на странице
//    public void waitForAlert() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until();
//    }
}
