package com.fmi;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class FMIDate {

    private int year;
    private int month;
    private int day;

    public FMIDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear() {

        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return  false;
        } else if (year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getCentury() {

        return year / 100 + 1;
    }

    public long getDaysDifference(FMIDate other) {

        return Duration.
            between(LocalDateTime.of(year, month, day, 0, 0, 0), LocalDateTime.of(other.year,
                other.month, other.day, 0, 0, 0)).toDays() + 1;
    }

    public void printInfo() {

        String result = year + " " + String.format("%02d", month) + " " + String.format("%02d", day) + " - " +
            getCentury() + " century.";

        if (isLeapYear()) {

            result += "It is a LEAP year";
        }

        System.out.println(result);
    }

    public static void main(String[] args) {

        FMIDate a = new FMIDate(2016, 9, 26);
        FMIDate b = new FMIDate(1878, 3, 3);

        System.out.println(b.getDaysDifference(a));
        a.printInfo();
        b.printInfo();

        FMIDate c = new FMIDate(2016, 9, 26);
        FMIDate d = new FMIDate(2017, 1, 1);

        System.out.println(c.getDaysDifference(d));
        c.printInfo();
        d.printInfo();
    }

}
