package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DateTest {
    @Test
    public void testIsValidDate_YearIsValid() {
        assertTrue(Date.isValidDate(1, 1, 2023));
    }

    @Test
    public void testIsValidDate_MonthIsInvalid() {
        assertFalse(Date.isValidDate(1, 13, 2023));
    }

    @Test
    public void testIsValidDate_DayIsInvalid() {
        assertFalse(Date.isValidDate(31, 4, 2023));
    }

    @Test
    public void testIsLeapYear_LeapYear() {
        assertTrue(Date.isLeapYear(2020));
    }

    @Test
    public void testIsLeapYear_NotLeapYear() {
        assertFalse(Date.isLeapYear(2021));
    }

    @Test
    public void testNextDate() {
        assertEquals(
                new Date(1, 1, 2023),
                new Date(31, 12, 2022).nextDate());
    }

    @Test
    public void testPreviousDate() {
        Date currentDate = new Date(1, 1, 2023);
        Date previousDate = currentDate.previousDate();
        assertEquals(new Date(31, 12, 2022), previousDate);
    }

    // step 3
    @Test
    public void testNextDate_SimpleIncrement() {
        assertEquals(new Date(2, 1, 2023), new Date(1, 1, 2023).nextDate());
    }

    @Test
    public void testNextDate_ChangeOfMonth() {
        assertEquals(new Date(1, 1, 2023), new Date(31, 12, 2022).nextDate());
    }

    @Test
    public void testNextDate_ChangeOfYear() {
        assertEquals(new Date(1, 1, 2024), new Date(31, 12, 2023).nextDate());
    }

    @Test
    public void testPreviousDate_SimpleDecrement() {
        assertEquals(new Date(1, 1, 2023), new Date(2, 1, 2023).previousDate());
    }

    @Test
    public void testPreviousDate_ChangeOfMonth() {
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
    }

    @Test
    public void testPreviousDate_ChangeOfYear() {
        assertEquals(new Date(31, 12, 2023), new Date(1, 1, 2024).previousDate());
    }

    @Test
    public void testPreviousDate_FirstDayOfYear() {
        assertEquals(new Date(31, 12, 2022), new Date(1, 1, 2023).previousDate());
    }

    // Etape 4

    @Test
    public void testCompareTo_PosteriorDate() {
        Date date1 = new Date(1, 1, 2023);
        Date date2 = new Date(31, 12, 2022);
        assertTrue(date1.compareTo(date2) > 0);
    }

    @Test
    public void testCompareTo_IdenticalDate() {
        Date date1 = new Date(1, 1, 2023);
        Date date3 = new Date(1, 1, 2023);
        assertTrue(date1.compareTo(date3) == 0);
    }

    @Test
    public void testCompareTo_AnteriorDate() {
        Date date1 = new Date(1, 1, 2023);
        Date date4 = new Date(2, 1, 2023);
        assertTrue(date1.compareTo(date4) < 0);
    }
}