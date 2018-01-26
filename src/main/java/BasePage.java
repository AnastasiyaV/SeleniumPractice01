import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends WebDriverSettings  {

    //1) Написать метод для выполнения джаваскрипта в бейс пейдж
    public Object jsExecutor(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("onItemClick();");
        return js.executeScript(script);
    }

    String title = (String) jsExecutor("return document.title");


    //2) дописать метод на ожидание любого елемента на странице
    public void waitForElement (){
        
    }

    //3) написать метод который ждет появления алерта на странице
    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until();
    }
}
