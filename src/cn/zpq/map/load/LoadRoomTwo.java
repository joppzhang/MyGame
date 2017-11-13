package cn.zpq.map.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadRoomTwo extends Thread {
	int[][] room2 = new int[17][21];

	public LoadRoomTwo(int[][] map) {
		this.room2 = map;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			File file = new File("src/cn/zpq/map/room2.txt");
			bufferedReader = new BufferedReader(new FileReader(file));
			String string = null;
			int i = 0;
			while ((string = bufferedReader.readLine()) != null) {
				String[] values = string.split(",");
				for (int j = 0; j < values.length; j++) {
					room2[i][j] = Integer.parseInt(values[j]);
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
			LoadMap.room2 = this.room2;
		}

	}
}
