import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

class ImagePanel extends JPanel{				//배경화면을 만들기 위한 이미지 패널 클래스 생성
	private Image img;
	public ImagePanel(Image img) {
		this.img = img;
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setLayout(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

public class Class4 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Class4 window = new Class4();
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
	public Class4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("HELLO");					//프로그램 이름
		frame.setBounds(100, 100, 400, 550);			//400*550으로 맞췄습니다
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel panel = new ImagePanel(new ImageIcon("./src/background.jpg").getImage());	//이미지 패널, src의 background.jpg 사용하였습니다
		frame.getContentPane().add(panel,BorderLayout.CENTER);
		JLabel lblNewLabel = new JLabel("어린 왕자");		//책 이름이 나타나는 자리인데 이것도 String 값 리턴하는 함수 만들어서 집어넣어야 할 것 같아요
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.yellow);		//JLabel 폰트 색상
		lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		lblNewLabel.setBounds(62, 31, 280, 67);
		panel.add(lblNewLabel);
		
		JButton ttsButton = new JButton("음성으로 듣기");	//TTS 프로그램 작동시키는 버튼, 기능 구현은 안돼있습니다.
		ttsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ttsButton.setBounds(62, 435, 103, 23);
		panel.add(ttsButton);
		
		JButton buyNow = new JButton("구매하러 가기");		//구매 페이지로 이동시키는 버튼, 이것도 uri값 리턴하는 함수 만들어야 할듯
		buyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jLabelClicked(e);
			}

			private void jLabelClicked(ActionEvent e) {	//여기가 클릭하면 이동하는 함수
				if (Desktop.isDesktopSupported()) {
		            Desktop desktop = Desktop.getDesktop();
		            try {
		                URI uri = new URI("http://www.yes24.com/Main/default.aspx/");
		                desktop.browse(uri);
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            } catch (URISyntaxException ex) {
		                ex.printStackTrace();
		            }
			}
			}
		});
		buyNow.setBounds(239, 435, 103, 23);
		panel.add(buyNow);
		
		JTextArea bookContent = new JTextArea();		//여기가 책 소개글이 나오는 자리, 소개글은 txt파일에 있는 거 쓰면 될 거 같아요
		bookContent.setText("");
		bookContent.setBounds(61, 99, 281, 293);
		panel.add(bookContent);
		Color ivory = new Color(255, 255, 240);
		bookContent.setBackground(ivory);
		bookContent.setForeground(Color.darkGray);
		
		JButton goBack = new JButton("\u25C0");			//뒤로가기 버튼인데 다른 클래스에 있는거 쓰시면 될듯
		goBack.setFont(new Font("굴림", Font.PLAIN, 15));
		goBack.setBorderPainted(false);					//버튼 경계 없애기
		goBack.setFocusPainted(false);					//버튼위에 마우스 올려도 반응없게
		goBack.setContentAreaFilled(false);				//버튼 색 없애기
		goBack.setForeground(Color.pink);				//버튼 폰트 색 칠하기
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		goBack.setBounds(12, 10, 50, 40);
		panel.add(goBack);
	}

}
