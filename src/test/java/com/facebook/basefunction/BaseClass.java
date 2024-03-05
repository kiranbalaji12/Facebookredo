package com.facebook.basefunction;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.net.www.protocol.http.HttpURLConnection;

public class BaseClass {
	
	public static BaseClass base = null;
	
	public static BaseClass getInstance() {
		if(base==null) {
			base = new BaseClass();
		}
		return base;
	}
	
	public static WebDriver driver;
	public static Actions action;
	public static JavascriptExecutor js;
	
	public static void edgeLauncher() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("start-maximized");
		driver = new EdgeDriver(options);
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void urlfunc(String url) {
		driver.get(url);
	}
	
	public static void browserQuit() {
		driver.quit();
	}
	
	public String getPagetitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void pageRefresh() {
		driver.navigate().refresh();
	}
	public void pageNext() {
		driver.navigate().forward();
	}
	public void pageBack() {
		driver.navigate().back();
	}
	
	public void sendString(WebElement webelement, String value) {
		webelement.sendKeys(value);
	}
	public boolean selectedElement(WebElement webelement) {
		boolean selected = webelement.isSelected();
		return selected;
	}
	public boolean enabledElement(WebElement webelement) {
		boolean enabled = webelement.isEnabled();
		return enabled;
	}
	
	public void tap(WebElement webelement) {
		webelement.click();
	}
	public String retrieveString(WebElement webelement) {
		String text = webelement.getText();
		return text;
	}
	public boolean displayed(WebElement webelement) {
		boolean displayed = webelement.isDisplayed();
		return displayed;
	}
	public String attribute(WebElement webelement, String attribute) {
		String attr = webelement.getAttribute(attribute);
		return attr;
	}
	public void gotoElement(WebElement webelement) {
		action.moveToElement(webelement).build().perform();
	}
	public void contextTap(WebElement webelement) {
		action.contextClick(webelement).build().perform();
	}
	public void doubleTap(WebElement webelement) {
		action.doubleClick(webelement).build().perform();
	}
	public void dragDropfunction(WebElement source, WebElement target) {
		action.dragAndDrop(source, target).build().perform();
	}
	public void selectByvisibletext(WebElement dropdown, String visibletext) {
		Select s = new Select(dropdown);
		s.selectByVisibleText(visibletext); 
	}
	public List<WebElement> selectOptions(WebElement dropdown) {
		Select s = new Select(dropdown);
		List<WebElement> options = s.getOptions();
		return options;
	}
	public void actioninsertString(WebElement webelement, String value) {
		action.sendKeys(webelement, value).build().perform();
	}
	public void actionButton(WebElement webelement) {
		action.click().build().perform();
	}
	public void screenshot(String filename) {
		TakesScreenshot shot = (TakesScreenshot)driver;
		File f1 = shot.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\kiran\\eclipse-workspace\\Faceookredo\\target\\Kiran-"+filename+".png");
		try {
			FileUtils.copyFile(f1, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void scrollDown(WebElement webelement) {
		js.executeScript("arguments[0].scrollIntoView(true)", webelement);
	}
	public void scrollUp(WebElement webelement) {
		js.executeScript("arguments[0].scrollIntoView(false)", webelement);
	}
	public void instertString(WebElement webelement, String value, String javascript) {
		js.executeScript("arguments[0].setAttribute('value','"+value+"')", webelement);
	}
	public void button(WebElement webelement, String javascript) {
		js.executeScript("arguments[0].click", webelement);
	}
	public void defaultFrame() {
		driver.switchTo().defaultContent();
	}
	public void previousFrame() {
		driver.switchTo().parentFrame();
	}
	public void nextFrame(WebElement webelement) {
		driver.switchTo().frame(webelement);
	}
	public void popupinstertText(String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}
	public Alert switchtoAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
	public void alertAccept(Alert alert) {
		alert.accept();
	}
	public void alertdismiss(Alert dismiss) {
		dismiss.dismiss();
	}
	public void brokenlink(String blink) throws MalformedURLException, IOException {
		base.edgeLauncher();
		driver.get(blink);
		driver.manage().window().maximize();
		List<WebElement> elements = driver.findElements(By.tagName("link"));
		Iterator<WebElement> iterator = elements.iterator();
		while(iterator.hasNext()) {
			WebElement link = iterator.next();
			String href = link.getAttribute("href");
			
			if((href==null)|| href.isEmpty()){
				System.out.println("Link unavailable");
			}
			else if(!href.startsWith("www.facebook.com")) {
				System.out.println("Links not related to FB: "+href);
			}
			else {
				HttpURLConnection http = (HttpURLConnection)(new URL(href).openConnection());
				http.setRequestMethod("HEAD");
				http.connect();
				int responsecode = http.getResponseCode();
				if(responsecode==200) {
					System.out.println("Link not broken: "+href);
				}
			}
		}
	}

}

