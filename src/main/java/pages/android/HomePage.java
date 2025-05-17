package pages.android;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.utils.AndroidCore.AndroidDriverSetup;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pages.Page;

public class HomePage {

    private String titleAccessibilityID = "التالي";
    private static final String phoneNumberFieldXPath = "//android.widget.EditText";
    private static final String acceptTermsCheckboxXPath = "//android.widget.CheckBox";

private static final String otpContainerXPath = 
"//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]";
private static final String otpFieldXPath = "//android.widget.EditText";
private static final String profileButtonXPath = "//android.view.View[@content-desc=\"Your Location\nX59G+RGH Karachi\"]/android.widget.ImageView";
private static final String alertMessageXPath = "//android.widget.ImageView[@content-desc=\"ALERT\nAre you sure to want to Logout\"]";


    public HomePage(Page page) {
    }

    public WebElement getElementByAccessibilityID(String accessibilityId) {
    return AndroidDriverSetup.getAndroidDriver().findElementByAccessibilityId(accessibilityId);
}

 public WebElement getElementBytheAccessibilityID(String accessibilityId) {
    AndroidDriver<?> driver = AndroidDriverSetup.getAndroidDriver();

    try {
        // Try finding the element directly
        return driver.findElement(MobileBy.AccessibilityId(accessibilityId));
    } catch (Exception e) {
        System.out.println("Element '" + accessibilityId + "' not immediately visible. Performing swipe up from 'Work Documents'...");

        // Step 1: Find the anchor element
        WebElement anchor = driver.findElement(By.xpath("//android.view.View[@content-desc='Work Documents']"));
        Point location = anchor.getLocation();
        Dimension size = anchor.getSize();

        int startX = location.getX() + size.getWidth() / 2;
        int startY = location.getY() + size.getHeight() / 2;
        int endY = startY - 800; // Increased scroll distance

        // Step 2: Perform tap-hold swipe up
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(100))); // Slight hold for realism
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(400), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(swipe));

        // Step 3: Try finding the element again after scroll
        return driver.findElement(MobileBy.AccessibilityId(accessibilityId));
    }
}


public static WebElement getPhoneNumberField() {
    return AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(phoneNumberFieldXPath));
}


public static WebElement getAcceptTermsCheckbox() {
    return AndroidDriverSetup.getAndroidDriver().findElement(By.xpath(acceptTermsCheckboxXPath));
}

public static AndroidElement getOtpContainer() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpContainerXPath)));
}

public static AndroidElement getOtpInputField() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(otpFieldXPath)));
}

public static AndroidElement getProfileButton() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(profileButtonXPath)));
}


public static AndroidElement getAlertMessageElement() {
    WebDriverWait wait = new WebDriverWait(AndroidDriverSetup.getAndroidDriver(), 10);
    return (AndroidElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(alertMessageXPath)));
}

}
