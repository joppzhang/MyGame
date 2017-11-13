package cn.zpq.room1.movecontrol;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.room1.RoomOne;

public class MyKeyAdapter1 extends KeyAdapter {
	RoomOne r;

	public MyKeyAdapter1(RoomOne r) {
		this.r = r;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP) {
			new Thread(new ThreadOfUpInRoom1(r)).start();
		} else if (k == KeyEvent.VK_DOWN) {
			new Thread(new ThreadOfDownInRoom1()).start();
		} else if (k == KeyEvent.VK_LEFT) {
			new Thread(new ThreadOfLeftInRoom1()).start();
		} else if (k == KeyEvent.VK_RIGHT) {
			new Thread(new ThreadOfRightInRoom1()).start();
		}
	}

}
