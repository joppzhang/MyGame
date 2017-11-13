package cn.zpq.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.menu.MyMenu;
import cn.zpq.village.Village;

public class ThreadOfFirst extends Thread {
	MyMenu m;
	static int i;

	public ThreadOfFirst(MyMenu m) {
		this.m = m;
	}

	@Override
	public void run() {
		i = 0;
		show();
		Village.vv.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					i++;
					showFirst(i);
				}
			}
		});
	}

	private void show() {
		// TODO Auto-generated method stub
		Village.talkLable.setVisible(true);
		Village.talkText.setVisible(true);
		Village.talkText.setText("入夜平静的村庄黑漆漆的，突然一个身影慢慢浮现。");
	}

	protected void showFirst(int j) {

		if (j == 1) {
			Village.hero.setVisible(true);
			Village.talkText.setText("哇咔咔，我走了三天三夜，终于在三更半夜走到了宝藏的埋藏地!");
		}
		if (j == 2) {
			Village.talkText.setText("黄天不负有心人啊，我要比马云更有钱啦~");
		}
		if (j == 3) {
			Village.talkText.setText("这地方怎么多了个村子。。。这怎么找我的宝藏啊。前面有个人  我去问问。");
		}
		if (j == 4) {
			Village.hero.setVisible(false);
			Village.talkLable.setVisible(false);
			Village.talkText.setVisible(false);
		}

	}

}
