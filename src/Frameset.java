import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class Frameset extends JFrame implements ActionListener {

    public JTextField search_in;
    public JButton searchButton;


    public Frameset() {

        this.setSize(400, 800);
        this.setLocation(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);


        search_in = new JTextField();
        search_in.setBounds(0,30,200,25);
        search_in.setVisible(true);
        add(search_in);
        repaint();


    }

    @Override
    public void actionPerformed(ActionEvent event) {

        // if event.getSource() ==





    }
}
