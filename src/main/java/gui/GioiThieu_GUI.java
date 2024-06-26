package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class GioiThieu_GUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GioiThieu_GUI frame = new GioiThieu_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GioiThieu_GUI() {
		super("Giới thiệu phần mềm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(this.createGUI());
		
		
	}
	public JPanel createGUI() {
		JPanel pnlTroGiup = new JPanel();
		pnlTroGiup.setBackground(new Color(240, 248, 255));
		pnlTroGiup.setBounds(0, 50, 1264, 632);
		pnlTroGiup.setLayout(null);
		
		JLabel lblTitle = new JLabel("Phần mềm được làm ra nhầm mục đích hỗ trợ những "
				+ "nhân viên văn phòng làm việc nhanh hơn, hiệu quả hơn");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setBounds(0, 0, 1264, 74);
		
		pnlTroGiup.add(lblTitle);
		
		JTextPane txtpnNoiDung = new JTextPane();
		txtpnNoiDung.setEditable(false);
		txtpnNoiDung.setText("Phần mềm hỗ trợ nhân viên trong việc tính lương, phân chia công đoạn và phân công công nhân vào công đoạn. Bên cạnh đó, phần mềm còn hỗ trợ cho những nhân viên văn phòng các chức năng như: Chấm công, quản lý nhân viên, công nhân. Hy vọng những tính năng đã có sẵn ở phần mềm sẽ hỗ trợ nhân viên làm việc tốt hơn trong công việc.");
		txtpnNoiDung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtpnNoiDung.setBounds(10, 63, 1244, 140);
		MutableAttributeSet mas = new SimpleAttributeSet();
		StyleConstants.setFontFamily(mas, "Tahoma");
		StyleConstants.setFontSize(mas, 20);
		StyleConstants.setLineSpacing(mas, (float) 1.1);
		txtpnNoiDung.setParagraphAttributes(mas, true);
		
		pnlTroGiup.add(txtpnNoiDung);
		
		JLabel lblCre = new JLabel("Phần mềm được tạo ra bởi:");
		lblCre.setHorizontalAlignment(SwingConstants.CENTER);
		lblCre.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCre.setBounds(10, 213, 1244, 30);
		pnlTroGiup.add(lblCre);
		
		JLabel lblLMinhTht = new JLabel("Lê Minh Thật");
		lblLMinhTht.setHorizontalAlignment(SwingConstants.CENTER);
		lblLMinhTht.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLMinhTht.setBounds(10, 251, 1244, 30);
		pnlTroGiup.add(lblLMinhTht);
		
		JLabel lblVnQu = new JLabel("Văn Quí");
		lblVnQu.setHorizontalAlignment(SwingConstants.CENTER);
		lblVnQu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVnQu.setBounds(10, 291, 1244, 30);
		pnlTroGiup.add(lblVnQu);
		
		JLabel lblHunhKimThnh = new JLabel("Huỳnh Kim Thành");
		lblHunhKimThnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHunhKimThnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHunhKimThnh.setBounds(10, 331, 1244, 30);
		pnlTroGiup.add(lblHunhKimThnh);
		
		JLabel lblTrnQucKhnh = new JLabel("Trần Quốc Khánh");
		lblTrnQucKhnh.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrnQucKhnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTrnQucKhnh.setBounds(10, 371, 1244, 30);
		pnlTroGiup.add(lblTrnQucKhnh);
		
		JLabel lblCre2 = new JLabel("Phần mềm được cập nhật bởi:");
		lblCre2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCre2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCre2.setBounds(10, 441, 1244, 30);
		pnlTroGiup.add(lblCre2);
		
		JLabel lblLMinhTht2 = new JLabel("Lê Minh Thật");
		lblLMinhTht2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLMinhTht2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLMinhTht2.setBounds(10, 481, 1244, 30);
		pnlTroGiup.add(lblLMinhTht2);
		
		JLabel lblAnhThang = new JLabel("Trương Hải Anh Thắng");
		lblAnhThang.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnhThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAnhThang.setBounds(10, 521, 1244, 30);
		pnlTroGiup.add(lblAnhThang);
		
		JLabel lblHunhKimThanh = new JLabel("Huỳnh Kim Thành");
		lblHunhKimThanh.setHorizontalAlignment(SwingConstants.CENTER);
		lblHunhKimThanh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHunhKimThanh.setBounds(10, 561, 1244, 30);
		pnlTroGiup.add(lblHunhKimThanh);
		
		return pnlTroGiup;
	}
}
