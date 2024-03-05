package signupFb;

import com.facebook.basefunction.BaseClass;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	@Before
	public void launching(Scenario scenario) {
		BaseClass.edgeLauncher();
//		final byte[] snip = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BYTES);
//		scenario.embed(snip,"image/png");
	}
	
	@After
	public void closing(Scenario scenario) {
//		BaseClass.browserQuit();
//		final byte[] snip = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.BYTES);
//		scenario.embed(snip,"image/png");
	}

}
