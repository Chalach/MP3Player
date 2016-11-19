package GUI.MP3Player;
import jaco.mp3.player.MP3Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MP3PlayerGUI {
    private JPanel panel;
    private JProgressBar progressBar1;
    private JButton openButton;
    private JLabel songName;
    private JButton playButton;
    private JButton pauseButton;
    private JButton skipBackwardButton1;
    private JButton skipForwardButton;
    private JButton stopButton;
    private static File path;
    private static ArrayList<String> myPlayList;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MP3Player");
        frame.setContentPane(new MP3PlayerGUI().panel);
        frame.setIconImage(new ImageIcon("C:\\Users\\Chalach\\Desktop\\MP3Player\\ImageIcon\\icon.jpg").getImage()); // -> Frame Icon
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(500,500);
        frame.setVisible(true);
    }

    public MP3PlayerGUI() {
        MP3Player player = new MP3Player();
        player.setRepeat(true);
        player.setShuffle(true);

        panel.setBackground(Color.darkGray);
        progressBar1.setBackground(Color.white);
        playButton.setBackground(Color.white);
        pauseButton.setBackground(Color.white);
        stopButton.setBackground(Color.white);
        skipBackwardButton1.setBackground(Color.white);
        skipForwardButton.setBackground(Color.white);
        songName.setBackground(Color.blue);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new java.io.File(".")); // -> Setzt den Pfad auf den zu letzt geöffneten
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // -> Erlaubt es Dateien und Ordner zu lesen

                // Filter, welche Dateien angezeigt werden soll
                FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3-Datein", "mp3");

                // Filter hizufügen
                fileChooser.addChoosableFileFilter(filter);
                fileChooser.setAcceptAllFileFilterUsed(true); // -> Reiter "Alle-Daten" wird dem Nutzer zugänglich gemacht

                int retrival = fileChooser.showOpenDialog(null); //Auswahl Dialog öffnen
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    // Setzt den Pfad
                    path =  fileChooser.getSelectedFile().getAbsoluteFile();
                    myPlayList = musicFiles();
                    // Fügt die Ausgewählten Songs zur Playlist hinzu

                    for (int i = 0; i < musicFiles().size(); i++){
                        player.addToPlayList(new File(path + "\\" + myPlayList.get(i)));
                    }
                }
                else{
                    path = null;
                }
            }
        });
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path == null){
                    JOptionPane.showMessageDialog(null, "Pfad muss gewählt werden!");
                }
                else{
                    player.play();
                }
            }
        });
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path == null){
                    JOptionPane.showMessageDialog(null, "Pfad muss gewählt werden!");
                }
                else{
                    player.pause();
                }
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path == null){
                    JOptionPane.showMessageDialog(null, "Pfad muss gewählt werden!");
                }
                else{
                    player.stop();
                }
            }
        });
        skipBackwardButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path == null){
                    JOptionPane.showMessageDialog(null, "Pfad muss gewählt werden!");
                }
                else{
                    player.skipBackward();
                    songName.setText(myPlayList.get(0));
                }
            }
        });
        skipForwardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(path == null){
                    JOptionPane.showMessageDialog(null, "Pfad muss gewählt werden!");
                }
                else{
                    player.skipBackward();
                    songName.setText(myPlayList.get(20));
                }
            }
        });
    }

    private ArrayList<String> musicFiles(){
        File readFolder = new File(path + "\\");
        String[] DIR = readFolder.list();

        ArrayList<String> songList = new ArrayList<>();

        for (int i = 0; i < DIR.length; i++){ // -> Fügt die Ausgewählten Songs zur Playlist hinzu
            // Es werden nur Dateien mit der Dateiendung .mp3 hinzugefügt + die Datei "desktop.ini" wird ignoriert
            if(!DIR[i].equals("desktop.ini") && DIR[i].endsWith(".mp3")){
                songList.add(DIR[i]);
            }
        }
        return songList;
    }
}
