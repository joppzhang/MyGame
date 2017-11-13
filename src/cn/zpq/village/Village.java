package cn.zpq.village;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.zpq.characteract.ArrayOfPerson;
import cn.zpq.characteract.MyKeyAdapter;

public class Village extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// 主角模型
	public static JLabel lblPerson;
	// 对话白底
	public static JLabel talkLable;
	// 守卫模型
	public static JLabel guardSmall;
	// 主角对话头像
	public static JLabel hero;
	// 守卫对话头像
	public static JLabel guard;
	// 结局宝箱

	public static JLabel box;
	// 对话文本
	public static JLabel talkText;
	// 记录是否完成任务
	public static boolean[] task = new boolean[7];
	public static int taskOfHeadInVillage = 0;
	// 单例设计
	public static Village vv = new Village();

	// Test
	// public static void main(String[] args) {
	// Village.vv.setVisible(true);
	// }

	/**
	 * Create the frame.
	 */
	private Village() {
		setTitle("夺宝奇兵");
		// setVisible(false);

		// 画板
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 766, 789);
		contentPane = new JPanel();
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 结局宝箱
		ImageIcon boximg = new ImageIcon("src/cn/zpq/images/打开宝箱1.png");
		boximg.setImage(boximg.getImage().getScaledInstance(150, 150,
				Image.SCALE_AREA_AVERAGING));
		box = new JLabel(boximg);
		box.setBounds(300, 300, 150, 150);
		contentPane.add(box);
		box.setVisible(false);

		// 对话文本
		talkText = new JLabel("");
		talkText.setFont(new Font("楷体", Font.BOLD, 18));
		talkText.setBounds(50, 590, 662, 142);
		contentPane.add(talkText);
		talkText.setVisible(true);

		// 对话的白色底版
		ImageIcon talkWindow = new ImageIcon(
				"src/cn/zpq/images/mainMaptalk.png");
		talkWindow.setImage(talkWindow.getImage().getScaledInstance(694, 159,
				Image.SCALE_AREA_AVERAGING));
		talkLable = new JLabel(talkWindow);
		talkLable.setFont(new Font("Adobe 楷体 Std R", Font.BOLD, 16));
		talkLable.setBounds(35, 580, 694, 159);
		contentPane.add(talkLable);
		talkLable.setVisible(false);

		// 主角对话头像
		ImageIcon heroimg = new ImageIcon("src/cn/zpq/roleimg/勇士.png");
		heroimg.setImage(heroimg.getImage().getScaledInstance(75, 75,
				Image.SCALE_AREA_AVERAGING));
		hero = new JLabel(heroimg);
		hero.setBounds(75, 505, 75, 75);
		contentPane.add(hero);
		hero.setVisible(false);

		// 守卫对话头像
		ImageIcon guardimg = new ImageIcon("src/cn/zpq/roleimg/守卫.png");
		guardimg.setImage(guardimg.getImage().getScaledInstance(75, 75,
				Image.SCALE_AREA_AVERAGING));
		guard = new JLabel(guardimg);
		guard.setBounds(625, 505, 75, 75);
		contentPane.add(guard);
		guard.setVisible(false);

		// 主角模型
		ImageIcon imageIcon = new ImageIcon(ArrayOfPerson.up[0]);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30,
				Image.SCALE_AREA_AVERAGING));
		lblPerson = new JLabel(imageIcon);
		lblPerson.setBounds(263, 711, 30, 30);
		contentPane.add(lblPerson);

		// 守卫模型
		ImageIcon imageGuardSmall = new ImageIcon(
				"src/cn/zpq/roleimg/small/守卫小左.png");
		// System.err.println(ArrayOfPerson.up[0]);
		imageGuardSmall.setImage(imageGuardSmall.getImage().getScaledInstance(
				30, 30, Image.SCALE_AREA_AVERAGING));
		guardSmall = new JLabel(imageGuardSmall);
		guardSmall.setBounds(285, 654, 30, 30);
		contentPane.add(guardSmall);

		// 村子地图
		ImageIcon image = new ImageIcon("bin/cn/zpq/images/mainMap.png");
		image.setImage(image.getImage().getScaledInstance(760, 760,
				Image.SCALE_AREA_AVERAGING));
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(0, 0, 760, 760);
		contentPane.add(lblNewLabel);

		// 键盘事件
		MyKeyAdapter adapter = new MyKeyAdapter(this);
		this.addKeyListener(adapter);

	}
}