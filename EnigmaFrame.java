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

    String rotors[] = {"1", "2", "3", "4", "5"};


    public EnigmaFrame() {
    
        rone = new JComboBox<String>(rotors);
        rtwo = new JComboBox<String>(rotors);
        rthree = new JComboBox<String>(rotors);
        initPos = new JTextField(3);
        encrypt = new JButton("Encrypt");
        decrypt = new JButton("Decrypt");

        input = new JTextArea(4, 100);
        output = new JTextArea(4, 100);

    
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
        output.setEditable(false);

        JPanel io = new JPanel(new BorderLayout());
        io.add(centerPanel, BorderLayout.NORTH);
        io.add(botPanel, BorderLayout.CENTER);

        encrypt.addActionListener((e) -> {crypt("encrypt");});
        decrypt.addActionListener((e) -> {crypt("decrypt");});

        this.add(topPanel, BorderLayout.NORTH);
        this.add(io, BorderLayout.CENTER);
        this.add(new JLabel("ONLY INPUT # AND LETTERS. USE ONLY LETTERS AND # AS INITIAL POSTIONS"), BorderLayout.SOUTH);
        this.setTitle("Enigma GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }

    private void crypt(String type) {
        
        int r1 = rone.getSelectedIndex();
        int r2 = rtwo.getSelectedIndex();
        int r3 = rthree.getSelectedIndex();
        String rotor1 = rotors[r1];
        String rotor2 = rotors[r2];
        String rotor3 = rotors[r3];
        String pos = initPos.getText().toUpperCase();
        if (pos.length() != 3) {
            output.setText("Initial positions must be 3 characters");
            return;
        }
        String in = input.getText().toUpperCase();

        String args[] = {rotor1, rotor2, rotor3, pos, type};
        try {
            String ans = Comms.processEnigma(args, in);
            output.setText(ans);
        } catch (Exception e) {
            output.setText("An Error Has Occured");
        }
    }

}
