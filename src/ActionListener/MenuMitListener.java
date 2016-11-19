package ActionListener;

import java.awt.BorderLayout;
import javax.swing.*;

public class MenuMitListener extends JFrame {
    // Menüleiste
    JMenuBar menuBar;

    // Menü "Datei"
    JMenu fileMenu;

    // Menüpunkt "Öffnen"
    JMenuItem openItem;

    // Menüpunkt "Schließen"
    JMenuItem closeItem;

    public MenuMitListener() {
        this.setTitle("JMenu mit ActionListener");
        this.setSize(400, 300);

        // Menüleiste wird erzeugt
        menuBar = new JMenuBar();

        // Menü "Datei" wird erzeugt
        fileMenu = new JMenu("Datei");

        // Menüpunkte werden erzeugt
        openItem = new JMenuItem("Öffnen");
        closeItem = new JMenuItem("Schließen");

        // Menüpunkte werden dem Datei-Menü hinzugefügt
        fileMenu.add(openItem);
        fileMenu.add(closeItem);

        //Datei-Menü wird der Menüleiste hinzugefügt
        menuBar.add(fileMenu);

        //Menüleiste wird dem JFrame hinzugefügt
        this.add(menuBar, BorderLayout.NORTH);

        // ActionListener wird als anonyme Klasse eingebunden
        openItem.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // Dateiauswahldialog wird erzeugt...
                JFileChooser fc = new JFileChooser();
                // ... und angezeigt
                fc.showOpenDialog(null);
            }
        });

        // ActionListener wird als anonyme Klasse eingebunden
        closeItem.addActionListener(new java.awt.event.ActionListener() {
            // Beim Drücken des Menüpunktes wird actionPerformed aufgerufen
            public void actionPerformed(java.awt.event.ActionEvent e) {
                //Programm schließen
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        MenuMitListener nml = new MenuMitListener();
        nml.setVisible(true);
    }
}
