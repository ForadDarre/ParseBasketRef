package Services.Parsing;

import Models.MatchModel;
import Util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseMain {
    public Elements getMatches(String url) throws IOException {
        Document doc = Jsoup.connect(url)
                .get();

        Elements listMatches = doc.select("table#" +
                Constants.TABLE_SCHEDULE_ID +
                "> tbody > tr:not(." +
                Constants.TABLE_SCHEDULE_HEADER_CLASS + ")");

        return listMatches;
    }
}
