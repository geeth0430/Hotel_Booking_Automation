package com.Geeth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BookingPage extends BasePage {

    private final By firstName = By.cssSelector("input[name='firstname'], .room-firstname");
    private final By lastName = By.cssSelector("input[name='lastname'], .room-lastname");
    private final By email = By.cssSelector("input[name='email'], .room-email");
    private final By phone = By.cssSelector("input[name='phone'], .room-phone");
    private final By reserveButton = By.xpath("//button[contains(.,'Reserve Now')]");
    private final By confirmation = By.xpath("//*[contains(text(),'Booking Confirmed')]");

    public BookingPage(WebDriver driver) {
        super(driver);
    }

    public void openRoom(String baseUrl, int roomId, String checkin, String checkout) {
        driver.get(baseUrl + "/reservation/" + roomId
                + "?checkin=" + checkin + "&checkout=" + checkout);
        dismissWelcomeBanner();
    }

    public void clickReserveNow() {
        click(reserveButton);
    }

    public void enterGuestDetails(String first, String last, String mail, String phoneNo) {
        type(firstName, first);
        type(lastName, last);
        type(email, mail);
        type(phone, phoneNo);
    }

    public boolean isBookingConfirmed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(confirmation)).isDisplayed();
    }
}