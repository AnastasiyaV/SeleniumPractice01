package myproject.story;
        import myproject.steps.TestSteps;
        import org.jbehave.core.Embeddable;
        import org.jbehave.core.configuration.Configuration;
        import org.jbehave.core.configuration.MostUsefulConfiguration;
        import org.jbehave.core.io.CodeLocations;
        import org.jbehave.core.io.LoadFromClasspath;
        import org.jbehave.core.io.StoryFinder;
        import org.jbehave.core.junit.JUnitStories;
        import org.jbehave.core.reporters.StoryReporterBuilder;
        import org.jbehave.core.steps.InjectableStepsFactory;
        import org.jbehave.core.steps.InstanceStepsFactory;

        import java.util.List;
        import java.util.Properties;

        import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
        import static org.jbehave.core.reporters.StoryReporterBuilder.Format.*;


public class WebDriverStories extends JUnitStories {
    public WebDriverStories() {
        configuredEmbedder().embedderControls().doGenerateViewAfterStories(true).doIgnoreFailureInStories(true)
                .doIgnoreFailureInView(true).useThreads(1).useStoryTimeoutInSecs(60);
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        Properties properties = new Properties();
        properties.setProperty("encoding", "UTF-8");
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embeddableClass))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(codeLocationFromClass(embeddableClass))
                        .withDefaultFormats()
                        .withViewResources(properties)
                        .withFormats(CONSOLE, TXT, HTML, XML));
    }


    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new TestSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(
                codeLocationFromClass(this.getClass()),
                "**/*.myproject.story", "**/excluded*.myproject.story");
    }


}
