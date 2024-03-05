package signupFb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.facebook.basefunction.BaseClass;
import com.facebook.locators.SignupLocators;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupFunction {
	
	SignupLocators locators = new SignupLocators();
	public static BaseClass base = BaseClass.getInstance();
	public static Actions action;
	public static List<WebElement> options;
	public static Select select;
	
	@Given("Webdriver launch {string}")
	public void webdriver_launch(String url) {
		base.urlfunc(url);
	}

	@When("Navigate to create new account and click it")
	public void navigate_to_create_new_account_and_click_it() {
	    base.tap(locators.getCreate());
	}

	@And("Fill in firstname {string}")
	public void fill_in_firstname(String firstname) {
		base.sendString(locators.getFname(), firstname);
	}

	@And("Fill in surname {string}")
	public void fill_in_surname(String surname) {
		base.sendString(locators.getSname(), surname);
	}

	@And("Fill in mail and password {string}{string}")
	public void fill_in_mail_and_password(String string, String string2) {
		base.sendString(locators.getNumber(), string);
		base.sendString(locators.getPass(), string2);
	}

	@And("Select date of birth {string}")
	public void select_date_of_birth(String string) {
		base.selectByvisibletext(locators.getDay(), string);
	}

	@And("Select month of birth {string}")
	public void select_month_of_birth(String string) {
		base.selectByvisibletext(locators.getMon(), string);
	}

	@And("Select year of birth {string}")
	public void select_year_of_birth(String string) throws IOException {
		base.selectByvisibletext(locators.getYr(), string);
		base.driver.findElement(By.xpath("//label[text()='Male']")).click();
	}
	
	@When("For screenshot {string}")
	public void for_screenshot(String firstName) {
		base.screenshot(firstName);
	}

	@Then("click subbmit")
	public void click_subbmit() {
	    System.out.println("**End of program**");
	}
	
	@Then("Broken link {string}")
	public void broken_link(String blink) throws MalformedURLException, IOException {
	   base.brokenlink(blink);
		System.out.println(blink);
	}


}
