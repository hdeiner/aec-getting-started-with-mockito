package com.solutionsiq.timeofday;

public class TimeOfDayService {

    public String getFormattedTimeOfDaySpokenWords(Clock clock) {
        int hour = clock.getHour();
        int minute = clock.getMinute();
        int second = clock.getSecond();

        String[] hours = {"twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven"};
        String[] approximateTimeWords = {"", "almost ten after", "ten after", "a quarter after", "twenty after", "almost half past", "half past", "almost twenty before", "twenty before", "a quarter of", "ten of", "almost"};
        String[] dayQuadrant = {"at night", "in the morning", "in the afternoon", "in the evening"};

        if (second >= 30) minute++;

        String output = "";
        if (minute >= 3) {
            output += approximateTimeWords[(minute+2)/5] + " ";
        }
        if (minute < 35) {
            output += hours[hour%12];
        }  else {
            output += hours[(hour+1)%12];
        }

        output += " " + dayQuadrant[hour/6];

        return output;
    }

}