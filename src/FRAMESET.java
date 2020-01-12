import javax.swing.JFrame;

import java.awt.GraphicsConfiguration;

public class FRAMESET {

    public static void main(String[] args) {

        FRAMESETUP();
    }

    private static void FRAMESETUP() {

        JFrame GUI = new JFrame();
        GUI.setSize(600,400);
        GUI.setVisible(true);
        GUI.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
        GUI.setResizable(false);

    }
}
