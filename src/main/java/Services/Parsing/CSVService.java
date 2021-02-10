package Services.Parsing;

import Util.Constants;
import com.opencsv.CSVWriter;

//import javax.lang.model.util.Elements;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CSVService {
    public void convertToCSV(Elements elements){
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(Constants.PATH_TO_CSV);

        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            Stream<Element> soWhat = elements.stream();
            List<String[]> data = soWhat
                    .map(p -> new String[]{p.text(), p.baseUri()})
                    .collect(Collectors.toList());

            writer.writeAll(data);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
