package Services.Parsing;

import Models.MatchModel;
import Util.Time;
import org.junit.Test;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.*;

public class SplitMatchTest {

    @Test
    public void getMonthFail() {
        SplitMatch splitMatch = new SplitMatch();
        assertNull(splitMatch.GetMonth(""));
        assertNull(splitMatch.GetMonth("November"));
    }

    @Test
    public void getMonthPass() {
        SplitMatch splitMatch = new SplitMatch();
        assertEquals(Month.JANUARY, splitMatch.GetMonth("Jan"));
        assertEquals(Month.FEBRUARY, splitMatch.GetMonth("Feb"));
        assertEquals(Month.MARCH, splitMatch.GetMonth("Mar"));
        assertEquals(Month.APRIL, splitMatch.GetMonth("Apr"));
        assertEquals(Month.MAY, splitMatch.GetMonth("May"));
        assertEquals(Month.JUNE, splitMatch.GetMonth("Jun"));
        assertEquals(Month.JULY, splitMatch.GetMonth("Jul"));
        assertEquals(Month.AUGUST, splitMatch.GetMonth("Aug"));
        assertEquals(Month.SEPTEMBER, splitMatch.GetMonth("Sep"));
        assertEquals(Month.OCTOBER, splitMatch.GetMonth("Oct"));
        assertEquals(Month.NOVEMBER, splitMatch.GetMonth("Nov"));
        assertEquals(Month.DECEMBER, splitMatch.GetMonth("Dec"));
    }

    @Test
    public void getTimePass() {
        SplitMatch splitMatch = new SplitMatch();
        assertThat(splitMatch.GetTime("7:30p")).isEqualToComparingFieldByField(new Time(19, 30, 0));
        assertThat(splitMatch.GetTime("12:00p")).isEqualToComparingFieldByField(new Time(12, 0, 0));
        assertThat(splitMatch.GetTime("12:30p")).isEqualToComparingFieldByField(new Time(12, 30, 0));
        assertThat(splitMatch.GetTime("12:00a")).isEqualToComparingFieldByField(new Time(0, 0, 0));
        assertThat(splitMatch.GetTime("12:30a")).isEqualToComparingFieldByField(new Time(0, 30, 0));
        assertThat(splitMatch.GetTime("7:15a")).isEqualToComparingFieldByField(new Time(7, 15, 0));
    }

    @Test
    public void getTeamsAndScores() {
        SplitMatch splitMatch = new SplitMatch();
        String match1 = "Fri, Nov 1, 2019 7:00p Houston Rockets 116 Brooklyn Nets 123 Box Score 17,732,";
        String match2 = "Fri, Nov 1, 2019 7:00p New York Knicks 99 Brooklyn Nets 100 Box Score 17,732,";
        String match3 = "Fri, Nov 1, 2019 7:00p Houston Rockets 99 New Orleans Pelicans 100 Box Score 17,732,";
        String match4 = "Fri, Nov 1, 2019 7:00p New York Knicks 99 New Orleans Pelicans 100 Box Score 17,732,";
        assertThat(splitMatch.GetTeamsAndScores(new ArrayList<>(Arrays.asList(match1.split(" ")))))
                .isEqualToComparingFieldByField(new MatchModel("Houston Rockets", "Brooklyn Nets", 116, 123));
        assertThat(splitMatch.GetTeamsAndScores(new ArrayList<>(Arrays.asList(match2.split(" ")))))
                .isEqualToComparingFieldByField(new MatchModel("New York Knicks", "Brooklyn Nets", 99, 100));
        assertThat(splitMatch.GetTeamsAndScores(new ArrayList<>(Arrays.asList(match3.split(" ")))))
                .isEqualToComparingFieldByField(new MatchModel("Houston Rockets", "New Orleans Pelicans", 99, 100));
        assertThat(splitMatch.GetTeamsAndScores(new ArrayList<>(Arrays.asList(match4.split(" ")))))
                .isEqualToComparingFieldByField(new MatchModel("New York Knicks", "New Orleans Pelicans", 99, 100));
    }
}