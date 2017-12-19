import org.junit.*;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

public class Class1 extends WebDriverSettings {
    private By memberLocator = By.className("member");
    private By tutorNameLocator = By.className("name");
    private By tutorPositionLocator = By.className("position");

    @Test
    public void createListTutors() throws Exception {
        driver.get(baseUrl + "/about/our-team/");
        List<WebElement> listMemberWebElements = driver.findElements(memberLocator);
        System.out.println(listMemberWebElements.size());
        List<Tutor> listTutors = new ArrayList<Tutor>();
        for (WebElement currentMember : listMemberWebElements) {
            String tutorName = currentMember.findElement(tutorNameLocator).getText();
            String tutorPosition = currentMember.findElement(tutorPositionLocator).getText();
            Tutor tutor = new Tutor(tutorName, tutorPosition);
            System.out.println(tutor.toString());
            listTutors.add(tutor);
        }
        System.out.println("listTutors size is " + listTutors.size());
    }

    private String getPosition(String tutorName) {
        String tutorPosition = null;


        return tutorPosition;

    }
}
    //@Test
//        public String getPosition("Анастасия Педоренко") {
//    }

//    private boolean isElementPresent(By by) {
//        try {
//            driver.findElement(by);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }
//    }
//    private boolean isAlertPresent() {
//        try {
//            driver.switchTo().alert();
//            return true;
//        } catch (NoAlertPresentException e) {
//            return false;
//        }
//    }
//}
//