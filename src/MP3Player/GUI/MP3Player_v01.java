package MP3Player.GUI;

import jaco.mp3.player.MP3Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class MP3Player_v01 extends Component {
    private static File path = getPath();

    private static File getPath(){
        JFileChooser fileChooser = new JFileChooser();

        // Setzt den Pfad auf den zu letzt geöffneten
        fileChooser.setCurrentDirectory(new java.io.File("."));

        // Erlaubt es Dateien und Ordner zu lesen
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        // Reiter "Alle-Daten" wird dem Nutzer zugänglich gemacht
        fileChooser.setAcceptAllFileFilterUsed(true);

        // Filter, welche Dateien angezeigt werden soll
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3-Datein", "mp3");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("WAV-Datein", "wav");

        // Filter hizufügen
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.addChoosableFileFilter(filter2);

        // Öffnet das Dialog Fenster
        fileChooser.showOpenDialog(null);
        /*
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " +  fileChooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " +  fileChooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }*/

        return fileChooser.getSelectedFile().getAbsoluteFile();
    }

    private static ArrayList<String> musicFiles(){
        ArrayList<String> songList = new ArrayList<>();
        File test = new File(path + "\\");
        String[] DIR = test.list();

        for (int i = 0; i < DIR.length; i++){
            if(!DIR[i].equals("desktop.ini")){
                songList.add(DIR[i]);
            }
        }
        return songList;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<String> myPlayList = musicFiles();

        // Playlist ausgeben
        for (int i = 0; i < myPlayList.size(); i++) {
            System.out.println(myPlayList.get(i));
        }

        // Neuen MP3PlayerGUI erstellen
        MP3Player player = new MP3Player();
        // Enable Loop
        player.setRepeat(true);
        // Wenn eine .mp3-Datei zu ende gespielt wurde, wird random ein Song aus der PlayList gespielt
        player.setShuffle(true);

        // Playlist Strings hinzufügen
        for (int i = 0; i < musicFiles().size(); i++) {
            player.addToPlayList(new File("Music\\" + myPlayList.get(i)));
        }

        // GUI vom Player
        player.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));


        // Fenster
        JFrame frame = new JFrame("MP3 Player");

        // Frame Icon
        frame.setIconImage(new ImageIcon("C:\\Users\\Chalach\\Desktop\\MP3Player\\ImageIcon\\icon.jpg").getImage());

        // Button
        JButton button = new JButton("Show song");
        button.addActionListener(new TestActionListener());
        frame.add(button);

        // Eigentliches Fenster
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // -> legt fest, was passiert, wenn man den Dialog/Programm schließt
        frame.getContentPane().add(player); // -> fügt den Player hinzu
        frame.setLayout(new FlowLayout()); // -> notwendig für einen Button
        frame.pack();
        frame.setLocationRelativeTo(null); // -> legt fest, wo das Fenster auftauchen soll: hier ist es in der Mitte
        frame.setVisible(true);
    }
}
