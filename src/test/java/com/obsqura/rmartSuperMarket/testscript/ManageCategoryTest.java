package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.ManageCategoryPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base
{
	@Test
	public void verifyWhetherTheUserAbleToAddValuesInManageCategory()
	{
		String userName = ExcelUtility.getString(1, 5,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageCategory();
		menuSelectionPage.clickOnCategorySubMenuOfManageCategory();
		
		ManageCategoryPage manageCategoryPage = new ManageCategoryPage(driver);
		manageCategoryPage.clickOnNewButton().enterValueInCategoryField().clickOnSelectGroup().uploadFile();
		manageCategoryPage.clickOnNoRadioButtonOfShowOnTopMenuField();
		manageCategoryPage.clickOnNoRadioButtonOfShowOnLeftMenuField();
		manageCategoryPage.clickOnSaveButton();
		boolean isAlertMessageDisplayed = manageCategoryPage.successalertMessageDisplay();
		assertTrue(isAlertMessageDisplayed, "Some issue while adding the doc or link");
	}

}
