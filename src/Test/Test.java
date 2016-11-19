package Test;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test extends Component {
    public static void main(String[] args) throws IOException {
        String c = readFile2();
        System.out.println(c);
        DemoJFileChooser panel = new DemoJFileChooser();
    }
    private void readFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        //chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //chooser soll nur Dateien öffnen
        //int retrival = chooser.showOpenDialog(null); //Auswahl Dialog öffnen

        // Filter, welche Dateien angezeigt werden soll
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3-Datein", "mp3");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("WAV-Datein", "wav");

        // Filter hizufügen
        chooser.addChoosableFileFilter(filter);
        chooser.addChoosableFileFilter(filter2);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            System.out.println("getCurrentDirectory(): " +  chooser.getCurrentDirectory());
            System.out.println("getSelectedFile() : " +  chooser.getSelectedFile());
        }
        else {
            System.out.println("No Selection ");
        }/*
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try (FileReader fr = new FileReader(chooser.getSelectedFile())) { //Reader mit Pfad der Datei öffnen
                BufferedReader br = new BufferedReader(fr);
                String line;
                System.out.println("Inhalt der Datei:");
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
                br.close();
                fr.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }*/
    }

    private static String readFile2() throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //chooser soll nur Dateien öffnen
        FileNameExtensionFilter filter = new FileNameExtensionFilter("MP3-Datein", "mp3");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("WAV-Datein", "wav");

        // Filter hizufügen
        chooser.addChoosableFileFilter(filter);
        chooser.addChoosableFileFilter(filter2);
        int retrival = chooser.showOpenDialog(null); //Auswahl Dialog öffnen
        if (retrival == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getAbsolutePath();
            return path;
        }
        return null;
    }
}
