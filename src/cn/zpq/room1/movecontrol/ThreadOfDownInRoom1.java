package cn.zpq.room1.movecontrol;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import cn.zpq.characteract.ArrayOfPerson;
import cn.zpq.map.load.LoadMap;
import cn.zpq.room1.RoomOne;
import cn.zpq.village.Village;

public class ThreadOfDownInRoom1 implements Runnable {

	@Override
	public void run() {
		setImage();

	}

	public void setImage() {
		synchronized (Village.vv) {
			ImageIcon imageIcon = null;
			imageIcon = new ImageIcon(ArrayOfPerson.down[0]);
			imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30,
					Image.SCALE_AREA_AVERAGING));
			RoomOne.personOfRoom1.setIcon(imageIcon);

			Point beforeStep = RoomOne.personOfRoom1.getLocation();
			// 判断下一个位置是否可以移动
			int afterX = beforeStep.x + 3;
			int afterY = beforeStep.y + 24;
			int indexX = afterX / 24 - 1;
			int indexY = afterY / 24;
			System.out.println("向下走 X:" + indexX + "--Y:" + indexY);
			if (indexY >= 14 || LoadMap.room1[indexY][indexX] == 0) {
				return;
			} else {

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 3; j++) {
						imageIcon = new ImageIcon(ArrayOfPerson.down[j]);
						imageIcon.setImage(imageIcon.getImage()
								.getScaledInstance(30, 30,
										Image.SCALE_AREA_AVERAGING));
						RoomOne.personOfRoom1.setIcon(imageIcon);
						Point here = RoomOne.personOfRoom1.getLocation();

						Point afterStep1 = new Point(here.x, here.y + 1);
						RoomOne.personOfRoom1.setLocation(afterStep1);

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
