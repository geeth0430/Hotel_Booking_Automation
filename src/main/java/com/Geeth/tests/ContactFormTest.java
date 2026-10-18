package com.Geeth.tests;

import com.Geeth.base.Base;
import com.Geeth.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactFormTest extends Base {

    @Test
    public void submitContactFormWithValidData() {
        HomePage home = new HomePage(driver);
        home.fillContactForm("Geeth", "geeth@test.com", "07712345678",
                "Room enquiry", "I would like to ask about room availability.");
        home.submitContactForm();
        Assert.assertTrue(home.isSuccessMessageDisplayed(),
                "Contact form success message not displayed");
    }
}