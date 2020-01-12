import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;
import java.util.HashSet;
import java.util.Set;
import javax.swing.border.Border;


public class Frameset extends JFrame implements ActionListener {

    public JTextField search_in;
    public ImageIcon search_b;
    public JButton sb_holder;
    public JTextArea output;
    public JScrollPane outputArea;
    public static final Color VLB = new Color(183, 229,255);

    public JButton reset;

    JPanel opinionPanel;
    JButton YES;
    JButton NO;

    public Frameset() {

        this.setTitle("Fresh Search");
        this.setSize(400, 800);
        this.setLocation(400, 50);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        getContentPane().setBackground(VLB);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);

        search_in = new JTextField();
        search_in.setBounds(95, 30, 200, 25);
        search_in.setVisible(true);
        search_in.setBackground(Color.BLACK);
        search_in.setForeground(Color.WHITE);
        search_in.setHorizontalAlignment(SwingConstants.CENTER);
        search_in.setText("INPUT");
        search_in.setBorder(border);
        add(search_in);

        output = new JTextArea();
        output.setEditable(false);
        output.setBounds(0, 100, 385, 450);
        output.setVisible(true);
        output.setBorder(border);
        output.setLineWrap(true);

//        outputArea = new JScrollPane(outputArea);
//        outputArea.setBounds(0, 100, 385, 450);

        this.add(output);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        // search_b = new ImageIcon("res/search_b.png");
//        sb_holder = new JButton("SEARCH");
//        sb_holder.setBounds(180, 50, 100, 50);
//        sb_holder.setVisible(true);
//        sb_holder.addActionListener(this);

        sb_holder = new JButton("SEARCH");
        sb_holder.setBackground(new Color(59, 89, 182));
        sb_holder.setForeground(Color.WHITE);
        sb_holder.setBounds(142, 60, 100, 35);
        sb_holder.setFocusPainted(false);
        sb_holder.setFont(new Font("Tahoma", Font.BOLD, 12));
        sb_holder.setVisible(true);
        sb_holder.addActionListener(this);

        buttonPanel.add(sb_holder);
        buttonPanel.setBackground(VLB);
        buttonPanel.setVisible(true);
        buttonPanel.setBounds(100, 50, 100, 30);

        JLabel question = new JLabel("Was the data too much?");
        Font newLabelFont=new Font(question.getFont().getName(), Font.BOLD, question.getFont().getSize() + 10);
        question.setBounds(75, 700, 400, 20);
        question.setFont(newLabelFont);
        this.add(question);

        opinionPanel = new JPanel();
        opinionPanel.setLayout(new GridLayout(1, 2));
        YES = new JButton("NO");
        NO = new JButton("YES");

        YES.setBackground(new Color(82, 182, 56));
        YES.setForeground(Color.WHITE);
        YES.setBounds(142, 60, 100, 55);
        YES.setFocusPainted(false);
        YES.setFont(new Font("Tahoma", Font.BOLD, 12));
        YES.setVisible(true);
        YES.addActionListener(this);

        NO.setBackground(new Color(82, 182, 56));
        NO.setForeground(Color.WHITE);
        NO.setBounds(142, 60, 100, 55);
        NO.setFocusPainted(false);
        NO.setFont(new Font("Tahoma", Font.BOLD, 12));
        NO.setVisible(true);
        NO.addActionListener(this);

        YES.setBounds(100, 600, 100, 100);
        NO.setBounds(100, 600, 100, 100);

        opinionPanel.add(YES);
        opinionPanel.add(NO);
        opinionPanel.setBounds(100, 600, 100, 100);

        reset = new JButton("Reset");
        reset.setBackground(new Color(255, 220, 76));
        reset.setForeground(Color.BLACK);
        reset.setBounds(140, 600, 100, 35);
        reset.setFocusPainted(false);
        reset.setFont(new Font("Tahoma", Font.BOLD, 12));
        reset.setVisible(true);
        reset.addActionListener(this);
        JPanel resetPanel = new JPanel();
        resetPanel.setBounds(140, 600, 100, 35);
        resetPanel.setBackground(new Color(4, 0, 2, 254));
        resetPanel.add(reset);
        this.add(resetPanel);
        resetPanel.setVisible(true);

        this.add(buttonPanel);

        this.add(opinionPanel, BorderLayout.PAGE_END);

        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        try {
            Main.updateAccuracy();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

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

                if (Main.allKeyWords.size() == 0 && Main.level != 0) {
                    output.setText("No similarities found...");
                } else {
                    System.out.println("Continuing program");

                    String input = text;
                    // output.setText(input);
                    Main.currentQuery = input;
                    if (!input.equals("Please enter some key words")) {
                        try {
                            Spider s = new Spider();

                            // Remove duplicates
                            Set<String> set = new HashSet<>(Main.allKeyWords);
                            Main.allKeyWords.clear();
                            Main.allKeyWords.addAll(set);

                            String outputText = "";
                            for (String x : Main.allKeyWords) {
                                outputText += x + " ";
                            }
                            output.setText(outputText);
                        } catch (IOException | InterruptedException e) {
                            // e.printStackTrace();
                            System.out.println("Frameset fucked up");
                        }
                    } else {
                        output.setText("Please enter some key words");
                    }
                    // output.setText();
                }

            }

            // revalidate();
            // repaint();

        }

        if (event.getSource() == YES) {
            try {
                Main.t.rewardCalculate(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (event.getSource() == NO) {
            try {
                Main.t.rewardCalculate(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (event.getSource() == reset) {
            Main.reset();
        }

    }
}
