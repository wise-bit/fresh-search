import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Miner {

    Map<String, Integer> map = new HashMap<String, Integer>();

    public Miner(String path) throws FileNotFoundException {

        generateTable(path);

    }

    public void generateTable(String path) throws FileNotFoundException {

        File dir = new File(path);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File f : directoryListing) {
                Scanner sc = new Scanner(f);

                while (sc.hasNextLine()) {
                    String s = sc.nextLine();
                    String[] arr = s.split(" ");

                    for (String str : arr) {
                        int count = map.getOrDefault(str, 0);
                        map.put(str, count + 1);
                    }

                }

            }
        }

        for (String keys : map.keySet()) {
            System.out.println(keys + ":"+ map.get(keys));
        }

    }

}
