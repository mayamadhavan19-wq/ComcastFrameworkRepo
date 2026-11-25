package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProductPage {
	WebDriver driver;
	public CreatingNewProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productname")
	private WebElement productnameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "discontinued")
	private WebElement productActiveCheckBox;
	
	@FindBy(name = "sales_start_date")
	private WebElement salesStartDate;
	
	@FindBy(name = "sales_end_date")
	private WebElement salesEndDate;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vendorNameIcon;
	
	
	
	

	public WebElement getProductActiveCheckBox() {
		return productActiveCheckBox;
	}

	public WebElement getSalesStartDate() {
		return salesStartDate;
	}

	public WebElement getSalesEndDate() {
		return salesEndDate;
	}

	public WebElement getVendorNameIcon() {
		return vendorNameIcon;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void setSaveBtn(WebElement saveBtn) {
		this.saveBtn = saveBtn;
	}

	public WebElement getProductnameTxt() {
		return productnameTxt;
	}
	
}