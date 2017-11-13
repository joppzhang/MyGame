package cn.zpq.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import cn.zpq.room1.RoomOne;
import cn.zpq.village.Village;

public class ThreadOfSixth extends Thread {
	RoomOne r;
	static int i;

	public ThreadOfSixth(RoomOne r) {
		// TODO Auto-generated constructor stub
		this.r = r;
	}

	@Override
	public void run() {
		i = 0;
		if (Village.taskOfHeadInVillage != 3) {
			RoomOne.talkLable.setVisible(true);
			RoomOne.bili.setVisible(true);
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
			RoomOne.bili.setVisible(false);
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
		RoomOne.hero.setVisible(true);
		RoomOne.talkText.setVisible(true);
		RoomOne.talkText.setText("比利比利，你好。");
	}

	protected void showMeet(int j) {

		if (j == 1) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("你有梦想吗？");
		}
		if (j == 2) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("额，我有事想你请教…");
		}
		if (j == 3) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("你有梦想吗？");
		}
		if (j == 4) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("…有的");
		}
		if (j == 5) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("原来大家都有梦想，为什么我没有。");
		}
		if (j == 6) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("只能每天在河边打鱼。。");
		}
		if (j == 7) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("只有莉莉愿意和我玩。。5555555");
		}
		if (j == 8) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("（原来他经常和莉莉在一起。。不行我要想个法子）");
		}
		if (j == 9) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("……振作点，其实梦想就是自己喜欢什么就去做什么！你喜欢什么？");
		}
		if (j == 10) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("我喜欢创造的感觉。。");
		}
		if (j == 11) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("这样，我给你介绍一个地方，北京尚学堂去学java，");
		}
		if (j == 12) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("学完就可以写代码来创造！");
		}
		if (j == 13) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("好主意！我要创造一个网站，名动天下，");
		}
		if (j == 14) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("名字都起好了，就叫比利比利");
		}
		if (j == 15) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("恭喜你！找到了梦想快去实现吧  不要在村子里呆了");
		}
		if (j == 16) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("谢谢啊~（一溜烟就跑了）");
		}
		if (j == 17) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("唉，真是个傻小子估计也只有尚学堂有能力把他教好了");
		}
		if (j == 18) {

			RoomOne.bili.setVisible(false);
			RoomOne.hero.setVisible(true);
			RoomOne.talkText.setText("哎哎哎等等，帮我看看地图再走啊！");
		}
		if (j == 19) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("晕，抱歉，一时激动，我来看下。。。");
		}
		if (j == 20) {

			RoomOne.bili.setVisible(true);
			RoomOne.hero.setVisible(false);
			RoomOne.talkText.setText("这个地方。。嗯…我认得…是守护雕像的位置，我要走了再见！");
		}
		if (j == 21) {
			RoomOne.bili.setVisible(false);
			RoomOne.talkLable.setVisible(false);
			RoomOne.talkText.setVisible(false);
			r.setVisible(false);
		}

	}

}
