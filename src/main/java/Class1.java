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