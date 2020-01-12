import java.io.*;
import java.util.Scanner;

public class Trainer {

    public Trainer() {

    }

    public void rewardCalculate(boolean good_feedback) throws IOException {
        Scanner sc = new Scanner(new File("res/score"));
        double ratio = Double.parseDouble(sc.nextLine());
        double last = Double.parseDouble(sc.nextLine());
        double jump = Double.parseDouble(sc.nextLine());
        // System.out.println(ratio + " " + last + " " + jump);

        if (good_feedback) {
            if (ratio < last) { // it was increased last time
                jump *= 2;
            } else {
                jump *= 0.5;
            }
            last = ratio;
            if (ratio >= jump) {
                ratio -= jump;
            }
        } else { // bad feedback, which means it was not a key word, which means ratio increase
            if (ratio > last) { // it was increased last time
                jump *= 2;
            } else {
                jump *= 0.5;
            }
            last = ratio;
            ratio += jump;
        }

        // Update the file with new data

        BufferedWriter writer = new BufferedWriter(new FileWriter("res/" + "score"));

        // System.out.println(keys + ":"+ map.get(keys));
        writer.write(Main.df.format(ratio));
        writer.write("\n");
        writer.write(Main.df.format(last));
        writer.write("\n");
        writer.write(Main.df.format(jump));
        writer.write("\n");
        writer.write("\n");
        writer.write("1 => ratio, 2 => last stored, 3 => jump");

        writer.close();

    }

}
