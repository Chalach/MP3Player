package JFrame;

import javax.swing.*;

public class TestJFrame extends JFrame {
    JButton testJButton = new JButton("Schaltfläche");
    public TestJFrame() {
        setTitle("Ein reines, unbeflecktes Frame");  // Fenstertitel setzen
        testJButton.addActionListener(new TestActionListener()); // EventListener für Schaltfläche hinzufügen
        add(testJButton);                                        // Schaltfläche zum GUI hinzufügen
        pack();
        setSize(200,200);                            // Fenstergröße einstellen
        // (notwendig, damit das GUI geschlossen werden kann)
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestJFrame();
    }
}
