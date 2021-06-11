//이클립스 사용할 경우
//import 패키지명 (default package라면 이름 바꿀 것)
//import Frame2

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Frame3 extends JFrame{

    private JPanel frame;
    private JLabel lblNewLabel;
    private JLabel imgLabel;
    private Mp3Player test;
    private Book bookInfo;

    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private Book[] books;
    private int num;


    public Frame3(Frame2 prevPage, String User, Frame3[] pagelist, int order) {
        super( "Panel Demo" );
        num = order;
        frame = new JPanel();
        frame.setLayout(null);
        books = new Book[4];
        for (int i = 0; i < 4; i++)
        {
            books[i] = new Book("./bookData/"+ User + "/" + User + i + ".txt");
        }

        setSize(400, 550);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        lblNewLabel = new JLabel(User+"의 책추천");
        lblNewLabel.setBounds(63, 20, 260, 41);
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel);

        imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon("./bookData/"+ User + "/" + User + num + ".JPG");
        Image img = icon.getImage();
        Image udicon = img.getScaledInstance(194, 250,
                Image.SCALE_SMOOTH);
        ImageIcon update = new ImageIcon(udicon);
        imgLabel.setIcon(update);
        imgLabel.setBounds(92, 87, 194, 250);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imgLabel);

        lblNewLabel_1 = new JLabel(books[num].getBookTitle());
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(1, 347, 400, 41);
        add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("저자 : " + books[num].getBookWriter());
        lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(92, 398, 153, 26);
        add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("출판 : " + books[num].getBookPublisher());
        lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(92, 423, 223, 36);
        add(lblNewLabel_3);


        btnNewButton = new JButton("◀");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (num == 0)
                {
                    prevPage.setLocation(getLocation());
                    prevPage.setVisible(true);
                    setVisible(false);
                }

                else if (num == 1)
                {
                    pagelist[0].setLocation(getLocation());
                    pagelist[0].setVisible(true);
                    setVisible(false);
                }

                else if (num == 2)
                {
                    pagelist[1].setLocation(getLocation());
                    pagelist[1].setVisible(true);
                    setVisible(false);
                }

                else if (num == 3)
                {
                    pagelist[2].setLocation(getLocation());
                    pagelist[2].setVisible(true);
                    setVisible(false);
                }
            }
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton.setBounds(12, 190, 60, 60);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(Color.PINK);
        add(btnNewButton);



        btnNewButton_1 = new JButton("▶");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (num == 0)
                {
                    pagelist[1].setLocation(getLocation());
                    pagelist[1].setVisible(true);
                    setVisible(false);
                }

                else if (num == 1)
                {
                    pagelist[2].setLocation(getLocation());
                    pagelist[2].setVisible(true);
                    setVisible(false);
                }

                else if (num == 2)
                {
                    pagelist[3].setLocation(getLocation());
                    pagelist[3].setVisible(true);
                    setVisible(false);
                }

                else if (num == 3)
                {
                    prevPage.setLocation(getLocation());
                    prevPage.setVisible(true);
                    setVisible(false);
                }

            }
        });
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton_1.setBounds(313, 190, 60, 60);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBackground(Color.PINK);
        add(btnNewButton_1);

        JButton ttsButton = new JButton("음성으로 듣기");	//TTS 프로그램 작동시키는 버튼, 기능 구현은 안돼있습니다.
        ttsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
        ttsButton.setBounds(70, 455, 100, 23);
        add(ttsButton);

        JButton buyNow = new JButton("구매하러 가기");		//구매 페이지로 이동시키는 버튼, 이것도 uri값 리턴하는 함수 만들어야 할듯
        buyNow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jLabelClicked(e);
            }

            private void jLabelClicked(ActionEvent e) {	//여기가 클릭하면 이동하는 함수
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        URI uri = new URI(books[num].getBookLink());
                        desktop.browse(uri);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    } catch (URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        buyNow.setBounds(230, 455, 100, 23);
        add(buyNow);

        add(frame);

    }

}
