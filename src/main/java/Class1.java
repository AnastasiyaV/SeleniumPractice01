import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Class1 extends WebDriverSettings {
    private By memberLocator = By.className("member");
    private By tutorNameLocator = By.className("name");
    private By tutorPositionLocator = By.className("position");

    private final List<Tutor> listTutors = new ArrayList<Tutor>();

    @Test
    public void createListTutors() throws Exception {
        driver.get(baseUrl + "/about/our-team/");
        List<WebElement> listMemberWebElements = driver.findElements(memberLocator);
        System.out.println(listMemberWebElements.size());
        listTutors.clear();
        for (WebElement currentMember : listMemberWebElements) {
            String tutorName = currentMember.findElement(tutorNameLocator).getText();
            String tutorPosition = currentMember.findElement(tutorPositionLocator).getText();
            Tutor tutor = new Tutor(tutorName, tutorPosition);
            System.out.println(tutor.toString());
            listTutors.add(tutor);
        }
        System.out.println("listTutors size is " + listTutors.size());

        String pos = getPosition("fdfdsf");
        if (pos != null) {

        } else {
            System.out.println("This name does`t exist");
        }
    }


    //method that will give you tutor position by tutor name
    private String getPosition(String tutorName) {
        String tutorPosition = null;
        for (Tutor tutor : listTutors) {
            if (tutor.name.equals(tutorName)) {
                tutorPosition = tutor.position;
                break;
            }
        }
        //if null, no item with this name
        return tutorPosition;

    }

    //1) Написать метод для выполнения джаваскрипта в бейс пейдж
    public Object jsExecutor(String script) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("onItemClick();");
        return js.executeScript(script);
    }

    String title = (String) jsExecutor("return document.title");


    //2) дописать метод на ожидание любого елемента на странице


    //3) написать метод который ждет появления алерта на странице
    public void test() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until();
    }





    driver.switchTo().

    alert().

    accept();

    boolean f;
        try

    {
        driver.switchTo().alert();
        f = true;
    } catch(
    NoAlertPresentException e )

    {
        f = false;
    }
        Assert.assertTrue(!f);
}

}