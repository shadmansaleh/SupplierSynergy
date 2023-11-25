/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package SupplierSynergy;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import SupplierSynergy.AddItems.AddSupplier;

/**
 *
 * @author shadman
 */
public class Suppliers extends javax.swing.JPanel {

    /**
     * Creates new form Suppliers
     */

    public Suppliers() {
        initComponents();
        JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
        verticalScrollBar.setUnitIncrement(20);
        verticalScrollBar.setBlockIncrement(200);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new lib.JSqlTablel1();
        txt_serach = new javax.swing.JTextField();
        btn_search = new necesario.RSMaterialButtonCircle();
        jPanel1 = new javax.swing.JPanel();
        btn_remove = new javax.swing.JButton();
        btn_add = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 760));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Glass Antiqua", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(251, 51, 51));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        title.setText("Suppliers");
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 200, 90));

        tbl.setAutoCreateRowSorter(true);
        tbl.setLIMIT(100);
        tbl.setSQLQuery("SELECT * FROM Supplier");
        tbl.setShowGrid(false);
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 1200, 550));

        txt_serach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 251)));
        txt_serach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_serachActionPerformed(evt);
            }
        });
        add(txt_serach, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, 250, 40));

        btn_search.setText("Serach");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 60, 120, 50));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_remove.setBackground(new java.awt.Color(255, 51, 51));
        btn_remove.setFont(new java.awt.Font("Glass Antiqua", 0, 32)); // NOI18N
        btn_remove.setForeground(new java.awt.Color(255, 255, 255));
        btn_remove.setText("-");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 30, 80, 30));

        btn_add.setBackground(new java.awt.Color(102, 204, 0));
        btn_add.setFont(new java.awt.Font("Glass Antiqua", 0, 32)); // NOI18N
        btn_add.setForeground(new java.awt.Color(255, 255, 255));
        btn_add.setText("+");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 80, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1200, 80));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        String query = txt_serach.getText();
        tbl.setSQLWhere("name LIKE \"%"+query+"%\"");
    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_serachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_serachActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_serachActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        // TODO add your handling code here:
        int[] rows = tbl.getSelectedRows();
        Vector<String> ids = new Vector<>();
        DefaultTableModel model = (DefaultTableModel)tbl.getModel();
        for (int i=0; i < rows.length; i++) ids.add(model.getValueAt(rows[i], 0).toString());
        for (String id: ids) {
            try {
                Connection con = DBConnection.getConnection();
                String query_insert = "DELETE FROM Supplier WHERE supplier_id = ?";
                PreparedStatement par = con.prepareStatement(query_insert);
                par.setInt(1, Integer.valueOf(id));
                par.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tbl.load_data();
    }//GEN-LAST:event_btn_removeActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        new AddSupplier().setVisible(true);
    }//GEN-LAST:event_btn_addActionPerformed

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_remove;
    private necesario.RSMaterialButtonCircle btn_search;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private lib.JSqlTablel1 tbl;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt_serach;
    // End of variables declaration//GEN-END:variables
}
