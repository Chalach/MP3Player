package Samples;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class Example3 {

    public static void main(String[] args) throws Exception {

        File file1 = new File("Music\\Test.mp3");
        // Pfade müssen angepasst werden
        File file2 = new File("Music\\test2.mp3");
        File file3 = new File("Music\\test3.mp3");

        // Der MP3Player kann auch mehrere Dateien gleichzeitig abspielen.
        new MP3Player(file1, file2, file3).play();
    }

}
