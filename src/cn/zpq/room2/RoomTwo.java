package cn.zpq.room2;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.zpq.characteract.ArrayOfPerson;
import cn.zpq.map.load.LoadMap;
import cn.zpq.room2.movecontrol.MyKeyAdapter2;

public class RoomTwo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JLabel personOfRoom2;
	// 村长模型
	public static JLabel headOfVillageSmall;
	// 村长头像
	public static JLabel headOfVillage;
	// 主角头像
	public static JLabel hero;
	// 大祭司模型
	public static JLabel wizardSmall;
	// 大祭司头像
	public static JLabel wizard;
	// 对话板
	public static JLabel talkLable;
	// 戴眼镜村长头像
	public static JLabel glassOnHeadOfVillage;
	// 对话文本
	public static JLabel talkText;

	// Test
	// public static void main(String[] args) {
	// RoomTwo room = new RoomTwo();
	// room.setVisible(true);
	// }

	/**
	 * Create the frame.
	 */
	public RoomTwo() {
		new LoadMap();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 510, 437);
		contentPane = new JPanel();
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 对话的白色底版
		ImageIcon talkWindow = new ImageIcon("src/cn/zpq/images/room2talk.png");
		talkWindow.setImage(talkWindow.getImage().getScaledInstance(485, 145,
				Image.SCALE_AREA_AVERAGING));

		// 对话文本
		talkText = new JLabel("");
		talkText.setFont(new Font("楷体", Font.BOLD, 18));
		talkText.setBounds(10, 250, 485, 145);
		contentPane.add(talkText);
		talkText.setVisible(true);
		talkLable = new JLabel(talkWindow);
		talkLable.setFont(new Font("楷体", Font.BOLD, 18));
		talkLable.setBounds(10, 250, 485, 145);
		contentPane.add(talkLable);
		talkText.setVisible(false);
		talkLable.setVisible(false);

		// 主角对话头像
		ImageIcon heroimg = new ImageIcon("src/cn/zpq/roleimg/勇士.png");
		heroimg.setImage(heroimg.getImage().getScaledInstance(70, 70,
				Image.SCALE_AREA_AVERAGING));
		hero = new JLabel(heroimg);
		hero.setBounds(50, 180, 70, 70);
		contentPane.add(hero);
		hero.setVisible(false);

		// 村长对话头像
		ImageIcon headOfVillageimg = new ImageIcon("src/cn/zpq/roleimg/村长.png");
		headOfVillageimg.setImage(headOfVillageimg.getImage()
				.getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		headOfVillage = new JLabel(headOfVillageimg);
		headOfVillage.setBounds(400, 180, 70, 70);
		contentPane.add(headOfVillage);
		headOfVillage.setVisible(false);

		// 村长戴眼镜对话头像
		ImageIcon glassOnHeadOfVillageimg = new ImageIcon(
				"src/cn/zpq/roleimg/村长戴眼镜.png");
		glassOnHeadOfVillageimg.setImage(glassOnHeadOfVillageimg.getImage()
				.getScaledInstance(70, 70, Image.SCALE_AREA_AVERAGING));
		glassOnHeadOfVillage = new JLabel(glassOnHeadOfVillageimg);
		glassOnHeadOfVillage.setBounds(400, 180, 70, 70);
		contentPane.add(glassOnHeadOfVillage);
		glassOnHeadOfVillage.setVisible(false);

		// 大祭司头像
		ImageIcon wizardimg = new ImageIcon("src/cn/zpq/roleimg/大祭司.png");
		wizardimg.setImage(wizardimg.getImage().getScaledInstance(70, 70,
				Image.SCALE_AREA_AVERAGING));
		wizard = new JLabel(wizardimg);
		wizard.setBounds(400, 180, 70, 70);
		contentPane.add(wizard);
		wizard.setVisible(false);

		// 村长模型
		ImageIcon headOfVillageSmallimg = new ImageIcon(
				"src/cn/zpq/roleimg/small/村长小.png");
		headOfVillageSmallimg.setImage(headOfVillageSmallimg.getImage()
				.getScaledInstance(30, 30, Image.SCALE_AREA_AVERAGING));
		headOfVillageSmall = new JLabel(headOfVillageSmallimg);
		headOfVillageSmall.setBounds(262, 166, 30, 30);
		contentPane.add(headOfVillageSmall);
		headOfVillageSmall.setVisible(false);

		// 大祭司模型
		ImageIcon wizardSmallimg = new ImageIcon(
				"src/cn/zpq/roleimg/small/大祭司小.png");
		wizardSmallimg.setImage(wizardSmallimg.getImage().getScaledInstance(30,
				30, Image.SCALE_AREA_AVERAGING));
		wizardSmall = new JLabel(wizardSmallimg);
		wizardSmall.setBounds(358, 310, 30, 30);
		contentPane.add(wizardSmall);
		wizardSmall.setVisible(false);

		// 主角模型
		ImageIcon imageIcon = new ImageIcon(ArrayOfPerson.up[0]);
		imageIcon.setImage(imageIcon.getImage().getScaledInstance(30, 30,
				Image.SCALE_AREA_AVERAGING));
		personOfRoom2 = new JLabel(imageIcon);
		personOfRoom2.setBounds(237, 380, 30, 30);
		contentPane.add(personOfRoom2);

		// 房间背景
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(RoomTwo.class
				.getResource("/cn/zpq/images/room2.png")));
		lblNewLabel.setBounds(0, 0, 504, 408);
		contentPane.add(lblNewLabel);
		MyKeyAdapter2 adapter = new MyKeyAdapter2(this);
		this.addKeyListener(adapter);
	}

}
