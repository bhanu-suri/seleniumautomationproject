package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'PRODUCT STORE')]")
	public WebElement linkProductStore;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement linkHome;
	
	@FindBy(xpath="//a[text()='Sign up']")
	public WebElement linkSignup;
	
	@FindBy(xpath="//a[text()='Log in']")
	public WebElement linkLogin;
	
	@FindBy(xpath="//a[text()='Log out']")
	public WebElement linkLogout;
	
	@FindBy(xpath="//a[text()='Cart']")
	public WebElement linkCart;
	
	@FindBy(id="signInModalLabel")
	public WebElement signUpModalLabel;
	
	@FindBy(id="logInModalLabel")
	public WebElement logInModalLabel;
	
	@FindBy(id="sign-username")
	public WebElement inputSignupUsername;
	
	@FindBy(id="sign-password")
	public WebElement inputSignupPassword;
	
	@FindBy(xpath="//button[text()='Sign up']")
	public WebElement buttonSignup;
	
	@FindBy(id="loginusername")
	public WebElement inputLoginUsername;
	
	@FindBy(id="loginpassword")
	public WebElement inputLoginPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	public WebElement buttonLogin;
	
	@FindBy(id="nameofuser")
	public WebElement nameofuser;
	
	@FindBy(xpath="//a[text()='Phones']")
	public WebElement linkPhones;
	
	@FindBy(xpath="//a[text()='Laptops']")
	public WebElement linkLaptops;
	
	@FindBy(xpath="//a[text()='Monitors']")
	public WebElement linkMonitors;
	
	@FindBy(xpath="//a[@class='hrefch']")
	public List<WebElement> listOfProducts;
	
}
