package MP3Player.GUI;

import jaco.mp3.player.MP3Player;
import jaco.mp3.player.plaf.MP3PlayerUICompact;

import java.io.File;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class MP3Player {

    public static void main(String[] args) throws Exception {

        // MP3Player.setDefaultUI(MP3PlayerUICompact.class);

        //

        jaco.mp3.player.MP3Player player = new jaco.mp3.player.MP3Player();

        player.setRepeat(true);

        player.addToPlayList(new File("test.mp3"));
        player.addToPlayList(new File("test2.mp3"));
        player.addToPlayList(new File("test3.mp3"));
        player.addToPlayList(new URL("http://server.com/mp3s/test4.mp3"));

        //

        player.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));

        JFrame frame = new JFrame("MP3 Player");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(player);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}