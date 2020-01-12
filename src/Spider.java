import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spider {

    public Spider() throws IOException, InterruptedException {

        // Creates a process which runs a python script
        Process p = Runtime.getRuntime().exec("python3 C:\\Users\\satra\\IdeaProjects\\fresh-search\\src\\webcrawler.py \"" + Main.currentQuery + "\"");
        p.waitFor();

        // Creates Bufferedreaders objects to get input from the process
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        System.out.println(stdInput.readLine());
        // System.out.println(stdError.readLine());

        String response = stdError.readLine();
        response = response.substring(1, response.length()-1);
        response = response.replaceAll("\'", "");
        response = response.replaceAll(" ", "");
        String[] responseArray = response.split(",");

        String allNewKeyWords = "";

        for (String s : responseArray) {
            Parser par = new Parser(s);
            allNewKeyWords += par.keywords;
        }
        System.out.println(allNewKeyWords);
        if (allNewKeyWords.length() > 0) {
            if (Main.level == 0) {
                Main.methods.addToMainArray(allNewKeyWords);
            } else {
                Main.methods.modifyMainArray(allNewKeyWords);
            }
            Main.level++;
        }

    }

}
