import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Component;
import java.awt.Desktop.Action;


public class ebook {

	private JFrame frame;
	private JTextField txtAdmin;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ebook window = new ebook();
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
	public ebook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		ImagePanel welcomePanel = new ImagePanel(new ImageIcon("C:\\Users\\shgus\\eclipse-workspace\\Ebook\\image/book.jpg").getImage()); //이미지 불러오기
		frame.setSize(400, 550); // 이미지의 크기에 맞게 프레임 설정함 
		frame.getContentPane().add(welcomePanel, BorderLayout.CENTER);
		
		JLabel id = new JLabel("ID");  //아이디 라벨
		id.setForeground(new Color(255, 218, 185));
		id.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 30));
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(80, 236, 98, 47);
		welcomePanel.add(id);
		
		txtAdmin = new RoundJTextField(0);  //아이디 입력칸 
		txtAdmin.setSelectedTextColor(new Color(255, 250, 240));
		txtAdmin.setSelectionColor(new Color(222, 184, 135));
		txtAdmin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtAdmin.getText().equals("admin")) {
					txtAdmin.setText("");   //마우스로 눌렀을때 admin 사라지는 효과
				}
				else
				{
					txtAdmin.selectAll(); 
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtAdmin.getText().equals("")) {
					txtAdmin.setText("admin");         //다른 화면을 마우스 눌렀을때 다시 admin 생김 
				}
			}
		});
		txtAdmin.setForeground(new Color(255, 250, 205));
		txtAdmin.setHorizontalAlignment(SwingConstants.LEFT);
		txtAdmin.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 30));
		txtAdmin.setText("admin");
		txtAdmin.setBackground(new Color(222, 184, 135));
		txtAdmin.setBounds(202, 236, 123, 47);
		welcomePanel.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		RoundedButton btnNewButton = new RoundedButton("ENTER");  //로그인 버튼
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtAdmin.getText().equals("ron")&& pwdPassword.getText().equals("1234")) {
					// 계정이 맞았을때 
					System.out.println("welcome ron");
					// 이 칸에 다음 패널 .setvisible(true);
				}
				else if (txtAdmin.getText().equals("")|| txtAdmin.getText().equals("admin")||
						pwdPassword.getText().equals("")||pwdPassword.getText().equals("Password")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하시오");
					//아이디와 비밀번호 입력하지않고 로그인 눌렀을때
				}
				else {
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
		
		JLabel lblNewLabel = new JLabel("EBOOK READER");   //제목 라벨
		lblNewLabel.setForeground(new Color(204, 153, 102));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Felix Titling", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(80, 128, 245, 78);
		welcomePanel.add(lblNewLabel);
		
		JLabel lblPw = new JLabel("PW");  //PW라벨
		lblPw.setHorizontalAlignment(SwingConstants.CENTER);
		lblPw.setForeground(new Color(255, 218, 185));
		lblPw.setFont(new Font("Rage Italic", Font.BOLD | Font.ITALIC, 30));
		lblPw.setBounds(80, 304, 98, 47);
		welcomePanel.add(lblPw);
		
		pwdPassword = new RoundPassword(0);  //PW입력 칸
		pwdPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(pwdPassword.getText().equals("Password")) {	
					pwdPassword.setEchoChar('●');     //아무것도입력하지않았을때 O표시
					pwdPassword.setText("");
				}
				else {
					pwdPassword.getSelectedText();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {   //마우스 다시 눌렀을때 O사라짐
				if(pwdPassword.getText().equals("")) {   
					pwdPassword.setText("Password");
					pwdPassword.setEchoChar('●');
				}
			}
		});
		pwdPassword.setSelectionColor(new Color(222, 184, 135));
		pwdPassword.setHorizontalAlignment(SwingConstants.LEFT);
		pwdPassword.setText("Password");
		pwdPassword.setBackground(new Color(222, 184, 135));
		pwdPassword.setForeground(new Color(255, 250, 205));
		pwdPassword.setFont(new Font("Microsoft YaHei", Font.PLAIN, 17));
		pwdPassword.setSelectedTextColor(new Color(255, 250, 240));
		pwdPassword.setBounds(202, 305, 123, 45);
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
class RoundedButton  extends JButton {     //버튼 둥글게 만드는 클래스  https://leirbag.tistory.com/15 참고했습니다.
    public RoundedButton() { super(); decorate(); } 
    public RoundedButton(String text) { super(text); decorate(); } 
    public RoundedButton(Action action) { super(action); decorate(); } 
    public RoundedButton(Icon icon) { super(icon); decorate(); } 
    public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
    protected void decorate() { setBorderPainted(false); setOpaque(false); }
    @Override 
    protected void paintComponent(Graphics g) {
       Color c=new Color(245, 222, 179); //배경색 결정
       Color o=new Color(222, 184, 135); //글자색 결정
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

