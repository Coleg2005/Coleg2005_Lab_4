import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnigmaFrame extends JFrame {

    private JComboBox<String> rone; 
    private JComboBox<String> rtwo;
    private JComboBox<String> rthree;

    private JTextField initPos;

    private JButton encrypt;
    private JButton decrypt;

    private JTextArea input;
    private JTextArea output;


    public EnigmaFrame() {
        JFrame f = new JFrame();

        String rotors[] = {"1", "2", "3", "4", "5"};
    
        rone = new JComboBox<String>(rotors);
        rtwo = new JComboBox<String>(rotors);
        rthree = new JComboBox<String>(rotors);
        initPos = new JTextField(3);
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");

        input = new JTextArea(4, 20);
        output = new JTextArea(4, 20);

    
        JPanel topPanel = new JPanel(new FlowLayout()); 
        topPanel.add(new JLabel("Inner: "));
        topPanel.add(rone);
        topPanel.add(new JLabel("Middle: "));
        topPanel.add(rtwo);
        topPanel.add(new JLabel("Outer: "));
        topPanel.add(rthree);
        topPanel.add(new JLabel("Initial Positions: "));
        topPanel.add(initPos);
        topPanel.add(encrypt);
        topPanel.add(decrypt);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.add(new JLabel("Input"));
        centerPanel.add(input);

        JPanel botPanel = new JPanel(new FlowLayout());
        botPanel.add(new JLabel("Output"));
        botPanel.add(output);

        f.add(topPanel, BorderLayout.NORTH);
        f.add(centerPanel, BorderLayout.CENTER);
        f.add(botPanel, BorderLayout.SOUTH);
        f.setTitle("Enigma GUI");
        f.pack();
        f.setVisible(true);

    }

}
