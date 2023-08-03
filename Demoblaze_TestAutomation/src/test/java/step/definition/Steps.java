package step.definition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import utils.BrowserUtil;

public class Steps {

	RemoteWebDriver driver;
	
	@After
	public void afterScenario() {
		driver.quit();
	}
	
	@Given("user open the browser")
	public void open_the_browser() throws Exception {
	    driver = BrowserUtil.getDriver();
	}

	@When("user navigates to the Demoblaze site")
	public void navigate_to_demoblaze_site() {
	    driver.navigate().to("https://www.demoblaze.com");
	}
	
	@Then("verify that demoblaze home page is displayed")
	public void verifyHomePageDisplayed() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "STORE");
		
		HomePage obj = new HomePage(driver);
		boolean flag = obj.linkProductStore.isDisplayed();
		Assert.assertEquals(flag, true, "Check PRODUCT STORE text is displayed!");
	}
	
	@When("user clicks on {string} menu link")
	public void clicksMenuLink(String menuLink) {
		HomePage obj = new HomePage(driver);

		if (menuLink.equalsIgnoreCase("Home")) {
			obj.linkHome.click();
		}
		else if (menuLink.equalsIgnoreCase("Cart")) {
			obj.linkCart.click();
		}
		else if (menuLink.equalsIgnoreCase("Log in")) {
			obj.linkLogin.click();
		}
		else if (menuLink.equalsIgnoreCase("Sign up")) {
			obj.linkSignup.click();
		}
		else if (menuLink.equalsIgnoreCase("Log out")) {
			obj.linkLogout.click();
		}
		else {
			throw new IllegalArgumentException("Invalid menu link: "+menuLink);
		}
	}
	
	@Then("check Sign up dialog is displayed")
	public void checkSignupDialogDisplayed() {
		HomePage obj = new HomePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(obj.signUpModalLabel));
		
		boolean flag = obj.signUpModalLabel.isDisplayed();
		Assert.assertEquals(flag, true, "Check Sign up modal is displayed!");
	}
	
	@Then("check Login dialog is displayed")
	public void checkLoginDialogDisplayed() {
		HomePage obj = new HomePage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(obj.logInModalLabel));
	}
	
	@When("I enter Username {string} and Password {string} and click on Sign up")
	public void enterSignupUsernameAndPassword(String username, String password) {
		HomePage obj = new HomePage(driver);
		obj.inputSignupUsername.sendKeys(username);
		obj.inputSignupPassword.sendKeys(password);
		obj.buttonSignup.click();
	}
	
	@When("I enter Username {string} and Password {string} and click on Log in")
	public void enterLoginUsernameAndPassword(String username, String password) {
		HomePage obj = new HomePage(driver);
		obj.inputLoginUsername.sendKeys(username);
		obj.inputLoginPassword.sendKeys(password);
		obj.buttonLogin.click();
	}
	
	@Then("verify alert popup displayed with text {string}")
	public void verifyAlertDisplayedWithText(String expectedText) throws InterruptedException {
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		Assert.assertEquals(alertText, expectedText);
		alert.accept();
	}
	
	@When("user clicks on {string} under Categories")
	public void clickOnCategory(String category) {
		HomePage obj = new HomePage(driver);
		
		if(category.equalsIgnoreCase("Phones")) {
			obj.linkPhones.click();
		} 
		else if(category.equalsIgnoreCase("Laptops")) {
			obj.linkLaptops.click();
		} 
		else if(category.equalsIgnoreCase("Monitors")) {
			obj.linkMonitors.click();
		} 
		else {
			throw new IllegalArgumentException("Invalid category: "+category);
		}
	}
	
	@Then("check that product {string} is displayed")
	public void checkProductNameIsDisplayed(String productName) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		Thread.sleep(2000); //work around for stale element reference exception
		
		boolean flag = false;
		for(WebElement we : obj.listOfProducts) {
			String text = we.getText();
			if(text.equals(productName)) {
				flag = true;
				break;
			}
		}
		Assert.assertEquals(flag, true, "Matching product name not found: "+productName);
	}
	
	@Then("verify welcome message is displayed with text {string}")
	public void verifyWelcomeMessageDisplayed(String expText) {
		HomePage obj = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(obj.nameofuser));
		
		String nameofuser = obj.nameofuser.getText();
		Assert.assertEquals(nameofuser, expText);
	}
	
	@When("user clicks on product {string} link")
	public void clickProductLink(String productName) throws InterruptedException {
		HomePage obj = new HomePage(driver);
		Thread.sleep(2000); //work around for stale element reference exception
		
		boolean flag = false;
		for(WebElement we : obj.listOfProducts) {
			String text = we.getText();
			if(text.equalsIgnoreCase(productName)) {
				flag = true;
				we.click();
				break;
			}
		}
		
		Assert.assertEquals(flag, true, "Matching product not found: " + productName);
	}
	
	@Then("check product page for {string} is displayed with price {string}")
	public void checkProductPageNameAndPrice(String productName, String price) {
		ProductPage obj = new ProductPage(driver);
		SoftAssert sa = new SoftAssert();
		
		sa.assertEquals(obj.prodName.getText(), productName, "Product name did not match.");
		sa.assertEquals(obj.pricecontainer.getText(), price, "Price did not match.");
		sa.assertAll();
	}
	
	@When("user clicks on 'Add to cart' button")
	public void clicksAddtocartButton() {
		ProductPage obj = new ProductPage(driver);
		obj.btnAddtocart.click();
	}
	
	@Then("verify product with title {string} and price {string} is added in the cart")
	public void verifyProductTitleAndPriceAddedInCart(String title, String expPrice) throws Exception {
		CartPage obj = new CartPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElements(obj.listCartTitle));
		
		boolean found = false;
		String price = null;
		for(int i=0;i<obj.listCartTitle.size();i++) {
			String text = obj.listCartTitle.get(i).getText();
			if(text.equalsIgnoreCase(title)) {
				found = true;
				price = obj.listCartPrice.get(i).getText();
				break;
			}
		}
		if(found==false) {
			throw new Exception("Product Title not found in Cart: " + title);
		}
		
		Assert.assertEquals(price, expPrice, "Price did not match.");
	}
	
	@When("user clicks Delete for product with title {string} in the cart")
	public void deleteProductWithTitleInCart(String title) throws Exception {
		CartPage obj = new CartPage(driver);
		
		boolean found = false;
		for(int i=0;i<obj.listCartTitle.size();i++) {
			String text = obj.listCartTitle.get(i).getText();
			if(text.equalsIgnoreCase(title)) {
				found = true;
				obj.listCartDelete.get(i).click();
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.invisibilityOf(obj.listCartTitle.get(i)));
				break;
			}
		}
		if(found == false) {
			throw new Exception("Product Title was not found in Cart: " + title);
		}
	}
	
	@Then("verify product with title {string} is removed from the cart")
	public void verifyProductIsRemovedFromCart(String title) {
		CartPage obj = new CartPage(driver);
		
		boolean found = false;
		for(WebElement element : obj.listCartTitle) {
			String text = element.getText();
			if(text.equalsIgnoreCase(title)) {
				found = true;
				break;
			}
		}
		Assert.assertEquals(found, false, "Product was found in the cart!");
	}
	
	@Then("check Total price of {string} is shown in the cart")
	public void checkTotalPriceInCart(String expTotal) {
		CartPage obj = new CartPage(driver);
		String totalPrice = obj.totalPrice.getText();
		Assert.assertEquals(totalPrice, expTotal, "Total price did not match in the cart!");
	}
	
	@When("user clicks on 'Place Order' button")
	public void clicksPlaceOrderButton() {
		CartPage obj = new CartPage(driver);
		obj.btnPlaceOrder.click();
	}
	
	@Then("check order modal with {string} is displayed")
	public void checkOrderModalTotal(String total) {
		CartPage obj = new CartPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(obj.orderModalLabel));
		
		String modalTotal = obj.modalTotal.getText();
		Assert.assertEquals(modalTotal, total, "Total did not match in the modal!");
	}
	
	/*
	 * Enter order form details using data from DataTable
	 * | Name  | Country | City  | Credit card | Month | Year |
	 */
	@When("user enter order form details as:")
	public void enterOrderFormDetails(DataTable table) {
		List<String> data = table.row(0);
		String name = data.get(0);
		String country = data.get(1);
		String city = data.get(2);
		String creditCard = data.get(3);
		String month = data.get(4);
		String year = data.get(5);
		
		CartPage obj = new CartPage(driver);
		if(name!=null) {
			obj.inputName.clear();
			obj.inputName.sendKeys(name);
		}
		if(country!=null) {
			obj.inputCountry.sendKeys(country);
		}
		if(city!=null) {
			obj.inputCity.sendKeys(city);
		}
		if(creditCard!=null) {
			obj.inputCreditcard.clear();
			obj.inputCreditcard.sendKeys(creditCard);
		}
		if(month!=null) {
			obj.inputMonth.sendKeys(month);
		}
		if(year!=null) {
			obj.inputYear.sendKeys(year);
		}
		
		obj.btnPurchase.click();
	}
	
	@Then("check popup with 'Success' icon is displayed")
	public void checkPopupWithSuccess() {
		CartPage obj = new CartPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(obj.iconSuccess));
	}
	
	@Then("verify popup shows {string} with details as:")
	public void verifyPopupShowsDetails(String message,DataTable table) {
		CartPage obj = new CartPage(driver);
		
		String popupMessage = obj.confirmPopupMessage.getText();
		Assert.assertEquals(popupMessage, message, "Popup message did not match!");
		
		List<String> data = table.row(0);
		String amount = data.get(0);
		String cardNumber = data.get(1);
		String name = data.get(2);
		
		String popupText = obj.confirmPopupText.getText();
		Assert.assertTrue(popupText.contains("Amount: "+amount), "Popup didn't contain expected Amount: "+amount);
		Assert.assertTrue(popupText.contains("Card Number: "+cardNumber), "Popup didn't contain expected Card Number: "+cardNumber);
		Assert.assertTrue(popupText.contains("Name: "+name), "Popup didn't contain expected Name: "+name);
	}
	
	@When("user clicks OK on confirmation popup")
	public void clicksOKConfirmPopup() {
		CartPage obj = new CartPage(driver);
		obj.btnOK.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(obj.confirmPopupMessage));
	}
	
	@Then("verify user is logged out")
	public void verifyUserLoggedOut() {
		HomePage obj = new HomePage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(obj.nameofuser));
	}
	
	@Then("verify the Cart table is empty")
	public void verifyCartIsEmpty() {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		Assert.assertEquals(rows.size(), 0, "Cart table is not empty!");
	}

}
