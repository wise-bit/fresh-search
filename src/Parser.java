import com.wuman.jreadability.Readability;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Parser {

    public Parser() throws IOException {

        String urlString = "https://github.com/MLH/mlh-hackathon-blockstack-starter?utm_source=Major+League+Hacking+-+2020+Season&utm_campaign=cf20aa51c8-EYNTK_2020&utm_medium=email&utm_term=0_b490f2beb8-cf20aa51c8-9681793";

        String content = null;
        URLConnection connection = null;

        try {

            connection =  new URL(urlString).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();

        } catch ( Exception ex ) {
            ex.printStackTrace();
        }

//        URL url = new URL("https://en.wikipedia.org/wiki/ASDF");
//        int timeoutMillis = 2000;
//        Readability readability = new Readability(url, timeoutMillis);  // URL
//
//        readability.init();
//        String cleanHtml = readability.outerHtml();
//
//        System.out.println(cleanHtml);

        String plainText= Jsoup.parse(content).text();

        try {
            int requiredIndex = plainText.indexOf("Retrieved from");
            plainText = plainText.substring(0, requiredIndex);
        } catch (Exception e) {

        }

        System.out.println(plainText); // this needs to be filtered

    }

}
