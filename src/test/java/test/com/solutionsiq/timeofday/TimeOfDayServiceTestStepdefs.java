package test.com.solutionsiq.timeofday;

import com.solutionsiq.timeofday.ClockImplementation;
import com.solutionsiq.timeofday.TimeOfDayService;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TimeOfDayServiceTestStepdefs {

    private int hour = -1;
    private int minute = -1;
    private int second = -1;

    @When("^the hour is \"([^\"]*)\"$")
    public void the_hour_is(String hour) throws Throwable {
        this.hour = Integer.parseInt(hour);
    }

    @When("^the minute is \"([^\"]*)\"$")
    public void the_minute_is(String minute) throws Throwable {
        this.minute = Integer.parseInt(minute);
    }

    @When("^the second is \"([^\"]*)\"$")
    public void the_second_is(String second) throws Throwable {
        this.second = Integer.parseInt(second);
    }

    @When("^I should see spoken formatting of \"([^\"]*)\"$")
    public void i_should_see_spoken_formatting_of(String formattedString) throws Throwable {
        TimeOfDayService timeOfDayService = new TimeOfDayService();

        // Here's the rub.  When we call getFormattedTimeOfDaySpokenWords with a
        // ClockImplementation that uses the *REAL* time of day, we can't check that
        // logic in TimeOfDayService works.  Because we don't know when the test runs.

        // So, to make our code testable, we made sure that TimeOfDayService didn't
        // rely on a dependency to java.time.LocalDateTime.  Instead, we do a Dependency
        // Injection of the dependency into TimeOfDayService for the Clock.

        // Now, we *COULD* implement a fake ClockFake that implements the Clock,
        // with perhaps a constructor that takes in the hour, minute, and second,
        // which then returns them with their appropriate getters.  Or, we can use
        // Mockito, which does this, and much more, automagically.

        // This is what we call in production that won't work here.
        // ClockImplementation clockImplementation = new ClockImplementation();

        // Arrange
        ClockImplementation clockImplementation = mock(ClockImplementation.class);
        // Act
        when(clockImplementation.getHour()).thenReturn(hour);
        when(clockImplementation.getMinute()).thenReturn(minute);
        when(clockImplementation.getSecond()).thenReturn(second);
        // Assert
        assertThat(timeOfDayService.getFormattedTimeOfDaySpokenWords(clockImplementation),is(formattedString));
    }

}
