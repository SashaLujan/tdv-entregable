import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demoqa {

	static WebDriver driver;
	static DemoqaRegister demoqaSearchRegister;
	//SoftAssert softAssert = new SoftAssert();

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		DesiredCapabilities capabilities=DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);
		driver = new ChromeDriver();
	}

	@Test (priority=1)
	//@Test
	public void loadPage() {
		driver.navigate().to("https://demoqa.com/books");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "ToolsQA");
	}
	
	@Test (priority=2)
	public void searchBook() {
		DemoqaSearch demoqaSearch = PageFactory.initElements(driver, DemoqaSearch.class);
		demoqaSearch.search("Eloquent JavaScript");
		System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://demoqa.com/books?book=9781593275846");
	}
	
	@Test (priority=3)
	public void searchRegister() {
		demoqaSearchRegister = PageFactory.initElements(driver, DemoqaRegister.class);
		demoqaSearchRegister.searchRegister();
		System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getCurrentUrl(), "https://demoqa.com/register");
		
	}
	
	@Test (priority=4)
	public void register() throws InterruptedException {
		demoqaSearchRegister.register("Pablo", "Lescano", "PabloTeclado", "C0ntRa$3nI4");
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test (priority=5)
	public void finishTest() {
		if(driver!=null) {
			driver.close();
			driver = null;
		}
		System.out.println("Termino satisfactoriamente");
		Assert.assertNull(driver);
	}

}
