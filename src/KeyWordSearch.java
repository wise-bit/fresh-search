import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
Author:
These will be general-purpose methods
*/

public class KeyWordSearch {

    public KeyWordSearch() {

    }

    public String filter(String str) {
        System.out.println(str);
        String newS = "";
        for (String s : str.split(" ")) {
            System.out.println(s + " : " + Main.persistentMap.get(s));
            if (Main.persistentMap.get(s) == null || Main.persistentMap.get(s) < 0.00001) {
                newS += s + " ";
            }
        }
        try {
            return newS.substring(0, newS.length() - 1);
        } catch (Exception e) {
            return "Please enter some key words";
        }
    }

    public void loadDictionary() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("Models/Sample1.txt"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] valueSets = s.split(":");
            Main.persistentMap.put(valueSets[0], Double.parseDouble(valueSets[1]));
        }

    }

    public void addToMainArray(String query) {
        for (String x : query.split(" ")) {
            Main.allKeyWords.add(x);
        }
    }

    public void modifyMainArray(String newS) {
        ArrayList<String> modifiedList = new ArrayList<String>();
        for (String s : newS.split(" ")) {
            if (Main.allKeyWords.contains(s)) {
                modifiedList.add(s);
            }
        }
        Main.allKeyWords = (ArrayList<String>) modifiedList.clone();
    }

}
