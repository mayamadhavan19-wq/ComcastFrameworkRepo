package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {
WebDriver driver;
public CreatingNewOrganizationPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(name = "accountname")
private WebElement orgNameTxt;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name = "phone")
private WebElement phoneNumberTxt;

public WebElement getPhoneNumberTxt() {
	return phoneNumberTxt;
}


public void createOrg(String Name) {
	orgNameTxt.sendKeys(Name);
	saveBtn.click();
}

public void createOrg(String Name, String phoneNumber) {
	orgNameTxt.sendKeys(Name);
	phoneNumberTxt.sendKeys(phoneNumber);
	saveBtn.click();
}

public WebElement getOrgNameTxt() {
	return orgNameTxt;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
}