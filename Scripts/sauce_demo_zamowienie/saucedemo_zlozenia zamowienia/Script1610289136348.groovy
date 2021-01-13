import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import bsh.Variable
import internal.GlobalVariable as GlobalVariable

// otwarcie przegladarki i wejscie na strone 'saucedemo.com'
WebUI.openBrowser(rawUrl=url)

// logowanie sie na stone przy uzyciu poprawnych danych
for (def row = 1; row <= findTestData('saucedemo_logowanie_poprawne_dane').getRowNumbers()-1; row++)
{
	// wpisanie nazwy uzytkownika
	WebUI.setText(findTestObject('Saucedemo/input_user_name'),
		 findTestData('saucedemo_logowanie_poprawne_dane').getValue('User-name', row))
	
	// wpisanie hasla
	WebUI.setText(findTestObject('Saucedemo/input_password'),
		findTestData('saucedemo_logowanie_poprawne_dane').getValue('password', row))
	
	// klikniecie na przycisk 'login'
	WebUI.click(findTestObject('Saucedemo/button_login'))
	
	// klikniecie na przycisk 'menu'
	WebUI.click(findTestObject('Saucedemo/button_Open Menu'))

	// klikniecie na przycisk 'logout'
	WebUI.click(findTestObject('Saucedemo/button_Logout'))	
}

// wpisanie nazwy uzytkownika
WebUI.setText(findTestObject('Saucedemo/input_user_name'),
	findTestData('saucedemo_logowanie_poprawne_dane').getValue('User-name',3))

// wpisanie hasla
WebUI.setText(findTestObject('Saucedemo/input_password'),
   findTestData('saucedemo_logowanie_poprawne_dane').getValue('password',3))

// klikniecie na przycisk 'login'
WebUI.click(findTestObject('Saucedemo/button_login'))

// klikniecie na obiekt 'div_Sauce Labs Backpack'
WebUI.click(findTestObject('Saucedemo/div_Sauce Labs Backpack'))

// klikniecie na przycisk 'ADD TO CART'
WebUI.click(findTestObject('Saucedemo/button_ADD TO CART'))

// klikniecie na przycisk 'ShoppingCart'
WebUI.click(findTestObject('Saucedemo/button_ShoppingCart'))

// klikniecie na przycisk 'Checkout'
WebUI.click(findTestObject('Saucedemo/button_Checkout'))

// klikniecie na przycisk 'Continue'
WebUI.click(findTestObject('Saucedemo/button_Continue'))

// sprawdzenie czy wiadomosc o bledzie przy podawaniu danych w formularzu sie zgadza
String msg_error_danych = WebUI.getText(findTestObject('Saucedemo/formularz_error_msg'))
assert msg_error_exp == msg_error_danych

// wpisanie imienia
WebUI.setText(findTestObject('Saucedemo/input_first-name'), Imie)

// wpisanie nazwiska
WebUI.setText(findTestObject('Saucedemo/input_last-name'), Nazwisko)

// wpisanie kodu pocztowego
WebUI.setText(findTestObject('Saucedemo/input_postal-code'), Kod_pocztowy)

// klikniecie na przycisk 'Continue'
WebUI.click(findTestObject('Saucedemo/button_Continue'))

// klikniecie na przycisk 'Finish'
WebUI.click(findTestObject('Saucedemo/button_Finish'))


// zamkniecie przegladarki
WebUI.closeBrowser()







