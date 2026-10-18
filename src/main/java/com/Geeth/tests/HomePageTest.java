package com.Geeth.tests;

import com.Geeth.base.Base;
import com.Geeth.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {

    @Test
    public void verifyPageTitle() {
        Assert.assertTrue(driver.getTitle().toLowerCase().contains("restful-booker")
                || driver.getTitle().toLowerCase().contains("hotel"));
    }

    @Test
    public void verifyRoomsAreDisplayed() {
        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.getRoomCount() > 0, "No rooms displayed");
    }
}