//이클립스 사용할 경우
//import 패키지명 (default package라면 이름 바꿀 것)
//import recommend1

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Frame2 extends JFrame
{
    private JLabel stringText; // 제일 위에 텍스트
    private JPanel buttonJPanel; // 버튼 4개 있는 격자
    private JButton[][] buttons; // array of buttons
//    private ButtonHandler handler;
    private String[] ButtonBox;
    private Frame3[][] nextPanel;
    private JLabel introText;
    private JLabel label1;
    private Image background;

    // public void paint(Graphics g) {//그리는 함수
    //   g.drawImage(background, 0, 0, null);//background를 그려줌
    //}
    // no-argument constructor
    public Frame2()
    {


        super( "EBOOK READER" ); // window title set
        //background = new ImageIcon("book3.jpg").getImage();
        ImagePanel secondPanel = new ImagePanel(new ImageIcon("book3.jpg").getImage()); //새로운 패널 추가
        add(secondPanel,BorderLayout.CENTER);
        buttons = new JButton[ 2 ][ 2 ];
        buttonJPanel = new JPanel();
//        handler = new ButtonHandler();
        stringText = new JLabel("WELCOME RON"); // JLabel text set
        stringText.setBounds(33,10,210,50);
        stringText.setForeground(new Color(219, 216, 216));
        stringText.setFont(new Font("Felix Titling", Font.BOLD | Font.ITALIC, 25));
        introText = new JLabel("버튼을 누르면 추천작품으로 이동합니다"); //설명 넣은 텍스트
        introText.setBounds(33,15,250,100);
        introText.setForeground(new Color(219, 216, 216));
        setLayout(null);

        //stringText.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬
        //여기에 JLabel 폰트 추가

        ButtonBox = new String[4];
        ButtonBox[0] = "권오민";
        ButtonBox[1] = "노현호";
        ButtonBox[2] = "신시온";
        ButtonBox[3] = "조동현";


        nextPanel = new Frame3[4][4];
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
                nextPanel[i][j] = new Frame3(this, ButtonBox[i], nextPanel[i], j);
        }

        setSize(400, 550);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        buttonJPanel.setLayout(null);

        // Button 4개 추가하는 부분 + ActionListenter 추가
        buttons[0][0] = new JButton(new ImageIcon("./lion.png"));
        buttons[0][1] = new JButton(new ImageIcon("./scale.png"));
        buttons[1][0] = new JButton(new ImageIcon("./human.png"));
        buttons[1][1] = new JButton(new ImageIcon("./scolpion.png"));
        for ( int row = 0; row < 2; row++ )
        {
            for ( int col = 0; col < 2; col++)
            {

//                buttons[row][col] = new RoundedButton2(ButtonBox[row + col * 2]);
                buttons[row][col].setContentAreaFilled(false);
                buttons[row][col].setBorderPainted(false);
                buttons[row][col].setBounds(180 * row + 30, 200 * col + 100, 150, 150);
                secondPanel.add(buttons[row][col]);
//                buttons[row][col].addActionListener( handler );
            }
        }
        buttons[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPanel[0][0].setLocation(getLocation());
                nextPanel[0][0].setVisible(true);
                setVisible(false);
            }
        });
        buttons[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPanel[1][0].setLocation(getLocation());
                nextPanel[1][0].setVisible(true);
                setVisible(false);
            }
        });
        buttons[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPanel[2][0].setLocation(getLocation());
                nextPanel[2][0].setVisible(true);
                setVisible(false);
            }
        });
        buttons[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPanel[3][0].setLocation(getLocation());
                nextPanel[3][0].setVisible(true);
                setVisible(false);
            }
        });

        secondPanel.add(introText);
        secondPanel.add(stringText);
        add( buttonJPanel, BorderLayout.CENTER ); // add panel to JFrame


    } // end PanelFrame constructor

//    private class ButtonHandler implements ActionListener
//    {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            String cmd = e.getActionCommand();
//
//            if (cmd.equals(ButtonBox[0]))
//            {
//                nextPanel[0][0].setLocation(getLocation());
//                nextPanel[0][0].setVisible(true);
//                setVisible(false);
//            }
//            else if (cmd.equals(ButtonBox[1]))
//            {
//                nextPanel[1][0].setLocation(getLocation());
//                nextPanel[1][0].setVisible(true);
//                setVisible(false);
//            }
//            else if (cmd.equals(ButtonBox[2]))
//            {
//                nextPanel[2][0].setLocation(getLocation());
//                nextPanel[2][0].setVisible(true);
//                setVisible(false);
//            }
//            else if (cmd.equals(ButtonBox[3]))
//            {
//                nextPanel[3][0].setLocation(getLocation());
//                nextPanel[3][0].setVisible(true);
//                setVisible(false);
//            }
//
//        }
//    }
} // end class PanelFrame

