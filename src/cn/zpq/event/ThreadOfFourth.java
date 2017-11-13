package cn.zpq.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.room1.RoomOne;
import cn.zpq.village.Village;

public class ThreadOfFourth extends Thread {
	RoomOne r;
	static int i;

	public ThreadOfFourth(RoomOne r) {
		this.r = r;
	}

	@Override
	public void run() {
		i = 0;
		if (!(Village.taskOfHeadInVillage == 1)) {
			RoomOne.talkLable.setVisible(true);
			RoomOne.girl.setVisible(true);
			RoomOne.talkText.setVisible(true);
			RoomOne.talkText.setText("现在还不是找我的时候");
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RoomOne.talkLable.setVisible(false);
			RoomOne.talkText.setVisible(false);
			RoomOne.girl.setVisible(false);
			r.setVisible(false);
			return;
		}
		showFirst();
		r.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					i++;
					showMeet(i);
				}
			}
		});
	}

	private void showFirst() {
		// TODO Auto-generated method stub
		RoomOne.talkLable.setVisible(true);
		RoomOne.girl.setVisible(true);
		RoomOne.talkText.setVisible(true);
		RoomOne.talkText.setText("你是？");
	}

	protected void showMeet(int j) {

		if (j == 1) {

			RoomOne.girl.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("（好，好漂亮…那么猥琐的老头怎么有这么漂亮的孙女。。。）");
		}
		if (j == 2) {

			RoomOne.girl.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("我…我…村，村长让我帮他拿眼镜…");
		}
		if (j == 3) {

			RoomOne.girl.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("是我爷爷让你来的啊，他的眼镜被大祭司拿去了，");
		}
		if (j == 4) {

			RoomOne.girl.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("大祭司随时会外出的你要是要找他就快去吧，他住在最高的地方。");
		}
		if (j == 5) {

			RoomOne.girl.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("我能在坐一会儿吗。。。");
		}
		if (j == 6) {

			RoomOne.girl.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("……可以……");
		}
		if (j == 7) {

			RoomOne.girl.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("谢谢你，莉莉，你在晚上运气会变得很差把");
		}
		if (j == 8) {

			RoomOne.girl.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("为什么这么讲");
		}
		if (j == 9) {

			RoomOne.girl.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("因为月宫的仙子嫦娥看到你会忍不住的嫉妒你的美貌的。");
		}
		if (j == 10) {

			RoomOne.girl.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("你你你…（脸红）你快走吧，一会儿大祭司外出就不好了");
		}
		if (j == 11) {

			RoomOne.girl.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("晕，把这茬忘了，我走啦");
		}
		if (j == 12) {
			RoomOne.hero.setVisible(false);
			RoomOne.talkLable.setVisible(false);
			RoomOne.talkText.setVisible(false);
			Village.task[3] = true;
			r.setVisible(false);
		}

	}

}
