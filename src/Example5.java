import jaco.mp3.player.MP3Player;

import java.io.File;

public class Example5 {

    public static void main(String[] args) throws Exception {

        MP3Player player = new MP3Player();

        player.addToPlayList(new File("Test.mp3"));
        player.addToPlayList(new File("Test2.mp3"));

        System.out.println("Music Player");
        System.out.println("Start to Play:");
        player.play();
        Thread.sleep(2000);
        System.out.println("Skip to next Song");
        player.skipForward();
        System.out.println("Test");
        player.play();
        System.out.println("Test");
        Thread.sleep(2000);
        System.out.println("Test");
        player.pause();
        System.out.println("Test");
        Thread.sleep(2000);
        player.play();
    }

}