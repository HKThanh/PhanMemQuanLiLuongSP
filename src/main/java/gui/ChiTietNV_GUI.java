package gui;

import java.awt.Font;
import java.math.RoundingMode;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.BangChamCongNV_DAO;
import dao.BangLuongNV_DAO;
import dao.NhanVien_DAO;

import entity.BangChamCongNV;
import entity.BangLuongNV;
import entity.NhanVien;

public class ChiTietNV_GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnlChiTietLuongNV;
	private JTable tblChiTietBangLuong;
	private JPanel contentPane;
	private DefaultTableModel modelTableChiTietBangLuong;
	private JLabel lblHoTen;
	private JLabel lblBoPhan;
	private JLabel lblThang;
	private JTextField txtThang;
	private JTextField txtNam;
	private JTextField txtBoPhan;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtLuongNhan;
	private JTextField txtBHXH;
	private JTextField txtSoNgayLam;
	private JTextField txtTongSongGioTangCa;
	private JLabel lblTongSoGioTangCa;
	private JLabel lblTongLuong;
	private JTextField txtTongLuong;
	private BangLuongNV_DAO bl_DAO;
	private NhanVien_DAO nv_DAO;
	private BangChamCongNV_DAO bcc_DAO;
	private JLabel lblPhuCap;
	private JTextField txtPhuCap;
	private JTextField txtPhuCap_1;
	private JLabel lblPhuCap_1;
	private JTextField txtKhauTru;
	private JTextField textField;
	private JTextField txtThuong;

	public ChiTietNV_GUI(String maNV, int Thang, int Nam, String boPhan, double khauTru) throws RemoteException {
		super("Chi Tiết Lương Nhân Viên");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(1280, 720);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		getChiTietNV_GUI();
		khoiTaoChiTietLuong(maNV, Thang, Nam, boPhan, khauTru);
	}

	public JPanel getChiTietNV_GUI() {
		pnlChiTietLuongNV = new JPanel();
		pnlChiTietLuongNV.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnlChiTietLuongNV);
		pnlChiTietLuongNV.setLayout(null);

		JLabel lblChiTietBangLuong = new JLabel("Chi Tiết Bảng Lương");
		lblChiTietBangLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiTietBangLuong.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblChiTietBangLuong.setBounds(420, 11, 420, 31);
		pnlChiTietLuongNV.add(lblChiTietBangLuong);

		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaNV.setBounds(10, 66, 140, 25);
		pnlChiTietLuongNV.add(lblMaNV);

		String headerChiTiet[] = { "Mã Chấm Công", "Ngày Chấm", "Số Giờ Tăng Ca", "Ca Làm", "Có Mặt", "Vắng Mặt",
				"Có Phép", "Tiền Công", "Ghi chú" };
		modelTableChiTietBangLuong = new DefaultTableModel(headerChiTiet, 0) {
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return (columnIndex >= 4 && columnIndex <= 6) ? Boolean.class : Object.class;
			}
		};

		tblChiTietBangLuong = new JTable(modelTableChiTietBangLuong);
		tblChiTietBangLuong.setFont(UIManager.getFont("TableHeader.font"));
		tblChiTietBangLuong.setFillsViewportHeight(true);
		tblChiTietBangLuong.setRowHeight(26);
		tblChiTietBangLuong.setRowSelectionAllowed(true);
		tblChiTietBangLuong.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblChiTietBangLuong.setBounds(20, 160, 550, 380);
		tblChiTietBangLuong.setEnabled(false);
		tblChiTietBangLuong.setAutoCreateRowSorter(true);
		tblChiTietBangLuong.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		JScrollPane scrollpane = new JScrollPane(tblChiTietBangLuong);
		scrollpane.setBounds(0, 160, 1260, 450);
		pnlChiTietLuongNV.add(scrollpane);

		lblHoTen = new JLabel("Họ tên:");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoTen.setBounds(10, 111, 80, 25);
		pnlChiTietLuongNV.add(lblHoTen);

		lblBoPhan = new JLabel("Bộ Phận:");
		lblBoPhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBoPhan.setBounds(300, 66, 90, 25);
		pnlChiTietLuongNV.add(lblBoPhan);

		lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(300, 111, 60, 25);
		pnlChiTietLuongNV.add(lblThang);

		txtThang = new JTextField();
		txtThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThang.setBounds(360, 111, 30, 25);
		pnlChiTietLuongNV.add(txtThang);
		txtThang.setColumns(10);

		JLabel lblNam = new JLabel("Năm");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNam.setBounds(400, 111, 45, 25);
		pnlChiTietLuongNV.add(lblNam);

		txtNam = new JTextField();
		txtNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNam.setColumns(10);
		txtNam.setBounds(450, 111, 85, 25);
		pnlChiTietLuongNV.add(txtNam);

		txtBoPhan = new JTextField();
		txtBoPhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBoPhan.setColumns(10);
		txtBoPhan.setBounds(387, 66, 165, 25);
		pnlChiTietLuongNV.add(txtBoPhan);

		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(143, 66, 142, 25);
		pnlChiTietLuongNV.add(txtMaNV);

		txtHoTen = new JTextField();
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoTen.setColumns(10);
		txtHoTen.setBounds(85, 111, 200, 25);
		pnlChiTietLuongNV.add(txtHoTen);

		JLabel lblLuongNhan = new JLabel("Lương Nhận:");
		lblLuongNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLuongNhan.setBounds(560, 66, 160, 25);
		pnlChiTietLuongNV.add(lblLuongNhan);

		JLabel lblBHXH = new JLabel("Bảo Hiểm Xã Hội:");
		lblBHXH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBHXH.setBounds(560, 111, 160, 25);
		pnlChiTietLuongNV.add(lblBHXH);

		txtLuongNhan = new JTextField();
		txtLuongNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLuongNhan.setColumns(10);
		txtLuongNhan.setBounds(680, 66, 220, 25);
		pnlChiTietLuongNV.add(txtLuongNhan);

		txtBHXH = new JTextField();
		txtBHXH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtBHXH.setColumns(10);
		txtBHXH.setBounds(720, 111, 200, 25);
		pnlChiTietLuongNV.add(txtBHXH);

		JLabel lblSoNgayNghi = new JLabel("Số Ngày Làm:");
		lblSoNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSoNgayNghi.setBounds(35, 631, 135, 25);
		pnlChiTietLuongNV.add(lblSoNgayNghi);

		txtSoNgayLam = new JTextField();
		txtSoNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoNgayLam.setColumns(10);
		txtSoNgayLam.setBounds(172, 631, 100, 25);
		pnlChiTietLuongNV.add(txtSoNgayLam);

		txtTongSongGioTangCa = new JTextField();
		txtTongSongGioTangCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongSongGioTangCa.setColumns(10);
		txtTongSongGioTangCa.setBounds(490, 631, 100, 25);
		pnlChiTietLuongNV.add(txtTongSongGioTangCa);

		lblTongSoGioTangCa = new JLabel("Tổng Số Giờ Tăng Ca:");
		lblTongSoGioTangCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongSoGioTangCa.setBounds(290, 631, 200, 25);
		pnlChiTietLuongNV.add(lblTongSoGioTangCa);

		lblTongLuong = new JLabel("Tổng Lương:");
		lblTongLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongLuong.setBounds(935, 631, 120, 25);
		pnlChiTietLuongNV.add(lblTongLuong);

		txtTongLuong = new JTextField();
		txtTongLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongLuong.setColumns(10);
		txtTongLuong.setBounds(1050, 631, 200, 25);
		pnlChiTietLuongNV.add(txtTongLuong);

		txtPhuCap_1 = new JTextField();
		txtPhuCap_1.setEditable(false);
		txtPhuCap_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhuCap_1.setColumns(10);

		txtPhuCap_1.setBounds(1040, 66, 200, 25);
		pnlChiTietLuongNV.add(txtPhuCap_1);

		lblPhuCap_1 = new JLabel("Phụ Cấp:");
		lblPhuCap_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblPhuCap_1.setBounds(934, 66, 160, 25);
		pnlChiTietLuongNV.add(lblPhuCap_1);

		JLabel lblKhauTru = new JLabel("Khấu Trừ:");
		lblKhauTru.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblKhauTru.setBounds(934, 111, 160, 25);
		pnlChiTietLuongNV.add(lblKhauTru);

		txtKhauTru = new JTextField();
		txtKhauTru.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtKhauTru.setColumns(10);
		txtKhauTru.setBounds(1040, 111, 170, 25);
		pnlChiTietLuongNV.add(txtKhauTru);

		JLabel lblThuong = new JLabel("Thưởng:");
		lblThuong.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblThuong.setBounds(620, 631, 80, 25);
		pnlChiTietLuongNV.add(lblThuong);

		txtThuong = new JTextField();
		txtThuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtThuong.setColumns(10);
		txtThuong.setBounds(705, 631, 200, 25);
		pnlChiTietLuongNV.add(txtThuong);

		txtThuong.setEditable(false);
		txtBHXH.setEditable(false);
		txtBoPhan.setEditable(false);
		txtHoTen.setEditable(false);
		txtLuongNhan.setEditable(false);
		txtMaNV.setEditable(false);
		txtNam.setEditable(false);
		txtSoNgayLam.setEditable(false);
		txtThang.setEditable(false);
		txtTongLuong.setEditable(false);
		txtKhauTru.setEditable(false);
		txtTongSongGioTangCa.setEditable(false);
		txtTongSongGioTangCa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTongLuong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSoNgayLam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBHXH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBoPhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtLuongNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtThang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBHXH.setBorder(null);
		txtBoPhan.setBorder(null);
		txtHoTen.setBorder(null);
		txtLuongNhan.setBorder(null);
		txtMaNV.setBorder(null);
		txtNam.setBorder(null);
		txtSoNgayLam.setBorder(null);
		txtThang.setBorder(null);
		txtTongLuong.setBorder(null);
		txtTongSongGioTangCa.setBorder(null);
		txtThuong.setBorder(null);
		txtPhuCap_1.setBorder(null);
		txtKhauTru.setBorder(null);
		return pnlChiTietLuongNV;
	}

	private void khoiTaoChiTietLuong(String maNV, int Thang, int Nam, String mabp, double khauTru) throws RemoteException {
		DecimalFormat decimalFormat = new DecimalFormat("#,###");
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		bl_DAO = Initiate.bangLuongNV_DAO;
		nv_DAO = Initiate.nhanVien_DAO;
		bcc_DAO = Initiate.bangChamCongNV_DAO;
		BangLuongNV bl = bl_DAO.lay1BangLuongTheoMaNVThangNam(maNV, Thang, Nam);

		List<BangChamCongNV> listBCC = bcc_DAO.dsBangCCtheomaNVthangnam(maNV, Thang, Nam);
		NhanVien nv = nv_DAO.getMotNVTuMaNV(maNV);
		txtMaNV.setText(nv.getMaNV());
		txtHoTen.setText(nv.getHo() + " " + nv.getTen());
		txtBoPhan.setText(mabp);
		txtThang.setText(Thang + "");
		txtNam.setText(Nam + "");
		txtLuongNhan.setText(decimalFormat.format(bl.getLuongTong()) + " VNĐ");
		txtBHXH.setText(decimalFormat.format(bl.getBhxh()) + " VNĐ");
		txtSoNgayLam.setText(bcc_DAO.getSoNgayDiLamCua1NV(nv.getMaNV(), Thang, Nam) + "");
		txtTongSongGioTangCa.setText(bcc_DAO.getTongSoGioTangCaCua1NV(nv.getMaNV(), Thang, Nam) + "");
		txtPhuCap_1.setText(decimalFormat.format(nv.getPhuCap()) + " VNĐ");
		txtKhauTru.setText(decimalFormat.format(khauTru) + " VNĐ");

		double tienCong1Ngay = (nv.getLuongCoBan() * nv.getHeSoLuong() * nv.getThangBacLuong()) / 30.0;

		double tienCong1Gio = tienCong1Ngay / 8.0;

		txtThuong.setText(
				(decimalFormat.format(bcc_DAO.getTongSoGioTangCaCua1NV(nv.getMaNV(), Thang, Nam) * tienCong1Gio * 2))
						+ " VNĐ");
		for (BangChamCongNV bcc : listBCC) {
			double tienCong = 0;
			if (bcc.isCoMat()) {
				tienCong = tienCong1Ngay + tienCong1Gio * 2 * bcc.getSoGioTangCa();

			} else if (bcc.isCoPhep() || bcc.isVangMat()) {
				tienCong = 0;
			}

			modelTableChiTietBangLuong.addRow(new Object[] { bcc.getMaChamCongNV(), dtf.format(bcc.getNgayCham()),
					bcc.getSoGioTangCa(), bcc.getCaLam() == 1 ? "Sáng" : "Tối", bcc.isCoMat(), bcc.isVangMat(),
					bcc.isCoPhep(), decimalFormat.format(tienCong), bcc.getGhiChu() });
		}
		int rowCount = tblChiTietBangLuong.getRowCount();
		double tongao = 0;
		for (int i = 0; i < rowCount; i++) {

			tongao += Double.parseDouble(modelTableChiTietBangLuong.getValueAt(i, 7).toString().replace(",", ""));
		}
		txtTongLuong.setText(decimalFormat.format(tongao) + " VNĐ");

	}

}
