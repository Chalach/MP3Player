package Samples;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class Example1 {

    public static void main(String[] args) {
        // Damit der Song zu Ende gespielt wird muss das Programm pausiert werden oder
        // mit einer While-Schleife das Beenden verhindern
        new MP3Player(new File("Music\\Test.mp3")).play();
    }

}
