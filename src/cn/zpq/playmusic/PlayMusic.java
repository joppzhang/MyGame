package cn.zpq.playmusic;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayMusic extends Thread {
	Player player;
	File music = new File("src/cn/zpq/music/BGM.mp3");

	@Override
	public void run() {
		while (true) {
			BufferedInputStream buffer = null;
			try {
				buffer = new BufferedInputStream(new FileInputStream(music));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				player = new Player(buffer);
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				player.play();
			} catch (JavaLayerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
