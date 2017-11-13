package cn.zpq.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.room2.RoomTwo;
import cn.zpq.village.Village;

public class ThreadOfFifth extends Thread {
	RoomTwo t;
	static int i = 0;

	public ThreadOfFifth(RoomTwo t) {
		this.t = t;
	}

	@Override
	public void run() {
		i = 0;
		if ((Village.taskOfHeadInVillage == 0
				|| Village.taskOfHeadInVillage == 2 || Village.taskOfHeadInVillage == 3)
				|| !Village.task[3]) {
			RoomTwo.talkLable.setVisible(true);
			RoomTwo.wizard.setVisible(true);
			RoomTwo.talkText.setVisible(true);
			RoomTwo.talkText.setText("现在还不是找我的时候");
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			RoomTwo.wizard.setVisible(false);
			t.setVisible(false);
			return;
		}
		showFirst();
		t.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					i++;
					showSecondMeet(i);
				}
			}
		});

	}

	private void showFirst() {
		// TODO Auto-generated method stub
		RoomTwo.talkLable.setVisible(true);
		RoomTwo.talkText.setVisible(true);
		RoomTwo.hero.setVisible(true);
		RoomTwo.wizard.setVisible(false);
		RoomTwo.talkText.setText("您好，村长大人让我帮他拿眼镜回去");
	}

	protected void showSecondMeet(int j) {

		if (j == 1) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(true);
			RoomTwo.talkText.setText("外来人？想拿东西先得帮我个忙！");
		}
		if (j == 2) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkText.setText("（捂住口袋）我真没钱了… ");
		}
		if (j == 3) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(true);
			RoomTwo.talkText.setText("呸。谁要你的钱，我做好了几个傀儡战士。");
		}
		if (j == 4) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkText.setText("如果你能把他们打倒，我就把眼镜给你。");
		}
		if (j == 5) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(true);
			RoomTwo.talkText.setText("这样啊 小菜一碟！");
		}
		if (j == 6) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkText.setText("打败傀儡战士");
		}

		if (j == 7) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(true);
			RoomTwo.talkText.setText("你居然可以打败他们，很厉害，小伙子，");
		}
		if (j == 8) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkText.setText("那是！也不看我是谁。");
		}
		if (j == 9) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkText.setText("我这么潇洒帅气，天下无敌，人见人爱花…");
		}
		if (j == 10) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(true);
			RoomTwo.talkText.setText("天哪，这个人也太不要脸了，拿着眼镜快滚！");
		}
		if (j == 11) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkText.setText("得到眼镜");
		}

		if (j == 12) {
			RoomTwo.wizard.setVisible(false);
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			Village.taskOfHeadInVillage = 2;
			t.setVisible(false);
		}

	}

}
