//이클립스 사용할 경우
//import 패키지명 (default package라면 이름 바꿀 것)
//import Frame2

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
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
    private RoundedButton2 btnNewButton;
    private RoundedButton2 btnNewButton_1;
    private Book[] books;
    private int num;



    public Frame3(Frame2 prevPage, String User, Frame3[] pagelist, int order) {
        super( "Book Recommender" );
        ImagePanel frame = new ImagePanel(new ImageIcon("book3.jpg").getImage()); //이미지 불러오기
        num = order;
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
        lblNewLabel.setForeground(new Color(219, 216, 216));
        lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 25));
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
        lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(1, 347, 400, 41);
        lblNewLabel_1.setForeground(new Color(219, 216, 216));
        add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("저자 : " + books[num].getBookWriter());
        lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblNewLabel_2.setBounds(92, 398, 200, 26);
        lblNewLabel_2.setForeground(new Color(219, 216, 216));
        add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("출판 : " + books[num].getBookPublisher());
        lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        lblNewLabel_3.setBounds(92, 423, 223, 36);
        lblNewLabel_3.setForeground(new Color(219, 216, 216));
        add(lblNewLabel_3);


        btnNewButton = new RoundedButton2("◀");
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
        btnNewButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnNewButton.setBounds(12, 190, 60, 60);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(Color.PINK);
        add(btnNewButton);



        btnNewButton_1 = new RoundedButton2("▶");
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
        btnNewButton_1.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        btnNewButton_1.setBounds(313, 190, 60, 60);
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBackground(Color.PINK);
        add(btnNewButton_1);

        JButton ttsButton = new JButton(new ImageIcon("./tts.png"));	//TTS 프로그램 작동시키는 버튼, 기능 구현은 안돼있습니다.
        ttsButton.setBorderPainted(false);
        ttsButton.setContentAreaFilled(false);
        ttsButton.setToolTipText("음성으로 듣기");
        ttsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SynthesizeText(books[num].getBookContent());
                File file = new File("output.wav"); //여기서부터 clip.start()는 Mp3Player와 같은 역할을 합니다. 꼭 필요함
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
            }
        });
        ttsButton.setBounds(70, 455, 50, 50);
        add(ttsButton);

        JButton buyNow = new JButton(new ImageIcon("./cart.png"));		//구매 페이지로 이동시키는 버튼, 이것도 uri값 리턴하는 함수 만들어야 할듯
        buyNow.setBorderPainted(false);
        buyNow.setContentAreaFilled(false);
        buyNow.setToolTipText("구매하러 가기");
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
        buyNow.setBounds(260, 455, 50, 50);
        add(buyNow);

        add(frame);

    }

}
class RoundedButton2  extends JButton {     //버튼 둥글게 만드는 클래스  https://leirbag.tistory.com/15 참고했습니다.
    public RoundedButton2() { super(); decorate(); }
    public RoundedButton2(String text) { super(text); decorate(); }
    public RoundedButton2(Icon icon) { super(icon); decorate(); }
    public RoundedButton2(String text, Icon icon) { super(text, icon); decorate(); }
    protected void decorate() { setBorderPainted(false); setOpaque(false); }
    @Override
    protected void paintComponent(Graphics g) {
        Color c=new Color(196, 193, 193); //배경색 결정
        Color o=new Color(0, 0, 0); //글자색 결정
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isArmed()) { graphics.setColor(c.darker()); }
        else if (getModel().isRollover()) { graphics.setColor(c.brighter()); }
        else { graphics.setColor(c); }
        graphics.fillRoundRect(0, 0, width, height, 10, 10);
        FontMetrics fontMetrics = graphics.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
        int textX = (width - stringBounds.width) / 2;
        int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
        graphics.setColor(o);
        graphics.setFont(getFont());
        graphics.drawString(getText(), textX, textY);
        graphics.dispose();
        super.paintComponent(g);
    }
}
