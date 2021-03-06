/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_giaodich;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import database.Database;
import entities.ChiTietPhieuDat;
import entities.ChiTietPhieuThue;
import entities.Dia;
import entities.KhachHang;
import entities.PhieuDat;
import entities.PhieuThue;
import entities.TheLoai;
import entities.TieuDe;
import service.QuanLyCT_PhieuDat;
import service.QuanLyCT_PhieuThue;
import service.QuanLyDia;
import service.QuanLyKhachHang;
import service.QuanLyPhieuDat;
import service.QuanLyPhieuThue;
import service.QuanLyTheLoai;
import service.QuanLyTieuDe;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author nmrhu
 */
public class TraCuu_Dia_Gui extends javax.swing.JPanel {

	/**
	 * Creates new form TraCuu_KhachHang_Gui
	 */
	public TraCuu_Dia_Gui() {
		initComponents();
		DocDuLieuDatabaseVaoTable("");
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		Database.getInstance().connect();
		qltd = new QuanLyTieuDe();
		qldia = new QuanLyDia();
		qltl = new QuanLyTheLoai();
		ql_ctpt = new QuanLyCT_PhieuThue();
		ql_ctpd = new QuanLyCT_PhieuDat();
		qlpt = new QuanLyPhieuThue();
		qlpd = new QuanLyPhieuDat();
		qlkh = new QuanLyKhachHang();
		
		jPanel4 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTableDia = new javax.swing.JTable();
		btnTim = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		txtTim = new javax.swing.JTextField();

		setBackground(new java.awt.Color(255, 255, 255));
		setPreferredSize(new java.awt.Dimension(1274, 605));

		jPanel4.setBackground(new java.awt.Color(255, 255, 255));
		jPanel4.setLayout(new java.awt.BorderLayout());

		jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

		jTableDia.setRowHeight(22);
		jTableDia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTableDia.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
		jTableDia.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {

		}, new String[] { "Mã đĩa", "Tên đĩa", "Thể loại", "Tình trạng", "Khách hàng" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		jScrollPane1.setViewportView(jTableDia);
		jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

		btnTim.setBackground(new java.awt.Color(0, 153, 255));
		btnTim.setForeground(new java.awt.Color(255, 255, 255));
		btnTim.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\search_30px.png")); // NOI18N
		btnTim.setText("Tìm kiếm");
		btnTim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String txt = txtTim.getText().toString();
				DocDuLieuDatabaseVaoTable(txt);
			}
		});

		jLabel2.setForeground(new java.awt.Color(102, 102, 102));
		jLabel2.setText("/ Tra cứu");

		jLabel1.setForeground(new java.awt.Color(51, 153, 255));
		jLabel1.setText("  Giao dịch");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(51)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 1170, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(53, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtTim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jPanel4, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(62, Short.MAX_VALUE)));
		this.setLayout(layout);
	}

	public void XoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) jTableDia.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void DocDuLieuDatabaseVaoTable(String txt) {
		XoaHetDuLieuTrenTableModel();
		List<Dia> list = new ArrayList<Dia>();
		qldia = new QuanLyDia();

		if (txt.equals(""))
			list = qldia.dsDia();
		else
			list = qldia.tim_Dia(txt);

		if (list.size() == 0) {
			JOptionPane.showMessageDialog(null, "Không tìm thấy");
			list = qldia.dsDia();
		}

		DefaultTableModel dm = (DefaultTableModel) jTableDia.getModel();
		for (Dia d : list) {
			TieuDe td = qltd.chiTietTieuDe(d.getTieuDe().getMaTD());
			TheLoai tl = qltl.chiTietTheLoai(d.getTheLoai().getMaTL());
			String tinhTrang, huHong;
			KhachHang kh = null;
			if (d.getTinhTrang() == 0) {
				tinhTrang = "Có sẵn";
			} else if (d.getTinhTrang() == 1) {
				tinhTrang = "Cho thuê";
				ChiTietPhieuThue ctpt = ql_ctpt.getPhieuThueGanNhat_TheoDia(d.getMaDia());
				PhieuThue pt = qlpt.chiTietPhieuThue(ctpt.getPhieuThue().getMaPT());
				kh = qlkh.chiTietKhachHang(pt.getKhachHang().getMaKH());
			} else {
				tinhTrang = "Đặt hàng";
				ChiTietPhieuDat ctpd = ql_ctpd.getPhieuDatGanNhat_TheoMaDia(d.getMaDia());
				PhieuDat pd = qlpd.chiTietPhieuDat(ctpd.getPhieuDat().getMaDH());
				kh = qlkh.chiTietKhachHang(pd.getKhachHang().getMaKH());
			}
			if(kh == null)
				dm.addRow(new Object[] { d.getMaDia(), td.getTenTD(), tl.getTenTL(), tinhTrang,"" });
			else
				dm.addRow(new Object[] { d.getMaDia(), td.getTenTD(), tl.getTenTL(), tinhTrang,kh.getTenKH() });
		}

	}

	private javax.swing.JButton btnTim;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTableDia;
	private javax.swing.JTextField txtTim;

	private QuanLyDia qldia;
	private QuanLyTheLoai qltl;
	private QuanLyTieuDe qltd;
	private QuanLyCT_PhieuThue ql_ctpt;
	private QuanLyPhieuThue qlpt;
	private QuanLyCT_PhieuDat ql_ctpd;
	private QuanLyPhieuDat qlpd;
	private QuanLyKhachHang qlkh;
	// End of variables declaration//GEN-END:variables
}
