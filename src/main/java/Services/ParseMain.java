package Services;

import Util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ParseMain {
    public void ParseThisShit()  throws IOException {
        Document doc = Jsoup.connect(Constants.URL)
                .get();

        Elements listNews = doc.select("title");

        for (Element element : listNews)
            System.out.println(element.text());
    }
}
