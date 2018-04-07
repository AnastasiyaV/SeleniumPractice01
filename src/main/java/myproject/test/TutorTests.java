package myproject.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import myproject.WebDriverSettings;
import myproject.domain.Tutor;
import myproject.page.TutorPage;
import org.junit.Test;

public class TutorTests  extends WebDriverSettings {
    @Test
    public void locateOSimchakInfo() {
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        String expectedTutorName = "Ольга Симчак";
        String position = tutorPage.getPosition(expectedTutorName);
        assertEquals("the position didn't matched for the tutor " + expectedTutorName,"тренер, PSPO, PSM",position);
        assertEquals("the position Length didn't matched for the tutor " + expectedTutorName,17,tutorPage.getPositionLength(expectedTutorName));
    }

    @Test
    public void locateAPedorenkoInfo() {
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        String expectedTutorName = "Анастасия Педоренко";
        String position = tutorPage.getPosition(expectedTutorName);
        assertEquals("the position didn't matched for the tutor " + expectedTutorName,"тренер, PSPO",position);
        assertEquals("the position Length didn't matched for the tutor " + expectedTutorName,12,tutorPage.getPositionLength(expectedTutorName));
        //добавить тесты с проверкой asserttrue/assertfalse
        assertTrue (String.format("%s is not a tutor",expectedTutorName),tutorPage.IsTutor(expectedTutorName));
    }

    @Test
    public void locateVPisarenkoInfo() {
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        String expectedTutorName = "Виктория Писаренко";
        String position = tutorPage.getPosition(expectedTutorName);
        assertEquals("the position didn't matched for the tutor " + expectedTutorName,"тренер, PSM, ISTQB CTFL",position);
        assertEquals("the position Length didn't matched for the tutor " + expectedTutorName,23,tutorPage.getPositionLength(expectedTutorName));
        assertTrue (String.format("%s is not a tutor",expectedTutorName),tutorPage.IsTutor(expectedTutorName));
    }

    @Test
    public void checkMap(){
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        tutorPage.buildTutorMapping();
    }

    @Test
    public void locateDMelnikInfo() {
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        String expectedTutorName = "Дарья Мельник";
        String position = tutorPage.getPosition(expectedTutorName);
        assertEquals("the position didn't matched for the tutor " + expectedTutorName,"преподаватель английского",position);
        assertEquals("the position Length didn't matched for the tutor " + expectedTutorName,25,tutorPage.getPositionLength(expectedTutorName));
        // добавить проверку длины имени (и /или фамилии) (проверить assertequals)
        assertEquals("the Name Length didn't matched for the tutor " + expectedTutorName,13,tutorPage.getNameLength(expectedTutorName));
        assertFalse (String.format("%s is not a tutor",expectedTutorName),tutorPage.IsTutor(expectedTutorName));
    }


    @Test
    public void locateFailInfo() {
        String expectedTutorName = "Fail";
        //assertIsTutorLocated(expectedTutorName);
    }
}
