import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TutorsInformationLocationTest extends WebDriverSettings{
    private By memberLocator = By.className("member");
    private By tutorNameLocator = By.className("name");
    private By tutorPositionLocator = By.className("position");
    @Test
    public void locateAnastasiyaInfo (){
        String expectedTutorName = "Анастасия Педоренко";
        String expectedPosition = "тренер, PSPO";
        assertTutorLocated(expectedTutorName, expectedPosition);
    };
    @Test
    public void locateFailInfo (){
        String expectedTutorName = "Fail";
        String expectedPosition = "Fail";
        assertTutorLocated(expectedTutorName, expectedPosition);
    };

    private void assertTutorLocated (String expectedTutorName, String expectedTutorPosition){
        //1. go to the site/team
        driver.get(baseUrl + "about/our-team/");
        //2. get  all members list
        List<WebElement> listMemberWebElements = driver.findElements(memberLocator);
        //3. check if there is Anastasiya with exact name and position
        for (WebElement currentMember : listMemberWebElements) {
            String tutorName = currentMember.findElement(tutorNameLocator).getText();
            String tutorPosition = currentMember.findElement(tutorPositionLocator).getText();
            boolean wasfound = expectedTutorName.equals(tutorName) && expectedTutorPosition.equals(tutorPosition);
            if (wasfound){
                return;
            }
        }
        Assert.fail("tutor with name " + expectedTutorName+ " was not found");
    }

}
