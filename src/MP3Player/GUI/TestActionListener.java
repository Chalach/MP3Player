package MP3Player.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TestActionListener implements ActionListener {
    private JButton button;
    private JFrame frame;
    private JLabel label = new JLabel();

    public TestActionListener(JButton button, JFrame frame){
        this.button = button;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.button){
            frame.add(label);
            label.setText("Button 1 wurde betätigt");
        }
        System.out.println("Schaltfläche wurde gedrückt");
    }
}
