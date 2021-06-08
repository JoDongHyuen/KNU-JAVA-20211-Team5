package bookmain;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class recommend1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recommend1 window = new recommend1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public recommend1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.PINK);
		
		JLabel lblNewLabel = new JLabel("±Ç¿À¹ÎÀÇ Ã¥ÃßÃµ");
		lblNewLabel.setBounds(63, 20, 260, 41);
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 30));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel imgLabel = new JLabel();
		
		ImageIcon icon = new ImageIcon("C:\\Users\\dhals\\Desktop\\java_team\\bookmain\\src\\bookmain/it.jpg");
		
		Image img = icon.getImage();
		Image udicon = img.getScaledInstance(194, 250, 
				Image.SCALE_SMOOTH);
		ImageIcon update = new ImageIcon(udicon);
		
		imgLabel.setIcon(update);
		
		imgLabel.setBounds(92, 87, 194, 250);
		imgLabel.setHorizontalAlignment(JLabel.CENTER);
		
		frame.getContentPane().add(imgLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IT °³¹ßÀÚÀÇ °ÅÀÇ ¸ðµç °Í");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(63, 347, 260, 41);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ÀúÀÚ : ÀÌº´´ö");
		lblNewLabel_2.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(92, 398, 153, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ÃâÆÇ : ¹Ì·¡ÀÇ Ã¢");
		lblNewLabel_3.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(92, 423, 223, 36);
		frame.getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("¢¸");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton.setBounds(12, 190, 60, 60);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(Color.PINK);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("¢º");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		btnNewButton_1.setBounds(313, 190, 60, 60);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(Color.PINK);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
	}
}
