/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_giaodich;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import entities.TaiKhoan;
import gui_heThong.PhieuThue_DS_Gui;

/**
 *
 * @author nmrhu
 */
public class PhieuThue_Gui extends javax.swing.JPanel {

    /**
     * Creates new form TraCuu_Gui
     */
    public PhieuThue_Gui() {
        initComponents();        
        khoiTao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1300, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1274, 605));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("/ Phiếu thuê");

        jLabel1.setForeground(new java.awt.Color(51, 153, 255));
        jLabel1.setText("  Giao dịch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void khoiTao(){
        DS_Phieu_pn = new gui_heThong.PhieuThue_DS_Gui();
        LapPhieu_pn = new PhieuThue_Lap_Gui();

        DS_Phieu_pn.setData(tk);
                
        jPanel2.add(DS_Phieu_pn);
        DS_Phieu_pn.setVisible(true);
    }
    
    public static void lapPhieuThue(TaiKhoan tk){
        LapPhieu_pn.setData(tk);
        
    	DS_Phieu_pn.setVisible(false);
                
        jPanel2.add(LapPhieu_pn);
        LapPhieu_pn.setVisible(true);
    }
    
    public static void dsPhieu(TaiKhoan tk){
        DS_Phieu_pn.setData(tk);
        
        LapPhieu_pn.setVisible(false);
                
        jPanel2.add(DS_Phieu_pn);
        DS_Phieu_pn.setVisible(true);
    }
    
    public static void setData(TaiKhoan tk_sql) {
    	if(!(tk_sql == null)) {
			tk = tk_sql;
		}
    }
    
//    private static PhieuThue_DS_Gui DS_Phieu_pn;
    public static gui_heThong.PhieuThue_DS_Gui DS_Phieu_pn;
    public static PhieuThue_Lap_Gui LapPhieu_pn;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
    
    public static TaiKhoan tk;
}
