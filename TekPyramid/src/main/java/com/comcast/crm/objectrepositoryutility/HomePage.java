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
		@FindBy(linkText = "Calendar")
		private WebElement calenderLink;
		
		@FindBy(linkText = "Leads")
		private WebElement leadsLink;
		
		@FindBy(linkText = "Organizations")
		private WebElement orgLink;
		
		@FindBy(linkText = "Contacts")
		private WebElement contactlnk;
		
		@FindBy(linkText="Opportunities")
		private WebElement opportunitiesLink;
		
		
		@FindBy(linkText = "Products")
		private WebElement productsLink;
	    
		@FindBy(id = "qccombo")
		private WebElement quickCreateDD;
		
		@FindBy(name = "vendorname")
		private WebElement vendorNameTxt;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement quickSaveBtn;
		
	public WebElement getVendorNameTxt() {
			return vendorNameTxt;
		}

		public WebElement getQuickSaveBtn() {
			return quickSaveBtn;
		}

	public WebElement getProductsLink() {
			return productsLink;
		}
		@FindBy(linkText = "Documents")
		private WebElement documentsLink;
		
		@FindBy(linkText = "Email")
		private WebElement emailLink;
		
		
		

		public WebElement getQuickCreateDD() {
			return quickCreateDD;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getCalenderLink() {
			return calenderLink;
		}

		public WebElement getLeadsLink() {
			return leadsLink;
		}

		public WebElement getOpportunitiesLink() {
			return opportunitiesLink;
		}

		

		public WebElement getDocumentsLink() {
			return documentsLink;
		}

		public WebElement getEmailLink() {
			return emailLink;
		}

		public WebElement getQuikeCreateDropdown() {
			return quikeCreateDropdown;
		}

		public WebElement getOrgNameTextField() {
			return orgNameTextField;
		}

		public WebElement getPhNumTextField() {
			return phNumTextField;
		}

		public WebElement getUserRadioBtn() {
			return userRadioBtn;
		}

		public WebElement getGroupRadioBtn() {
			return groupRadioBtn;
		}

		public WebElement getAssignedToUserDD() {
			return assignedToUserDD;
		}

		public WebElement getAssignedToGroupDD() {
			return assignedToGroupDD;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		public WebElement getCancelBtn() {
			return cancelBtn;
		}

		public WebElement getAdminImg() {
			return adminImg;
		}

		public WebElement getSignOutLnk() {
			return signOutLnk;
		}
		@FindBy(linkText = "Campaigns")
		private WebElement campaignlnk;
		
		@FindBy(linkText = "More")
		private WebElement moreLink;
		
		@FindBy(id = "qccombo")
		private WebElement quikeCreateDropdown;
		//CreateOrg pop up elements
		@FindBy(name="accountname")
		private WebElement orgNameTextField;
		
		@FindBy(id  ="phone")
		private WebElement phNumTextField;
		
		@FindBy(xpath="//input[@value='U']")
		private WebElement userRadioBtn;
		
		@FindBy(xpath = "//input[@value='T']")
		private WebElement groupRadioBtn;
		
		@FindBy(name = "assigned_user_id")
		private WebElement assignedToUserDD;
		
		@FindBy(name = "assigned_group_id")
		private WebElement assignedToGroupDD;
		
		@FindBy(xpath = "//input[ @name='button' and @title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		@FindBy(xpath = "//input[ @name='button' and @title='Cancel [Alt+X]']")
		private WebElement cancelBtn;
		
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
		
		
		
		
		@FindBy(linkText = "Documents")
		private WebElement documentlLink;
		
		public WebElement getdocumentlLink() {
			return documentlLink;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		public void navigateToCampaginPage(WebDriver driver) {
			Actions act = new Actions(driver);
			act.moveToElement(moreLink).perform();
			campaignlnk.click();
		}
		public void logout() {
			Actions act = new Actions(driver);
			act.moveToElement(adminImg).perform();
			signOutLnk.click();
			System.out.println("from homepage ");
		}
		
	}
