import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/*

TODO: (follows)
Need to use dictionary to only keep nouns, remove verbs and stuff

 */

public class Main {

    public static Map<String, Double> persistentMap = new HashMap<String, Double>();
    public static KeyWordSearch methods;

    public static DecimalFormat df = new DecimalFormat("#");
    public static Trainer t;

    public static double accuracy;

    public static String currentQuery = "";

    public static int level = 0;
    public static ArrayList<String> allKeyWords = new ArrayList<>();

    public static Frameset f;

    public static void main(String[] args) throws IOException {

        df.setMaximumFractionDigits(8);

        run();
        // retrainData();

    }

    public static void run() throws IOException {

        updateAccuracy();

        methods = new KeyWordSearch();
        methods.loadDictionary();

        t = new Trainer();

        f = new Frameset();

        // new Spider();

        // new Parser("https://github.com/MLH/mlh-hackathon-blockstack-starter?utm_source=Major+League+Hacking+-+2020+Season&utm_campaign=cf20aa51c8-EYNTK_2020&utm_medium=email&utm_term=0_b490f2beb8-cf20aa51c8-9681793");

        // Feedback. TODO: to be combined with GUI
        // t.rewardCalculate(true);

        // System.out.println(methods.filter(""));

    }

    public static void retrainData() throws IOException {

        // Miner m = new Miner("temp");
        Miner m = new Miner("training-files");

    }

    public static void updateAccuracy() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("res/score"));
        double ratio = Double.parseDouble(sc.nextLine());
        Main.accuracy = ratio;
        sc.close();
    }

    public static void removeTheFirstNameDuplicates(final Map<String, String> map) {
        final Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        final HashSet<String> valueSet = new HashSet<String>();
        while (iter.hasNext()) {
            final Map.Entry<String, String> next = iter.next();
            if (!valueSet.add(next.getValue())) {
                iter.remove();
            }
        }
    }

    public static void reset() {
        Main.allKeyWords = new ArrayList<>();
        Main.level = 0;
        Main.currentQuery = "";
        f.dispose();
        f = new Frameset();
    }

}
