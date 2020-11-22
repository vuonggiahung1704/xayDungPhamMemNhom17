/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_taiKhoan;

import java.awt.HeadlessException;

import javax.swing.JOptionPane;

import database.Database;
import entities.TaiKhoan;
import service.QuanLyTaiKhoan;

/**
 *
 * @author nmrhu
 */
public class DoiMatKhau_Dialog extends javax.swing.JDialog {

    /**
     * Creates new form TaiKhoan_DL
     */
    public DoiMatKhau_Dialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	Database.getInstance().connect();
    	qltk = new QuanLyTaiKhoan();

        jLabel5 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JTextField();
        txtMatKhauMoi = new javax.swing.JTextField();
        txtXacNhan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel5.setText("Xác nhận:");

        btnLuu.setBackground(new java.awt.Color(0, 153, 255));
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setIcon(new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\save_30px.png")); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(kiemTraNhap()) {
                	capNhatMatKhau();
                }
            }
        });

        btnXoaTrang.setBackground(new java.awt.Color(255, 0, 0));
        btnXoaTrang.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaTrang.setIcon(new javax.swing.ImageIcon("D:\\HK1_Nam_4\\XayDungPhanMem\\Netbeans\\DemoGui\\img\\delete_30px.png")); // NOI18N
        btnXoaTrang.setText("Đóng");
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });

        jLabel3.setText("Mật khẩu:");

        jLabel4.setText("Mât khẩu mới:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMatKhau)
                    .addComponent(txtMatKhauMoi)
                    .addComponent(txtXacNhan)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaTrang, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                .addGap(23, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMatKhauMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnXoaTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    
    public void capNhatMatKhau() {
    	String matKhauMoi = txtMatKhauMoi.getText().toString();
    	tk.setMatKhau(matKhauMoi);
    	try {
			qltk.capNhatTaiKhoan(tk);
			JOptionPane.showMessageDialog(null, "Cập nhật mật khẩu mới thánh công");
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public boolean kiemTraNhap() {
    	String matKhauCu = txtMatKhau.getText();
    	String matKhauMoi = txtMatKhauMoi.getText();
    	String xacNhan = txtXacNhan.getText();
    	
    	if(matKhauCu.equals("") || matKhauMoi.equals("") || xacNhan.equals("")) {
    		JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ");
    		return false;        	
    	}
    	else if(!matKhauCu.equals(tk.getMatKhau())){
    		JOptionPane.showMessageDialog(null, "Mật khẩu không chính xác");
    		txtMatKhau.requestFocus();
    		return false; 
    	}
    	else if(!matKhauMoi.equals(xacNhan)){
    		JOptionPane.showMessageDialog(null, "Nhập lại xác nhận mật khẩu");
    		txtXacNhan.requestFocus();
    		return false; 
    	}
    	return true;
    }
    
    public static void setData(TaiKhoan tk_sql) {
    	tk = tk_sql;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoiMatKhau_Dialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DoiMatKhau_Dialog dialog = new DoiMatKhau_Dialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnXoaTrang;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtMatKhauMoi;
    private javax.swing.JTextField txtXacNhan;
    
    public static TaiKhoan tk;
    
    public QuanLyTaiKhoan qltk;
    // End of variables declaration//GEN-END:variables
}