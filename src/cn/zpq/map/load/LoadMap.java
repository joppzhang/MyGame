package cn.zpq.map.load;


/**
 * 加载地图的类
 * */
public class LoadMap {

	public LoadMap() {
		loadMainMap();
		loadRoomOne();
		loadRoomTwo();
		System.out.println("三个地图加载完成");
	}

	// 三个地图数组
	public static int[][] mainMap = new int[40][40];
	public static int[][] room1 = new int[15][19];
	public static int[][] room2 = new int[17][21];

	/**
	 * 主地图
	 * */
	public static void loadMainMap() {
		Thread thread = new LoadMainMap(mainMap);
		thread.start();
	}

	/**
	 * 房间1
	 * 
	 * */
	public static void loadRoomOne() {
		Thread thread = new LoadRoomOne(room1);
		thread.start();
	}

	/**
	 * 房间2
	 */
	public static void loadRoomTwo() {
		Thread thread = new LoadRoomTwo(room2);
		thread.start();
	}

	// @Test
	// public static void main(String[] args) throws IOException {
	// loadMainMap();
	// loadRoomOne();
	// loadRoomTwo();
	// for (int i = 0; i < 40; i++) {
	// for (int j = 0; j < 40; j++) {
	// System.out.print(mainMap[i][j]);
	// }
	// System.out.println();
	// }
	// System.out.println("------------------------");
	// for (int i = 0; i < 15; i++) {
	// for (int j = 0; j < 19; j++) {
	// System.out.print(room1[i][j]);
	// }
	// System.out.println();
	// }
	// System.out.println("------------------------");
	// for (int i = 0; i < 17; i++) {
	// for (int j = 0; j < 21; j++) {
	// System.out.print(room2[i][j]);
	// }
	// System.out.println();
	// }
	// }
}
