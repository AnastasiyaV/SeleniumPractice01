package myproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NavigationListSuit extends WebDriverSettings {
    private By trainingItemLocator = By.xpath("//*[@id='menu1078']/a");
    private By consultingItemLocator = By.xpath("//*[@id='menu1076']/a");
    private By runITItemLocator = By.xpath("//*[@id='menu6600']/a");
    private By careerItemLocator = By.xpath("//*[@id='menu1219']/a");
    private By outOfOfficeItemLocator = By.xpath("//*[@id='menu1143']/a");
    private By calendarItemLocator = By.xpath("//*[@id='menu3020']/a");
    private By aboutItemLocator = By.xpath("//*[@id='menu3039']/a");
    private By contactsItemLocator =By.xpath("//*[@id='menu1106']/a");

    private By elementNotPresentLocator =By.xpath("//*[@id='menu1106666']/a");
    @Test
    public void getLinkListNavigation() throws Exception {
        driver.get(baseUrl + "about/our-team/");
        WebElement webElementTraining  = driver.findElement(trainingItemLocator);
        String training = webElementTraining.getText();
        WebElement webElementConsulting  = driver.findElement(consultingItemLocator);
        String consulting = webElementConsulting.getText();
        WebElement webElementRunIT  = driver.findElement(runITItemLocator);
        String runIT = webElementRunIT.getText();
        WebElement webElementCareer  = driver.findElement(careerItemLocator);
        String career = webElementCareer.getText();
        WebElement webElementOutOfOffice  = driver.findElement(outOfOfficeItemLocator);
        String outOfOffice = webElementOutOfOffice.getText();
        WebElement webElementCalendar  = driver.findElement(calendarItemLocator);
        String calendar = webElementCalendar.getText();
        WebElement webElementAbout  = driver.findElement(aboutItemLocator);
        String about = webElementAbout.getText();
        WebElement webElementContacts  = driver.findElement(contactsItemLocator);
        String contacts = webElementContacts.getText();
        System.out.println(training);
        System.out.println(consulting);
        System.out.println(runIT);
        System.out.println(career);
        System.out.println(outOfOffice);
        System.out.println(calendar);
        System.out.println(about);
        System.out.println(contacts);
       List<String> actualResultList = Arrays.asList(training,consulting ,runIT , career,outOfOffice , calendar,about , contacts);
       List<String> expectedResultList = Arrays.asList("Обучение" , "Консалтинг", "RunIT","Карьера","Вне офиса", "Календарь","О нас","Контакты");
        assertEquals("Checking navigation actual menu elemrnts  vc expected ",actualResultList,expectedResultList);
        System.out.println(webElementAbout.isDisplayed());
        //assertTrue("i'm a message if False = webElementAbout is NOT Selected", webElementAbout.isSelected());
    }
    @Test
    public void elementNotPresentTest() throws Exception {
        driver.get(baseUrl + "about/our-team/");
        List<WebElement> locators = driver.findElements(elementNotPresentLocator);
        assertTrue(!locators.isEmpty());
    }
    }
