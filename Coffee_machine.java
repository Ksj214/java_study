package 자바XXVII_그래픽;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class Coffee_machine extends JFrame implements ActionListener {
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Font font15 = new Font("SansSerif", Font.PLAIN, 15);
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font20b = new Font("SansSerif", Font.BOLD, 20);
	Font font30 = new Font("SansSerif", Font.PLAIN, 30);
	Font font30b = new Font("SansSerif", Font.BOLD, 30);
	
	JButton button_americano = new JButton("");
	JButton button_mocha = new JButton("");
	JButton button_capuccino = new JButton("");
	JLabel label_selDrink = new JLabel("");
	JLabel label_drinkName = new JLabel("\uC74C\uB8CC\uBA85");
	JLabel label_drinkCost = new JLabel("-\uC6D0");
	JLabel lblNewLabel_drinkQuan = new JLabel("\uC218\uB7C9");
	JButton btnDrinkPlus = new JButton("\uC218\uB7C9+1");
	JButton btnDrinkMinus = new JButton("\uC218\uB7C9-1");
	JButton btnDrinkCancel = new JButton("\uCDE8\uC18C\uD558\uAE30");
	
	JButton btnCookie = new JButton("");
	JButton btnCake = new JButton("");
	JButton btnMacaron = new JButton("New button");
	JLabel label_cookieIcon = new JLabel("");
	JLabel Label_cookieName = new JLabel("\uAC04\uC2DD\uBA85");
	JLabel label_cookieQuan = new JLabel("\uC218\uB7C9");
	JLabel Label_cookieCost = new JLabel("-\uC6D0");
	JButton btnCookiePlus = new JButton("\uC218\uB7C9+1");
	JButton btnCookieMinus = new JButton("\uC218\uB7C9-1");
	JButton btnCookieCancel = new JButton("\uCDE8\uC18C\uD558\uAE30");
	
	JRadioButton rdbtntakeOut = new JRadioButton("\uD14C\uC774\uD06C\uC544\uC6C3(Take out)");
	JRadioButton rdbtneatIn = new JRadioButton("\uBA39\uACE0 \uAC00\uAE30(eat in)");
	JButton btnBuy = new JButton("\uAD6C\uB9E4\uD558\uAE30");
	
	JLabel lbName1 = new JLabel("\uBAA8\uCE74 \uCEE4\uD53C");
	JLabel lbName2 = new JLabel("\uC544\uBA54\uB9AC\uCE74\uB178");
	JLabel lbName3 = new JLabel("\uCE74\uD478\uCE58\uB178");
	JLabel lbName4 = new JLabel("\uC218\uC81C \uCFE0\uD0A4");
	JLabel lbName5 = new JLabel("\uC870\uAC01 \uCF00\uC774\uD06C");
	JLabel lbName6 = new JLabel("\uB9C8\uCE74\uB871");
	
	JLabel lbQuan1 = new JLabel("\uC7AC\uACE0 : 10\uAC1C");
	JLabel lbQuan2 = new JLabel("\uC7AC\uACE0 : 10\uAC1C");
	JLabel lbQuan3 = new JLabel("\uC7AC\uACE0 : 10\uAC1C");
	JLabel lbQuan4 = new JLabel("\uC7AC\uACE0 : 10\uAC1C");
	JLabel lbQuan5 = new JLabel("\uC7AC\uACE0 : 10\uAC1C");
	JLabel lbQuan6 = new JLabel("\uC7AC\uACE0 : 10\uAC1C");
	
	JLabel lbCost1 = new JLabel("2500\uC6D0");
	JLabel lbCost2 = new JLabel("2000\uC6D0");
	JLabel lbCost3 = new JLabel("4000\uC6D0");
	JLabel lbCost4 = new JLabel("3000\uC6D0");
	JLabel lbCost5 = new JLabel("8000\uC6D0");
	JLabel lbCost6 = new JLabel("5000\uC6D0");
	
	private String coffee[][] = new String[6][3];
	
	private String drinkName = ""; //커피 이름
	private int drinkQuan = 0; //커피 수량
	private int drinkCost = 0; //커피 가격
	
	private String cookieName = ""; //간식 이름
	private int cookieQuan = 0; //간식 수량
	private int cookieCost = 0; //간식 가격
	
	private String takeOut = ""; //테이크아웃 여부
	
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	private String name5;
	private String name6;
	
	private int quan1;
	private int quan2;
	private int quan3;
	private int quan4;
	private int quan5;
	private int quan6;
	
	private int cost1;
	private int cost2;
	private int cost3;
	private int cost4;
	private int cost5;
	private int cost6;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coffee_machine frame = new Coffee_machine();
					frame.setVisible(true);
					frame.center();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Coffee_machine() {
		super("카페 무인 주문기");
		
		setFont(new Font("Dialog", Font.PLAIN, 30));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(110, 103, 57, 15);
		contentPane.add(label);
		
		button_americano.addActionListener(this);
		button_mocha.addActionListener(this);
		button_capuccino.addActionListener(this);
		btnDrinkPlus.addActionListener(this);
		btnDrinkMinus.addActionListener(this);
		btnDrinkCancel.setEnabled(false);
		btnDrinkCancel.addActionListener(this);
		
		btnCookie.addActionListener(this);
		btnCake.addActionListener(this);
		btnMacaron.addActionListener(this);
		btnCookiePlus.addActionListener(this);
		btnCookieMinus.addActionListener(this);
		btnCookieCancel.setEnabled(false);
		btnCookieCancel.addActionListener(this);
		rdbtntakeOut.setBackground(new Color(255, 255, 224));
		rdbtntakeOut.setEnabled(false);
		
		rdbtntakeOut.addActionListener(this);
		rdbtneatIn.setBackground(new Color(255, 255, 224));
		rdbtneatIn.setEnabled(false);
		rdbtneatIn.addActionListener(this);
		btnBuy.setEnabled(false);
		btnBuy.addActionListener(this);
		
		btnDrinkPlus.setEnabled(false);
		btnDrinkMinus.setEnabled(false);
		
		btnCookiePlus.setEnabled(false);
		btnCookieMinus.setEnabled(false);
		
		
		button_americano.setToolTipText("\uC544\uBA54\uB9AC\uCE74\uB178 \uBC84\uD2BC");
		button_americano.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\americano.jpg"));
		button_americano.setBounds(189, 69, 140, 140);
		contentPane.add(button_americano);
		
		
		button_mocha.setToolTipText("\uBAA8\uCE74\uCEE4\uD53C \uBC84\uD2BC");
		button_mocha.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\mocha.jpg"));
		button_mocha.setBounds(22, 69, 140, 140);
		contentPane.add(button_mocha);
		
		
		button_capuccino.setToolTipText("\uCE74\uD478\uCE58\uB178 \uBC84\uD2BC");
		button_capuccino.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\capuchino.jpg"));
		button_capuccino.setBounds(354, 69, 140, 140);
		contentPane.add(button_capuccino);
		
		
		lbName1.setForeground(new Color(139, 69, 19));
		lbName1.setFont(new Font("바탕", Font.BOLD, 20));
		lbName1.setBounds(46, 219, 100, 30);
		contentPane.add(lbName1);
		
//		JLabel lblMocha = new JLabel("Mocha coffee");
//		lblMocha.setForeground(new Color(205, 92, 92));
//		lblMocha.setFont(new Font("바탕", Font.PLAIN, 13));
//		lblMocha.setBounds(50, 246, 87, 15);
//		contentPane.add(lblMocha);
		
		
		lbName2.setForeground(new Color(139, 69, 19));
		lbName2.setFont(new Font("바탕", Font.BOLD, 20));
		lbName2.setBounds(208, 219, 115, 30);
		contentPane.add(lbName2);
		
//		JLabel lblAmericano = new JLabel("Americano");
//		lblAmericano.setForeground(new Color(205, 92, 92));
//		lblAmericano.setFont(new Font("바탕", Font.PLAIN, 13));
//		lblAmericano.setBounds(227, 246, 73, 15);
//		contentPane.add(lblAmericano);
		
		
		lbName3.setForeground(new Color(139, 69, 19));
		lbName3.setFont(new Font("바탕", Font.BOLD, 20));
		lbName3.setBounds(383, 219, 100, 30);
		contentPane.add(lbName3);
		
//		JLabel lblCapuchino = new JLabel("capuccino");
//		lblCapuchino.setForeground(new Color(205, 92, 92));
//		lblCapuchino.setFont(new Font("바탕", Font.PLAIN, 13));
//		lblCapuchino.setBounds(392, 246, 73, 15);
//		contentPane.add(lblCapuchino);
		
		JLabel label_3 = new JLabel("\uC120\uD0DD \uC74C\uB8CC");
		label_3.setForeground(new Color(178, 34, 34));
		label_3.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		label_3.setBounds(556, 33, 108, 35);
		contentPane.add(label_3);
		
		
		label_selDrink.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\coffee_icon.jpg"));
		label_selDrink.setBackground(Color.WHITE);
		label_selDrink.setBounds(534, 69, 140, 140);
		contentPane.add(label_selDrink);
		label_drinkName.setForeground(new Color(139, 69, 19));
		
		
		label_drinkName.setFont(new Font("바탕", Font.PLAIN, 17));
		label_drinkName.setBounds(534, 208, 130, 20);
		contentPane.add(label_drinkName);
		
		
		lbCost1.setForeground(new Color(255, 127, 80));
		lbCost1.setFont(new Font("바탕", Font.BOLD, 20));
		lbCost1.setBounds(61, 269, 73, 20);
		contentPane.add(lbCost1);
		
		
		lbCost2.setForeground(new Color(255, 127, 80));
		lbCost2.setFont(new Font("바탕", Font.BOLD, 20));
		lbCost2.setBounds(229, 271, 65, 18);
		contentPane.add(lbCost2);
		
		
		lbCost3.setForeground(new Color(255, 127, 80));
		lbCost3.setFont(new Font("바탕", Font.BOLD, 20));
		lbCost3.setBounds(392, 269, 73, 20);
		contentPane.add(lbCost3);
		label_drinkCost.setForeground(new Color(139, 69, 19));
		
		
		label_drinkCost.setFont(new Font("바탕", Font.PLAIN, 17));
		label_drinkCost.setBounds(535, 242, 130, 20);
		contentPane.add(label_drinkCost);
		lblNewLabel_drinkQuan.setForeground(new Color(139, 69, 19));
		
		
		lblNewLabel_drinkQuan.setFont(new Font("바탕", Font.PLAIN, 17));
		lblNewLabel_drinkQuan.setBounds(534, 225, 130, 20);
		contentPane.add(lblNewLabel_drinkQuan);
		
		btnDrinkPlus.setFont(new Font("굴림", Font.PLAIN, 12));
		btnDrinkPlus.setBounds(529, 270, 72, 23);
		contentPane.add(btnDrinkPlus);
		
		btnDrinkMinus.setFont(new Font("굴림", Font.PLAIN, 12));
		btnDrinkMinus.setBounds(610, 270, 72, 23);
		contentPane.add(btnDrinkMinus);
		

		btnBuy.setFont(new Font("굴림", Font.BOLD, 19));
		btnBuy.setBackground(new Color(152, 251, 152));
		btnBuy.setBounds(715, 390, 164, 258);
		contentPane.add(btnBuy);
		
		
		btnDrinkCancel.setBackground(new Color(250, 128, 114));
		btnDrinkCancel.setFont(new Font("굴림", Font.BOLD, 14));
		btnDrinkCancel.setBounds(529, 303, 153, 30);
		contentPane.add(btnDrinkCancel);

		
		btnCookie.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cookie.jpg"));
		btnCookie.setBounds(22, 384, 140, 140);
		contentPane.add(btnCookie);
		
		btnCake.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cake.jpg"));
		btnCake.setBounds(189, 384, 140, 140);
		contentPane.add(btnCake);
		
		btnMacaron.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\macaron.jpg"));
		btnMacaron.setBounds(354, 384, 140, 140);
		contentPane.add(btnMacaron);
		
		JLabel label_4 = new JLabel("\uC120\uD0DD \uAC04\uC2DD");
		label_4.setForeground(new Color(178, 34, 34));
		label_4.setFont(new Font("함초롬바탕", Font.BOLD, 23));
		label_4.setBounds(556, 350, 108, 30);
		contentPane.add(label_4);
		
		
		label_cookieIcon.setBackground(Color.WHITE);
		label_cookieIcon.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cookie_icon.png"));
		label_cookieIcon.setBounds(534, 384, 140, 140);
		contentPane.add(label_cookieIcon);
		
		
		lbName4.setForeground(new Color(139, 69, 19));
		lbName4.setFont(new Font("바탕", Font.BOLD, 20));
		lbName4.setBounds(46, 540, 100, 20);
		contentPane.add(lbName4);
		
//		JLabel lblNewLabel_5 = new JLabel("Handmade cookie");
//		lblNewLabel_5.setForeground(new Color(205, 92, 92));
//		lblNewLabel_5.setFont(new Font("바탕", Font.PLAIN, 13));
//		lblNewLabel_5.setBounds(38, 561, 131, 15);
//		contentPane.add(lblNewLabel_5);
		
		
		lbCost4.setForeground(new Color(255, 127, 80));
		lbCost4.setFont(new Font("바탕", Font.BOLD, 20));
		lbCost4.setBounds(61, 586, 73, 20);
		contentPane.add(lbCost4);
		
		
		lbName5.setForeground(new Color(139, 69, 19));
		lbName5.setFont(new Font("바탕", Font.BOLD, 20));
		lbName5.setBounds(203, 537, 115, 26);
		contentPane.add(lbName5);
		
		
		lbName6.setForeground(new Color(139, 69, 19));
		lbName6.setFont(new Font("바탕", Font.BOLD, 20));
		lbName6.setBounds(391, 540, 79, 20);
		contentPane.add(lbName6);
		
//		JLabel lblNewLabel_7 = new JLabel("a Piece of cake");
//		lblNewLabel_7.setForeground(new Color(205, 92, 92));
//		lblNewLabel_7.setFont(new Font("바탕", Font.PLAIN, 13));
//		lblNewLabel_7.setBounds(211, 561, 108, 15);
//		contentPane.add(lblNewLabel_7);
		
//		JLabel lblNewLabel_8 = new JLabel("Macaron");
//		lblNewLabel_8.setForeground(new Color(205, 92, 92));
//		lblNewLabel_8.setFont(new Font("바탕", Font.PLAIN, 13));
//		lblNewLabel_8.setBounds(396, 561, 57, 15);
//		contentPane.add(lblNewLabel_8);
		
		
		lbCost5.setForeground(new Color(255, 127, 80));
		lbCost5.setFont(new Font("바탕", Font.BOLD, 20));
		lbCost5.setBounds(227, 586, 73, 20);
		contentPane.add(lbCost5);
		
		
		lbCost6.setForeground(new Color(255, 127, 80));
		lbCost6.setFont(new Font("바탕", Font.BOLD, 20));
		lbCost6.setBounds(392, 586, 73, 20);
		contentPane.add(lbCost6);
		Label_cookieName.setForeground(new Color(139, 69, 19));
		
		
		Label_cookieName.setFont(new Font("바탕", Font.PLAIN, 17));
		Label_cookieName.setBounds(534, 522, 130, 20);
		contentPane.add(Label_cookieName);
		label_cookieQuan.setForeground(new Color(139, 69, 19));
		
		
		label_cookieQuan.setFont(new Font("바탕", Font.PLAIN, 17));
		label_cookieQuan.setBounds(534, 540, 130, 18);
		contentPane.add(label_cookieQuan);
		Label_cookieCost.setForeground(new Color(139, 69, 19));
		
		
		Label_cookieCost.setFont(new Font("바탕", Font.PLAIN, 17));
		Label_cookieCost.setBounds(534, 556, 130, 20);
		contentPane.add(Label_cookieCost);
		
		
		btnCookiePlus.setFont(new Font("굴림", Font.PLAIN, 12));
		btnCookiePlus.setBounds(529, 585, 72, 23);
		contentPane.add(btnCookiePlus);
		
		
		btnCookieMinus.setFont(new Font("굴림", Font.PLAIN, 12));
		btnCookieMinus.setBounds(610, 585, 72, 23);
		contentPane.add(btnCookieMinus);
		
		
		btnCookieCancel.setFont(new Font("굴림", Font.BOLD, 14));
		btnCookieCancel.setBackground(new Color(250, 128, 114));
		btnCookieCancel.setBounds(529, 618, 153, 30);
		contentPane.add(btnCookieCancel);
		
		
		rdbtntakeOut.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtntakeOut.setBounds(713, 338, 164, 20);
		contentPane.add(rdbtntakeOut);
		
		
		rdbtneatIn.setFont(new Font("굴림", Font.PLAIN, 15));
		rdbtneatIn.setBounds(713, 360, 153, 20);
		contentPane.add(rdbtneatIn);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textArea.setBackground(new Color(255, 250, 205));
		textArea.setEditable(false);
		textArea.setText(".-------\uC8FC\uBB38\uD558\uC2DC\uB294 \uBC29\uBC95-------.\r\n\r\n1. \uB4DC\uC2DC\uACE0 \uC2F6\uC740\r\n    \uC74C\uB8CC \uD639\uC740 \uAC04\uC2DD\uC744 \uC120\uD0DD\r\n\r\n2. \uD544\uC694\uD55C \uB9CC\uD07C \uC218\uB7C9\uC744 \uC870\uC808\r\n    (\uCD5C\uB300 10\uAC1C)\r\n\r\n3. \uD14C\uC774\uD06C\uC544\uC6C3 \uC5EC\uBD80 \uD655\uC778\r\n\r\n4. \uAD6C\uB9E4\uD558\uAE30 \uBC84\uD2BC \uD074\uB9AD\r\n\r\n5. \uC8FC\uBB38\uC774 \uC644\uC131\uB418\uBA74 \uB370\uC2A4\uD06C\uB85C");
		textArea.setBounds(703, 40, 187, 278);
		contentPane.add(textArea);
		
		JLabel label_1 = new JLabel("\uCE74\uD398 \uBB34\uC778 \uC8FC\uBB38\uAE30");
		label_1.setForeground(new Color(128, 0, 0));
		label_1.setFont(new Font("함초롬바탕", Font.BOLD, 34));
		label_1.setBounds(131, 10, 257, 40);
		contentPane.add(label_1);
		
		
		lbQuan1.setFont(new Font("바탕", Font.PLAIN, 15));
		lbQuan1.setBounds(56, 299, 79, 15);
		contentPane.add(lbQuan1);
		
		lbQuan2.setFont(new Font("바탕", Font.PLAIN, 15));
		lbQuan2.setBounds(224, 299, 79, 15);
		contentPane.add(lbQuan2);
		
		lbQuan3.setFont(new Font("바탕", Font.PLAIN, 15));
		lbQuan3.setBounds(388, 299, 79, 15);
		contentPane.add(lbQuan3);
		
		lbQuan4.setFont(new Font("바탕", Font.PLAIN, 15));
		lbQuan4.setBounds(56, 616, 79, 15);
		contentPane.add(lbQuan4);
		
		lbQuan5.setFont(new Font("바탕", Font.PLAIN, 15));
		lbQuan5.setBounds(223, 616, 79, 15);
		contentPane.add(lbQuan5);
		
		lbQuan6.setFont(new Font("바탕", Font.PLAIN, 15));
		lbQuan6.setBounds(388, 616, 79, 15);
		contentPane.add(lbQuan6);
		
		try { //데이터 베이스에서 정보를 불러옴
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.out.println("드라이브 연결안됨.");
			System.exit(0);
		}
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+"useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT * FROM coffee_machine";
		try {
			conn = DriverManager.getConnection(url, id, pass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			int count = 0;
			while (rs.next()) {
				coffee[count][0] = rs.getString("name");
				coffee[count][1] = rs.getString("quantity");
				coffee[count][2] = rs.getString("cost");
				count++;
			}
			lbName1.setText(coffee[0][0]);
			lbQuan1.setText("재고 : "+coffee[0][1]+"개");
			lbCost1.setText(coffee[0][2]+"원");
			this.name1 = coffee[0][0];
			int quan1 = Integer.parseInt(coffee[0][1]);
			this.quan1 = quan1;
			int cost1 = Integer.parseInt(coffee[0][2]);
			this.cost1 = cost1;
			
			lbName2.setText(coffee[1][0]);
			lbQuan2.setText("재고 : "+coffee[1][1]+"개");
			lbCost2.setText(coffee[1][2]+"원");
			this.name2 = coffee[1][0];
			int quan2 = Integer.parseInt(coffee[1][1]);
			this.quan2 = quan2;
			int cost2 = Integer.parseInt(coffee[1][2]);
			this.cost2 = cost2;
			
			lbName3.setText(coffee[2][0]);
			lbQuan3.setText("재고 : "+coffee[2][1]+"개");
			lbCost3.setText(coffee[2][2]+"원");
			this.name3 = coffee[2][0];
			int quan3 = Integer.parseInt(coffee[2][1]);
			this.quan3 = quan3;
			int cost3 = Integer.parseInt(coffee[2][2]);
			this.cost3 = cost3;
			
			lbName4.setText(coffee[3][0]);
			lbQuan4.setText("재고 : "+coffee[3][1]+"개");
			lbCost4.setText(coffee[3][2]+"원");
			this.name4 = coffee[3][0];
			int quan4 = Integer.parseInt(coffee[3][1]);
			this.quan4 = quan4;
			int cost4 = Integer.parseInt(coffee[3][2]);
			this.cost4 = cost4;
			
			lbName5.setText(coffee[4][0]);
			lbQuan5.setText("재고 : "+coffee[4][1]+"개");
			lbCost5.setText(coffee[4][2]+"원");
			this.name5 = coffee[4][0];
			int quan5 = Integer.parseInt(coffee[4][1]);
			this.quan5 = quan5;
			int cost5 = Integer.parseInt(coffee[4][2]);
			this.cost5 = cost5;
			
			lbName6.setText(coffee[5][0]);
			lbQuan6.setText("재고 : "+coffee[5][1]+"개");
			lbCost6.setText(coffee[5][2]+"원");
			this.name6 = coffee[5][0];
			int quan6 = Integer.parseInt(coffee[5][1]);
			this.quan6 = quan6;
			int cost6 = Integer.parseInt(coffee[5][2]);
			this.cost6 = cost6;
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException ee) {
			System.err.println("error = " + ee.toString());
		}
	}
	void center() { //창을 가운데에 띄워주는 용도
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_mocha) { //모카 커피를 눌렀을 때
			drinkName = this.name1;
			drinkCost = this.cost1;
			drinkQuan = 1;
			label_selDrink.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\mocha.jpg"));
			label_drinkName.setText(drinkName);
			lblNewLabel_drinkQuan.setText("수량: "+drinkQuan+"개");
			label_drinkCost.setText(drinkCost+"원");
		}else if(e.getSource()==button_americano) { //아메리카노를 눌렀을 때
			drinkName = this.name2;
			drinkCost = this.cost2;
			drinkQuan = 1;
			label_selDrink.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\americano.jpg"));
			label_drinkName.setText(drinkName);
			lblNewLabel_drinkQuan.setText("수량: "+drinkQuan+"개");
			label_drinkCost.setText(drinkCost+"원");
		}else if(e.getSource()==button_capuccino) { //카푸치노를 눌렀을 때
			drinkName = this.name3;
			drinkCost = this.cost3;
			drinkQuan = 1;
			label_selDrink.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\capuchino.jpg"));
			label_drinkName.setText(drinkName);
			lblNewLabel_drinkQuan.setText("수량: "+drinkQuan+"개");
			label_drinkCost.setText(drinkCost+"원");
		}
		if(e.getSource()==btnDrinkPlus) { //(커피)+1을 눌렀을 때
			drinkQuan++;
			lblNewLabel_drinkQuan.setText("수량: "+drinkQuan+"개");
			label_drinkCost.setText(drinkCost*drinkQuan+"원");
		}else if(e.getSource()==btnDrinkMinus) { //(커피)-1을 눌렀을 때
			drinkQuan--;
			lblNewLabel_drinkQuan.setText("수량: "+drinkQuan+"개");
			label_drinkCost.setText(drinkCost*drinkQuan+"원");
		}
		
		if(e.getSource()==btnDrinkCancel) { //(커피)취소하기를 눌렀을 때
			drinkName = "";
			drinkCost = 0;
			drinkQuan = 0;
			label_selDrink.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\coffee_icon.jpg"));
			label_drinkName.setText("음료명");
			lblNewLabel_drinkQuan.setText("수량");
			label_drinkCost.setText("-원");
		}
		if(drinkQuan >= 1) { //커피 수량이 1이상이어야 취소하기 버튼이 활성화
			btnDrinkCancel.setEnabled(true);
		}else {
			btnDrinkCancel.setEnabled(false);
		}
		
		if(drinkQuan > 1) { //커피 수량이 2개일 때부터 -1버튼이 활성화
			btnDrinkMinus.setEnabled(true);
		}else {
			btnDrinkMinus.setEnabled(false);
		}
		if(drinkQuan == 0) { //커피 수량이 0개이면 수량증감 버튼이 비활성화
			btnDrinkPlus.setEnabled(false);
		}else {
			if(drinkQuan == 10) { //커피 수량이 10개이면 +1버튼이 비활성화
				btnDrinkPlus.setEnabled(false);
			}else {
				btnDrinkPlus.setEnabled(true);
			}
		}
		if(drinkQuan == quan1 || drinkQuan == quan2 || drinkQuan == quan3) { //재고와 커피 수량이 같아지면 +1버튼이 비활성화
			btnDrinkPlus.setEnabled(false);
		}
		
		if(e.getSource()==btnCookie) { //수제 쿠키를 눌렀을 때
			cookieName = this.name4;
			cookieCost = this.cost4;
			cookieQuan = 1;
			label_cookieIcon.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cookie.jpg"));
			Label_cookieName.setText(cookieName);
			label_cookieQuan.setText("수량: "+cookieQuan+"개");
			Label_cookieCost.setText(cookieCost+"원");
		}else if(e.getSource()==btnCake) { //조각 케이크를 눌렀을 때
			cookieName = this.name5;
			cookieCost = this.cost5;
			cookieQuan = 1;
			label_cookieIcon.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cake.jpg"));
			Label_cookieName.setText(cookieName);
			label_cookieQuan.setText("수량: "+cookieQuan+"개");
			Label_cookieCost.setText(cookieCost+"원");
		}else if(e.getSource()==btnMacaron) { //마카롱을 눌렀을 때
			cookieName = this.name6;
			cookieCost = this.cost6;
			cookieQuan = 1;
			label_cookieIcon.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\macaron.jpg"));
			Label_cookieName.setText(cookieName);
			label_cookieQuan.setText("수량: "+cookieQuan+"개");
			Label_cookieCost.setText(cookieCost+"원");
		}
		if(e.getSource()==btnCookiePlus) { //(간식)+1을 눌렀을 때
			cookieQuan++;
			label_cookieQuan.setText("수량: "+cookieQuan+"개");
			Label_cookieCost.setText(cookieCost*cookieQuan+"원");
		}else if(e.getSource()==btnCookieMinus) { //(간식)-1을 눌렀을 때
			cookieQuan--;
			label_cookieQuan.setText("수량: "+cookieQuan+"개");
			Label_cookieCost.setText(cookieCost*cookieQuan+"원");
		}
		if(e.getSource()==btnCookieCancel) { //(간식)취소하기를 눌렀을 때
			cookieName = "";
			cookieCost = 0;
			cookieQuan = 0;
			label_cookieIcon.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cookie_icon.png"));
			Label_cookieName.setText("간식명");
			label_cookieQuan.setText("수량");
			Label_cookieCost.setText("-원");
		}
		if(cookieQuan >= 1) { //간식 수량이 1이상이어야 취소하기 버튼이 활성화
			btnCookieCancel.setEnabled(true);
		}else {
			btnCookieCancel.setEnabled(false);
		}
		
		if(cookieQuan > 1) { //간식 수량이 2개일 때부터 -1버튼이 활성화
			btnCookieMinus.setEnabled(true);
		}else {
			btnCookieMinus.setEnabled(false);
		}
		if(cookieQuan == 0) { //간식 수량이 0개이면 수량증감 버튼이 비활성화
			btnCookiePlus.setEnabled(false);
		}else {
			if(cookieQuan == 10) { //간식 수량이 10개이면 +1버튼이 비활성화
				btnCookiePlus.setEnabled(false);
			}else {
				btnCookiePlus.setEnabled(true);
			}
		}
		if(cookieQuan == quan4 || cookieQuan == quan5 || cookieQuan == quan6) { //재고와 간식 수량이 같아지면 +1버튼이 비활성화
			btnCookiePlus.setEnabled(false);
		}
		
		if(drinkQuan >= 1 || cookieQuan >= 1) { //커피나 간식을 골랐다면 테이크아웃 여부 확인이 활성화
			rdbtntakeOut.setEnabled(true);
			rdbtneatIn.setEnabled(true);
		}else { //아무것도 고르지 않았다면 테이크아웃 여부, 구매하기 버튼이 비활성화
			rdbtntakeOut.setEnabled(false);
			rdbtneatIn.setEnabled(false);
			rdbtntakeOut.setSelected(false);
			rdbtneatIn.setSelected(false);
			btnBuy.setEnabled(false);
		}
		
		if(e.getSource()==rdbtntakeOut) { //테이크아웃을 골랐다면
			takeOut = "O";
			rdbtneatIn.setSelected(false);
			btnBuy.setEnabled(true);
		}else if(e.getSource()==rdbtneatIn) { //먹고 가기를 눌렀다면
			takeOut = "X";
			rdbtntakeOut.setSelected(false);
			btnBuy.setEnabled(true);
		}
		
		if(e.getSource()==btnBuy) {
			if(drinkQuan >= 1 && cookieQuan >= 1) { //커피와 간식을 고르고 구매하기를 눌렀을 때
				msg("'"+drinkName+"' " + drinkQuan + " 개, '"+cookieName+"' " + cookieQuan + " 개를 구매하시겠습니까?"
						+ "\n가격: " + (drinkCost*drinkQuan + cookieCost*cookieQuan) + "원"
						+ "\n" + "테이크아웃 여부: " + takeOut);
			}else if(drinkQuan >= 1) { //커피만 고르고 구매하기를 눌렀을 때
				msg("'"+drinkName+"' " + drinkQuan + " 개를 구매하시겠습니까?"
						+ "\n가격: " + (drinkCost*drinkQuan) + "원"
						+ "\n" + "테이크아웃 여부: " + takeOut);
			}else if(cookieQuan >= 1) { //간식만 고르고 구매하기를 눌렀을 때
				msg("'"+cookieName+"' " + cookieQuan + " 개를 구매하시겠습니까?"
						+ "\n가격: " + (cookieCost*cookieQuan) + "원"
						+ "\n" + "테이크아웃 여부: " + takeOut);
			}
		}
	}
	void msg(String msg)
	{
		final Dialog dlg = new Dialog(this, "결제 메시지", true);
		dlg.setLayout(null);
		JTextArea taMsg = new JTextArea(msg);
		taMsg.setEditable(false);
		JButton btnBuy = new JButton("구매하기");
		JButton btnCancel = new JButton("취소");
		JButton btnPurchase = new JButton("결재");
		JButton btnOk = new JButton("확인");
		btnPurchase.setVisible(false);
		btnOk.setVisible(false);
		
		dlg.add(taMsg);
		dlg.add(btnBuy);
		dlg.add(btnCancel);
		dlg.add(btnPurchase);
		dlg.add(btnOk);
		
		taMsg.setBounds(10, 60, 380, 100);	taMsg.setFont(font15);
		
		btnBuy.setBounds(50, 170, 130, 40);	btnBuy.setFont(font20);
		btnCancel.setBounds(220, 170, 130, 40);	btnCancel.setFont(font20);
		btnPurchase.setBounds(50, 170, 130, 40);	btnPurchase.setFont(font20);
		btnOk.setBounds(135, 170, 130, 40);	btnOk.setFont(font20);
		
		dlg.setSize(400, 250);
		dlg.setLocation(800, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		btnBuy.addActionListener(new ActionListener() { //구매하기 버튼을 눌렀을 때
			public void actionPerformed(ActionEvent e) {
				taMsg.setText("카드를 단말기에 꽂으시고 결재버튼을 눌러주세요.");
				btnBuy.setVisible(false);
				btnPurchase.setVisible(true);
			}
		});
		btnPurchase.addActionListener(new ActionListener() { //결재 버튼을 눌렀을 때
			public void actionPerformed(ActionEvent e) {
				
				try { Thread.sleep(500);
					taMsg.setText("결재중입니다. 잠시만 기다려주십시오.");
					System.out.println("결재중입니다. 잠시만 기다려주십시오.");
				} catch (InterruptedException e1) {}
				try { Thread.sleep(500);
					taMsg.setText("결재중입니다. 잠시만 기다려주십시오..");
					System.out.println("결재중입니다. 잠시만 기다려주십시오..");
				} catch (InterruptedException e1) {}
				try { Thread.sleep(500);
					taMsg.setText("결재중입니다. 잠시만 기다려주십시오...");
					System.out.println("결재중입니다. 잠시만 기다려주십시오...");
				} catch (InterruptedException e1) {}
				taMsg.setText("주문이 완료되었습니다. 카드를 수거해주세요.");
				
				if(drinkName.equals(name1)) { //모카 커피를 주문했다면 그만큼 재고가 빠짐
					quan1-=drinkQuan;
					lbQuan1.setText("재고 : "+quan1+"개");
				}else if(drinkName.equals(name2)) { //아메리카노를 주문했다면 그만큼 재고가 빠짐
					quan2-=drinkQuan;
					lbQuan2.setText("재고 : "+quan2+"개");
				}else if(drinkName.equals(name3)) { //카푸치노를 주문했다면 그만큼 재고가 빠짐
					quan3-=drinkQuan;
					lbQuan3.setText("재고 : "+quan3+"개");
				}
				if(cookieName.equals(name4)) { //수제 쿠키를 주문했다면 그만큼 재고가 빠짐
					quan4-=cookieQuan;
					lbQuan4.setText("재고 : "+quan4+"개");
				}else if(cookieName.equals(name5)) { //조각 케이크를 주문했다면 그만큼 재고가 빠짐
					quan5-=cookieQuan;
					lbQuan5.setText("재고 : "+quan5+"개");
				}else if(cookieName.equals(name6)) { //조각 케이크를 주문했다면 그만큼 재고가 빠짐
					quan6-=cookieQuan;
					lbQuan6.setText("재고 : "+quan6+"개");
				}
				quantity();
				btnPurchase.setVisible(false);
				btnCancel.setVisible(false);
				btnOk.setVisible(true);
				reset();
			}
		});
		btnOk.addActionListener(new ActionListener() { //확인 버튼을 눌렀을 때
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		btnCancel.addActionListener(new ActionListener() { //취소 버튼을 눌렀을 때
			public void actionPerformed(ActionEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
	void quantity() { //판매한 개수만큼 데이터베이스에서 재고가 감소함.
		int quan1 = 0;
		int idx1 = 0;
		int quan2 = 0;
		int idx2 = 0;
		if(drinkName.equals(name1)) {
			quan1 = this.quan1;
			idx1 = 1;
		}else if(drinkName.equals(name2)) {
			quan1 = this.quan2;
			idx1 = 2;
		}else if(drinkName.equals(name3)) {
			quan1 = this.quan3;
			idx1 = 3;
		}
		if(cookieName.equals(name4)) {
			quan2 = this.quan4;
			idx2 = 4;
		}else if(cookieName.equals(name5)) {
			quan2 = this.quan5;
			idx2 = 5;
		}else if(cookieName.equals(name6)) {
			quan2 = this.quan6;
			idx2 = 6;
		}
		Connection dc=null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
		}
		String url = "jdbc:mysql://127.0.0.1:3306/dw202?"
				+"useUnicode=true&characterEncoding=utf8";
		String id = "root";
		String pass = "qwer";
		try {
			dc = DriverManager.getConnection(url, id, pass);
		} catch (SQLException ee) {
		}
		String query = "update coffee_machine set quantity = ? where idx = ?";
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setInt(1, quan1);
			pstmt.setInt(2, idx1);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException ee) {
		}
		try {
			PreparedStatement pstmt = dc.prepareStatement(query);
			pstmt.setInt(1, quan2);
			pstmt.setInt(2, idx2);
			pstmt.executeUpdate();
			pstmt.close();
		}catch (SQLException ee) {
		}
	}
	void reset() { //맨처음 상태로 초기화됨.
		drinkName = "";
		drinkQuan = 0;
		drinkCost = 0;
		cookieName = "";
		cookieQuan = 0;
		cookieCost = 0;
		takeOut = "";
		
		label_selDrink.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\coffee_icon.jpg"));
		label_drinkName.setText("음료명");
		lblNewLabel_drinkQuan.setText("수량");
		label_drinkCost.setText("-원");
		
		label_cookieIcon.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\김성준 자바폴더\\java_windowprogramming\\images\\cookie_icon.png"));
		Label_cookieName.setText("간식명");
		label_cookieQuan.setText("수량");
		Label_cookieCost.setText("-원");
		
		btnDrinkPlus.setEnabled(false);
		btnDrinkMinus.setEnabled(false);
		btnDrinkCancel.setEnabled(false);
		btnCookiePlus.setEnabled(false);
		btnCookieMinus.setEnabled(false);
		btnCookieCancel.setEnabled(false);
		
		rdbtntakeOut.setEnabled(false);
		rdbtneatIn.setEnabled(false);
		rdbtntakeOut.setSelected(false);
		rdbtneatIn.setSelected(false);
		btnBuy.setEnabled(false);
	}
}


















