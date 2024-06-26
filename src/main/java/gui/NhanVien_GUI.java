package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import dao.BoPhan_DAO;
import dao.NhanVien_DAO;
import entity.BoPhan;
import entity.NhanVien;

public class NhanVien_GUI implements MouseListener, ActionListener {

	private JFrame frame;
	private JPanel contentPane;
	private JPanel pnTop, pnCenter;
	private JLabel lblHoDem, lblTen, lblNgaySinh, lblCCCD, lblGioiTinh, lblSDT, lblDiaChi, lblBatDauLam, lblCaLam,
			lblLuongCB, lblAvt, lblBacLuong, lblHeSoLuong, lblBoPhan;
	private JTextField txtHoDem, txtTen, txtCCCD, txtSDT, txtDiaChi, txtLuongCB, txtTimKiem;
	private kDatePicker dpNgaySinh, dpBatDauLam;
	private JCheckBox chkSang, chkToi;
	private JRadioButton rdoNam, rdoNu;
	private DefaultComboBoxModel<String> modelBacLuong, modelHeSoLuong;
	private JComboBox<String> cboBacLuong, cboHeSoLuong;
	private JButton btnTimKiem, btnXuatDs, btnThem, btnXoa, btnSua, btnThemAnh;
	private DefaultComboBoxModel<String> modelNam;
	private JComboBox<String> cboNam;
	public DefaultTableModel modelDsNV;
	public JTable tblDsNV;
	private NhanVien_DAO nhanVienDao;
	private static ArrayList<NhanVien> dsNV;
	private DefaultComboBoxModel<String> modelBoPhan;
	private JComboBox<String> cboBoPhan;
	private BoPhan_DAO boPhanDao;
	private List<BoPhan> dsBP;
	private ArrayList<NhanVien> dsNVBP;
	private String ma;
	private List<String> dsTen;

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NhanVien_GUI window = new NhanVien_GUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public NhanVien_GUI() {
		frame = new JFrame("Nhân viên");
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setLayout(null);

		frame.setContentPane(contentPane);

		try {
			contentPane.add(this.createGUI());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public JPanel createGUI() throws RemoteException {
		nhanVienDao = Initiate.nhanVien_DAO;
		boPhanDao = Initiate.boPhan_DAO;

		dsNV = nhanVienDao.getListNV();
		dsBP = boPhanDao.getdsBoPhan();
		dsNVBP = new ArrayList<NhanVien>();
		dsNV = nhanVienDao.getListNV();
		dsTen = new ArrayList<String>();

		JPanel pnlNV = new JPanel();
		pnlNV.setBounds(0, 50, 1268, 632);
		;
		pnlNV.setLayout(new BorderLayout(0, 0));

		pnlNV.setLayout(new BorderLayout(0, 0));
		pnTop = new JPanel();
		pnlNV.add(pnTop, BorderLayout.NORTH);
		pnTop.setBorder(new EmptyBorder(20, 20, 0, 20));
		pnTop.setLayout(new BoxLayout(pnTop, BoxLayout.X_AXIS));

		Box b, b1, b2, b3, b11, b12, b13, b14, b15, b21, b22, b23, b31, b32, b33;

		b = Box.createHorizontalBox();
		pnTop.add(b);

		b1 = Box.createVerticalBox();
		b2 = Box.createVerticalBox();
		b3 = Box.createVerticalBox();

		b11 = Box.createHorizontalBox();
		b12 = Box.createHorizontalBox();
		b13 = Box.createHorizontalBox();
		b14 = Box.createHorizontalBox();
		b15 = Box.createHorizontalBox();

		b11.setPreferredSize(new Dimension(200, 33));
		b12.setPreferredSize(new Dimension(200, 33));
		b13.setPreferredSize(new Dimension(200, 33));
		b14.setPreferredSize(new Dimension(200, 33));
		b15.setPreferredSize(new Dimension(200, 33));

		b21 = Box.createHorizontalBox();
		b22 = Box.createHorizontalBox();
		b23 = Box.createHorizontalBox();

		b21.setPreferredSize(new Dimension(200, 30));
		b22.setPreferredSize(new Dimension(200, 33));
		b23.setPreferredSize(new Dimension(200, 33));

		b31 = Box.createHorizontalBox();
		b32 = Box.createHorizontalBox();
		b33 = Box.createHorizontalBox();

		b.add(b1);
		b.add(Box.createHorizontalStrut(30));

		b.add(b2);
		b.add(Box.createHorizontalStrut(50));
		b.add(b3);

		b1.add(b11);
		b1.add(Box.createVerticalStrut(5));
		b1.add(b12);
		b1.add(Box.createVerticalStrut(5));
		b1.add(b13);
		b1.add(Box.createVerticalStrut(5));
		b1.add(b14);
		b1.add(Box.createVerticalStrut(5));
		b1.add(b15);

		b3.add(Box.createVerticalStrut(15));
		b3.add(b31);
		b3.add(Box.createVerticalStrut(25));
		b3.add(b32);
		b3.add(Box.createVerticalStrut(25));
		b3.add(b33);
		b3.add(Box.createVerticalStrut(15));

		b3.setBorder(BorderFactory.createTitledBorder("Tác vụ"));

		b31.setPreferredSize(new Dimension(200, 33));
		b32.setPreferredSize(new Dimension(200, 33));
		b33.setPreferredSize(new Dimension(200, 33));

		b21.setPreferredSize(new Dimension(200, 33));
		b22.setPreferredSize(new Dimension(200, 33));

		b1.setPreferredSize(new Dimension(432, 180));

		b2.setPreferredSize(new Dimension(216, 180));

		lblNgaySinh = new JLabel("Ngày Sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCaLam = new JLabel("Ca làm cố định");
		lblCaLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoDem = new JLabel("Họ đệm");
		lblHoDem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHoDem.setPreferredSize(lblNgaySinh.getPreferredSize());
		b11.add(lblHoDem);
		b11.add(Box.createHorizontalStrut(15));

		txtHoDem = new JTextField();
		txtHoDem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHoDem.setPreferredSize(new Dimension(20, 36));
		b11.add(txtHoDem);
		b11.add(Box.createHorizontalStrut(20));

		lblSDT = new JLabel("Số điện thoại");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT.setPreferredSize(lblCaLam.getPreferredSize());
		b11.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSDT.setPreferredSize(txtHoDem.getPreferredSize());
		b11.add(txtSDT);

		lblTen = new JLabel("Tên");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTen.setPreferredSize(lblNgaySinh.getPreferredSize());
		b12.add(lblTen);
		b12.add(Box.createHorizontalStrut(15));

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTen.setPreferredSize(txtHoDem.getPreferredSize());
		b12.add(txtTen);
		b12.add(Box.createHorizontalStrut(20));

		lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDiaChi.setPreferredSize(lblCaLam.getPreferredSize());
		b12.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDiaChi.setPreferredSize(txtHoDem.getPreferredSize());
		b12.add(txtDiaChi);

		b13.add(lblNgaySinh);
		b13.add(Box.createHorizontalStrut(15));

		dpNgaySinh = new kDatePicker(192);
		dpNgaySinh.setPreferredSize(new Dimension(193, 35));
		b13.add(dpNgaySinh);

		b13.add(Box.createHorizontalStrut(20));
		lblBatDauLam = new JLabel("Bắt đầu làm");
		lblBatDauLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBatDauLam.setPreferredSize(lblCaLam.getPreferredSize());
		b13.add(lblBatDauLam);

		dpBatDauLam = new kDatePicker(193);
		dpBatDauLam.setPreferredSize(new Dimension(193, 35));
		b13.add(dpBatDauLam);

		lblCCCD = new JLabel("CCCD");
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCCCD.setPreferredSize(lblNgaySinh.getPreferredSize());
		b14.add(lblCCCD);
		b14.add(Box.createHorizontalStrut(15));

		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b14.add(txtCCCD);

		b14.add(Box.createHorizontalStrut(20));
		b14.add(lblCaLam);
		b14.add(Box.createHorizontalStrut(43));

		chkSang = new JCheckBox("Sáng");
		chkSang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b14.add(chkSang);
		b14.add(Box.createHorizontalStrut(45));

		chkToi = new JCheckBox("Tối");
		chkToi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b14.add(chkToi);

		lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGioiTinh.setPreferredSize(lblNgaySinh.getPreferredSize());
		b15.add(lblGioiTinh);
		b15.add(Box.createHorizontalStrut(40));

		rdoNam = new JRadioButton("Nam");
		rdoNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdoNu = new JRadioButton("Nữ");
		rdoNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdoNam);
		buttonGroup.add(rdoNu);
		b15.add(rdoNam);
		b15.add(Box.createHorizontalStrut(60));
		b15.add(rdoNu);
		b15.add(Box.createHorizontalStrut(35));

		lblLuongCB = new JLabel("Lương cơ bản");
		lblLuongCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLuongCB.setPreferredSize(lblCaLam.getPreferredSize());
		b15.add(lblLuongCB);

		txtLuongCB = new JTextField();
		txtLuongCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b15.add(txtLuongCB);

		lblHeSoLuong = new JLabel("Hệ số lương");
		lblHeSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JPanel overlayPanel = new JPanel();
		overlayPanel.setLayout(new OverlayLayout(overlayPanel));
		overlayPanel.setPreferredSize(new Dimension(80, 90));

		lblAvt = new JLabel("");
		lblAvt.setPreferredSize(new Dimension(50, 110));
		lblAvt.setMaximumSize(new Dimension(90, 100));

		btnThemAnh = new JButton("Chọn ảnh");
		overlayPanel.add(lblAvt);
		overlayPanel.add(btnThemAnh);

		btnThemAnh.setAlignmentX(0.5f);
		btnThemAnh.setAlignmentY(0.5f);
		btnThemAnh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

				int result = fileChooser.showOpenDialog(null);

				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					resizeAndSetImage(selectedFile, lblAvt);
					btnThemAnh.setVisible(false);
				}
			}
		});

		b2.add(overlayPanel);

		lblBacLuong = new JLabel("Bậc lương");
		lblBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBacLuong.setPreferredSize(lblHeSoLuong.getPreferredSize());
		b21.add(lblBacLuong);
		b21.add(Box.createHorizontalStrut(15));

		modelBacLuong = new DefaultComboBoxModel<String>();
		cboBacLuong = new JComboBox<String>(modelBacLuong);
		cboBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboBacLuong.setPreferredSize(new Dimension(120, 35));
		for (int bacLuong : layDSBacLuong()) {
			cboBacLuong.addItem(String.valueOf(bacLuong));
		}
		cboBacLuong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedOption = Integer.valueOf(String.valueOf(cboBacLuong.getSelectedItem()));
				for (int n = 0; n < layDSBacLuong().size(); n++) {
					if (layDSBacLuong().get(n) == selectedOption) {
						cboHeSoLuong.setSelectedIndex(n);
					}
				}
			}
		});

		ItemListener itemListener = new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				JCheckBox source = (JCheckBox) e.getSource();

				if (e.getStateChange() == ItemEvent.SELECTED) {
					if (source == chkSang) {
						chkToi.setSelected(false);

					} else if (source == chkToi) {
						chkSang.setSelected(false);
					}

				}
			}
		};

		chkSang.addItemListener(itemListener);
		chkToi.addItemListener(itemListener);

		b21.add(cboBacLuong);
		b2.add(b21);
		b2.add(Box.createVerticalStrut(10));
		b21.setPreferredSize(new Dimension(50, 25));

		b22.add(lblHeSoLuong);
		b22.add(Box.createHorizontalStrut(12));
		b22.setPreferredSize(new Dimension(50, 25));

		modelHeSoLuong = new DefaultComboBoxModel<String>();
		cboHeSoLuong = new JComboBox<String>(modelHeSoLuong);
		cboHeSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboHeSoLuong.setPreferredSize(new Dimension(120, 35));
		cboHeSoLuong.setEnabled(false);

		for (double heSoLuong : layDSHeSoLuong()) {
			cboHeSoLuong.addItem(String.valueOf(heSoLuong));
		}
		b22.add(cboHeSoLuong);
		b2.add(b21);
		b2.add(Box.createVerticalStrut(7));
		b2.add(b22);
		b2.add(Box.createVerticalStrut(7));

		modelBoPhan = new DefaultComboBoxModel<String>();
		cboBoPhan = new JComboBox<String>(modelBoPhan);

		lblBoPhan = new JLabel("Bộ phận");
		lblBoPhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBoPhan.setPreferredSize(lblHeSoLuong.getPreferredSize());
		for (BoPhan bp : dsBP) {
			modelBoPhan.addElement(bp.getTenBoPhan());
		}
		modelBoPhan.addElement("Tất cả");
		modelBoPhan.setSelectedItem("Tất cả");

		cboBoPhan.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					String tenBoPhan = String.valueOf(cboBoPhan.getSelectedItem());
					if (tenBoPhan.equals("Tất cả")) {
						if (String.valueOf(cboNam.getSelectedItem()) != "Tất cả") {
							dsNV = nhanVienDao
									.getListNVtheoNamVaoLam(Integer.valueOf((String) cboNam.getSelectedItem()));
							dsTen.removeAll(dsTen);
							dsTen = layDsTen(dsNV);
							AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
							if (dsNVBP.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							}
							clearTable();
							docDuLieuVaoTable(dsNV);
							return;
						} else if (String.valueOf(cboNam.getSelectedItem()) == "Tất cả") {
							dsNV = nhanVienDao.getListNV();
							if (dsNVBP.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							}
							dsTen.removeAll(dsTen);
							dsTen = layDsTen(dsNV);
							AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
							clearTable();
							docDuLieuVaoTable(dsNV);
							return;
						}

					} else {
						if (String.valueOf(cboNam.getSelectedItem()) != "Tất cả") {
							dsNVBP = nhanVienDao.getListNVtheoNamBP(Integer.valueOf((String) cboNam.getSelectedItem()),
									dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan());
							if (dsNVBP.isEmpty() == true) {
//							cboNam.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							} else {
								dsTen.removeAll(dsTen);
								dsTen = layDsTen(dsNVBP);
								AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
								clearTable();
								docDuLieuVaoTable(dsNVBP);
								return;
							}

						} else {

							dsNVBP = nhanVienDao.getListNVtheoBP(dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan());
							if (dsNVBP.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							}
							dsTen.removeAll(dsTen);
							dsTen = layDsTen(dsNVBP);
							AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
							clearTable();
							docDuLieuVaoTable(dsNVBP);
							return;
						}

					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}

		});

		b23.add(lblBoPhan);
		b23.add(Box.createHorizontalStrut(15));
		b23.add(cboBoPhan);
		b23.setPreferredSize(new Dimension(50, 25));
		b2.add(b23);

		b31.add(Box.createHorizontalStrut(20));
		txtTimKiem = new JTextField("Nhập tên");
		txtTimKiem.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// Xóa placeholder text khi TextField nhận focus
				if (txtTimKiem.getText().equals("Nhập tên")) {
					txtTimKiem.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtTimKiem.getText().isEmpty()) {
					txtTimKiem.setText("Nhập tên");
				}
			}
		});
		b31.add(txtTimKiem);

		btnTimKiem = new JButton("");
		btnTimKiem.setPreferredSize(new Dimension(35, 50));
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));

		dsTen = layDsTen(dsNV);
		AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);

		txtTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtTimKiem.setCaretPosition(txtTimKiem.getText().length());
			}
		});

		txtTimKiem.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					if ((txtTimKiem.getSelectionStart() == 1
							&& txtTimKiem.getSelectionEnd() == txtTimKiem.getText().length())
							|| (txtTimKiem.getSelectionStart() == 0
									&& txtTimKiem.getSelectionEnd() == txtTimKiem.getText().length())) {
						txtTimKiem.setText("");
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {

			}
		});

		btnTimKiem.setIcon(new ImageIcon("img\\icons\\icons8-magnifying-glass-20.png"));
		btnTimKiem.setBackground(new Color(255, 255, 255));
		b31.add(btnTimKiem);
		b31.add(Box.createHorizontalStrut(50));

		modelNam = new DefaultComboBoxModel<String>();
		cboNam = new JComboBox<String>(modelNam);
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboNam.setPreferredSize(new Dimension(120, 35));
		capNhatCboNam();
		cboNam.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				try {

					if (String.valueOf(cboNam.getSelectedItem()) != "Tất cả") {
						if (String.valueOf(cboBoPhan.getSelectedItem()).equals("Tất cả")) {
							dsNV = nhanVienDao
									.getListNVtheoNamVaoLam(Integer.valueOf((String) cboNam.getSelectedItem()));
							if (dsNV.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							}
							dsTen.removeAll(dsTen);
							dsTen = layDsTen(dsNV);
							AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
							clearTable();
							docDuLieuVaoTable(dsNV);
							return;

						} else {
							dsNVBP = nhanVienDao.getListNVtheoNamBP(Integer.valueOf((String) cboNam.getSelectedItem()),
									dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan());
							if (dsNVBP.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							} else {
								dsTen.removeAll(dsTen);
								dsTen = layDsTen(dsNVBP);
								AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
								clearTable();
								docDuLieuVaoTable(dsNVBP);
								return;
							}

						}
					} else {
						if (String.valueOf(cboNam.getSelectedItem()) == "Tất cả") {
							dsNV = nhanVienDao.getListNV();
							if (dsNV.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							}
							dsTen.removeAll(dsTen);
							dsTen = layDsTen(dsNV);
							AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
							clearTable();
							docDuLieuVaoTable(dsNV);
							return;
						} else {
							int viTri = cboBoPhan.getSelectedIndex();
							dsNVBP = nhanVienDao.getListNVtheoBP(dsBP.get(viTri).getMaBoPhan());
							if (dsNVBP.isEmpty() == true) {
//							cboBoPhan.setSelectedItem("Tất cả");
//							JOptionPane.showMessageDialog(frame, "Không tìm thấy nhân viên nào");
								modelDsNV.setRowCount(0);
								return;
							}
							dsTen.removeAll(dsTen);
							dsTen = layDsTen(dsNVBP);
							AutoCompleteDecorator.decorate(txtTimKiem, dsTen, false);
							clearTable();
							docDuLieuVaoTable(dsNVBP);
							return;
						}

					}
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		b31.add(cboNam);
		b31.add(Box.createHorizontalStrut(20));

		b32.add(Box.createHorizontalStrut(20));
		btnXuatDs = new JButton("Xuất DS");
		b32.add(btnXuatDs);
		btnXuatDs.setMaximumSize(new Dimension(140, 45));
		btnXuatDs.setIcon(new ImageIcon("img\\icons\\icons8-excel-20.png"));
		btnXuatDs.setBackground(new Color(255, 255, 255));
		b32.add(Box.createHorizontalStrut(50));

		btnThem = new JButton("Thêm");
		b32.add(btnThem);
		btnThem.setMaximumSize(new Dimension(140, 45));
		btnThem.setIcon(new ImageIcon("img\\icons\\icons8-add-user-20.png"));
		btnThem.setBackground(new Color(255, 255, 255));
		b32.add(Box.createHorizontalStrut(20));

		b33.add(Box.createHorizontalStrut(20));
		btnSua = new JButton("Sửa");
		b33.add(btnSua);
		btnSua.setMaximumSize(new Dimension(160, 45));
		btnSua.setIcon(new ImageIcon("img\\icons\\icons8-pencil-20.png"));
		btnSua.setBackground(new Color(255, 255, 255));
		b33.add(Box.createHorizontalStrut(50));

		btnXoa = new JButton("Xóa");
		btnXoa.setMaximumSize(new Dimension(140, 45));
		b33.add(btnXoa);
		btnXoa.setIcon(new ImageIcon("img\\icons\\icons8-delete-20.png"));
		btnXoa.setBackground(new Color(255, 255, 255));
		b33.add(Box.createHorizontalStrut(20));

		pnCenter = new JPanel();
		pnlNV.add(pnCenter, BorderLayout.CENTER);
		String[] cols_nhanVien = { "Mã nhân viên", "Họ đệm", "Tên", "Tuổi", "Ngày sinh", "CCCD", "Giới tính", "SĐT",
				"Địa chỉ", "Ngày bắt đầu làm", "Ca làm việc", "Bậc lương", "Lương cơ bản", "Hệ số lương", "Phụ cấp",
				"Bộ phận" };
		modelDsNV = new DefaultTableModel(cols_nhanVien, 0);
		tblDsNV = new JTable(modelDsNV);
		tblDsNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDsNV.setRowHeight(24);
		JScrollPane scrollPane = new JScrollPane(tblDsNV);
		pnCenter.add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(1220, 400));
		TableColumn column = tblDsNV.getColumnModel().getColumn(15);
		column.setPreferredWidth(100);
		dsNVBP = nhanVienDao.getListNVtheoBP(dsBP.get(0).getMaBoPhan());
		docDuLieuVaoTable(dsNV);

		tblDsNV.addMouseListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnXuatDs.addActionListener(this);

		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItem1 = new JMenuItem("Làm mới");

		menuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtTen.setText("");
				txtHoDem.setText("");
				txtSDT.setText("");
				txtDiaChi.setText("");
				txtCCCD.setText("");
				txtLuongCB.setText("");

				rdoNam.setSelected(false);
				rdoNu.setSelected(false);

				chkSang.setSelected(false);
				chkToi.setSelected(false);

				dpNgaySinh.setValueToDay();
				dpBatDauLam.setValueToDay();
			}
		});

		popupMenu.add(menuItem1);
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
		return pnlNV;
	}

	public void docDuLieuVaoTable(ArrayList<NhanVien> dsNV) {
		for (NhanVien nv : dsNV) {
			String tenBP = "";
			for (BoPhan bp : dsBP) {
				if (bp.getMaBoPhan().equals(nv.getBoPhan().getMaBoPhan())) {
					tenBP = bp.getTenBoPhan();
				}
			}
			Object[] rowData = { nv.getMaNV(), nv.getHo(), nv.getTen(), tinhTuoi(nv), nv.getNgaySinh(), nv.getcCCD(),
					laGioiTinh(nv), nv.getSoDienThoai(), nv.getDiaChi(), nv.getNgayBatDauLamViec(), layCaLamViec(nv),
					nv.getThangBacLuong(), nv.getLuongCoBan(), nv.getHeSoLuong(), nv.getPhuCap(), tenBP };
			modelDsNV.addRow(rowData);
		}
	}

	public int tinhTuoi(NhanVien nv) {
		LocalDate currentDate = LocalDate.now();
		return Period.between(nv.getNgaySinh(), currentDate).getYears();
	}

	public int tinhTuoiTheoNS(LocalDate ns) {
		LocalDate currentDate = LocalDate.now();
		return Period.between(ns, currentDate).getYears();
	}

	public String laGioiTinh(NhanVien nv) {
		if (nv.isGioiTinh() == true) {
			return "Nam";
		}
		return "Nữ";
	}

	public List<Integer> layDSBacLuong() {
		Set<Integer> dsBacLuong = new HashSet<>();

		for (NhanVien nv : dsNV) {
			dsBacLuong.add(nv.getThangBacLuong());
		}
		ArrayList<Integer> ds = new ArrayList<Integer>(dsBacLuong);
		Collections.sort(ds);
		return ds;
	}

	public List<String> layDSNamVaoLam() throws RemoteException {
		Set<String> dsNam = new HashSet<String>();
		dsNV = nhanVienDao.getListNV();
		for (NhanVien nv : dsNV) {
			dsNam.add(String.valueOf(nv.getNgayBatDauLamViec().getYear()));
		}
		ArrayList<String> ds = new ArrayList<String>(dsNam);
		Collections.sort(ds);

		return ds;
	}

	public List<Double> layDSHeSoLuong() {
		Set<Double> dsHeSoLuong = new HashSet<>();

		for (NhanVien nv : dsNV) {
			dsHeSoLuong.add(nv.getHeSoLuong());
		}
		ArrayList<Double> ds = new ArrayList<Double>(dsHeSoLuong);
		Collections.sort(ds);
		return ds;
	}

	public String layCaLamViec(NhanVien nv) {
		if (nv.getCaLamViec() == 1) {
			return "Sáng";
		}
		return "Tối";

	}

	public static String phatSinhMaNV(LocalDate today) {
		// Lấy 2 số cuối của năm hiện tại
		SimpleDateFormat yearFormat = new SimpleDateFormat("yy");
		String maMax = "";
		String year = yearFormat.format(Date.valueOf(today));
		int count = 0;
		for (NhanVien nv : dsNV) {
			if (nv.getNgayBatDauLamViec().getYear() == today.getYear()) {
				count++;
				maMax = nv.getMaNV();
			}
		}
		if (count == 0) {
			// Định dạng thứ tự người làm vào công ty trong năm
			String formattedSequence = String.format("%04d", count + 1);

			// Tạo mã nhân viên
			String employeeId = "NV" + year + formattedSequence;
			return employeeId;
		} else {
			count = Integer.parseInt(maMax.substring(maMax.length() - 4));
			String formattedSequence = String.format("%04d", count + 1);

			// Tạo mã nhân viên
			String employeeId = "NV" + year + formattedSequence;
			return employeeId;
		}

	}

	public void capNhatCboNam() throws RemoteException {
		for (String nam : layDSNamVaoLam()) {
			modelNam.addElement(nam);
		}
		modelNam.addElement("Tất cả");
		modelNam.setSelectedItem("Tất cả");

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblDsNV.getSelectedRow();

		String boPhan = String.valueOf(cboBoPhan.getSelectedItem());

		if (boPhan.equals("Bộ phận kế toán") || boPhan.equals("Bộ phận nhân sự") || boPhan.equals("Quản lý Xưởng")) {
			{
				if (row != -1) {
					NhanVien nv = dsNVBP.get(row);
					ma = nv.getMaNV();
					txtTen.setText(nv.getTen());
					if (nv.getAnhDaiDien() != null) {
						lblAvt.setIcon(convertByteArrayToImageIcon(nv.getAnhDaiDien()));
						lblAvt.setAlignmentX(0.45f);
						btnThemAnh.setVisible(false);
					} else {
						lblAvt.setText("");
						lblAvt.setIcon(null);
						btnThemAnh.setVisible(true);

					}
					txtHoDem.setText(nv.getHo());
					txtSDT.setText(nv.getSoDienThoai());
					txtDiaChi.setText(nv.getDiaChi());
					txtCCCD.setText(nv.getcCCD());
					txtLuongCB.setText(String.valueOf(nv.getLuongCoBan()));
					cboBacLuong.setSelectedItem(String.valueOf(nv.getThangBacLuong()));
					cboHeSoLuong.setSelectedItem(String.valueOf(nv.getHeSoLuong()));
					if (nv.isGioiTinh() == true) {
						rdoNam.setSelected(true);
					} else
						rdoNu.setSelected(true);
					if (nv.getCaLamViec() == 1) {
						chkSang.setSelected(true);
						chkToi.setSelected(false);
					} else {
						chkSang.setSelected(false);
						chkToi.setSelected(true);

					}
					dpNgaySinh.setValue(Date.valueOf(nv.getNgaySinh()));
					dpBatDauLam.setValue(Date.valueOf(nv.getNgayBatDauLamViec()));

				}

			}

		}

		if (boPhan.equals("Tất cả")) {
			if (row != -1) {
				NhanVien nv = dsNV.get(row);
				ma = nv.getMaNV();
				if (nv.getAnhDaiDien() != null) {
					lblAvt.setIcon(convertByteArrayToImageIcon(nv.getAnhDaiDien()));
					lblAvt.setAlignmentX(0.45f);
					btnThemAnh.setVisible(false);
				} else {
					lblAvt.setText("");
					lblAvt.setIcon(null);
					btnThemAnh.setVisible(true);

				}

				txtTen.setText(nv.getTen());
				txtHoDem.setText(nv.getHo());
				txtSDT.setText(nv.getSoDienThoai());
				txtDiaChi.setText(nv.getDiaChi());
				txtCCCD.setText(nv.getcCCD());
				txtLuongCB.setText(String.valueOf(nv.getLuongCoBan()));
				cboBacLuong.setSelectedItem(String.valueOf(nv.getThangBacLuong()));
				cboHeSoLuong.setSelectedItem(String.valueOf(nv.getHeSoLuong()));
				if (nv.isGioiTinh() == true) {
					rdoNam.setSelected(true);
				} else
					rdoNu.setSelected(true);
				if (nv.getCaLamViec() == 1) {
					chkSang.setSelected(true);
					chkToi.setSelected(false);
				} else {
					chkSang.setSelected(false);
					chkToi.setSelected(true);

				}
				dpNgaySinh.setValue(Date.valueOf(nv.getNgaySinh()));
				dpBatDauLam.setValue(Date.valueOf(nv.getNgayBatDauLamViec()));
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnThem) {
			cboNam.setSelectedItem("Tất cả");
			String hoDem = txtHoDem.getText();
			String regexHoDem = "^(\\p{Lu}\\p{L}*(\\s|$))+";
			Pattern patternHoDem = Pattern.compile(regexHoDem);
			if (hoDem.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống họ đệm");
				return;
			}
			if (patternHoDem.matches(regexHoDem, hoDem) == false) {
				JOptionPane.showMessageDialog(frame, "Các từ trong họ đệm phải có chữ cái đầu viết hoa");
				return;
			}

			String ten = txtTen.getText();
			String regexTen = "^[A-Z]";
			if (ten.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống tên");
				return;
			}
			if (Pattern.matches(regexTen, ten)) {
				JOptionPane.showMessageDialog(frame, "Chữ cái đầu của tên phải viết hoa");
				return;

			}

			String diaChi = txtDiaChi.getText();
			if (diaChi.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống địa chỉ");
				return;
			}

			String sdt = txtSDT.getText();
			String regexSDT = "0[135789]\\d{8}";
			Pattern patternSDT = Pattern.compile(regexSDT);
			if (sdt.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống số điện thoại");
				return;
			}
			if (patternSDT.matches(regexSDT, sdt) == false) {
				JOptionPane.showMessageDialog(frame,
						"Số điện thoại phải có đầu số là 01,03,05,07,08,09 và gồm 10 chữ số");
				return;
			}

			String cccd = txtCCCD.getText();
			String regexCCCD = "^[0-9]{12}$";
			if (cccd.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống căn cước công dân");
				return;
			}
			if (Pattern.matches(regexCCCD, cccd) == false) {
				JOptionPane.showMessageDialog(frame, "Căn cước công dân bao gồm 12 số");
				return;
			}

			String regexLuongCB = "^[-+]?\\d*\\.?\\d+$";
			if (txtLuongCB.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống lương");
				return;
			}
			if (Pattern.matches(regexLuongCB, txtLuongCB.getText()) == false) {
				JOptionPane.showMessageDialog(frame, "Lương phải là một số tiền");
				return;
			}
			double luongCB = Double.valueOf(txtLuongCB.getText());

			LocalDate ngaySinh = null;
			try {
				ngaySinh = dpNgaySinh.getFullDate().toLocalDate();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (tinhTuoiTheoNS(ngaySinh) < 18) {
				JOptionPane.showMessageDialog(frame, "Nhân viên chưa đủ 18 tuổi");
				return;
			}

			if (String.valueOf(cboBoPhan.getSelectedItem()).equals("Tất cả")) {
				JOptionPane.showMessageDialog(frame, "Bạn chưa chọn bộ phận cho nhân viên");
			}

			LocalDate ngayBatDauLam = null;
			try {
				ngayBatDauLam = dpBatDauLam.getFullDate().toLocalDate();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if ((rdoNam.isSelected() == false) && (rdoNu.isSelected() == false)) {
				JOptionPane.showMessageDialog(frame, "Bạn chưa chọn giới tính");
				return;
			}

			String maNV = phatSinhMaNV(ngayBatDauLam);
			Boolean gioiTinh = null;
			if (rdoNam.isSelected() == true) {
				gioiTinh = true;
			} else if (rdoNu.isSelected() == true)
				gioiTinh = false;

			int caLam = 1;
			if ((chkSang.isSelected() == false) && (chkToi.isSelected() == false)) {
				JOptionPane.showMessageDialog(frame, "Bạn chưa chọn ca làm");
				return;
			}
			if (chkSang.isSelected() == true) {
				caLam = 1;
			} else if (chkToi.isSelected() == true) {
				caLam = 2;
			}
			double phuCap = 500000;
			int bacLuong = Integer.valueOf((String) cboBacLuong.getSelectedItem());
			double heSoLuong = Double.valueOf((String) cboHeSoLuong.getSelectedItem());
			String maBoPhan = dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan();
			BoPhan boPhan = new BoPhan(maBoPhan);

			byte[] avt = null;

			if (lblAvt.getIcon() == null) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn ảnh đại diện cho nhân viên!");
			} else {
				avt = convertImageIconToByteArray((ImageIcon) lblAvt.getIcon());
			}

			NhanVien nv = new NhanVien(maNV, avt, hoDem, ten, gioiTinh, sdt, diaChi, cccd, ngaySinh, ngayBatDauLam,
					caLam, luongCB, bacLuong, heSoLuong, phuCap, boPhan);
			try {
				if (JOptionPane.showConfirmDialog(frame,
						"Bạn có muốn thêm nhân viên có mã là " + maNV + " và tên là " + hoDem + " " + ten + " không?",
						"Xác nhận", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
					nhanVienDao.insertNV(nv);
					dsNV = nhanVienDao.getListNV();
					clearTable();
					dsNVBP = nhanVienDao.getListNVtheoBP(dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan());
					docDuLieuVaoTable(dsNVBP);
					JOptionPane.showMessageDialog(frame, "Bạn đã thêm thành công nhân viên có mã là " + maNV,
							"Thông báo", 1);
				} else {
					JOptionPane.showMessageDialog(frame, "Bạn đã hủy thêm nhân viên!", "Thông báo", 0);
				}

			} catch (Exception e1) {
				// TODO: handle exception
				e1.printStackTrace();
			}

		}
		if (o == btnXoa) {
			int row = tblDsNV.getSelectedRow();
			int xacNhan;
			String boPhan = String.valueOf(cboBoPhan.getSelectedItem());
			String nam = String.valueOf(cboNam.getSelectedItem());

			try {

				if (boPhan.equals("Tất cả")) {
					if (nam.equals("Tất cả")) {
						xacNhan = JOptionPane.showConfirmDialog(frame,
								"Bạn có muốn xóa nhân viên có mã là " + dsNV.get(row).getMaNV() + " và có tên là "
										+ dsNV.get(row).getHo() + " " + dsNV.get(row).getTen() + " không?",
								"Xác nhận", JOptionPane.YES_NO_OPTION);
						if (xacNhan == JOptionPane.YES_OPTION) {
							nhanVienDao.deleteNV(ma);
							clearTable();
							dsNV = nhanVienDao.getListNV();
							if (dsNV.isEmpty()) {
								modelDsNV.setRowCount(0);
								return;
							}
							docDuLieuVaoTable(dsNV);
							return;
						}
						return;
					} else {
						xacNhan = JOptionPane.showConfirmDialog(frame,
								"Bạn có muốn xóa nhân viên có mã là " + dsNV.get(row).getMaNV() + " và có tên là "
										+ dsNV.get(row).getHo() + " " + dsNV.get(row).getTen() + " không?",
								"Xác nhận", JOptionPane.YES_NO_OPTION);
						if (xacNhan == JOptionPane.YES_OPTION) {
							nhanVienDao.deleteNV(ma);

							dsNV = nhanVienDao.getListNVtheoNamVaoLam(Integer.valueOf(nam));
							if (dsNV.isEmpty()) {
								modelDsNV.setRowCount(0);
								return;
							}
							clearTable();
							docDuLieuVaoTable(dsNV);
							return;
						}
						return;

					}
				} else {
					if (nam.equals("Tất cả")) {
						xacNhan = JOptionPane.showConfirmDialog(frame,
								"Bạn có muốn xóa nhân viên có mã là " + dsNVBP.get(row).getMaNV() + " và có tên là "
										+ dsNVBP.get(row).getHo() + " " + dsNVBP.get(row).getTen() + " không?",
								"Xác nhận", JOptionPane.YES_NO_OPTION);
						if (xacNhan == JOptionPane.YES_OPTION) {
							nhanVienDao.deleteNV(ma);
							dsNVBP = nhanVienDao.getListNVtheoBP(dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan());
							if (dsNVBP.isEmpty()) {
								modelDsNV.setRowCount(0);
								return;
							}
							clearTable();
							docDuLieuVaoTable(dsNVBP);
							return;
						}
						return;
					} else {
						xacNhan = JOptionPane.showConfirmDialog(frame,
								"Bạn có muốn xóa nhân viên có mã là " + dsNVBP.get(row).getMaNV() + " và có tên là "
										+ dsNVBP.get(row).getHo() + " " + dsNVBP.get(row).getTen() + " không?",
								"Xác nhận", JOptionPane.YES_NO_OPTION);
						if (xacNhan == JOptionPane.YES_OPTION) {
							nhanVienDao.deleteNV(ma);
							dsNVBP = nhanVienDao.getListNVtheoNamBP(Integer.valueOf(nam),
									dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan());
							if (dsNVBP.isEmpty()) {
								modelDsNV.setRowCount(0);
								return;
							}
							clearTable();
							docDuLieuVaoTable(dsNVBP);
							return;
						}
						return;

					}
				}
			} catch (RemoteException e3) {
				e3.printStackTrace();
			}
		}
		if (o == btnSua) {

			String ten = txtTen.getText();
			String regexTen = "^[A-Z]";
			if (ten.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống tên");
				return;
			}
			if (Pattern.matches(regexTen, ten)) {
				JOptionPane.showMessageDialog(frame, "Chữ cái đầu của tên phải viết hoa");
				return;

			}
			byte[] avt = convertImageIconToByteArray((ImageIcon) lblAvt.getIcon());
			String hoDem = txtHoDem.getText();
			String regexHoDem = "^(\\p{Lu}\\p{L}*(\\s|$))+";
			Pattern patternHoDem = Pattern.compile(regexHoDem);
			if (hoDem.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống họ đệm");
				return;
			}
			if (patternHoDem.matches(regexHoDem, hoDem) == false) {
				JOptionPane.showMessageDialog(frame, "Các từ trong họ đệm phải có chữ cái đầu viết hoa");
				return;
			}

			String diaChi = txtDiaChi.getText();
			if (diaChi.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống địa chỉ");
				return;
			}

			String sdt = txtSDT.getText();
			String regexSDT = "0[15789]\\d{8}";
			Pattern patternSDT = Pattern.compile(regexSDT);
			if (sdt.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống số điện thoại");
				return;
			}
			if (patternSDT.matches(regexSDT, sdt) == false) {
				JOptionPane.showMessageDialog(frame,
						"Số điện thoại phải có đầu số là 01,03,05,07,08,09 và gồm 10 chữ số");
				return;
			}

			String cccd = txtCCCD.getText();
			String regexCCCD = "^[0-9]{12}$";
			if (cccd.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống căn cước công dân");
				return;
			}
			if (Pattern.matches(regexCCCD, cccd) == false) {
				JOptionPane.showMessageDialog(frame, "Căn cước công dân bao gồm 12 số");
				return;
			}

			String regexLuongCB = "^[-+]?\\d*\\.?\\d+$";
			if (txtLuongCB.equals("")) {
				JOptionPane.showMessageDialog(frame, "Không được để trống lương");
				return;
			}
			if (Pattern.matches(regexLuongCB, txtLuongCB.getText()) == false) {
				JOptionPane.showMessageDialog(frame, "Lương phải là một số tiền");
				return;
			}
			double luongCB = Double.valueOf(txtLuongCB.getText());

			LocalDate ngaySinh = null;
			try {
				ngaySinh = dpNgaySinh.getFullDate().toLocalDate();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (tinhTuoiTheoNS(ngaySinh) < 18) {
				JOptionPane.showMessageDialog(frame, "Nhân viên chưa đủ 18 tuổi");
				return;
			}

			if (String.valueOf(cboBoPhan.getSelectedItem()).equals("Tất cả")) {
				JOptionPane.showMessageDialog(frame, "Bạn chưa chọn bộ phận cho nhân viên");
			}

			LocalDate ngayBatDauLam = null;
			try {
				ngayBatDauLam = dpBatDauLam.getFullDate().toLocalDate();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if ((rdoNam.isSelected() == false) && (rdoNu.isSelected() == false)) {
				JOptionPane.showMessageDialog(frame, "Bạn chưa chọn giới tính");
				return;
			}

			Boolean gioiTinh = null;
			if (rdoNam.isSelected() == true) {
				gioiTinh = true;
			} else if (rdoNu.isSelected() == true)
				gioiTinh = false;

			int caLam = 1;
			if ((chkSang.isSelected() == false) && (chkToi.isSelected() == false)) {
				JOptionPane.showMessageDialog(frame, "Bạn chưa chọn ca làm");
				return;
			}
			if (chkSang.isSelected() == true) {
				caLam = 1;
			} else if (chkToi.isSelected() == true) {
				caLam = 2;
			}

			int bacLuong = Integer.valueOf((String) cboBacLuong.getSelectedItem());
			double heSoLuong = Double.valueOf((String) cboHeSoLuong.getSelectedItem());
			String maBoPhan = dsBP.get(cboBoPhan.getSelectedIndex()).getMaBoPhan();
			BoPhan boPhan = new BoPhan(maBoPhan);
			NhanVien nv = new NhanVien(ma, avt, hoDem, ten, gioiTinh, sdt, diaChi, cccd, ngaySinh, ngayBatDauLam, caLam,
					luongCB, bacLuong, heSoLuong, 500000, boPhan);

			int xacNhan = JOptionPane.showConfirmDialog(frame,
					"Bạn có muốn sửa nhân viên có mã là " + ma + " và có tên là " + hoDem + " " + ten + " không?",
					"Xác nhận", JOptionPane.YES_NO_OPTION);
			
			try {
			if (xacNhan == JOptionPane.YES_OPTION) {
				nhanVienDao.updateNhanVien(nv);
				clearTable();
				dsNV = nhanVienDao.getListNV();
				dsNVBP = nhanVienDao.getListNVtheoBP(maBoPhan);
				docDuLieuVaoTable(dsNVBP);

				return;
			}
			} catch (RemoteException e3) {
				e3.printStackTrace();
			}
			return;
		}
		if (o == btnTimKiem) {
			String ten = txtTimKiem.getText();
			String boPhan = String.valueOf(cboBoPhan.getSelectedItem());
			String nam = String.valueOf(cboNam.getSelectedItem());
			if (!ten.equals("") && !ten.equals("Nhập tên")) {
				if (boPhan.equals("Tất cả")) {
					clearTable();
					for (NhanVien nv : dsNV) {
						if (nv.getTen().equals(ten)) {
							String tenBP = "";
							for (BoPhan bp : dsBP) {
								if (bp.getMaBoPhan().equals(nv.getBoPhan().getMaBoPhan())) {
									tenBP = bp.getTenBoPhan();
								}
							}
							Object[] rowData = { nv.getMaNV(), nv.getHo(), nv.getTen(), tinhTuoi(nv), nv.getNgaySinh(),
									nv.getcCCD(), laGioiTinh(nv), nv.getSoDienThoai(), nv.getDiaChi(),
									nv.getNgayBatDauLamViec(), layCaLamViec(nv), nv.getThangBacLuong(),
									nv.getLuongCoBan(), nv.getHeSoLuong(), nv.getPhuCap(), tenBP };
							modelDsNV.addRow(rowData);
						}
					}

				} else {
					clearTable();
					for (NhanVien nv : dsNVBP) {
						if (nv.getTen().equals(ten)) {
							String tenBP = "";
							for (BoPhan bp : dsBP) {
								if (bp.getMaBoPhan().equals(nv.getBoPhan().getMaBoPhan())) {
									tenBP = bp.getTenBoPhan();
								}
							}
							Object[] rowData = { nv.getMaNV(), nv.getHo(), nv.getTen(), tinhTuoi(nv), nv.getNgaySinh(),
									nv.getcCCD(), laGioiTinh(nv), nv.getSoDienThoai(), nv.getDiaChi(),
									nv.getNgayBatDauLamViec(), layCaLamViec(nv), nv.getThangBacLuong(),
									nv.getLuongCoBan(), nv.getHeSoLuong(), nv.getPhuCap(), tenBP };
							modelDsNV.addRow(rowData);
						}
					}
				}

			} else {
				if (boPhan.equals("Tất cả")) {
					clearTable();
					docDuLieuVaoTable(dsNV);
				} else {
					clearTable();
					docDuLieuVaoTable(dsNVBP);
				}

			}
		}
		if (o == btnXuatDs) {
			try {
				XSSFWorkbook workBook = new XSSFWorkbook();
				XSSFSheet sheet = workBook.createSheet("Danh sách");

				XSSFRow headerRow = sheet.createRow(0);
				for (int i = 0; i < tblDsNV.getColumnCount(); i++) {
					headerRow.createCell(i, CellType.STRING).setCellValue(tblDsNV.getColumnName(i));
				}

				for (int i = 0; i < tblDsNV.getRowCount(); i++) {
					XSSFRow row = sheet.createRow(i + 1);
					for (int j = 0; j < tblDsNV.getColumnCount(); j++) {
						Object value = tblDsNV.getValueAt(i, j);
						if (value != null) {
							if (value instanceof Number) {
								row.createCell(j, CellType.NUMERIC).setCellValue(((Number) value).doubleValue());
							} else {
								row.createCell(j, CellType.STRING).setCellValue(value.toString());
							}
						}
					}
				}

				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn vị trí lưu file Excel");
				fileChooser.setFileFilter(new FileNameExtensionFilter("Tệp Excel (*.xlsx)", "xlsx"));
				int returnValue = fileChooser.showSaveDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					String filePath = selectedFile.getAbsolutePath();

					try (FileOutputStream fos = new FileOutputStream(filePath + ".xlsx")) {
						workBook.write(fos);
						JOptionPane.showMessageDialog(frame, "In thành công", "Thông báo",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	public void clearTable() {
		modelDsNV.getDataVector().removeAllElements();
	}

	public static void resizeAndSetImage(File file, JLabel label) {
		try {
			// Đọc ảnh từ tệp tin
			Image originalImage = new ImageIcon(file.getPath()).getImage();

			// Kích thước mới bạn muốn đặt
			int newWidth = 75;
			int newHeight = 90;

			// Tạo ảnh mới với kích thước mới
			Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

			// Tạo ImageIcon từ ảnh mới
			ImageIcon scaledIcon = new ImageIcon(scaledImage);

			// Gán ImageIcon vào JLabel
			label.setIcon(scaledIcon);
			label.setAlignmentX(0.45f);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> layDsTen(ArrayList<NhanVien> ds) {
		ArrayList<String> dsTenNV = new ArrayList<String>();
		for (NhanVien nv : ds) {
			dsTenNV.add(nv.getTen());
		}
		return dsTenNV;

	}

	public static byte[] convertImageIconToByteArray(ImageIcon icon) {
		BufferedImage bufferedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
				BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.createGraphics();
		// Vẽ ImageIcon lên BufferedImage
		icon.paintIcon(null, g, 0, 0);
		g.dispose();

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		try {
			// Ghi BufferedImage vào ByteArrayOutputStream dưới định dạng PNG
			ImageIO.write(bufferedImage, "png", byteArrayOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return byteArrayOutputStream.toByteArray();
	}

	public ImageIcon convertByteArrayToImageIcon(byte[] imageData) {
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
			BufferedImage bufferedImage = ImageIO.read(bais);
			return new ImageIcon(bufferedImage);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
