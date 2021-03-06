package gui_danhMuc;

import javax.swing.JOptionPane;

import database.Database;
import entities.TaiKhoan;
import gui_main.Main_Gui;
import service.QuanLyTieuDe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nmrhu
 */
public class TenDia_Dialog extends javax.swing.JDialog {

	/**
	 * Creates new form NewJDialog
	 */
	public TenDia_Dialog(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		
		getID();
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
		
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtMaTD = new javax.swing.JTextField();
		txtTenTD = new javax.swing.JTextField();
		btnLuu = new javax.swing.JButton();
		btnDong = new javax.swing.JButton();

		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBackground(new java.awt.Color(255, 255, 255));

		jLabel1.setText("Mã tiêu đề");

		jLabel2.setText("Tên tiêu đề");

		txtMaTD.setEditable(false);

		btnLuu.setBackground(new java.awt.Color(0, 153, 255));
		btnLuu.setForeground(new java.awt.Color(255, 255, 255));
		btnLuu.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\save_30px.png")); // NOI18N
		btnLuu.setText("Lưu");
		btnLuu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String tenTd = txtTenTD.getText().toString();
				if (tenTd.equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ");
				} else {
					main.tenDia_pn.ThemTenDia(tenTd);
					dispose();
				}
			}
		});

		btnDong.setBackground(new java.awt.Color(255, 0, 0));
		btnDong.setForeground(new java.awt.Color(255, 255, 255));
		btnDong.setIcon(
				new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\delete_30px.png")); // NOI18N
		btnDong.setText("Đóng");
		btnDong.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				main.tenDia_pn.DocDuLieuDatabaseVaoTable("");
        		dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
								.addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtMaTD, javax.swing.GroupLayout.DEFAULT_SIZE, 333,
												Short.MAX_VALUE)
										.addComponent(txtTenTD))
								.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 154,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29,
												Short.MAX_VALUE)
										.addComponent(btnDong, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(18, Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(txtMaTD, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(txtTenTD, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnLuu).addComponent(btnDong))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}
	
	public void getID() {
		int id = qltd.getMaTieuDe();
		String maTD = null;
		if (id == 0) {
			maTD = "TD00001";
		} else if (id < 10)
			maTD = "TD0000" + id;
		else if (id < 100)
			maTD = "TD000" + id;
		else if (id < 1000)
			maTD = "TD00" + id;
		else if (id < 10000)
			maTD = "TD0" + id;
		else
			maTD = "TD" + id;

		txtMaTD.setText(maTD);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TenDia_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TenDia_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TenDia_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TenDia_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				TenDia_Dialog dialog = new TenDia_Dialog(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnDong;
	private javax.swing.JButton btnLuu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JTextField txtMaTD;
	private javax.swing.JTextField txtTenTD;

	private Main_Gui main;
	private QuanLyTieuDe qltd;
	// End of variables declaration//GEN-END:variables
}
