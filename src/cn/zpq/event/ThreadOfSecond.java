package cn.zpq.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.village.Village;

public class ThreadOfSecond extends Thread {
	static int i = 0;
	Village v;

	public ThreadOfSecond(Village v) {
		this.v = v;
	}

	@Override
	public void run() {
		if (Village.task[1]) {
			Village.talkLable.setVisible(true);
			Village.talkText.setVisible(true);
			Village.talkText.setText("不是告诉你要去找村长了吗？快去吧");
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Village.talkLable.setVisible(false);
			Village.talkText.setVisible(false);
			return;
		}
		showTalk();
		v.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					i++;
					showMore(i);
				}
			}
		});

	}

	protected void showMore(int j) {
		// TODO Auto-generated method stub
		if (j == 1) {
			Village.hero.setVisible(false);
			Village.guard.setVisible(true);
			Village.talkText.setText("得得得，别废话，大晚上你能看见这么多？你是谁来我们村子干嘛？");
		}
		if (j == 2) {
			Village.hero.setVisible(true);
			Village.guard.setVisible(false);
			Village.talkText.setText("是这样的，我在找这个地方，帅哥你知道这个地方吗？被你们村子盖住了。");
		}
		if (j == 3) {
			Village.hero.setVisible(false);
			Village.guard.setVisible(true);
			Village.talkText.setText("看在你爱说实话的面子上，我就告诉你吧。。。没见过。");
		}
		if (j == 4) {
			Village.hero.setVisible(true);
			Village.guard.setVisible(false);
			Village.talkText.setText("你你你。。。看刀！");
		}
		if (j == 5) {
			Village.hero.setVisible(false);
			Village.guard.setVisible(true);
			Village.talkText.setText("嘿嘿，别冲动啊，来来来，放下刀放下刀。你去问问村长大人吧。");
		}
		if (j == 6) {
			Village.hero.setVisible(false);
			Village.guard.setVisible(true);
			Village.talkText.setText("他是这个村子最年长的人，应该会知道。");
		}
		if (j == 7) {
			Village.talkLable.setVisible(false);
			Village.talkText.setVisible(false);
			Village.guard.setVisible(false);
			Village.task[1] = true;
		}
	}

	private void showTalk() {
		Village.talkLable.setVisible(true);
		Village.hero.setVisible(true);
		Village.talkText.setVisible(true);
		Village.talkText.setText("嗨，这位帅哥，你真是风流倜傥，英俊潇洒，人见人爱，花见……");
	}

}
