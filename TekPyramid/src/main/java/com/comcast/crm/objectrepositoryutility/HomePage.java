package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactlnk;
	
	public WebElement getAdminImg() {
		return adminImg;
	}

	public void setAdminImg(WebElement adminImg) {
		this.adminImg = adminImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}

	public void setSignOutLnk(WebElement signOutLnk) {
		this.signOutLnk = signOutLnk;
	}

	public void setOrgLink(WebElement orgLink) {
		this.orgLink = orgLink;
	}

	public void setContactlnk(WebElement contactlnk) {
		this.contactlnk = contactlnk;
	}

	public void setCampaignlnk(WebElement campaignlnk) {
		this.campaignlnk = campaignlnk;
	}

	public void setMoreLink(WebElement moreLink) {
		this.moreLink = moreLink;
	}

	@FindBy(linkText = "Campaigns")
	private WebElement campaignlnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getContactlnk() {
		return contactlnk;
	}

	public WebElement getCampaignlnk() {
		return campaignlnk;
	}
	
	public void navigateToCampaginPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignlnk.click();
	}
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLnk.click();
		
	}
	
}