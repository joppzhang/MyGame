package cn.zpq.map.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadRoomOne extends Thread {
	int[][] room1 = new int[15][19];

	public LoadRoomOne(int[][] map) {
		this.room1 = map;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			File file = new File("src/cn/zpq/map/room1.txt");
			bufferedReader = new BufferedReader(new FileReader(file));
			String string = null;
			int i = 0;
			while ((string = bufferedReader.readLine()) != null) {
				String[] values = string.split(",");
				for (int j = 0; j < values.length; j++) {
					room1[i][j] = Integer.parseInt(values[j]);
				}
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			LoadMap.room1 = this.room1;
		}

	}
}
