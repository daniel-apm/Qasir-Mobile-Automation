package scenarioDemo
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.MobileDriver

import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class QasirAuthentikasi {

	@Given("User berada pada halaman pemilihan bahasa")
	def preferedLanguagePage() {
		Mobile.startExistingApplication(GlobalVariable.qasir_app_id)
	}

	@When("User memilih bahasa Indonesia")
	def choosePreferedLanguage() {
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Prefered Language-Page/android_RadioButton - Indonesia'), 5, FailureHandling.OPTIONAL) == true) {
			Mobile.takeScreenshot()
			Mobile.tap(findTestObject('Object Repository/Prefered Language-Page/android_RadioButton - Indonesia'), 5)
			Mobile.delay(1)
			Mobile.tap(findTestObject('Object Repository/Prefered Language-Page/android_Button - Lanjut'), 5)
		}
	}

	@And("User melakukan next pada setiap halaman Onboarding")
	def slideOnboarding() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login-Page/android_Button - Masuk'), 5)
		for (int i = 1; i <= 4; i++) {
			Mobile.tap(findTestObject("Object Repository/Login-Page/android_ImageView - Onboarding (${i})"), 5)
			Mobile.takeScreenshot()
		}
		Mobile.tap(findTestObject('Object Repository/Login-Page/android_Button - Masuk'), 5)
	}

	@And("User memasukkan akun credentials yang sudah didaftarkan")
	def inputCredentials() {
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Login-Page/android_Button - OK (Info)'), 5, FailureHandling.OPTIONAL) == true) {
			Mobile.tap(findTestObject('Object Repository/Login-Page/android_Button - OK (Info)'), 5)
			Mobile.delay(1)
			Mobile.tap(findTestObject('Object Repository/Permission-Page/android.widget.Button - While using the app'), 5)
			Mobile.delay(1)
			Mobile.tap(findTestObject('Object Repository/Permission-Page/android.widget.Button - Allow'), 5)
		}
		Mobile.verifyElementVisible(findTestObject('Object Repository/Login-Page/android_EditText - No. Handphone'), 5)
		Mobile.takeScreenshot()
		Mobile.setText(findTestObject('Object Repository/Login-Page/android_EditText - No. Handphone'), GlobalVariable.no_hp, 5)
		Mobile.delay(1)
		Mobile.setEncryptedText(findTestObject('Object Repository/Login-Page/android_EditText - No PIN'), GlobalVariable.pin, 5)
	}

	@And("User memilih outlet (.*)")
	def chooseOutlet(String cabang) {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Choose Outlet-Page/android_EditText - Cari'), 60)
		Mobile.setText(findTestObject('Object Repository/Choose Outlet-Page/android_EditText - Cari'), cabang, 5)
		Mobile.verifyElementVisible(findTestObject('Object Repository/Choose Outlet-Page/android_TextView - Item'), 10)
		Mobile.takeScreenshot()
		Mobile.tap(findTestObject('Object Repository/Choose Outlet-Page/android_TextView - Item'), 5)
	}

	@Then("User berada pada halaman beranda")
	def validateLogin() {
		if (Mobile.verifyElementVisible(findTestObject('Object Repository/Permission-Page/android.widget.Button - Allow'), 15, FailureHandling.OPTIONAL) == true) {
			Mobile.tap(findTestObject('Object Repository/Permission-Page/android.widget.Button - Allow'), 5)
		}
		Mobile.verifyElementVisible(findTestObject('Object Repository/Beranda-Page/android_TextView - Beranda'), 60)
		Mobile.takeScreenshot()
	}
}