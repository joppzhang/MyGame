package cn.zpq.start;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import cn.zpq.map.load.LoadMap;
import cn.zpq.menu.MyMenu;

public class Welcome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static JProgressBar progressBar;
	static Welcome frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Welcome();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Welcome() {

		// 边框透明化
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(new ImageIcon(
				"src/cn/zpq/images/welcome.png"));
		lblNewLabel.setBounds(-45, 0, 955, 427);
		contentPane.add(lblNewLabel);
		// 窗口透明化
		this.setBackground(new Color(0, 0, 0, 0));
		contentPane.add(lblNewLabel);
		// 进度条
		progressBar = new JProgressBar();
		progressBar.setBounds(133, 353, 600, 14);
		contentPane.add(progressBar);

		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				setProgressBar();
			}
		}).start();
		new LoadMap();

	}

	private static void setProgressBar() {
		progressBar.setValue(0);
		progressBar.setMaximum(200);
		int i = 0;
		while (i < 201) {
			progressBar.setValue(i);
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}

		MyMenu.menu.setVisible(true);
		frame.setVisible(false);
	}
}
