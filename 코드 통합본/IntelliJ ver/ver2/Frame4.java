import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

class ImagePanel1 extends JPanel{				//배경화면을 만들기 위한 이미지 패널 클래스 생성
    private Image img;
    public ImagePanel1(Image img) {
        this.img = img;
        setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setLayout(null);
    }
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}

public class Frame4 extends JFrame{

    private JFrame frame;
    private JButton btnNewButton;
    private Book bookInfo;
    private Mp3Player test;
    /**
     * Create the application.
     */
    public Frame4(Frame3 prevPage, Book bookInfo) {
        frame = new JFrame("HELLO");					//프로그램 이름
        setBounds(100, 100, 400, 550);			//400*550으로 맞췄습니다
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel panel = new ImagePanel(new ImageIcon("book.jpg").getImage());	//이미지 패널, src의 background.jpg 사용하였습니다
        add(panel,BorderLayout.CENTER);
        JLabel lblNewLabel = new JLabel("어린 왕자");		//책 이름이 나타나는 자리인데 이것도 String 값 리턴하는 함수 만들어서 집어넣어야 할 것 같아요
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(Color.yellow);		//JLabel 폰트 색상
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
        lblNewLabel.setBounds(62, 31, 280, 67);
        panel.add(lblNewLabel);

        JButton ttsButton = new JButton("음성으로 듣기");	//TTS 프로그램 작동시키는 버튼, 기능 구현은 안돼있습니다.
        ttsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SynthesizeText("안녕하세요 이북 서비스입니다. 만나서 반갑습니다");
                test = new Mp3Player("output.mp3");
                test.run();
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
                        URI uri = new URI(bookInfo.getBookLink());
                        test.close();
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
        bookContent.setText(bookInfo.getBookContent());
        bookContent.setBounds(81, 99, 281, 293);
        panel.add(bookContent);
        Color ivory = new Color(255, 255, 240);
        bookContent.setBackground(ivory);
        bookContent.setForeground(Color.darkGray);

        btnNewButton = new JButton("◀");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                test.close();
                prevPage.setLocation(getLocation());
                prevPage.setVisible(true);
                setVisible(false);
            }
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton.setBounds(12, 190, 60, 60);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(Color.PINK);
        panel.add(btnNewButton);
    }

}
