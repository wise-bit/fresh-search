import com.wuman.jreadability.Readability;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Parser {

    public Parser() throws IOException {

        String content = null;
        URLConnection connection = null;
        try {
            connection =  new URL("https://en.wikipedia.org/wiki/ASDF").openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
        }catch ( Exception ex ) {
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
        System.out.println(plainText);

    }

}
