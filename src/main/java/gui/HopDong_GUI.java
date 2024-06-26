package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import dao.HopDong_DAO;
import dao.SanPham_DAO;
import entity.HopDong;
import entity.SanPham;

public class HopDong_GUI extends JFrame implements ActionListener, MouseListener {
	private JPanel contentPane;
	private JTextField txtTenDoiTac;
	private JTextField txtTimKiem;
	private JDateChooser dcNgayKi;
	private JDateChooser dcNgayThanhLi;
	private JButton btnTimKiem;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXacNhanThanhLi;
	private JCheckBox chkNamVaTT;
	private JTable tblDSHopDong;
	private DefaultTableModel modelDSHopDong;
	private TableRowSorter<DefaultTableModel> sorterHopDong;
	private DefaultComboBoxModel<String> modelCBONam;
	private DefaultComboBoxModel<String> modelCBOTrangThai;
	private JComboBox<String> cboTrangThai;
	private JComboBox<String> cboNam;
	
	private HopDong_DAO hd_DAO;
	private SanPham_DAO sp_DAO;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//					HopDong_GUI frame = new HopDong_GUI();
//				try {
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	/**
	 * Create the frame.
	 */
	public HopDong_GUI() {
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setLayout(null);
		
		try {
			contentPane.add(this.createGUI());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		setContentPane(contentPane);
	}
	/**
	 * Phương thức lấy JPanel chứa giao diện của HopDong_GUI
	 * @return
	 * @throws RemoteException 
	 */
	public JPanel createGUI() throws RemoteException {
		hd_DAO = Initiate.hopDong_DAO;
		sp_DAO = Initiate.sanPham_DAO;
		
		JPanel pnlHD = new JPanel();
		pnlHD.setBackground(new Color(240, 248, 255));
		pnlHD.setBounds(0, 50, 1268, 632);
		pnlHD.setLayout(null);
		
		JPanel pnlThongTin = new JPanel();
		pnlThongTin.setBorder(new TitledBorder(null, "Th\u00F4ng Tin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlThongTin.setBackground(new Color(240, 248, 255));
		pnlThongTin.setBounds(10, 10, 450, 150);
		pnlHD.add(pnlThongTin);
		pnlThongTin.setLayout(null);
		
		JLabel lblTenDoiTac = new JLabel("Tên đối tác:");
		lblTenDoiTac.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTenDoiTac.setBounds(10, 20, 120, 30);
		pnlThongTin.add(lblTenDoiTac);
		
		txtTenDoiTac = new JTextField();
		txtTenDoiTac.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenDoiTac.setBounds(150, 20, 280, 30);
		pnlThongTin.add(txtTenDoiTac);
		txtTenDoiTac.setColumns(14);
		
		JLabel lblNgyK = new JLabel("Ngày Kí:");
		lblNgyK.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgyK.setBounds(10, 60, 80, 30);
		pnlThongTin.add(lblNgyK);
		
		dcNgayKi = new JDateChooser();
		dcNgayKi.setFont(new Font("Tahoma", Font.BOLD, 16));
		dcNgayKi.setDateFormatString("dd/MM/yyyy");
		dcNgayKi.setBackground(new Color(255, 255, 255));
		dcNgayKi.setBounds(150, 60, 280, 30);
		dcNgayKi.setDate(new Date());
		pnlThongTin.add(dcNgayKi);
		
		JLabel lblNgayThanhLi = new JLabel("Ngày Thanh Lí:");
		lblNgayThanhLi.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNgayThanhLi.setBounds(10, 100, 140, 30);
		pnlThongTin.add(lblNgayThanhLi);
		
		dcNgayThanhLi = new JDateChooser();
		dcNgayThanhLi.setFont(new Font("Tahoma", Font.BOLD, 16));
		dcNgayThanhLi.setDateFormatString("dd/MM/yyyy");
		dcNgayThanhLi.setBackground(new Color(255, 255, 255));
		dcNgayThanhLi.setBounds(150, 100, 280, 30);
		Calendar currentDate = Calendar.getInstance();
		currentDate.add(Calendar.DAY_OF_MONTH, 1);
		
		dcNgayThanhLi.setDate(currentDate.getTime());
		pnlThongTin.add(dcNgayThanhLi);
		
		JPanel pnlChucNang = new JPanel();
		pnlChucNang.setLayout(null);
		pnlChucNang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Ch\u1EE9c N\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlChucNang.setBackground(new Color(240, 248, 255));
		pnlChucNang.setBounds(798, 10, 460, 150);
		pnlHD.add(pnlChucNang);
		
		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(255, 255, 255));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThem.setBounds(30, 50, 170, 40);
		btnThem.setIcon(new ImageIcon("img\\icons\\icons8-add-document-20.png"));
		pnlChucNang.add(btnThem);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setBackground(new Color(255, 255, 255));
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXoa.setBounds(250, 50, 170, 40);
		btnXoa.setIcon(new ImageIcon("img\\icons\\icons8-delete-20.png"));
		pnlChucNang.add(btnXoa);
		
		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(255, 255, 255));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSua.setBounds(250, 100, 170, 40);
		btnSua.setIcon(new ImageIcon("img\\icons\\icons8-pencil-20.png"));
		pnlChucNang.add(btnSua);
		
		chkNamVaTT = new JCheckBox("Lọc theo năm và trạng thái");
		chkNamVaTT.setBackground(new Color(240, 248, 255));
		chkNamVaTT.setBounds(30, 20, 220, 23);
		pnlChucNang.add(chkNamVaTT);
		chkNamVaTT.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		btnXacNhanThanhLi = new JButton("Đã thanh lí");
		btnXacNhanThanhLi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnXacNhanThanhLi.setBackground(Color.WHITE);
		btnXacNhanThanhLi.setBounds(30, 100, 170, 40);
		btnXacNhanThanhLi.setIcon(new ImageIcon("img\\icons\\icons8-check-20.png"));
		pnlChucNang.add(btnXacNhanThanhLi);
		
		String header[] = {"Mã hợp đồng", "Tên đối tác", "Ngày kí", "Ngày thanh lí", "Trạng Thái"};
		modelDSHopDong = new DefaultTableModel(header, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return column != 0;
			}
		};
		tblDSHopDong = new JTable(modelDSHopDong);
		
		sorterHopDong = new TableRowSorter<DefaultTableModel>(modelDSHopDong);
		tblDSHopDong.setRowSorter(sorterHopDong);
		
		tblDSHopDong.setRowHeight(30);
		tblDSHopDong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
//		layDSHopDongTuDB();
		
		JScrollPane scrDSHopDong = new JScrollPane(tblDSHopDong);
		scrDSHopDong.setBounds(10, 161, 1248, 460);
		pnlHD.add(scrDSHopDong);
		
		JPanel pnlLoc = new JPanel();
		pnlLoc.setBorder(new TitledBorder(null, "B\u1ED9 L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlLoc.setBackground(new Color(240, 248, 255));
		pnlLoc.setBounds(459, 10, 340, 149);
		pnlHD.add(pnlLoc);
		pnlLoc.setLayout(null);
		
		modelCBONam = new DefaultComboBoxModel<String>();
		cboNam = new JComboBox<String>(modelCBONam);
		cboNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboNam.setBounds(110, 20, 220, 30);
		
		capNhatCBONam();
		
		pnlLoc.add(cboNam);
		
		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNam.setBounds(10, 20, 100, 30);
		pnlLoc.add(lblNam);
		
		JLabel lblTrangThai = new JLabel("Trạng Thái:");
		lblTrangThai.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTrangThai.setBounds(10, 60, 100, 30);
		pnlLoc.add(lblTrangThai);
		
		modelCBOTrangThai = new DefaultComboBoxModel<String>();
		cboTrangThai = new JComboBox<String>(modelCBOTrangThai);
		cboTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cboTrangThai.setBounds(110, 60, 220, 30);
		modelCBOTrangThai.addElement("Hiển thị tất cả");
		modelCBOTrangThai.addElement("Đã thanh lí");
		modelCBOTrangThai.addElement("Chưa thanh lí");
		pnlLoc.add(cboTrangThai);
		
		txtTimKiem = new JTextField("Nhập tên đối tác");
		txtTimKiem.setForeground(new Color(119, 136, 153));
		txtTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTimKiem.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtTimKiem.getText().equals("Nhập tên đối tác")) {
					txtTimKiem.setForeground(Color.black);
					txtTimKiem.setText("");
				}
			}
		});
		txtTimKiem.setBounds(10, 100, 290, 30);
		pnlLoc.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimKiem = new JButton("");
		btnTimKiem.setBackground(new Color(255, 255, 255));
		btnTimKiem.setBounds(300, 100, 30, 30);
		btnTimKiem.setIcon(new ImageIcon("img\\icons\\icons8-magnifying-glass-20.png"));
		pnlLoc.add(btnTimKiem);
		
		btnThem.addActionListener(this);
		btnXacNhanThanhLi.addActionListener(this);
	    btnXoa.addActionListener(this);
	    btnSua.addActionListener(this);
	    btnTimKiem.addActionListener(this);
	    tblDSHopDong.addMouseListener(this);
	    cboTrangThai.addActionListener(this);
	    cboNam.addActionListener(this);
		chkNamVaTT.addActionListener(this);
	    
		return pnlHD;
	}
	/**
	 * cre: Huỳnh Kim Thành
	 * Phương thức cập nhật combobox hiển thị năm kí hợp đồng
	 * @throws RemoteException 
	 */
	private void capNhatCBONam() throws RemoteException {
		for (Integer year : hd_DAO.getDSNamKiHopDong()) {
			modelCBONam.addElement(year.toString());
		}
	}
	/**
	 * cre: Huỳnh Kim Thành
	 * Phương thức cập nhật danh sách hợp đồng từ database vào table
	 * @throws RemoteException 
	 */
	private void layDSHopDongTuDB() throws RemoteException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		modelDSHopDong.setRowCount(0);
		
		for (HopDong hd: hd_DAO.getDSHopDong()) {
			modelDSHopDong.addRow(new Object[] {hd.getMaHopDong(), hd.getTenDoiTac(), hd.getNgayKy().format(dtf)
					, hd.getNgayThanhLyHopDong().format(dtf), hd.isTrangThai() ? "Đã thanh lí" : "Chưa thanh lí"});
		}
	}
	/**
	 * cre: Huỳnh Kim Thành
	 * Phương thức cập nhật danh sách hợp đồng theo trạng thái từ database vào table
	 * @throws RemoteException 
	 */
	private void layDSHopDongTheoTrangThaiTuDB(boolean trangThai) throws RemoteException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		modelDSHopDong.setRowCount(0);
		
		for (HopDong hd: hd_DAO.getListHDTheoTrangThai(trangThai)) {
			modelDSHopDong.addRow(new Object[] {hd.getMaHopDong(), hd.getTenDoiTac(), hd.getNgayKy().format(dtf)
					, hd.getNgayThanhLyHopDong().format(dtf), hd.isTrangThai() ? "Đã thanh lí" : "Chưa thanh lí"});
		}
	}
	/**
	 * cre: Huỳnh Kim Thành
	 * Phương thức cập nhật danh sách hợp đồng theo năm từ database vào table
	 * @throws RemoteException 
	 */
	private void layDSHopDongTheoNamTuDB(int nam) throws RemoteException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		modelDSHopDong.setRowCount(0);
		
		for (HopDong hd: hd_DAO.getDSHopDongTheoNam(nam)) {
			modelDSHopDong.addRow(new Object[] {hd.getMaHopDong(), hd.getTenDoiTac(), hd.getNgayKy().format(dtf)
					, hd.getNgayThanhLyHopDong().format(dtf), hd.isTrangThai() ? "Đã thanh lí" : "Chưa thanh lí"});
		}
	}
	/**
	 * cre: Huỳnh Kim Thành
	 * Phương thức cập nhật danh sách hợp đồng theo năm và trạng thái từ database vào table
	 * @throws RemoteException 
	 */
	private void layDSHopDongTheoNamVaTTTuDB(int nam, boolean tinhTrang) throws RemoteException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		modelDSHopDong.setRowCount(0);
		
		for (HopDong hd: hd_DAO.getDSHopDongTheoNamvaTT(nam, tinhTrang)) {
			modelDSHopDong.addRow(new Object[] {hd.getMaHopDong(), hd.getTenDoiTac(), hd.getNgayKy().format(dtf)
					, hd.getNgayThanhLyHopDong().format(dtf), hd.isTrangThai() ? "Đã thanh lí" : "Chưa thanh lí"});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if (o.equals(btnThem)) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String tenDoiTac = txtTenDoiTac.getText().trim();
			LocalDate ngayKi = dcNgayKi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate ngayThanhLi = dcNgayThanhLi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			
			String maHopDong = null;
			try {
				maHopDong = taoMaHopDong(ngayKi);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (validation()) {
				HopDong hd = new HopDong(maHopDong, tenDoiTac, ngayKi, ngayThanhLi, false);
				try {
					if (hd_DAO.insertHopDong(hd)) {
						modelDSHopDong.addRow(new Object[] {maHopDong, tenDoiTac, ngayKi.format(dtf), ngayThanhLi.format(dtf), "Chưa thanh lí"});
						if (!hd_DAO.getDSNamKiHopDong().contains(ngayKi.getYear())) {
							capNhatCBONam();
						}
						JOptionPane.showMessageDialog(null, "Thêm hợp đồng thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm hợp đồng thất bại! Hợp đồng đã tồn tại");
					}
				} catch (HeadlessException | RemoteException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if (o.equals(btnXacNhanThanhLi)) {
			int row = tblDSHopDong.getSelectedRow();
			
			if (tblDSHopDong.getValueAt(row, 4).toString().equals("Đã thanh lí")) {
				JOptionPane.showMessageDialog(null, "Hợp đồng này đã thanh lí");
			} else {
				String maHD = tblDSHopDong.getValueAt(row, 0).toString();
				try {
					HopDong hd = hd_DAO.getMotHopDong(maHD);
					
					if (hd != null) {
						boolean checkListSP = true;
						
						List<SanPham> listSPDaHoanThanh = sp_DAO.getDSSanPhamTheoHopDong(maHD);
						
						if (listSPDaHoanThanh.size() == 0) {
							JOptionPane.showMessageDialog(null, "Hợp đồng này chưa có sản phẩm");
						} else {
							for (SanPham sp : listSPDaHoanThanh) {
								if (!sp.isTrangThai()) {
									checkListSP = false;
								}
							}
							
							if (checkListSP) {
								hd.setTrangThai(true);
								hd_DAO.updateHopDong(hd);
								tblDSHopDong.setValueAt("Đã thanh lí", row, 4);
							} else {
								JOptionPane.showMessageDialog(null, "Hợp đồng này còn sản phẩm chưa hoàn thành");
							}
						}
					}
				} catch (HeadlessException | RemoteException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		if (o.equals(btnSua)) {
			int row = tblDSHopDong.getSelectedRow();
			int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa hợp đồng này không?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
			
			if (luaChon == JOptionPane.YES_OPTION) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
				String tenDoiTac = txtTenDoiTac.getText().trim();
				LocalDate ngayKi = dcNgayKi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				LocalDate ngayThanhLi = dcNgayThanhLi.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				String maHD = tblDSHopDong.getValueAt(row, 0).toString();
				try {
					HopDong hd = hd_DAO.getMotHopDong(maHD);
					
					if (validation()) {
						if (ngayThanhLi.isAfter(hd.getNgayThanhLyHopDong()))
							hd.setTrangThai(false);
						else
							hd.setTrangThai(true);
						hd.setTenDoiTac(tenDoiTac);
						hd.setNgayKy(ngayKi);
						hd.setNgayThanhLyHopDong(ngayThanhLi);
						
						if (hd_DAO.updateHopDong(hd)) {
							JOptionPane.showMessageDialog(null, "Đã sửa hợp đồng thành công");
							layDSHopDongTuDB();
						}
					}
				} catch (HeadlessException | RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		if (o.equals(btnXoa)) {
			int row = tblDSHopDong.getSelectedRow();
			int luaChon = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xoá hợp đồng này?", "Lưu Ý", JOptionPane.YES_NO_OPTION);
			
			if (luaChon == JOptionPane.YES_OPTION) {
				try {
					if (hd_DAO.deleteHopDong((String) tblDSHopDong.getValueAt(row, 0))) {
						modelDSHopDong.removeRow(row);
						JOptionPane.showMessageDialog(null, "Xoá thành công!");
					} else {
						JOptionPane.showMessageDialog(null, "Xoá thất bại! Không tìm thấy hợp đồng cần xoá");
					}
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		if (o.equals(btnTimKiem)) {
			String tenDoiTac = txtTimKiem.getText().trim();
			
			if (tenDoiTac.length() == 0) {
				sorterHopDong.setRowFilter(null);
			} else {
				try {
					sorterHopDong.setRowFilter(RowFilter.regexFilter(tenDoiTac, 1));
				} catch (PatternSyntaxException pse) {
					// TODO Auto-generated catch block
					System.out.println("Bad regex pattern");
				}
			}
		}
		
		if (o.equals(cboTrangThai)) {
			try {
				switch (cboTrangThai.getSelectedItem().toString()) {
				
				case "Hiển thị tất cả" -> layDSHopDongTuDB();
				case "Chưa thanh lí" -> layDSHopDongTheoTrangThaiTuDB(false);
				case "Đã thanh lí" -> layDSHopDongTheoTrangThaiTuDB(true);
				
				default ->
				throw new IllegalArgumentException("Unexpected value: " + cboTrangThai.getSelectedItem());
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (o.equals(cboNam)) {
			String strNam = cboNam.getSelectedItem().toString();
			int year = Integer.parseInt(strNam);
			try {
				layDSHopDongTheoNamTuDB(year);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if (o.equals(chkNamVaTT)) {
			int year = Integer.parseInt(cboNam.getSelectedItem().toString());
			String trangThai = cboTrangThai.getSelectedItem().toString();
			
			try {
				switch (trangThai) {
				
				case "Hiển thị tất cả" -> layDSHopDongTheoNamTuDB(year);
				case "Chưa thanh lí" -> layDSHopDongTheoNamVaTTTuDB(year, false);
				case "Đã thanh lí" -> layDSHopDongTheoNamVaTTTuDB(year, true);
				
				default ->
				throw new IllegalArgumentException("Unexpected value: " + trangThai);
				}
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	/**
	 * Phương thức tạo mã hợp đồng dựa trên ngày kí và số thứ tự thêm hợp đồng theo ngày kí
	 * @param ngayKi
	 * @return String maHopDong
	 * @throws RemoteException 
	 */
	private String taoMaHopDong(LocalDate ngayKi) throws RemoteException {
		int numOfHopDong = 0;
		
		int day = ngayKi.getDayOfMonth();
		int month = ngayKi.getMonthValue();
		int year = ngayKi.getYear();
		String maCanTao = "00";
		
		String day_String = maCanTao.substring(0, maCanTao.length() - String.valueOf(day).length()) + day;
		String month_String = maCanTao.substring(0, maCanTao.length() - String.valueOf(month).length()) + month;
		String year_String = maCanTao.substring(0, maCanTao.length() - String.valueOf(year % 100).length()) + year % 100;

		for (HopDong hd : hd_DAO.getDSHopDong()) {
			if (hd.getNgayKy().equals(ngayKi))
				numOfHopDong++;
		}
		String stt = maCanTao.substring(0, maCanTao.length() - String.valueOf(numOfHopDong).length()) + (numOfHopDong + 1);
		System.out.println(stt);
		return day_String + month_String + year_String + stt;
	}
	/**
	 * cre: Huỳnh Kim Thành
	 * Hàm kiểm tra dữ liệu nhập vào có hợp lệ hay không
	 * @return true nếu tất cả đều hợp lệ
	 */
	private boolean validation() {
		String tenDoiTac = txtTenDoiTac.getText().trim();

		if (tenDoiTac.length() == 0 || !tenDoiTac.matches("^[\\p{L}0-9&,-]+(\\s?[\\p{L}0-9&,-]*)*")) {
			thongBaoLoiNhapDuLieu(txtTenDoiTac, "Tên đối tác không được để trống");
			return false;
		}
		
		if (dcNgayKi.getDate().after(dcNgayThanhLi.getDate())) {
			JOptionPane.showMessageDialog(null, "Ngày thanh lí hợp đồng phải sau ngày kí!!");
			dcNgayThanhLi.requestFocus();
			return false;
		}
		
		return true;
	}
	/**
	 * Hàm thông báo lỗi, khi nhập dữ liệu sai thì trỏ vào txt chứa chuỗi không hợp lệ
	 * @param txt
	 * @param mess
	 */
	private void thongBaoLoiNhapDuLieu(JTextField txt, String mess) {
		JOptionPane.showMessageDialog(null, mess);
		txt.selectAll();
		txt.requestFocus();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object o = e.getSource();
		
		if (o.equals(tblDSHopDong)) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int row = tblDSHopDong.getSelectedRow();
			
			txtTenDoiTac.setText((String) modelDSHopDong.getValueAt(row, 1));
			
			try {
				Date ngayKi = sdf.parse((String) modelDSHopDong.getValueAt(row, 2));
				Date ngayThanhLi = sdf.parse((String) modelDSHopDong.getValueAt(row, 3));
				
				dcNgayKi.setDate(ngayKi);
				dcNgayThanhLi.setDate(ngayThanhLi);
			} catch (ParseException e1) {
				e1.printStackTrace();
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
}
