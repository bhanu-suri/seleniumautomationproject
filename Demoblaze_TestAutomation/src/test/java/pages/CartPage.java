package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	public CartPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	public List<WebElement> listCartTitle;

	@FindBy(xpath="//tr/td[3]")
	public List<WebElement> listCartPrice;
	
	@FindBy(xpath="//a[text()='Delete']")
	public List<WebElement> listCartDelete;
	
	@FindBy(id="totalp")
	public WebElement totalPrice;
	
	@FindBy(xpath="//button[text()='Place Order']")
	public WebElement btnPlaceOrder;
	
	@FindBy(id="orderModalLabel")
	public WebElement orderModalLabel;
	
	@FindBy(id="totalm")
	public WebElement modalTotal;
	
	@FindBy(id="name")
	public WebElement inputName;
	
	@FindBy(id="country")
	public WebElement inputCountry;
	
	@FindBy(id="city")
	public WebElement inputCity;
	
	@FindBy(id="card")
	public WebElement inputCreditcard;
	
	@FindBy(id="month")
	public WebElement inputMonth;
	
	@FindBy(id="year")
	public WebElement inputYear;
	
	@FindBy(xpath="//button[text()='Purchase']")
	public WebElement btnPurchase;
	
	@FindBy(css=".sa-icon.sa-success.animate")
	public WebElement iconSuccess;
	
	@FindBy(xpath="//div[contains(@class,'sweet-alert')]//h2")
	public WebElement confirmPopupMessage;
	
	@FindBy(xpath="//p[@class='lead text-muted ']")
	public WebElement confirmPopupText;
	
	@FindBy(xpath="//button[text()='OK']")
	public WebElement btnOK;

}
