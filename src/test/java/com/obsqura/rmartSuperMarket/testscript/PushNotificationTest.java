package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import com.obsqura.rmartSuperMarket.pages.PushNotificationPage;

import utilities.ExcelUtility;

public class PushNotificationTest extends Base
{
	@Test
	public void verifyWhetherUserAbleToSendTheNotification()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnPushNotification();
		
		PushNotificationPage pushNotificationPage = new PushNotificationPage(driver);
		pushNotificationPage.enterTitle().enterDescripiton().clickOnSaveButton();
		boolean isAlertMessageDisplayed = pushNotificationPage.alertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "Submission failed");
	}

}
