package com.solutionsiq.timeofday;

import java.time.LocalDateTime;

public class ClockImplementation implements Clock {
    public int getHour() {return LocalDateTime.now().getHour();};
    public int getMinute() {return LocalDateTime.now().getMinute();};
    public int getSecond() {return LocalDateTime.now().getSecond();};
}
