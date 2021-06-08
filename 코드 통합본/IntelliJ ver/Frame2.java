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
    private ButtonHandler handler;
    private String[] ButtonBox;
    // no-argument constructor
    public Frame2()
    {

        super( "Panel Demo" ); // window title set
        buttons = new JButton[ 2 ][ 2 ];
        buttonJPanel = new JPanel();
        handler = new ButtonHandler();
        stringText = new JLabel("Choose Type or user"); // JLabel text set
        stringText.setHorizontalAlignment(SwingConstants.CENTER); // 가운데 정렬

        ButtonBox = new String[4];
        ButtonBox[0] = "권오민";
        ButtonBox[1] = "노현호";
        ButtonBox[2] = "신시온";
        ButtonBox[3] = "조동현";

        setSize(400, 500);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        buttonJPanel.setLayout(null);

        // Button 4개 추가하는 부분 + ActionListenter 추가
        for ( int row = 0; row < 2; row++ )
        {
            for ( int col = 0; col < 2; col++)
            {
                buttons[row][col] = new JButton(ButtonBox[row + col * 2]);
                buttons[row][col].setBounds(180 * row + 30, 200 * col + 100, 150, 150);
                add(buttons[row][col]);
                buttons[row][col].addActionListener( handler );
            }
        }

        add( stringText, BorderLayout.NORTH);
        add( buttonJPanel, BorderLayout.CENTER ); // add panel to JFrame

        setVisible(true);
    } // end PanelFrame constructor

    private class ButtonHandler implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand(); // test code
            if (cmd.equals(ButtonBox[0]))
            {
                System.out.println(e); // test code
                new Frame3(ButtonBox[0]);
                setVisible(false);
            }
            if (cmd.equals(ButtonBox[1]))
            {
                System.out.println(e); // test code
                new Frame3(ButtonBox[1]);
                setVisible(false);
            }
            if (cmd.equals(ButtonBox[2]))
            {
                System.out.println(e); // test code
                new Frame3(ButtonBox[2]);
                setVisible(false);
            }
            if (cmd.equals(ButtonBox[3]))
            {
                System.out.println(e); // test code
                new Frame3(ButtonBox[3]);
                setVisible(false);
            }
           //else if (cmd.equals(""))

        }
    }
} // end class PanelFrame

