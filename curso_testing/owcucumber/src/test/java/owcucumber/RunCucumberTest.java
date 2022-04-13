package owcucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"}
        //features = {"classpath:owcucumber/features/"}
        //tags = {"@Tag1"} //include(@)/exclude(@~)
)
public class RunCucumberTest {
}
