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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// otwarcie przegladarki i wejscie na strone 'saucedemo.com'
WebUI.openBrowser(rawUrl=url)

// proba zalogowanie sie na strone przy uzyciu blednych danych
for (def row = 1; row <= findTestData('saucedemo_logowanie_bledne_dane_1').getRowNumbers(); row++)
{
	// wpisanie nazwy uzytkownika
	WebUI.setText(findTestObject('Saucedemo/input_user_name'),
		 findTestData('saucedemo_logowanie_bledne_dane_1').getValue('user-name', row))
	
	// wpisanie hasla
	WebUI.setText(findTestObject('Saucedemo/input_password'),
		findTestData('saucedemo_logowanie_bledne_dane_1').getValue('password', row))
	
	// klikniecie na przycisk 'login'
	WebUI.click(findTestObject('Saucedemo/button_login'))
	
	// sprawdzenie czy wiadomosc o bledzie przy logowaniu sie sprawdza
	String msg_error_logowanie = WebUI.getText(findTestObject('Saucedemo/login_error_msg'))
	assert msg_error_expected == msg_error_logowanie
}


// zamkniecie przegladarki
WebUI.closeBrowser()

