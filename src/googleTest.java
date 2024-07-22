import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class googleTest {
	
	public googleTest() {
		
	}
	
	@Test
	public void homePageCheck() throws MalformedURLException, URISyntaxException
	{
		//Also we have to create another class called as DesiredCapabilities
		//Basically from the below class we are going to describe what browser we want everything
		//And finally that object you are going to send as a second argument in the URL class
		DesiredCapabilities caps = new DesiredCapabilities();
		//On which browser we have to execute
		caps.setBrowserName("chrome");
		//On which platform we have to execute
		caps.setPlatform(Platform.WIN10);
		
		//Setup advanced capablites
		//here you will get lots of option like in chrome if you have to accept the SSL certificate
		/* caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false); */
		
		//So here we can execute the test remotely in remote machine if you invoke and
		//Create the driver object as a RemoteWebDriver class
		//So the RemoteWebDriver shall need two arguments, 1st where the hub is listening.
		//We have to wrap the URL in one class. new and the class name is URL in this you can pass the actual URL
		//URL stands for Uniform Resource Locator.
		//So the URL class is depricate in the java 20, so we have another class for it as URI.
		//But if we get it as URI the RemoteWebDriver shall give us the error as its first argument accepts as URL.
		//So we have converted it to URL.
		//Basically it is comming from Java .net package
		//2nd argument is capablites for the machine.
		WebDriver driver = new RemoteWebDriver(new URI("http://192.168.29.180:4444").toURL(), caps);
		driver.get("Google.com");
	}

}
