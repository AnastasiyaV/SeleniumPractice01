package myproject.test;

import myproject.WebDriverSettings;
import myproject.domain.Tutor;
import org.junit.*;
import org.openqa.selenium.*;

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
        //accert din myproject.test
        //to read about Java8 class Optional
        if (pos != null) {
            //magic logic code is here :)
        } else {
            System.out.println("This name does`t exist");
        }
    }

    //method that will give you tutor position by tutor name
    private String getPosition(String tutorName) {
        String tutorPosition = null;
        for (Tutor tutor : listTutors) {
            if (tutor.getName().equals(tutorName)) {
                tutorPosition = tutor.getPosition();
                break;
            }
        }
        //if null, no item with this name
        return tutorPosition;

    }



   }