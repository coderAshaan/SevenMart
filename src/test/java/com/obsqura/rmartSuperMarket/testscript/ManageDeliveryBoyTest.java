package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageDeliveryBoyPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base
{
	@Test
	public void verifyTheUserExistsInTheVerifyUsersList()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageDeliveryBoy();
		
		ManageDeliveryBoyPage manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		manageDeliveryBoyPage.clickOnNewButton().enterName().enterEmailId().enterPhoneNumber().enterAddressField().reenterUserName().reenterPassword().clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageDeliveryBoyPage.alertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "Submission failed");
	}

}
