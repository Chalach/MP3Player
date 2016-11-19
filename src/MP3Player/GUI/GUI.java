package MP3Player.GUI;

import jaco.mp3.player.MP3Player;
import javax.swing.*;
import java.awt.*;


public class GUI extends JFrame{
    private JMenuBar menuBar; // -> Menüleiste
    private JMenu fileMenu; // Menü "Datei"
    private JMenuItem openItem; // Menüpunkt "Öffnen"
    private JMenuItem closeItem; // Menüpunkt "Schließen"


    public GUI(MP3Player player){

        new JFrame();
        this.setIconImage(new ImageIcon("C:\\Users\\Chalach\\Desktop\\MP3Player\\ImageIcon\\icon.jpg").getImage()); // -> Frame Icon
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // -> legt fest, was passiert, wenn man den Dialog/Programm schließt
        this.getContentPane().add(player); // -> fügt den Player hinzu
        this.setLayout(new FlowLayout()); // -> notwendig für einen Button
        this.pack();
        this.setLocationRelativeTo(null); // -> legt fest, wo das GUI auftauchen soll: hier ist es in der Mitte
        this.setVisible(true); // -> macht das GUI sichtbar
        this.setTitle("MP3 Player");
        this.setSize(400,300);

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
}
