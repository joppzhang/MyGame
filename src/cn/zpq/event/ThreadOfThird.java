package cn.zpq.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.room2.RoomTwo;
import cn.zpq.village.Village;

public class ThreadOfThird extends Thread {
	RoomTwo t;
	static int i = 0;

	public ThreadOfThird(RoomTwo t) {
		this.t = t;
	}

	@Override
	public void run() {
		if (!Village.task[1]) {
			RoomTwo.talkLable.setVisible(true);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setVisible(true);
			RoomTwo.talkText.setText("你在村口没看到守卫吗？");
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			RoomTwo.headOfVillage.setVisible(false);
			t.setVisible(false);
			return;
		}
		i = 0;
		if (Village.taskOfHeadInVillage == 1) {
			RoomTwo.talkLable.setVisible(true);
			RoomTwo.talkText.setVisible(true);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("我的眼镜怎么还没拿回来？");
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			RoomTwo.headOfVillage.setVisible(false);
			t.setVisible(false);
			return;
		}
		if (Village.taskOfHeadInVillage == 3) {
			RoomTwo.talkLable.setVisible(true);
			RoomTwo.talkText.setVisible(true);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("现在不是找我的时候");
			try {
				sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			RoomTwo.headOfVillage.setVisible(false);
			t.setVisible(false);
			return;
		}
		if (Village.taskOfHeadInVillage == 2) {
			showTalk2();
			t.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyChar() == KeyEvent.VK_SPACE) {
						i++;
						showSecondMeet(i);
					}
				}
			});

		} else {
			showTalk1();
			t.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						i++;
						showFirstMeet(i);
					}
				}
			});
		}

	}

	private void showTalk2() {
		// TODO Auto-generated method stub
		RoomTwo.talkLable.setVisible(true);
		RoomTwo.hero.setVisible(true);
		RoomTwo.talkText.setVisible(true);
		RoomTwo.talkText.setText("老头，你的眼镜，快帮我看看地图 ");
	}

	private void showFirstMeet(int j) {
		// TODO Auto-generated method stub
		if (j == 1) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("200!");
		}
		if (j == 2) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.headOfVillage.setVisible(false);
			RoomTwo.talkText.setText("What???");
		}
		if (j == 3) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("少废话，200，不还价，支持微信支付宝pos机刷卡!");
		}
		if (j == 4) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.headOfVillage.setVisible(false);
			RoomTwo.talkText.setText("顶你个肺啊，奸商 QAQ");
		}
		if (j == 5) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("你懂什么，现在是经济社会，不给我就不告诉你");
		}
		if (j == 6) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.headOfVillage.setVisible(false);
			RoomTwo.talkText.setText("算了  为了宝藏，我忍了。。。乖乖掏出200");
		}
		if (j == 7) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("好小伙子，爽快人。不过今天好累，明天在看吧…");
		}
		if (j == 8) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("哎哎哎你干嘛?小伙子，不要没事就拿刀啊。");
		}
		if (j == 9) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("我突然感觉我这会儿还不用休息。");
		}
		if (j == 10) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("这个地方太模糊了，这样，你去拿我的眼镜来");
		}
		if (j == 11) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.headOfVillage.setVisible(true);
			RoomTwo.talkText.setText("它在我孙女儿那里,她喜欢种菜。");
		}

		if (j == 12) {
			RoomTwo.headOfVillage.setVisible(false);
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			Village.taskOfHeadInVillage = 1;
			t.setVisible(false);
		}

	}

	private void showTalk1() {
		RoomTwo.talkLable.setVisible(true);
		RoomTwo.hero.setVisible(true);
		RoomTwo.talkText.setVisible(true);
		RoomTwo.talkText.setText("您好，敬爱的村长大人，您的样子是那么的睿智，我… ");
	}

	private void showSecondMeet(int j) {

		if (j == 1) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("催什么催，我看看，这个地方。。。有点熟悉。");
		}
		if (j == 2) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("咦这条线，是浏阳河！");
		}
		if (j == 3) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("我们村子的这条，他的走向我忘不了");
		}
		if (j == 4) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("不过这个地方具体在哪");
		}
		if (j == 5) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("你就要到河边住的比利家去问问了");
		}
		if (j == 6) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("他从小就在河边，一定知道这是哪里。");
		}
		if (j == 7) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.glassOnHeadOfVillage.setVisible(false);
			RoomTwo.talkText.setText("我马上就去，对了，你孙女有男朋友吗？");
		}
		if (j == 8) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("我呸，200都抠门的家伙想泡我孙女?痴心妄想！");
		}
		if (j == 9) {
			RoomTwo.hero.setVisible(true);
			RoomTwo.glassOnHeadOfVillage.setVisible(false);
			RoomTwo.talkText.setText("你等着，我会比马云还富有");
		}
		if (j == 10) {
			RoomTwo.hero.setVisible(false);
			RoomTwo.glassOnHeadOfVillage.setVisible(true);
			RoomTwo.talkText.setText("快滚！");
		}
		if (j == 11) {
			RoomTwo.glassOnHeadOfVillage.setVisible(false);
			RoomTwo.talkLable.setVisible(false);
			RoomTwo.talkText.setVisible(false);
			Village.taskOfHeadInVillage = 3;
			t.setVisible(false);
		}

	}

}
