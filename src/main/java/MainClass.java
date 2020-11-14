import Services.ParseMain;
import Util.Constants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        ParseMain parseMain = new ParseMain();
        parseMain.ParseThisShit();
    }
}