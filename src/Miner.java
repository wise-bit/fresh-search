import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Miner {

    String filename = "Sample1";
    Map<String, Double> map = new HashMap<String, Double>();

    int totalWords = 0;

    public Miner(String path) throws IOException {

        generateTable(path);

    }

    public void generateTable(String path) throws IOException {

        File dir = new File(path);
        File[] directoryListing = dir.listFiles();

        if (directoryListing != null) {
            for (File f : directoryListing) {
                Scanner sc = new Scanner(f);

                while (sc.hasNextLine()) {
                    String s = sc.nextLine();
                    String[] arr = s.split(" ");

                    for (String str : arr) {
                        str = str.toLowerCase();
                        str = str.replaceAll("[^A-Za-z]", "");
                        if (str.length() > 1) {

                            totalWords++; // Only consider as words if this is applicable
                            double count = map.getOrDefault(str, 0.0);
                            map.put(str, count + 1.0);

                        }
                    }

                }

            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("Models/" + filename + ".txt"));

        for (String keys : map.keySet()) {
            // System.out.println(keys + ":"+ map.get(keys));
            writer.write(keys + ":"+ Main.df.format(map.get(keys) / totalWords));
            writer.write("\n");
        }

        writer.close();

    }

}
