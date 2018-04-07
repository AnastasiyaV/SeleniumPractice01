package myproject.page;

import myproject.domain.Tutor;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class TutorPage extends BasePage {
    public TutorPage(WebDriver driver) {
        super(driver);
    }

    private String site = "http://skillsup.ua/about/our-team/";
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
        //TODO waitUntil myproject.page is loaded
    }

    //3. check if there is a Tutor with expected name
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
        Assert.fail(String.format("tutor with name %s was not found", expectedTutorName));
        return null;
    }

    //сформировать мапы тренер, PSPO,ISTQB
    public Map<String, List<Tutor>> buildTutorMapping() {
        List<WebElement> listMemberWebElements = getMembers();
        Map<String, List<Tutor>> map = new HashMap<>();
        List<Tutor> listCoach = new ArrayList<>();
        List<Tutor> listPSPO = new ArrayList<>();
        List<Tutor> listISTQB = new ArrayList<>();

        for (WebElement currentMember : listMemberWebElements) {
            String tutorName = getMemberName(currentMember);
            String tutorPosition = getMemberPosition(currentMember);

            if (tutorPosition.contains("тренер")) {
                listCoach.add(new Tutor(tutorName, tutorPosition));
            }
            if (tutorPosition.contains("PSPO")) {
                listPSPO.add(new Tutor(tutorName, tutorPosition));
            }
            if (tutorPosition.contains("ISTQB")) {
                listISTQB.add(new Tutor(tutorName, tutorPosition));
            }

        }

        map.put("тренер", listCoach);
        map.put("PSPO", listPSPO);
        map.put("ISTQB", listISTQB);
        System.out.println(map);
        return map;

    }



        //добавить метод isTutor (позиция содержит слово тренер)
        public boolean IsTutor (String tutorName){
            String tutorPosition = getTutor(tutorName).getPosition();
            return (tutorPosition.contains("coach") || tutorPosition.contains("тренер"));

        }

        public String getPosition (String tutorName){
            Tutor tutor = getTutor(tutorName);
            return tutor.getPosition();
        }

        public int getPositionLength (String tutorName){
            return getPosition(tutorName).length();
        }

        public String getName (String tutorName){
            Tutor tutor = getTutor(tutorName);
            return tutor.getName();
        }

        public int getNameLength (String tutorName){
            return getName(tutorName).length();
        }

    }
