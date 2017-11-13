package cn.zpq.room2.movecontrol;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import cn.zpq.characteract.ArrayOfPerson;
import cn.zpq.map.load.LoadMap;
import cn.zpq.room2.RoomTwo;
import cn.zpq.village.Village;

public class ThreadOfRightInRoom2 implements Runnable {

	@Override
	public void run() {
		setImage();

	}

	public void setImage() {
		synchronized (Village.vv) {
			ImageIcon imageIcon = null;
			imageIcon = new ImageIcon(ArrayOfPerson.right[0]);
			imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30,
					Image.SCALE_AREA_AVERAGING));
			RoomTwo.personOfRoom2.setIcon(imageIcon);

			Point beforeStep = RoomTwo.personOfRoom2.getLocation();
			// 判断下一个位置是否可以移动
			int afterX = beforeStep.x + 3 + 24;
			int afterY = beforeStep.y;
			int indexX = afterX / 24;
			int indexY = afterY / 24 + 1;
			System.out.println("向右走 X:" + indexX + "--Y:" + indexY);
			if (LoadMap.room2[indexY][indexX] == 0) {
				return;
			} else {

				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 3; j++) {
						imageIcon = new ImageIcon(ArrayOfPerson.right[j]);
						imageIcon.setImage(imageIcon.getImage()
								.getScaledInstance(30, 30,
										Image.SCALE_AREA_AVERAGING));
						RoomTwo.personOfRoom2.setIcon(imageIcon);
						Point here = RoomTwo.personOfRoom2.getLocation();
						Point afterStep1 = new Point(here.x + 1, here.y);
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
