package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Arunachalam
 * This class contains Login Page elements & business libraries like login()
 */
public class LoginPage extends com.comcast.crm.geneic.webdriverutility.WebDriverUtility {
WebDriver driver ;
public LoginPage(WebDriver driver ) {
this.driver=driver;
PageFactory.initElements(driver, this);
}

@FindBy(name="user_name")
private WebElement usernameEdt;

@FindBy(name="user_password")
private WebElement passwordEdt;

@FindBy(id="submitButton")
private WebElement loginBtn;

public WebElement getUsernameEdt() {
	return usernameEdt;
}

public WebElement getPassswordEdt() {
	return passwordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}
/**
 * login to application based on url ,username, password
 * @param url
 * @param username
 * @param password
 */
public void loginToapp(String url,String username, String password) {
	waitForPageToLoad(driver);
	maximize(driver);
	driver.get(url);
	
	usernameEdt.sendKeys(username);
	passwordEdt.sendKeys(password);
	loginBtn.click();
}
}