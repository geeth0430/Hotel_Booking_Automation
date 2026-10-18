package com.Geeth.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final By roomCards = By.cssSelector(".room-card");
    private final By bookButton = By.xpath("(//a[contains(.,'Book now')] | //button[contains(.,'Book')])[1]");

    private final By nameField = By.cssSelector("#name, [data-testid='ContactName']");
    private final By emailField = By.cssSelector("#email, [data-testid='ContactEmail']");
    private final By phoneField = By.cssSelector("#phone, [data-testid='ContactPhone']");
    private final By subjectField = By.cssSelector("#subject, [data-testid='ContactSubject']");
    private final By messageField = By.cssSelector("#description, [data-testid='ContactDescription']");
    private final By submitButton = By.xpath("//button[@id='submitContact' or normalize-space()='Submit']");
    private final By successMessage = By.xpath("//*[contains(text(),'Thanks for getting in touch')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public int getRoomCount() {
        wait.until(ExpectedConditions.presenceOfElementLocated(roomCards));
        return driver.findElements(roomCards).size();
    }

    public void clickFirstBookButton() {
        click(bookButton);
    }

    public boolean isReservationPageOpened() {
        return wait.until(ExpectedConditions.urlContains("reservation"));
    }

    public void fillContactForm(String name, String email, String phone,
                                String subject, String message) {
        type(nameField, name);
        type(emailField, email);
        type(phoneField, phone);
        type(subjectField, subject);
        type(messageField, message);
    }

    public void submitContactForm() {
        click(submitButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
    }
}