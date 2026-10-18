package com.Geeth.tests;

import com.Geeth.base.Base;
import com.Geeth.pages.BookingPage;
import com.Geeth.pages.HomePage;
import com.Geeth.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class BookingTest extends Base {

    @Test
    public void verifyRoomBookingWithValidDetails() {
        BookingPage booking = new BookingPage(driver);

        LocalDate checkin = LocalDate.now().plusDays(ThreadLocalRandom.current().nextInt(30, 300));
        LocalDate checkout = checkin.plusDays(2);

        booking.openRoom(ConfigReader.get("baseUrl"), 1, checkin.toString(), checkout.toString());
        booking.clickReserveNow();   // opens the guest form
        booking.enterGuestDetails("Geeth", "Perera", "geeth@test.com", "07712345678");
        booking.clickReserveNow();   // submits the booking

        Assert.assertTrue(booking.isBookingConfirmed(), "Booking was not confirmed");
    }

    @Test
    public void verifyBookButtonOpensReservationPage() {
        HomePage home = new HomePage(driver);
        home.clickFirstBookButton();
        Assert.assertTrue(home.isReservationPageOpened(), "Reservation page did not open");
    }
}