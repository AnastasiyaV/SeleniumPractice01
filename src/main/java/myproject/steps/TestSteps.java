package myproject.steps;

        import org.jbehave.core.annotations.Given;

public class TestSteps extends BaseSteps{

    @Given("open browser")
    public void OpenBrowser() {
    driver.get("http://skillsup.ua/");
    }
}