package cn.zpq.room2.movecontrol;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import cn.zpq.characteract.ArrayOfPerson;
import cn.zpq.event.ThreadOfFifth;
import cn.zpq.event.ThreadOfThird;
import cn.zpq.map.load.LoadMap;
import cn.zpq.room2.RoomTwo;
import cn.zpq.village.Village;

public class ThreadOfUpInRoom2 implements Runnable {
	RoomTwo t;

	public ThreadOfUpInRoom2(RoomTwo t) {
		this.t = t;
	}

	@Override
	public void run() {
		setImage();

	}

	public void setImage() {
		synchronized (Village.vv) {
			ImageIcon imageIcon = null;
			imageIcon = new ImageIcon(ArrayOfPerson.up[0]);
			imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30,
					Image.SCALE_AREA_AVERAGING));
			RoomTwo.personOfRoom2.setIcon(imageIcon);
			Point beforeStep = RoomTwo.personOfRoom2.getLocation();
			// 判断下一个位置是否可以移动
			int afterX = beforeStep.x + 3;
			int afterY = beforeStep.y - 24;
			int indexX = afterX / 24;
			int indexY = afterY / 24 + 1;
			System.out.println("向上走 X:" + indexX + "--Y:" + indexY);
			if (indexX == 11 && indexY == 7) {
				new ThreadOfThird(t).start();
			}
			if (indexX == 15 && indexY == 13) {
				new ThreadOfFifth(t).start();
			}

			if (LoadMap.room2[indexY][indexX] == 0) {
				return;
			} else {

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 3; j++) {
						imageIcon = new ImageIcon(ArrayOfPerson.up[j]);
						imageIcon.setImage(imageIcon.getImage()
								.getScaledInstance(30, 30,
										Image.SCALE_AREA_AVERAGING));
						RoomTwo.personOfRoom2.setIcon(imageIcon);
						Point here = RoomTwo.personOfRoom2.getLocation();
						Point afterStep1 = new Point(here.x, here.y - 1);
						RoomTwo.personOfRoom2.setLocation(afterStep1);

						try {
							// System.out.println("睡30毫秒");
							Thread.sleep(30);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}

				}
			}
		}
	}
}
