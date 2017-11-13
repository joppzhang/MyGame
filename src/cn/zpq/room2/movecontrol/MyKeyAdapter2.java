package cn.zpq.room2.movecontrol;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.room2.RoomTwo;

public class MyKeyAdapter2 extends KeyAdapter {
	RoomTwo t;

	public MyKeyAdapter2(RoomTwo t) {
		this.t = t;
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		int k = e.getKeyCode();
		if (k == KeyEvent.VK_UP) {
			new Thread(new ThreadOfUpInRoom2(t)).start();
		} else if (k == KeyEvent.VK_DOWN) {
			new Thread(new ThreadOfDownInRoom2()).start();
		} else if (k == KeyEvent.VK_LEFT) {
			new Thread(new ThreadOfLeftInRoom2()).start();
		} else if (k == KeyEvent.VK_RIGHT) {
			new Thread(new ThreadOfRightInRoom2()).start();
		}
	}

}
