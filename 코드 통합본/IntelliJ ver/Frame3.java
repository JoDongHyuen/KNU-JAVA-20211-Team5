//이클립스 사용할 경우
//import 패키지명 (default package라면 이름 바꿀 것)
//import Frame2

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame3 extends JFrame{

    private JPanel frame;
    private JLabel lblNewLabel;
    private JLabel imgLabel;

    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JButton btnNewButton;
    private JButton btnNewButton_1;


    public Frame3(String User) {
        super( "Panel Demo" );
        frame = new JPanel();
        frame.setLayout(null);

        setSize(400, 500);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        lblNewLabel = new JLabel(User+"의 책추천");
        lblNewLabel.setBounds(63, 20, 260, 41);
        lblNewLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
        lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblNewLabel);

        imgLabel = new JLabel();
        ImageIcon icon = new ImageIcon("it.jpg");
        Image img = icon.getImage();
        Image udicon = img.getScaledInstance(194, 250,
                Image.SCALE_SMOOTH);
        ImageIcon update = new ImageIcon(udicon);
        imgLabel.setIcon(update);
        imgLabel.setBounds(92, 87, 194, 250);
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imgLabel);

        lblNewLabel_1 = new JLabel("IT 개발자의 거의 모든 것");
        lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(63, 347, 260, 41);
        add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("저자 : 이병덕");
        lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(92, 398, 153, 26);
        add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("출판 : 미래의 창");
        lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 15));
        lblNewLabel_3.setBounds(92, 423, 223, 36);
        add(lblNewLabel_3);


        btnNewButton = new JButton("◀");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Frame2();
                setVisible(false);
            }
        });
        btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton.setBounds(12, 190, 60, 60);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(Color.PINK);
        add(btnNewButton);



        btnNewButton_1 = new JButton("▶");
        btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
        btnNewButton_1.setBounds(313, 190, 60, 60);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBackground(Color.PINK);
        add(btnNewButton_1);

        add(frame);

        setVisible(true);
    }
}
