package JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TestActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        System.out.println("Schaltfläche wurde gedrückt");
    }
}
