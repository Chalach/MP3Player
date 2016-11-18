package Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        readFile();
    }
    private static void readFile() throws IOException {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //chooser soll nur Dateien öffnen
        int retrival = chooser.showOpenDialog(null); //Auswahl Dialog öffnen
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
        }
    }
}
