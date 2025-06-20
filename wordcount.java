package wordcounter;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class wordcount extends JFrame implements ActionListener {
    JLabel lb1, lb2;
    JTextArea ta;
    JButton b;
    JButton pad, text;

    public wordcount() throws HeadlessException {
        super("Character And Word Counter");
        lb1 = new JLabel("Character");
        lb1.setBounds(50, 50, 100, 20);

        lb2 = new JLabel("Words:");
        lb2.setBounds(50, 80, 100, 20);

        ta = new JTextArea();
        ta.setBounds(50, 110, 300, 200);

        b = new JButton("click");
        b.setBounds(50, 320, 80, 30);
        b.addActionListener(this);

        pad = new JButton("Pad Color");
        pad.setBounds(140, 320, 100, 30);
        pad.addActionListener(this);

        text = new JButton("Text Color");
        text.setBounds(260, 320, 110, 30);
        text.addActionListener(this);

        add(lb1);
        add(lb2);
        add(ta);
        add(b);
        add(pad);
        add(text);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(320, 190);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            String text = ta.getText();
            // Remove whitespaces from the text
            String trimmedText = text.replaceAll("\\s", "");
            lb1.setText("Character:" + trimmedText.length());

            String words[] = text.split("\\s+");
            lb2.setText("Words:" + words.length);

            // Append "Created by sarthak" to the end of the text
            ta.append("\n \n \n \n \t Created by jaiswal-sarthak.");
        } else if (e.getSource() == pad) {
            Color c = JColorChooser.showDialog(this, "Choose Color", Color.black);
            ta.setBackground(c);
        } else if (e.getSource() == text) {
            Color c = JColorChooser.showDialog(this, "Choose color", Color.black);
            ta.setForeground(c);
        }
    }

    public static void main(String[] args) {
        new wordcount();
    }
}
