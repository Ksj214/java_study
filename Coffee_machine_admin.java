package 자바XXVII_그래픽;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class Coffee_machine_admin extends JFrame implements ActionListener {
	
	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Font font15 = new Font("SansSerif", Font.PLAIN, 15);
	Font font20 = new Font("SansSerif", Font.PLAIN, 20);
	Font font20b = new Font("SansSerif", Font.BOLD, 20);
	Font font30 = new Font("SansSerif", Font.PLAIN, 30);
	Font font30b = new Font("SansSerif", Font.BOLD, 30);
	
	private String coffee[][] = new String[6][3];

	private JPanel contentPane;
	private JTextField tfMerch1Name;
	private JTextField tfMerch2Name;
	private JTextField tfMerch3Name;
	private JTextField tfMerch4Name;
	private JTextField tfMerch5Name;
	private JTextField tfMerch6Name;
	private JTextField tfMerch1Quan;
	private JTextField tfMerch2Quan;
	private JTextField tfMerch3Quan;
	private JTextField tfMerch4Quan;
	private JTextField tfMerch5Quan;
	private JTextField tfMerch6Quan;
	private JTextField tfMerch1Cost;
	private JTextField tfMerch2Cost;
	private JTextField tfMerch3Cost;
	private JTextField tfMerch4Cost;
	private JTextField tfMerch5Cost;
	private JTextField tfMerch6Cost;
	
	private JButton btnMerch1 = new JButton("\uC801\uC6A9");
	private JButton btnMerch2 = new JButton("\uC801\uC6A9");
	private JButton btnMerch3 = new JButton("\uC801\uC6A9");
	private JButton btnMerch4 = new JButton("\uC801\uC6A9");
	private JButton btnMerch5 = new JButton("\uC801\uC6A9");
	private JButton btnMerch6 = new JButton("\uC801\uC6A9");
	
	JTextArea taName1 = new JTextArea();
	JTextArea taName2 = new JTextArea();
	JTextArea taName3 = new JTextArea();
	JTextArea taName4 = new JTextArea();
	JTextArea taName5 = new JTextArea();
	JTextArea taName6 = new JTextArea();
	
	JTextArea taQuan1 = new JTextArea();
	JTextArea taQuan2 = new JTextArea();
	JTextArea taQuan3 = new JTextArea();
	JTextArea taQuan4 = new JTextArea();
	JTextArea taQuan5 = new JTextArea();
	JTextArea taQuan6 = new JTextArea();
	
	JTextArea taCost1 = new JTextArea();
	JTextArea taCost2 = new JTextArea();
	JTextArea taCost3 = new JTextArea();
	JTextArea taCost4 = new JTextArea();
	JTextArea taCost5 = new JTextArea();
	JTextArea taCost6 = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coffee_machine_admin frame = new Coffee_machine_admin();
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
	public Coffee_machine_admin() {
		super("카페 무인 주문기-관리자화면");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnMerch1.setBackground(new Color(255, 235, 205));
		
		btnMerch1.addActionListener(this);
		btnMerch2.setBackground(new Color(255, 222, 173));
		btnMerch2.addActionListener(this);
		btnMerch3.setBackground(new Color(255, 235, 205));
		btnMerch3.addActionListener(this);
		btnMerch4.setBackground(new Color(255, 222, 173));
		btnMerch4.addActionListener(this);
		btnMerch5.setBackground(new Color(255, 235, 205));
		btnMerch5.addActionListener(this);
		btnMerch6.setBackground(new Color(255, 222, 173));
		btnMerch6.addActionListener(this);
		
		JLabel lbTitle = new JLabel("\uCE74\uD398 \uBB34\uC778 \uC8FC\uBB38\uAE30-\uAD00\uB9AC\uC790\uD654\uBA74");
		lbTitle.setFont(new Font("함초롬돋움", Font.BOLD, 30));
		lbTitle.setBounds(168, 24, 385, 35);
		contentPane.add(lbTitle);
		
		JLabel lbMerch1 = new JLabel("\uC0C1\uD4881 \uC774\uB984 :");
		lbMerch1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch1.setBounds(30, 90, 119, 27);
		contentPane.add(lbMerch1);
		
		JLabel lbCorrent1 = new JLabel("\uC218\uC815 :");
		lbCorrent1.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbCorrent1.setBounds(88, 127, 59, 21);
		contentPane.add(lbCorrent1);
		
		tfMerch1Name = new JTextField();
		tfMerch1Name.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch1Name.setBounds(147, 125, 119, 27);
		contentPane.add(tfMerch1Name);
		tfMerch1Name.setColumns(10);
		
		JLabel lbMerch2 = new JLabel("\uC0C1\uD4882 \uC774\uB984 :");
		lbMerch2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch2.setBounds(30, 180, 119, 27);
		contentPane.add(lbMerch2);
		
		tfMerch2Name = new JTextField();
		tfMerch2Name.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch2Name.setBounds(147, 213, 119, 27);
		contentPane.add(tfMerch2Name);
		tfMerch2Name.setColumns(10);
		
		JLabel lbMerch3 = new JLabel("\uC0C1\uD4883 \uC774\uB984 :");
		lbMerch3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch3.setBounds(30, 270, 119, 27);
		contentPane.add(lbMerch3);
		
		tfMerch3Name = new JTextField();
		tfMerch3Name.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch3Name.setBounds(147, 305, 119, 27);
		contentPane.add(tfMerch3Name);
		tfMerch3Name.setColumns(10);
		
		JLabel lbMerch4 = new JLabel("\uC0C1\uD4884 \uC774\uB984 :");
		lbMerch4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch4.setBounds(30, 360, 119, 27);
		contentPane.add(lbMerch4);
		
		tfMerch4Name = new JTextField();
		tfMerch4Name.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch4Name.setBounds(147, 395, 119, 28);
		contentPane.add(tfMerch4Name);
		tfMerch4Name.setColumns(10);
		
		JLabel lbMerch5 = new JLabel("\uC0C1\uD4885 \uC774\uB984 :");
		lbMerch5.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch5.setBounds(30, 450, 119, 27);
		contentPane.add(lbMerch5);
		
		tfMerch5Name = new JTextField();
		tfMerch5Name.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch5Name.setBounds(147, 482, 119, 28);
		contentPane.add(tfMerch5Name);
		tfMerch5Name.setColumns(10);
		
		JLabel lbMerch6 = new JLabel("\uC0C1\uD4886 \uC774\uB984 :");
		lbMerch6.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch6.setBounds(30, 540, 119, 27);
		contentPane.add(lbMerch6);
		
		tfMerch6Name = new JTextField();
		tfMerch6Name.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch6Name.setBounds(147, 575, 119, 28);
		contentPane.add(tfMerch6Name);
		tfMerch6Name.setColumns(10);
		
		JLabel lbMerch1Quan = new JLabel("\uC218\uB7C9 :");
		lbMerch1Quan.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch1Quan.setBounds(278, 90, 59, 25);
		contentPane.add(lbMerch1Quan);
		
		tfMerch1Quan = new JTextField();
		tfMerch1Quan.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch1Quan.setBounds(337, 125, 82, 28);
		contentPane.add(tfMerch1Quan);
		tfMerch1Quan.setColumns(10);
		
		JLabel lbMerch2Quan = new JLabel("\uC218\uB7C9 :");
		lbMerch2Quan.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch2Quan.setBounds(278, 181, 59, 25);
		contentPane.add(lbMerch2Quan);
		
		tfMerch2Quan = new JTextField();
		tfMerch2Quan.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch2Quan.setBounds(337, 215, 82, 28);
		contentPane.add(tfMerch2Quan);
		tfMerch2Quan.setColumns(10);
		
		JLabel lbMerch3Quan = new JLabel("\uC218\uB7C9 :");
		lbMerch3Quan.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch3Quan.setBounds(278, 271, 57, 25);
		contentPane.add(lbMerch3Quan);
		
		tfMerch3Quan = new JTextField();
		tfMerch3Quan.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch3Quan.setBounds(337, 305, 82, 28);
		contentPane.add(tfMerch3Quan);
		tfMerch3Quan.setColumns(10);
		
		JLabel lbMerch4Quan = new JLabel("\uC218\uB7C9 :");
		lbMerch4Quan.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch4Quan.setBounds(278, 361, 57, 25);
		contentPane.add(lbMerch4Quan);
		
		tfMerch4Quan = new JTextField();
		tfMerch4Quan.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch4Quan.setBounds(337, 395, 82, 28);
		contentPane.add(tfMerch4Quan);
		tfMerch4Quan.setColumns(10);
		
		JLabel lbMerch5Quan = new JLabel("\uC218\uB7C9 :");
		lbMerch5Quan.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch5Quan.setBounds(278, 451, 57, 25);
		contentPane.add(lbMerch5Quan);
		
		tfMerch5Quan = new JTextField();
		tfMerch5Quan.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch5Quan.setBounds(337, 482, 82, 28);
		contentPane.add(tfMerch5Quan);
		tfMerch5Quan.setColumns(10);
		
		JLabel lbMerch6Quan = new JLabel("\uC218\uB7C9 :");
		lbMerch6Quan.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch6Quan.setBounds(278, 541, 57, 25);
		contentPane.add(lbMerch6Quan);
		
		tfMerch6Quan = new JTextField();
		tfMerch6Quan.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch6Quan.setBounds(337, 575, 82, 28);
		contentPane.add(tfMerch6Quan);
		tfMerch6Quan.setColumns(10);
		
		JLabel lbMerch1Cost = new JLabel("\uAC00\uACA9 :");
		lbMerch1Cost.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch1Cost.setBounds(431, 90, 57, 25);
		contentPane.add(lbMerch1Cost);
		
		tfMerch1Cost = new JTextField();
		tfMerch1Cost.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch1Cost.setBounds(489, 125, 100, 28);
		contentPane.add(tfMerch1Cost);
		tfMerch1Cost.setColumns(10);
		
		JLabel lbMerch2Cost = new JLabel("\uAC00\uACA9 :");
		lbMerch2Cost.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch2Cost.setBounds(431, 181, 57, 25);
		contentPane.add(lbMerch2Cost);
		
		tfMerch2Cost = new JTextField();
		tfMerch2Cost.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch2Cost.setBounds(489, 215, 100, 28);
		contentPane.add(tfMerch2Cost);
		tfMerch2Cost.setColumns(10);
		
		JLabel lbMerch3Cost = new JLabel("\uAC00\uACA9 :");
		lbMerch3Cost.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch3Cost.setBounds(431, 271, 57, 25);
		contentPane.add(lbMerch3Cost);
		
		tfMerch3Cost = new JTextField();
		tfMerch3Cost.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch3Cost.setBounds(489, 305, 100, 28);
		contentPane.add(tfMerch3Cost);
		tfMerch3Cost.setColumns(10);
		
		JLabel lbMerch4Cost = new JLabel("\uAC00\uACA9 :");
		lbMerch4Cost.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch4Cost.setBounds(431, 361, 57, 25);
		contentPane.add(lbMerch4Cost);
		
		tfMerch4Cost = new JTextField();
		tfMerch4Cost.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch4Cost.setBounds(489, 395, 100, 28);
		contentPane.add(tfMerch4Cost);
		tfMerch4Cost.setColumns(10);
		
		JLabel lbMerch5Cost = new JLabel("\uAC00\uACA9 :");
		lbMerch5Cost.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch5Cost.setBounds(431, 451, 57, 25);
		contentPane.add(lbMerch5Cost);
		
		tfMerch5Cost = new JTextField();
		tfMerch5Cost.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch5Cost.setBounds(489, 482, 100, 28);
		contentPane.add(tfMerch5Cost);
		tfMerch5Cost.setColumns(10);
		
		JLabel lbMerch6Cost = new JLabel("\uAC00\uACA9 :");
		lbMerch6Cost.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbMerch6Cost.setBounds(431, 543, 57, 21);
		contentPane.add(lbMerch6Cost);
		
		tfMerch6Cost = new JTextField();
		tfMerch6Cost.setFont(new Font("굴림", Font.PLAIN, 20));
		tfMerch6Cost.setBounds(489, 575, 100, 28);
		contentPane.add(tfMerch6Cost);
		tfMerch6Cost.setColumns(10);
		
		btnMerch1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnMerch1.setBounds(601, 90, 80, 63);
		contentPane.add(btnMerch1);
		
		btnMerch2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnMerch2.setBounds(601, 180, 80, 63);
		contentPane.add(btnMerch2);
		
		btnMerch3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnMerch3.setBounds(601, 270, 80, 63);
		contentPane.add(btnMerch3);
		
		btnMerch4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnMerch4.setBounds(601, 360, 80, 63);
		contentPane.add(btnMerch4);
		
		btnMerch5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnMerch5.setBounds(601, 450, 80, 63);
		contentPane.add(btnMerch5);
		
		btnMerch6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		btnMerch6.setBounds(601, 540, 80, 63);
		contentPane.add(btnMerch6);
		
		JLabel lbCorrent2 = new JLabel("\uC218\uC815 :");
		lbCorrent2.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbCorrent2.setBounds(88, 215, 57, 21);
		contentPane.add(lbCorrent2);
		
		JLabel lbCorrent3 = new JLabel("\uC218\uC815 :");
		lbCorrent3.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbCorrent3.setBounds(88, 305, 57, 21);
		contentPane.add(lbCorrent3);
		
		JLabel lbCorrent4 = new JLabel("\uC218\uC815 :");
		lbCorrent4.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbCorrent4.setBounds(88, 397, 57, 21);
		contentPane.add(lbCorrent4);
		
		JLabel lbCorrent5 = new JLabel("\uC218\uC815 :");
		lbCorrent5.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbCorrent5.setBounds(88, 487, 57, 21);
		contentPane.add(lbCorrent5);
		
		JLabel lbCorrent6 = new JLabel("\uC218\uC815 :");
		lbCorrent6.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
		lbCorrent6.setBounds(88, 577, 57, 21);
		contentPane.add(lbCorrent6);
		taName1.setBackground(new Color(245, 245, 220));
		
		
		taName1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taName1.setText("\uC0C1\uD488\uBA85");
		taName1.setEditable(false);
		taName1.setBounds(147, 90, 119, 27);
		contentPane.add(taName1);
		taName2.setBackground(new Color(255, 239, 213));
		
		
		taName2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taName2.setEditable(false);
		taName2.setText("\uC0C1\uD488\uBA85");
		taName2.setBounds(147, 180, 119, 27);
		contentPane.add(taName2);
		taName3.setBackground(new Color(245, 245, 220));
		
		
		taName3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taName3.setEditable(false);
		taName3.setText("\uC0C1\uD488\uBA85");
		taName3.setBounds(147, 270, 119, 27);
		contentPane.add(taName3);
		taName4.setBackground(new Color(255, 239, 213));
		
		
		taName4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taName4.setEditable(false);
		taName4.setText("\uC0C1\uD488\uBA85");
		taName4.setBounds(147, 360, 119, 27);
		contentPane.add(taName4);
		taName5.setBackground(new Color(245, 245, 220));
		
		
		taName5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taName5.setEditable(false);
		taName5.setText("\uC0C1\uD488\uBA85");
		taName5.setBounds(147, 450, 119, 27);
		contentPane.add(taName5);
		taName6.setBackground(new Color(255, 239, 213));
		
		
		taName6.setEditable(false);
		taName6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taName6.setText("\uC0C1\uD488\uBA85");
		taName6.setBounds(147, 540, 119, 27);
		contentPane.add(taName6);
		taQuan1.setBackground(new Color(245, 245, 220));
		
		
		taQuan1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taQuan1.setEditable(false);
		taQuan1.setText("000");
		taQuan1.setBounds(337, 90, 82, 27);
		contentPane.add(taQuan1);
		taQuan2.setBackground(new Color(255, 239, 213));
		
		
		taQuan2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taQuan2.setEditable(false);
		taQuan2.setText("000");
		taQuan2.setBounds(337, 180, 82, 27);
		contentPane.add(taQuan2);
		taQuan3.setBackground(new Color(245, 245, 220));
		
		
		taQuan3.setEditable(false);
		taQuan3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taQuan3.setText("000");
		taQuan3.setBounds(337, 270, 82, 27);
		contentPane.add(taQuan3);
		taQuan4.setBackground(new Color(255, 239, 213));
		
		
		taQuan4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taQuan4.setEditable(false);
		taQuan4.setText("000");
		taQuan4.setBounds(337, 360, 82, 27);
		contentPane.add(taQuan4);
		taQuan5.setBackground(new Color(245, 245, 220));
		
		
		taQuan5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taQuan5.setEditable(false);
		taQuan5.setText("000");
		taQuan5.setBounds(337, 450, 82, 27);
		contentPane.add(taQuan5);
		taQuan6.setBackground(new Color(255, 239, 213));
		
		
		taQuan6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taQuan6.setEditable(false);
		taQuan6.setText("000");
		taQuan6.setBounds(337, 540, 82, 27);
		contentPane.add(taQuan6);
		taCost1.setBackground(new Color(245, 245, 220));
		
		
		taCost1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taCost1.setEditable(false);
		taCost1.setText("0000");
		taCost1.setBounds(489, 90, 100, 27);
		contentPane.add(taCost1);
		taCost2.setBackground(new Color(255, 239, 213));
		
		
		taCost2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taCost2.setEditable(false);
		taCost2.setText("0000");
		taCost2.setBounds(489, 180, 100, 27);
		contentPane.add(taCost2);
		taCost3.setBackground(new Color(245, 245, 220));
		
		
		taCost3.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taCost3.setEditable(false);
		taCost3.setText("0000");
		taCost3.setBounds(489, 270, 100, 27);
		contentPane.add(taCost3);
		taCost4.setBackground(new Color(255, 239, 213));
		
		
		taCost4.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taCost4.setEditable(false);
		taCost4.setText("0000");
		taCost4.setBounds(489, 360, 100, 27);
		contentPane.add(taCost4);
		taCost5.setBackground(new Color(245, 245, 220));
		
		
		taCost5.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taCost5.setEditable(false);
		taCost5.setText("0000");
		taCost5.setBounds(489, 450, 100, 27);
		contentPane.add(taCost5);
		taCost6.setBackground(new Color(255, 239, 213));
		
		
		taCost6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		taCost6.setEditable(false);
		taCost6.setText("0000");
		taCost6.setBounds(489, 540, 100, 27);
		contentPane.add(taCost6);
		
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
			taName1.setText(coffee[0][0]);
			taQuan1.setText(coffee[0][1]);
			taCost1.setText(coffee[0][2]);
			
			taName2.setText(coffee[1][0]);
			taQuan2.setText(coffee[1][1]);
			taCost2.setText(coffee[1][2]);
			
			taName3.setText(coffee[2][0]);
			taQuan3.setText(coffee[2][1]);
			taCost3.setText(coffee[2][2]);
			
			taName4.setText(coffee[3][0]);
			taQuan4.setText(coffee[3][1]);
			taCost4.setText(coffee[3][2]);
			
			taName5.setText(coffee[4][0]);
			taQuan5.setText(coffee[4][1]);
			taCost5.setText(coffee[4][2]);
			
			taName6.setText(coffee[5][0]);
			taQuan6.setText(coffee[5][1]);
			taCost6.setText(coffee[5][2]);
			
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
		}catch (SQLException ee) {
		}
		
		//상품 1의 적용버튼을 눌렀을 때------------------------------------------------------------------------------------------
		if(e.getSource()==btnMerch1) {
			String name = tfMerch1Name.getText();
			String quantity = tfMerch1Quan.getText();
			String cost = tfMerch1Cost.getText();
			int idx = 1;
			String merchNo = "상품1";
			
			if(name.equals("") && quantity.equals("") && cost.equals("")) { //아무것도 입력하지 않았을 때
				msg(merchNo+"의 수정할 품목에 내용을 적어주세요.");
			}else if(quantity.equals("") && cost.equals("")) { //이름만 입력했을 때
				String query = "update coffee_machine set name = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명이 수정되었습니다.");
					taName1.setText(name);
					tfMerch1Name.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && cost.equals("")) { //수량만 입력했을 때
				String query = "update coffee_machine set quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량이 수정되었습니다.");
					taQuan1.setText(quantity);
					tfMerch1Quan.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && quantity.equals("")) { //가격만 입력했을 때
				String query = "update coffee_machine set cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, cost);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 가격이 수정되었습니다.");
					taCost1.setText(cost);
					tfMerch1Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("")) { //수량과 가격만 입력했을 때
				String query = "update coffee_machine set quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량과 가격이 수정되었습니다.");
					taQuan1.setText(quantity);
					taCost1.setText(cost);
					tfMerch1Quan.setText("");
					tfMerch1Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(quantity.equals("")) { //이름과 가격만 입력했을 때
				String query = "update coffee_machine set name = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 가격이 수정되었습니다.");
					taName1.setText(name);
					taCost1.setText(cost);
					tfMerch1Name.setText("");
					tfMerch1Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(cost.equals("")) { //이름과 수량만 입력했을 때
				String query = "update coffee_machine set name = ?, quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량이 수정되었습니다.");
					taName1.setText(name);
					taQuan1.setText(quantity);
					tfMerch1Name.setText("");
					tfMerch1Quan.setText("");
				}catch (SQLException ee) {
				}
			}else { //모든 칸에 입력을 했을 때
				String query = "update coffee_machine set name = ?, quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setString(3, cost);
					pstmt.setInt(4, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량과 가격이 수정되었습니다.");
					taName1.setText(name);
					taCost1.setText(cost);
					taQuan1.setText(quantity);
					tfMerch1Name.setText("");
					tfMerch1Cost.setText("");
					tfMerch1Quan.setText("");
				}catch (SQLException ee) {
				}
			}
			
		//상품 2의 적용버튼을 눌렀을 때------------------------------------------------------------------------------------------
		}else if(e.getSource()==btnMerch2) {
			String name = tfMerch2Name.getText();
			String quantity = tfMerch2Quan.getText();
			String cost = tfMerch2Cost.getText();
			int idx = 2;
			String merchNo = "상품2";
			
			if(name.equals("") && quantity.equals("") && cost.equals("")) { //아무것도 입력하지 않았을 때
				msg(merchNo+"의 수정할 품목에 내용을 적어주세요.");
			}else if(quantity.equals("") && cost.equals("")) { //이름만 입력했을 때
				String query = "update coffee_machine set name = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명이 수정되었습니다.");
					taName2.setText(name);
					tfMerch2Name.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && cost.equals("")) { //수량만 입력했을 때
				String query = "update coffee_machine set quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량이 수정되었습니다.");
					taQuan2.setText(quantity);
					tfMerch2Quan.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && quantity.equals("")) { //가격만 입력했을 때
				String query = "update coffee_machine set cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, cost);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 가격이 수정되었습니다.");
					taCost2.setText(cost);
					tfMerch2Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("")) { //수량과 가격만 입력했을 때
				String query = "update coffee_machine set quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량과 가격이 수정되었습니다.");
					taQuan2.setText(quantity);
					taCost2.setText(cost);
					tfMerch2Quan.setText("");
					tfMerch2Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(quantity.equals("")) { //이름과 가격만 입력했을 때
				String query = "update coffee_machine set name = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 가격이 수정되었습니다.");
					taName2.setText(name);
					taCost2.setText(cost);
					tfMerch2Name.setText("");
					tfMerch2Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(cost.equals("")) { //이름과 수량만 입력했을 때
				String query = "update coffee_machine set name = ?, quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량이 수정되었습니다.");
					taName2.setText(name);
					taQuan2.setText(quantity);
					tfMerch2Name.setText("");
					tfMerch2Quan.setText("");
				}catch (SQLException ee) {
				}
			}else { //모든 칸에 입력을 했을 때
				String query = "update coffee_machine set name = ?, quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setString(3, cost);
					pstmt.setInt(4, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량과 가격이 수정되었습니다.");
					taName2.setText(name);
					taCost2.setText(cost);
					taQuan2.setText(quantity);
					tfMerch2Name.setText("");
					tfMerch2Cost.setText("");
					tfMerch2Quan.setText("");
				}catch (SQLException ee) {
				}
			}
		
		//상품 3의 적용버튼을 눌렀을 때------------------------------------------------------------------------------------------
		}else if(e.getSource()==btnMerch3) {
			String name = tfMerch3Name.getText();
			String quantity = tfMerch3Quan.getText();
			String cost = tfMerch3Cost.getText();
			int idx = 3;
			String merchNo = "상품3";
			
			if(name.equals("") && quantity.equals("") && cost.equals("")) { //아무것도 입력하지 않았을 때
				msg(merchNo+"의 수정할 품목에 내용을 적어주세요.");
			}else if(quantity.equals("") && cost.equals("")) { //이름만 입력했을 때
				String query = "update coffee_machine set name = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명이 수정되었습니다.");
					taName3.setText(name);
					tfMerch3Name.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && cost.equals("")) { //수량만 입력했을 때
				String query = "update coffee_machine set quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량이 수정되었습니다.");
					taQuan3.setText(quantity);
					tfMerch3Quan.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && quantity.equals("")) { //가격만 입력했을 때
				String query = "update coffee_machine set cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, cost);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 가격이 수정되었습니다.");
					taCost3.setText(cost);
					tfMerch3Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("")) { //수량과 가격만 입력했을 때
				String query = "update coffee_machine set quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량과 가격이 수정되었습니다.");
					taQuan3.setText(quantity);
					taCost3.setText(cost);
					tfMerch3Quan.setText("");
					tfMerch3Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(quantity.equals("")) { //이름과 가격만 입력했을 때
				String query = "update coffee_machine set name = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 가격이 수정되었습니다.");
					taName3.setText(name);
					taCost3.setText(cost);
					tfMerch3Name.setText("");
					tfMerch3Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(cost.equals("")) { //이름과 수량만 입력했을 때
				String query = "update coffee_machine set name = ?, quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량이 수정되었습니다.");
					taName3.setText(name);
					taQuan3.setText(quantity);
					tfMerch3Name.setText("");
					tfMerch3Quan.setText("");
				}catch (SQLException ee) {
				}
			}else { //모든 칸에 입력을 했을 때
				String query = "update coffee_machine set name = ?, quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setString(3, cost);
					pstmt.setInt(4, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량과 가격이 수정되었습니다.");
					taName3.setText(name);
					taCost3.setText(cost);
					taQuan3.setText(quantity);
					tfMerch3Name.setText("");
					tfMerch3Cost.setText("");
					tfMerch3Quan.setText("");
				}catch (SQLException ee) {
				}
			}
		
		//상품 4의 적용버튼을 눌렀을 때------------------------------------------------------------------------------------------
		}else if(e.getSource()==btnMerch4) {
			String name = tfMerch4Name.getText();
			String quantity = tfMerch4Quan.getText();
			String cost = tfMerch4Cost.getText();
			int idx = 4;
			String merchNo = "상품4";
			
			if(name.equals("") && quantity.equals("") && cost.equals("")) { //아무것도 입력하지 않았을 때
				msg(merchNo+"의 수정할 품목에 내용을 적어주세요.");
			}else if(quantity.equals("") && cost.equals("")) { //이름만 입력했을 때
				String query = "update coffee_machine set name = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명이 수정되었습니다.");
					taName4.setText(name);
					tfMerch4Name.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && cost.equals("")) { //수량만 입력했을 때
				String query = "update coffee_machine set quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량이 수정되었습니다.");
					taQuan4.setText(quantity);
					tfMerch4Quan.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && quantity.equals("")) { //가격만 입력했을 때
				String query = "update coffee_machine set cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, cost);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 가격이 수정되었습니다.");
					taCost4.setText(cost);
					tfMerch4Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("")) { //수량과 가격만 입력했을 때
				String query = "update coffee_machine set quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량과 가격이 수정되었습니다.");
					taQuan4.setText(quantity);
					taCost4.setText(cost);
					tfMerch4Quan.setText("");
					tfMerch4Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(quantity.equals("")) { //이름과 가격만 입력했을 때
				String query = "update coffee_machine set name = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 가격이 수정되었습니다.");
					taName4.setText(name);
					taCost4.setText(cost);
					tfMerch4Name.setText("");
					tfMerch4Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(cost.equals("")) { //이름과 수량만 입력했을 때
				String query = "update coffee_machine set name = ?, quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량이 수정되었습니다.");
					taName4.setText(name);
					taQuan4.setText(quantity);
					tfMerch4Name.setText("");
					tfMerch4Quan.setText("");
				}catch (SQLException ee) {
				}
			}else { //모든 칸에 입력을 했을 때
				String query = "update coffee_machine set name = ?, quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setString(3, cost);
					pstmt.setInt(4, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량과 가격이 수정되었습니다.");
					taName4.setText(name);
					taCost4.setText(cost);
					taQuan4.setText(quantity);
					tfMerch4Name.setText("");
					tfMerch4Cost.setText("");
					tfMerch4Quan.setText("");
				}catch (SQLException ee) {
				}
			}
		
		//상품 5의 적용버튼을 눌렀을 때------------------------------------------------------------------------------------------
		}else if(e.getSource()==btnMerch5) {
			String name = tfMerch5Name.getText();
			String quantity = tfMerch5Quan.getText();
			String cost = tfMerch5Cost.getText();
			int idx = 5;
			String merchNo = "상품5";
			
			if(name.equals("") && quantity.equals("") && cost.equals("")) { //아무것도 입력하지 않았을 때
				msg(merchNo+"의 수정할 품목에 내용을 적어주세요.");
			}else if(quantity.equals("") && cost.equals("")) { //이름만 입력했을 때
				String query = "update coffee_machine set name = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명이 수정되었습니다.");
					taName5.setText(name);
					tfMerch5Name.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && cost.equals("")) { //수량만 입력했을 때
				String query = "update coffee_machine set quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량이 수정되었습니다.");
					taQuan5.setText(quantity);
					tfMerch5Quan.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && quantity.equals("")) { //가격만 입력했을 때
				String query = "update coffee_machine set cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, cost);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 가격이 수정되었습니다.");
					taCost5.setText(cost);
					tfMerch5Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("")) { //수량과 가격만 입력했을 때
				String query = "update coffee_machine set quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량과 가격이 수정되었습니다.");
					taQuan5.setText(quantity);
					taCost5.setText(cost);
					tfMerch5Quan.setText("");
					tfMerch5Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(quantity.equals("")) { //이름과 가격만 입력했을 때
				String query = "update coffee_machine set name = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 가격이 수정되었습니다.");
					taName5.setText(name);
					taCost5.setText(cost);
					tfMerch5Name.setText("");
					tfMerch5Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(cost.equals("")) { //이름과 수량만 입력했을 때
				String query = "update coffee_machine set name = ?, quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량이 수정되었습니다.");
					taName5.setText(name);
					taQuan5.setText(quantity);
					tfMerch5Name.setText("");
					tfMerch5Quan.setText("");
				}catch (SQLException ee) {
				}
			}else { //모든 칸에 입력을 했을 때
				String query = "update coffee_machine set name = ?, quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setString(3, cost);
					pstmt.setInt(4, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량과 가격이 수정되었습니다.");
					taName5.setText(name);
					taCost5.setText(cost);
					taQuan5.setText(quantity);
					tfMerch5Name.setText("");
					tfMerch5Cost.setText("");
					tfMerch5Quan.setText("");
				}catch (SQLException ee) {
				}
			}
		
		//상품 6의 적용버튼을 눌렀을 때------------------------------------------------------------------------------------------
		}else if(e.getSource()==btnMerch6) {
			String name = tfMerch6Name.getText();
			String quantity = tfMerch6Quan.getText();
			String cost = tfMerch6Cost.getText();
			int idx = 6;
			String merchNo = "상품6";
			
			if(name.equals("") && quantity.equals("") && cost.equals("")) { //아무것도 입력하지 않았을 때
				msg(merchNo+"의 수정할 품목에 내용을 적어주세요.");
			}else if(quantity.equals("") && cost.equals("")) { //이름만 입력했을 때
				String query = "update coffee_machine set name = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명이 수정되었습니다.");
					taName6.setText(name);
					tfMerch6Name.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && cost.equals("")) { //수량만 입력했을 때
				String query = "update coffee_machine set quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량이 수정되었습니다.");
					taQuan6.setText(quantity);
					tfMerch6Quan.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("") && quantity.equals("")) { //가격만 입력했을 때
				String query = "update coffee_machine set cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, cost);
					pstmt.setInt(2, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 가격이 수정되었습니다.");
					taCost6.setText(cost);
					tfMerch6Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(name.equals("")) { //수량과 가격만 입력했을 때
				String query = "update coffee_machine set quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, quantity);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 수량과 가격이 수정되었습니다.");
					taQuan6.setText(quantity);
					taCost6.setText(cost);
					tfMerch6Quan.setText("");
					tfMerch6Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(quantity.equals("")) { //이름과 가격만 입력했을 때
				String query = "update coffee_machine set name = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, cost);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 가격이 수정되었습니다.");
					taName6.setText(name);
					taCost6.setText(cost);
					tfMerch6Name.setText("");
					tfMerch6Cost.setText("");
				}catch (SQLException ee) {
				}
			}else if(cost.equals("")) { //이름과 수량만 입력했을 때
				String query = "update coffee_machine set name = ?, quantity = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setInt(3, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량이 수정되었습니다.");
					taName6.setText(name);
					taQuan6.setText(quantity);
					tfMerch6Name.setText("");
					tfMerch6Quan.setText("");
				}catch (SQLException ee) {
				}
			}else { //모든 칸에 입력을 했을 때
				String query = "update coffee_machine set name = ?, quantity = ?, cost = ? where idx = ?";
				try {
					PreparedStatement pstmt = dc.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setString(2, quantity);
					pstmt.setString(3, cost);
					pstmt.setInt(4, idx);
					pstmt.executeUpdate();
					pstmt.close();
					msg(merchNo+"의 상품명과 수량과 가격이 수정되었습니다.");
					taName6.setText(name);
					taCost6.setText(cost);
					taQuan6.setText(quantity);
					tfMerch6Name.setText("");
					tfMerch6Cost.setText("");
					tfMerch6Quan.setText("");
				}catch (SQLException ee) {
				}
			}
		}
	}
	void msg(String msg) { //메세지창
		final Dialog dlg = new Dialog(this, "알림 메세지창", true);
		dlg.setLayout(null);
		JTextArea taMsg = new JTextArea(msg);
		taMsg.setEditable(false);
		
		dlg.add(taMsg);
		
		taMsg.setBounds(10, 60, 380, 100); taMsg.setFont(font15);
		
		dlg.setSize(400, 250);
		dlg.setLocation(800, 400);
		
		dlg.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dlg.setVisible(false);
			}
		});
		dlg.setVisible(true);
	}
}

































