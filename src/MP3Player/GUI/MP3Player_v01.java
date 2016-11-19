package MP3Player.GUI;

/*
    MP3Player funktioniert nur mit .mp3 Dateien!
 */

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
        fileChooser.setCurrentDirectory(new java.io.File(".")); // -> Setzt den Pfad auf den zu letzt geöffneten
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // -> Erlaubt es Dateien und Ordner zu lesen

        // Filter, welche Dateien angezeigt werden soll
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3-Datein", "mp3");

        // Filter hizufügen
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(true); // -> Reiter "Alle-Daten" wird dem Nutzer zugänglich gemacht

        int retrival = fileChooser.showOpenDialog(null); //Auswahl Dialog öffnen
        if (retrival == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsoluteFile();
        }
        return null;
    }

    private static ArrayList<String> musicFiles(){
        ArrayList<String> songList = new ArrayList<>();
        if(path == null){ // -> Sollte der Pfad "null" sein so wird das Programm automatisch beendet
            System.exit(0);
        }
        File test = new File(path + "\\");
        String[] DIR = test.list();

        for (int i = 0; i < DIR.length; i++){ // -> Fügt die Ausgewählten Songs zur Playlist hinzu
            // Es werden nur Dateien mit der Dateiendung .mp3 hinzugefügt + die Datei "desktop.ini" wird ignoriert
            if(!DIR[i].equals("desktop.ini") && DIR[i].endsWith(".mp3")){
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
        player.setRepeat(true); // -> Loop aktivieren
        player.setShuffle(true); // -> Wenn eine .mp3-Datei zu ende gespielt wurde, wird random ein Song aus der PlayList gespielt

        for (int i = 0; i < musicFiles().size(); i++) { // -> Playlist Strings hinzufügen
            player.addToPlayList(new File(path + "\\" + myPlayList.get(i)));
        }

        // GUI vom Player
        player.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));


        // Fenster
        JFrame frame = new JFrame("MP3 Player");
        frame.setIconImage(new ImageIcon("C:\\Users\\Chalach\\Desktop\\MP3Player\\ImageIcon\\icon.jpg").getImage()); // -> Frame Icon
        JButton button = new JButton("Show song"); // -> Button
        button.addActionListener(new TestActionListener(button, frame)); // -> Listener für den Button
        frame.add(button); // -> Füge den Button zum Fenster hinzu

        // Eigentliches Fenster
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // -> legt fest, was passiert, wenn man den Dialog/Programm schließt
        frame.getContentPane().add(player); // -> fügt den Player hinzu
        frame.setLayout(new FlowLayout()); // -> notwendig für einen Button
        frame.pack();
        frame.setLocationRelativeTo(null); // -> legt fest, wo das Fenster auftauchen soll: hier ist es in der Mitte
        frame.setVisible(true); // -> macht das Fenster sichtbar
    }
}
