/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_danhMuc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import database.Database;
import entities.KhachHang;
import entities.PhieuThue;
import entities.TaiKhoan;
import gui_giaodich.ChiTietPhieuThueDialog;
import gui_main.Main_Gui;
import service.QuanLyPhieuThue;
import service.QuanLyTaiKhoan;

/**
 *
 * @author nmrhu
 */
public class GiaoDich_Panel extends javax.swing.JPanel {

	/**
	 * Creates new form ThanhToan_Panel
	 */
	public GiaoDich_Panel(String maKH_) {
		maKH = maKH_;
		initComponents();
		DocDuLieuDatabaseVaoTable();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		Database.getInstance().connect();
		qlpt = new QuanLyPhieuThue();
		qltk = new QuanLyTaiKhoan();
		
		jScrollPane1 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		jPopupMenu1 = new javax.swing.JPopupMenu();
		jPopupMenu1.setFocusable(false);
    	
		mnCTPT = new javax.swing.JMenuItem();
		mnCTPT.setText("Chi tiết phiếu thuê");
		mnCTPT.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChiTietPhieuThueDialog dialog = new ChiTietPhieuThueDialog(main, true, maPT);
				dialog.setTitle("Chi tiết phiếu thuê");
				dialog.setLocationRelativeTo(main);
				dialog.setData(maPT);
				dialog.setVisible(true);
			}
		});
		jPopupMenu1.add(mnCTPT);
		
		setLayout(new java.awt.BorderLayout());

		jTable1.setRowHeight(22);
		jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][] {
		}, new String[] { "MaPT", "Ngày lập", "Tổng tiền", "Người lập" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jTable1.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jTable1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
				}else {
					int row = jTable1.getSelectedRow();
					TableModel model = jTable1.getModel();
					maPT = model.getValueAt(row, 0).toString();
				}
			}
		});
		
		jScrollPane1.setViewportView(jTable1);

		add(jScrollPane1, java.awt.BorderLayout.CENTER);
	}
	
//	ChiTietPhieuThueDialog dialog = new ChiTietPhieuThueDialog(main, true, maPT);
//	dialog.setLocationRelativeTo(main);
//	dialog.setData(maPT);
//	dialog.setVisible(true);
	
	public void DocDuLieuDatabaseVaoTable() {
		List<PhieuThue> list = new ArrayList<PhieuThue>();
		qlpt = new QuanLyPhieuThue();
		list = qlpt.tim_PhieuThue_KhachHang(maKH);
		DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
		for (PhieuThue phieuThue : list) {
			TaiKhoan tk = qltk.chiTietTaiKhoan(phieuThue.getNhanVien().getTenTK());
			dm.addRow(new Object[] {phieuThue.getMaPT(),phieuThue.getNgayThue(),tk.getHoTen(),phieuThue.getTongTien()});
		}
	}
	
	private javax.swing.JPopupMenu jPopupMenu1;
	private javax.swing.JMenuItem mnCTPT;
	
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables
	private QuanLyPhieuThue qlpt;
	private QuanLyTaiKhoan qltk;
	private String maKH;
	
	private String maPT;
	private Main_Gui main;
}