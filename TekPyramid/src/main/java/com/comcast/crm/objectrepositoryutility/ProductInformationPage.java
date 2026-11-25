package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	WebDriver driver;
	public ProductInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "mouseArea_Product Name")
	private WebElement productNameTbl;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeaderTxt;
	
	public WebElement getProductNameTbl() {
		return productNameTbl;
	}

	public WebElement getProductHeaderTxt() {
		return productHeaderTxt;
	}
	
	@FindBy(linkText = "Create Invoice")
	private WebElement invoicelink;
	
	public WebElement getinvoicelink() {
	return invoicelink;
}
}
