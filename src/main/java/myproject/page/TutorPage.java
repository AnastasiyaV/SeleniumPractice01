package myproject.page;

import myproject.domain.Tutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class TutorPage extends BasePage {
    public TutorPage(WebDriver driver) {
        super(driver);
    }

    private String site = "http://skillsup.ua/about/our-team/";
    //private String baseUrl = "http://skillsup.ua";
    private By memberLocator = By.className("member");
    private By tutorNameLocator = By.className("name");
    private By tutorPositionLocator = By.className("position");

    private List<WebElement> getMembers() {
        return driver.findElements(memberLocator);
    }

    private String getMemberName(WebElement member) {
        return member.findElement(tutorNameLocator).getText();
    }

    private String getMemberPosition(WebElement member) {
        return member.findElement(tutorPositionLocator).getText();
    }




    public void openPage() {
        driver.get(site);
        //myproject.driver.get(baseUrl + "/about/our-team/");
        //TODO waitUntil myproject.page is loaded
    }

    //3. check if there is a Tutor with exact name and position
    private Tutor getTutor(String expectedTutorName) {
        List<WebElement> listMemberWebElements = getMembers();
        for (WebElement currentMember : listMemberWebElements) {
            String tutorName = getMemberName(currentMember);
            String tutorPosition = getMemberPosition(currentMember);
            boolean wasFound = expectedTutorName.equals(tutorName);
            if (wasFound) {
                return new Tutor(tutorName, tutorPosition);
            }
        }

        Assert.fail(String.format("tutor with name %s was not found",expectedTutorName));
        return null;

    }

    public String getPosition(String tutorName) {
        Tutor tutor = getTutor(tutorName);
        return tutor.position;
    }
    public int getPositionLength(String tutorName) {
        return getPosition(tutorName).length();
    }
}
