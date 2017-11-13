package cn.zpq.map.load;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoadMainMap extends Thread {
	int[][] mainMap = new int[40][40];

	public LoadMainMap(int[][] map) {
		this.mainMap = map;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader = null;
		try {
			File file = new File("src/cn/zpq/map/mainMap.txt");
			bufferedReader = new BufferedReader(new FileReader(file));
			String string = null;
			int i = 0;
			while ((string = bufferedReader.readLine()) != null) {
				String[] values = string.split(",");
				for (int j = 0; j < values.length; j++) {
					mainMap[i][j] = Integer.parseInt(values[j]);
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
			LoadMap.mainMap = this.mainMap;
		}

	}
}
