package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocInfoPage {
	WebDriver driver;
	public DocInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
	@FindBy(id = "mouseArea_Title")
	private WebElement titletxt;
	
	public WebElement gettitletxt() {
		return titletxt;
	}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headertxt;
	
	public WebElement getheadertxt() {
		return headertxt;
	}
}
