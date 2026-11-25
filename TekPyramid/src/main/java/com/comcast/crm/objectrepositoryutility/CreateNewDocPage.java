package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewDocPage {
	WebDriver driver;
	public CreateNewDocPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "notes_title")
	private WebElement  Title;
	
	public WebElement getTitle() {
		return Title;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement  saveBtn;
	
	public WebElement getsaveBtn() {
		return saveBtn;
}
}
