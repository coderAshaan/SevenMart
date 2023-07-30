package com.obsqura.rmartSuperMarket.testscript;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.obsqura.rmartSuperMarket.pages.ExpenseCategoryPage;
import com.obsqura.rmartSuperMarket.pages.LoginPage;
import com.obsqura.rmartSuperMarket.pages.MenuSelectionPage;

import utilities.ExcelUtility;

public class ExpenseCategoryTest extends Base
{
	@Test
	public void verifyWhetherUserAbleToDeleteTheTitle()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense();
		menuSelectionPage.clickOnExpenseCategorySubMenu();
		
		ExpenseCategoryPage expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.deletTheTitle();
		boolean isAlertMessageDisplayed = expenseCategoryPage.deleteAlertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayed, "Unable to delete");
	}
	
	@Test
	public void verifyUserAbleToEditTheTile()
	{
		String userName = ExcelUtility.getString(1, 0,"LoginPage");
		String password = ExcelUtility.getString(1, 0,"LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsernameOnUsernameField(userName).enterPasswrodOnPasswrodField(password).clickOnSignInButton();
		
		MenuSelectionPage menuSelectionPage = new MenuSelectionPage(driver);
		menuSelectionPage.clickOnManageExpense();
		menuSelectionPage.clickOnExpenseCategorySubMenu();
		
		ExpenseCategoryPage expenseCategoryPage = new ExpenseCategoryPage(driver);
		expenseCategoryPage.editTheTitle();
		boolean isAlertMessageDisplayedForEdit = expenseCategoryPage.editAlertMessageIsDisplayed();
		assertTrue(isAlertMessageDisplayedForEdit, "Unable to edit");
	}
	

}
