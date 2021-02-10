package Services.Parsing;

import Models.MatchModel;
import Util.StringIntConversations;
import Util.Time;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class SplitMatch {
    public LocalDateTime GetDateTime(ArrayList<String> matchString) {
        String monthString = matchString.get(1);
        int day = Integer
                .parseInt(matchString.get(2)
                        .replaceAll(",", ""));
        int year = Integer.parseInt(matchString.get(3));
        String timeString = matchString.get(4);

        Time time = GetTime(timeString);

        return LocalDateTime.of(year, GetMonth(monthString), day, time.getHour(), time.getMinutes(), 0);
    }

    public Month GetMonth(String monthString) {
        return switch (monthString) {
            case ("Jan") -> Month.JANUARY;
            case ("Feb") -> Month.FEBRUARY;
            case ("Mar") -> Month.MARCH;
            case ("Apr") -> Month.APRIL;
            case ("May") -> Month.MAY;
            case ("Jun") -> Month.JUNE;
            case ("Jul") -> Month.JULY;
            case ("Aug") -> Month.AUGUST;
            case ("Sep") -> Month.SEPTEMBER;
            case ("Oct") -> Month.OCTOBER;
            case ("Nov") -> Month.NOVEMBER;
            case ("Dec") -> Month.DECEMBER;
            default -> null;
        };
    }

    public Time GetTime(String timeString) {
        String[] hoursAndMinutes = timeString.split(":");
        String pmam = hoursAndMinutes[1].substring(hoursAndMinutes[1].length() - 1);
        int hour = Integer.parseInt(hoursAndMinutes[0]);

        if (pmam.equals("p")) {
            hour += 12;
            if(hour == 24)
                hour = 12; // in US culture 12 pm = 12:00 in 24-h format
        }

        else if (hour == 12)
            hour = 0;

        int minutes = Integer.parseInt(hoursAndMinutes[1].substring(0, hoursAndMinutes[1].length() - 1));

        return new Time(hour, minutes, 0);
    }

    public MatchModel GetTeamsAndScores(ArrayList<String> matchString) {
        String teamA;
        String teamB;
        int scoreA;
        int scoreB;
        if (StringIntConversations.isInteger(matchString.get(7))) {
            teamA = matchString.get(5) + " " + matchString.get(6);
            scoreA = Integer.parseInt(matchString.get(7));
            if (StringIntConversations.isInteger(matchString.get(10))) {
                teamB = matchString.get(8) + " " + matchString.get(9);
                scoreB = Integer.parseInt(matchString.get(10));
            }
            else {
                teamB = matchString.get(8) + " " + matchString.get(9) + " " + matchString.get(10);
                scoreB = Integer.parseInt(matchString.get(11));
            }
        }

        else {
            teamA = matchString.get(5) + " " + matchString.get(6) + " " + matchString.get(7);
            scoreA = Integer.parseInt(matchString.get(8));
            if (StringIntConversations.isInteger(matchString.get(11))) {
                teamB = matchString.get(9) + " " + matchString.get(10);
                scoreB = Integer.parseInt(matchString.get(11));
            }
            else {
                teamB = matchString.get(9) + " " + matchString.get(10) + " " + matchString.get(11);
                scoreB = Integer.parseInt(matchString.get(12));
            }
        }

        return new MatchModel(teamA, teamB, scoreA, scoreB);
    }
}
