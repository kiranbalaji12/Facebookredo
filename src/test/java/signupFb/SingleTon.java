package signupFb;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import sun.net.www.protocol.http.HttpURLConnection;

public class SingleTon {
	public static void main(String[] args) throws MalformedURLException, IOException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		EdgeOptions options = new EdgeOptions();
		driver.get("https://www.facebook.com");
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
