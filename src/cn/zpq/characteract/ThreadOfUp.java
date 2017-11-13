package cn.zpq.characteract;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import cn.zpq.event.ThreadOfSeventh;
import cn.zpq.map.load.LoadMap;
import cn.zpq.room1.RoomOne;
import cn.zpq.room2.RoomTwo;
import cn.zpq.village.Village;

public class ThreadOfUp implements Runnable {

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
			Village.lblPerson.setIcon(imageIcon);
			Point beforeStep = Village.lblPerson.getLocation();
			// 判断下一个位置是否可以移动
			int afterX = beforeStep.x + 3;
			int afterY = beforeStep.y - 19;
			int indexX = afterX / 19;
			int indexY = afterY / 19 + 1;
			System.out.println("向上走 X:" + indexX + "--Y:" + indexY);
			if (indexX == 19 && indexY == 8) {
				new ThreadOfSeventh().start();
			}
			if (indexX == 7 && indexY == 18) {
				RoomOne roomOne = new RoomOne();
				RoomOne.girlSmall.setVisible(true);
				RoomOne.biliSmall.setVisible(false);
				roomOne.setVisible(true);
			}
			if (indexX == 23 && indexY == 28) {
				RoomOne roomOne = new RoomOne();
				RoomOne.girlSmall.setVisible(false);
				RoomOne.biliSmall.setVisible(true);
				roomOne.setVisible(true);
			}
			if (indexX == 14 && indexY == 32) {
				RoomTwo roomTwo = new RoomTwo();
				RoomTwo.headOfVillageSmall.setVisible(true);
				RoomTwo.wizardSmall.setVisible(false);
				roomTwo.setVisible(true);
			}
			if (indexX == 36 && indexY == 6) {
				RoomTwo roomTwo = new RoomTwo();
				RoomTwo.headOfVillageSmall.setVisible(false);
				RoomTwo.wizardSmall.setVisible(true);
				roomTwo.setVisible(true);
			}
			if (LoadMap.mainMap[indexY][indexX] == 0) {

				return;
			} else {

				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						imageIcon = new ImageIcon(ArrayOfPerson.up[j]);
						imageIcon.setImage(imageIcon.getImage()
								.getScaledInstance(30, 30,
										Image.SCALE_AREA_AVERAGING));
						Village.lblPerson.setIcon(imageIcon);
						Point here = Village.lblPerson.getLocation();
						if (i == 5 && j == 2) {
							Point afterStep1 = new Point(here.x, here.y - 2);
							Village.lblPerson.setLocation(afterStep1);
						} else {
							Point afterStep1 = new Point(here.x, here.y - 1);
							Village.lblPerson.setLocation(afterStep1);
						}

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
