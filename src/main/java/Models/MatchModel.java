package Models;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MatchModel {
    private LocalDateTime dateTime;
    private String teamA;
    private String teamB;
    private int scoreA;
    private int scoreB;
    private String url;

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public String getTeamA() { return teamA; }
    public void setTeamA(String teamA) { this.teamA = teamA; }

    public String getTeamB() { return teamB; }
    public void setTeamB(String teamB) { this.teamB = teamB; }

    public int getScoreA() { return scoreA; }
    public void setScoreA(int scoreA) { this.scoreA = scoreA; }

    public int getScoreB() { return scoreB; }
    public void setScoreB(int scoreB) { this.scoreB = scoreB; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public MatchModel(LocalDateTime dateTime, String teamA, String teamB, int scoreA, int scoreB, String url) {
        this.dateTime = dateTime;
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.url = url;
    }

    public MatchModel(String teamA, String teamB, int scoreA, int scoreB) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
    }

    // maybe this stuff should be moved to a new class?
    public MatchModel(Element match) {
        String[] matchString = new String[]{match.text(), match.baseUri()};
        String[] matchNoUri = match.text().split(" ");
    }

    public String GetDateTime(String[] match) {

        return "";
    }
    public void Output() {
        System.out.println(dateTime + ": " + teamA + " " + scoreA + " - " + scoreB + " " + teamB + "  " + url);
    }
}
