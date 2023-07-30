package com.obsqura.rmartSuperMarket.testscript;

import org.testng.annotations.Test;

import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;

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
	}

}
