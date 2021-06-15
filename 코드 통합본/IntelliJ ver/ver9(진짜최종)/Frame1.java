import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.IOException;


public class Frame1 extends JFrame {

    private JFrame frame;
    private JTextField txtAdmin;
    private JPasswordField pwdPassword;
    private Frame2 nextPage;

    public Frame1() {
        frame = new JFrame();
        nextPage = new Frame2();

        ImagePanel welcomePanel = new ImagePanel(new ImageIcon("book.jpeg").getImage()); //이미지 불러오기
        setSize(400, 550); // 이미지의 크기에 맞게 프레임 설정함
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        add(welcomePanel, BorderLayout.CENTER);

        JLabel id = new JLabel("ID");  //아이디 라벨
        id.setForeground(new Color(219, 216, 216));
        id.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 30));
        id.setHorizontalAlignment(SwingConstants.CENTER);
        id.setBounds(80, 236, 98, 47);
        welcomePanel.add(id);

        txtAdmin = new RoundJTextField(0);  //아이디 입력칸
        txtAdmin.setSelectedTextColor(new Color(219, 216, 216));
        txtAdmin.setSelectionColor(new Color(47, 34, 34));
        txtAdmin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtAdmin.getText().equals("admin")) {
                    txtAdmin.setText("");   //마우스로 눌렀을때 admin 사라지는 효과
                } else {
                    txtAdmin.selectAll();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtAdmin.getText().equals("")) {
                    txtAdmin.setText("admin");         //다른 화면을 마우스 눌렀을때 다시 admin 생김
                }
            }
        });
        txtAdmin.setForeground(new Color(219, 216, 216));
        txtAdmin.setHorizontalAlignment(SwingConstants.LEFT);
        txtAdmin.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 30));
        txtAdmin.setText("admin");
        txtAdmin.setBackground(new Color(184, 178, 170));
        txtAdmin.setBounds(202, 236, 123, 47);
        welcomePanel.add(txtAdmin);
        txtAdmin.setColumns(10);

        RoundedButton2 btnNewButton = new RoundedButton2("ENTER");  //로그인 버튼
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (txtAdmin.getText().equals("ron") && pwdPassword.getText().equals("1234")) {
                    nextPage.setLocation(getLocation());
                    nextPage.setVisible(true);
                    setVisible(false);
                    new SynthesizeText("Ron 님, 반갑습니다.");
                    File file = new File("output.wav");
                    AudioInputStream audioStream = null;
                    try {
                        audioStream = AudioSystem.getAudioInputStream(file);
                    } catch (UnsupportedAudioFileException unsupportedAudioFileException) {
                        unsupportedAudioFileException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    Clip clip = null;
                    try {
                        clip = AudioSystem.getClip();
                    } catch (LineUnavailableException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    }
                    try {
                        clip.open(audioStream);
                    } catch (LineUnavailableException lineUnavailableException) {
                        lineUnavailableException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    clip.start();

                } else if (txtAdmin.getText().equals("") || txtAdmin.getText().equals("admin") ||
                        pwdPassword.getText().equals("") || pwdPassword.getText().equals("Password")) {
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하시오");
                    //아이디와 비밀번호 입력하지않고 로그인 눌렀을때
                } else {
                    JOptionPane.showMessageDialog(null, "아이디와 비밀번호가 맞지 않습니다.");
                    //아이디와 비밀번호 틀렸을때
                }
            }
        });
        btnNewButton.setToolTipText("\uB85C\uADF8\uC778\uD558\uB824\uBA74 \uD074\uB9AD\uD558\uC138\uC694");
        btnNewButton.setBorderPainted(false); //버튼 테두리 없애기
        btnNewButton.setFont(new Font("High Tower Text", Font.BOLD | Font.ITALIC, 26));
        btnNewButton.setBounds(80, 390, 245, 52);
        welcomePanel.add(btnNewButton);

        JLabel lblNewLabel = new JLabel("BOOK Recommender");   //제목 라벨
        lblNewLabel.setForeground(new Color(219, 216, 216));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Felix Titling", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(40, 128, 300, 78);
        welcomePanel.add(lblNewLabel);

        JLabel lblPw = new JLabel("PW");  //PW라벨
        lblPw.setHorizontalAlignment(SwingConstants.CENTER);
        lblPw.setForeground(new Color(219, 216, 216));
        lblPw.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 30));
        lblPw.setBounds(80, 304, 98, 47);
        welcomePanel.add(lblPw);

        pwdPassword = new RoundPassword(0);  //PW입력
        pwdPassword.setSelectionColor(new Color(47, 34, 34));
        pwdPassword.setHorizontalAlignment(SwingConstants.LEFT);
        pwdPassword.setText("Password");
        pwdPassword.setBackground(new Color(184, 178, 170));
        pwdPassword.setForeground(new Color(219, 216, 216));
        pwdPassword.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
        pwdPassword.setSelectionColor(new Color(219, 216, 216));
        pwdPassword.setBounds(202, 305, 123, 45);
        pwdPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (pwdPassword.getText().equals("Password")) {
                    pwdPassword.setEchoChar('●');     //아무것도입력하지않았을때 O표시
                    pwdPassword.setText("");
                } else {
                    pwdPassword.getSelectedText();
                }
            }

            @Override
            public void focusLost(FocusEvent e) {   //마우스 다시 눌렀을때 O사라짐
                if (pwdPassword.getText().equals("")) {
                    pwdPassword.setText("Password");
                    pwdPassword.setEchoChar('●');
                }
            }
        });
        welcomePanel.add(pwdPassword);
        frame.setResizable(false);  //frame 사이즈 조정 불가
        frame.setLocationRelativeTo(null); //창 가운데서 실행됨
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class ImagePanel extends JPanel{   //이미지패널
    private Image img;

    public ImagePanel(Image img) {
        this.img = img;
        setSize(new Dimension(img.getWidth(null),img.getHeight(null))); //사진에 맞게 자동 조정
        setPreferredSize(new Dimension(img.getWidth(null),img.getHeight(null)));
        setLayout(null);
    }
    public int getWidth()
    {//이미지의 가로길이 숫자로 알려줌
        return img.getWidth(null);
    }
    public int getHeight() {
        //이미지의 세로길이
        return img.getHeight(null);
    }

    public void paintComponent(Graphics g) { //사진 불러옴
        g.drawImage(img, 0, 0, null);
    }
}

class RoundJTextField extends JTextField {  //텍스트 필드 둥글게 만드는 클래스  https://leirbag.tistory.com/16?category=889746 참고했습니다.
    private Shape shape;
    public RoundJTextField(int size) {
        super(size);
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}
class RoundPassword extends JPasswordField {  //패스워드 필드 둥글게 만드는 클래스 https://leirbag.tistory.com/16?category=889746 참고했습니다.
    private Shape shape;
    public RoundPassword (int size) {
        super(size);
        setOpaque(false);
    }
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(g);
    }
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
    }
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        }
        return shape.contains(x, y);
    }
}

