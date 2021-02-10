import Models.MatchModel;
import Services.Parsing.CSVService;
import Services.Parsing.ParseMain;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import Services.Parsing.SplitMatch;
import Util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainClass {
    public static void main(String[] args) throws IOException {
        BuildDatabase();
    }

    public static void BuildDatabase() throws IOException {
        ParseMain parseMain = new ParseMain();
        Elements matches = parseMain.getMatches(Constants.URL);

        SplitMatch splitMatch = new SplitMatch();
        for (Element match:
                matches) {
            ArrayList<String> matchString = new ArrayList<>(Arrays.asList(match.text().split(" ")));
            matchString.add(matches.first().baseUri());

            LocalDateTime dateTime = splitMatch.GetDateTime(matchString);
            MatchModel matchModelBuf = splitMatch.GetTeamsAndScores(matchString);
            MatchModel matchModel = new MatchModel(dateTime,
                    matchModelBuf.getTeamA(), matchModelBuf.getTeamB(), matchModelBuf.getScoreA(), matchModelBuf.getScoreB(),
                    matchString.get(matchString.size() - 1));

            matchModel.Output();
        }

        //CSVService csvService = new CSVService();
        //csvService.convertToCSV(matches);
    }
}