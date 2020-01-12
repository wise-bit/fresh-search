import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import javax.swing.border.Border;


public class Frameset extends JFrame implements ActionListener {

    public JTextField search_in;
    public ImageIcon search_b;
    public JButton sb_holder;
    public JTextField output;
    public static final Color VLB = new Color(51,204,255);

    public Frameset() {


        this.setSize(400, 800);
        this.setLocation(200, 200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        getContentPane().setBackground(VLB);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);


        search_in = new JTextField();
        search_in.setBounds(95, 30, 200, 25);
        search_in.setVisible(true);
        search_in.setText("INPUT");
        search_in.setBorder(border);
        add(search_in);


        output = new JTextField();
        output.setEditable(false);
        output.setBounds(0, 100, 385, 450);
        output.setVisible(true);
        output.setBorder(border);
        add(output);

        search_b = new ImageIcon("res/search_b.png");
        sb_holder = new JButton(search_b);
        sb_holder.setBounds(180, 60, 30, 30);
        sb_holder.setVisible(true);
        sb_holder.addActionListener(this);
        add(sb_holder);


        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == sb_holder) {

            String text = search_in.getText().toLowerCase();
            System.out.println(text);
            int valid = 0;
            for (int x = 0; x < text.length(); x++) {

                String s = Character.toString(text.charAt(x));
                if (s != " ") {
                    valid++;
                }

            }
            System.out.println(valid);
            if (valid >= 30) {

                search_in.setText(" ");
                output.setText(" --- Input MUST be less than 30 characters --- ");

            } else {

                System.out.println("Continuing program");

                String input = Main.methods.filter(text);
                output.setText(input);

            }

            // revalidate();
            // repaint();

        }
    }
}
