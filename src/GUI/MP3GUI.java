package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MP3GUI {
    private JTextField textField1;
    private JTextField textField2;
    private JButton ausrechnenButton;
    private JButton loeschenButton;
    private JLabel result;
    private JPanel panel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MP3GUI");
        frame.setContentPane(new MP3GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MP3GUI() {
        ausrechnenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double res = Double.parseDouble(textField1.getText()) + Double.parseDouble(textField2.getText());
                    result.setText("" + res);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Falsche Eingabe");
                }
            }
        });

        loeschenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                result.setText("0");
            }
        });
    }
}
