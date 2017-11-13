package cn.zpq.characteract;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.village.Village;

public class MyKeyAdapter extends KeyAdapter {
	Village v;

	public MyKeyAdapter(Village v) {
		this.v = v;
	}

	@Override
	public synchronized void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP) {
			new Thread(new ThreadOfUp()).start();
		} else if (k == KeyEvent.VK_DOWN) {
			new Thread(new ThreadOfDown()).start();
		} else if (k == KeyEvent.VK_LEFT) {
			new Thread(new ThreadOfLeft()).start();
		} else if (k == KeyEvent.VK_RIGHT) {
			ThreadOfRight threadOfRight = new ThreadOfRight(v);
			Thread thread1 = new Thread(threadOfRight);
			thread1.start();
		}
	}

}
