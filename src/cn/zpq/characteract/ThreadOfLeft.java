package cn.zpq.characteract;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import cn.zpq.map.load.LoadMap;
import cn.zpq.village.Village;

public class ThreadOfLeft implements Runnable {

	@Override
	public void run() {
		setImage();

	}

	public void setImage() {
		synchronized (Village.vv) {
			ImageIcon imageIcon = null;
			imageIcon = new ImageIcon(ArrayOfPerson.left[0]);
			imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30,
					Image.SCALE_AREA_AVERAGING));
			Village.lblPerson.setIcon(imageIcon);

			Point beforeStep = Village.lblPerson.getLocation();
			// 判断下一个位置是否可以移动
			int afterX = beforeStep.x + 3 - 19;
			int afterY = beforeStep.y;
			int indexX = afterX / 19;
			int indexY = afterY / 19 + 1;
			System.out.println("向左走 X:" + indexX + "--Y:" + indexY);
			if (LoadMap.mainMap[indexY][indexX] == 0) {
				return;
			} else {

				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						imageIcon = new ImageIcon(ArrayOfPerson.left[j]);
						imageIcon.setImage(imageIcon.getImage()
								.getScaledInstance(30, 30,
										Image.SCALE_AREA_AVERAGING));
						Village.lblPerson.setIcon(imageIcon);
						Point here = Village.lblPerson.getLocation();
						if (i == 5 && j == 2) {
							Point afterStep1 = new Point(here.x - 2, here.y);
							Village.lblPerson.setLocation(afterStep1);
						} else {
							Point afterStep1 = new Point(here.x - 1, here.y);
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
