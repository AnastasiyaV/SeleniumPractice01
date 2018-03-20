package myproject.test;
import static org.junit.Assert.assertEquals;
import myproject.WebDriverSettings;
import myproject.page.TutorPage;
import org.junit.Test;

public class TutorTests  extends WebDriverSettings {


    @Test
    public void locateAnastasiyaInfo() {
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        String expectedTutorName = "Анастасия Педоренко";
        String position = tutorPage.getPosition(expectedTutorName);
        assertEquals("the position didn't matched for the tutor " + expectedTutorName,"n, PSPO",position);
    }
    @Test
    public void locateDaryaInfo() {
        TutorPage tutorPage = new TutorPage(driver);
        tutorPage.openPage();
        String expectedTutorName = "Дарья Мельник";
        String position = tutorPage.getPosition(expectedTutorName);
        assertEquals("the position didn't matched for the tutor " + expectedTutorName,"преподаватель английского",position);
        assertEquals("the position Length didn't matched for the tutor " + expectedTutorName,25,tutorPage.getPositionLength(expectedTutorName));

    }

    // повторить тоже самое для других тьюторов
    // добавить проверку длины имени (и /или фамилии) (проверить assertequals)
    //добавить метод isTutor (позиция содержит слово тренер)
    //добавить тесты с проверкой asserttrue/assertfalse
    

    @Test
    public void locateFailInfo() {
        String expectedTutorName = "Fail";
        //assertIsTutorLocated(expectedTutorName);
    }
}
