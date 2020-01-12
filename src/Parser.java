import com.wuman.jreadability.Readability;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    public String keywords;

    public Parser(String urlString) throws IOException {

        String content = null;
        URLConnection connection = null;

        try {

            connection =  new URL(urlString).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();

        } catch ( Exception ex ) {
            // ex.printStackTrace();
        }

//        URL url = new URL("https://en.wikipedia.org/wiki/ASDF");
//        int timeoutMillis = 2000;
//        Readability readability = new Readability(url, timeoutMillis);  // URL
//
//        readability.init();
//        String cleanHtml = readability.outerHtml();
//
//        System.out.println(cleanHtml);
        String plainText = "";

        try {

            plainText = Jsoup.parse(content).text();
            int requiredIndex = plainText.indexOf("Retrieved from");
            plainText = plainText.substring(0, requiredIndex);

        } catch (Exception e) {

        }

        // System.out.println(plainText); // this needs to be filtered
        keywords = filter(plainText);

    }

    public String filter(String str) {
        String newS = "";
        for (String s : str.split(" ")) {
            if (Main.persistentMap.get(s) != null && Main.persistentMap.get(s) < 0.00001) {
                newS += s + " ";
            }
        }
        return newS;
    }

}
