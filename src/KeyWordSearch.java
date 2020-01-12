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

        // map is already loaded as static from Main

        String newstr = "";

        for (String s: str.split(" ")) {
            newstr += s + " ";
        }

        return newstr.substring(0, newstr.length()-1);

    }

    public void loadDictionary() throws FileNotFoundException {

        Scanner sc = new Scanner(new File("Models/Sample1.txt"));
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] valueSets = s.split(":");
            Main.persistentMap.put(valueSets[0], Double.parseDouble(valueSets[1]));
        }

    }

}
