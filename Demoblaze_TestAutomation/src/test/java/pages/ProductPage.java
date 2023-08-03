package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public ProductPage(RemoteWebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="name")
	public WebElement prodName;
	
	@FindBy(className="price-container")
	public WebElement pricecontainer;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	public WebElement btnAddtocart;

}
