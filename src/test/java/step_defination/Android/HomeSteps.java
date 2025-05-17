package step_defination.Android;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page;
import pages.android.HomePage;

public class HomeSteps extends Page {

    private AndroidKey getAndroidKeyFromDigit(char digit) {
    switch (digit) {
        case '0': return AndroidKey.DIGIT_0;
        case '1': return AndroidKey.DIGIT_1;
        case '2': return AndroidKey.DIGIT_2;
        case '3': return AndroidKey.DIGIT_3;
        case '4': return AndroidKey.DIGIT_4;
        case '5': return AndroidKey.DIGIT_5;
        case '6': return AndroidKey.DIGIT_6;
        case '7': return AndroidKey.DIGIT_7;
        case '8': return AndroidKey.DIGIT_8;
        case '9': return AndroidKey.DIGIT_9;
        default:
            throw new IllegalArgumentException("Invalid digit: " + digit);
    }
}
    @Given("User is on Get Ride Requests screen")
    public void UserIsOnHomePageTitleTestingApp() {
        Assert.assertTrue(getHomePage().getTitle().isDisplayed());
    }

    @Then("User should see home screen")
    public void UsershouldseeHomePageTitleTestingApp() {
        Assert.assertTrue(getHomePage().getTitle().isDisplayed());
    }

    // @And("User taps on تخطي >")
    // public void UserTapsonEmailField() {
    //     Assert.assertTrue(getHomePage().getEmailfield().isDisplayed());
    //     getHomePage().getEmailfield().click();
    // }

@When("User taps on {string}")
public void userTapsOnDynamicElement(String accessibilityId) {
    Assert.assertTrue(getHomePage().getElementByAccessibilityID(accessibilityId).isDisplayed());
    getHomePage().getElementByAccessibilityID(accessibilityId).click();
}

@When("User taps on the {string}")
public void userTapsOntheDynamicElement(String accessibilityId) {
    Assert.assertTrue(getHomePage().getElementBytheAccessibilityID(accessibilityId).isDisplayed());
    getHomePage().getElementBytheAccessibilityID(accessibilityId).click();
}

@When("User taps on Phone Number field")
public void userTapsOnPhoneNumberField() {
    Assert.assertTrue(getHomePage().getPhoneNumberField().isDisplayed());
    getHomePage().getPhoneNumberField().click();
}

@And("User type {string} in Phone Number field")
public void userTypeInPhoneNumberField(String phoneNumber) {
    WebElement phoneField = getHomePage().getPhoneNumberField();
    Assert.assertTrue(phoneField.isDisplayed());
    phoneField.clear();
    phoneField.sendKeys(phoneNumber);
}

@And("User clicks on Accept Agreements and Terms checkbox")
public void userClicksOnAcceptTermsCheckbox() {
    WebElement checkbox = getHomePage().getAcceptTermsCheckbox();
    checkbox.click();
}

@When("user enter {string} in otp field")
public void userEnterOtpWithKeyEvents(String otp) throws InterruptedException {
    AndroidElement otpField = HomePage.getOtpInputField();
    otpField.click(); // Focus the OTP field

    // Press each digit using AndroidKey events
    for (char digit : otp.toCharArray()) {
        AndroidKey key = getAndroidKeyFromDigit(digit);
        AndroidDriverSetup.getAndroidDriver().pressKey(new KeyEvent(key));
        Thread.sleep(300); // Optional delay between key presses
    }
}


@Then("User should see {string}")
public void userShouldSeeDynamicElement(String accessibilityId) {
    Assert.assertTrue(getHomePage().getElementByAccessibilityID(accessibilityId).isDisplayed());
}

@When("user taps on profile button")
public void userClicksOnProfileButton() {
    AndroidElement profileButton = HomePage.getProfileButton();
    Assert.assertTrue("Profile button is not displayed", profileButton.isDisplayed());
    profileButton.click();
}

@Then("user should see Alert Message")
public void userShouldSeeAlertMessage() {
    AndroidElement alert = HomePage.getAlertMessageElement();
    Assert.assertTrue("Alert message not displayed", alert.isDisplayed());
}

}