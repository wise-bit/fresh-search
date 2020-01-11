import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/*

TODO: (follows)
Need to use dictionary to only keep nouns, remove verbs and stuff

 */

public class Main {

    public static Map<String, Double> persistentMap = new HashMap<String, Double>();
    public static KeyWordSearch methods;

    public static DecimalFormat df = new DecimalFormat("#");

    public static void main(String[] args) throws IOException {

        df.setMaximumFractionDigits(8);
        // run();
        retrainData();

    }

    public static void run() throws FileNotFoundException {
        methods = new KeyWordSearch();
        methods.loadDictionary();
    }

    public static void retrainData() throws IOException {
        // Miner m = new Miner("temp");
        Miner m = new Miner("training-files");
    }

}
