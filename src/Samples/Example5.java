package Samples;

import jaco.mp3.player.MP3Player;
import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

public class Example5{

    public static ArrayList<String> musicFiles(){
        ArrayList<String> songList = new ArrayList<>();
        File test = new File("Music\\");
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
        for(String i : myPlayList){
            System.out.println(myPlayList.get(Integer.parseInt(i)));
        }

        // Neuen MP3Player erstellen
        MP3Player player = new MP3Player();
        // Enable Loop
        player.setRepeat(true);
        // Wenn eine .mp3-Datei zu ende gespielt wurde, wird random ein Song aus der PlayList gespielt
        player.setShuffle(true);

        // Playlist Strings hinzufügen
        for(String i : myPlayList){
            player.addToPlayList(new File("Music\\" + myPlayList.get(Integer.parseInt(i))));
        }


        // GUI
        player.setBorder(BorderFactory.createEmptyBorder(15, 100, 15, 100));

        JFrame frame = new JFrame("MP3 Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(player);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}