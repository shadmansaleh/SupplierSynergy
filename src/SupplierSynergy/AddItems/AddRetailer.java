/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SupplierSynergy.AddItems;

/**
 *
 * @author shadman
 */
public class AddRetailer extends javax.swing.JFrame {

    /**
     * Creates new form AddSupplier
     */
    public AddRetailer() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_bookid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_bookid1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_bookid4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_bookid5 = new javax.swing.JTextField();
        rSMaterialButtonCircle1 = new necesario.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(51, 102, 255));
        jLabel1.setFont(new java.awt.Font("Glass Antiqua", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("Name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        txt_bookid.setFont(new java.awt.Font("Glass Antiqua", 0, 18)); // NOI18N
        txt_bookid.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 230, 30));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("Glass Antiqua", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Address");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, -1, -1));

        txt_bookid1.setFont(new java.awt.Font("Glass Antiqua", 0, 18)); // NOI18N
        txt_bookid1.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookid1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_bookid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookid1ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 230, 30));

        jLabel5.setBackground(new java.awt.Color(51, 102, 255));
        jLabel5.setFont(new java.awt.Font("Glass Antiqua", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Phone");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        txt_bookid4.setFont(new java.awt.Font("Glass Antiqua", 0, 18)); // NOI18N
        txt_bookid4.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookid4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_bookid4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookid4ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, 230, 30));

        jLabel6.setBackground(new java.awt.Color(51, 102, 255));
        jLabel6.setFont(new java.awt.Font("Glass Antiqua", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 250, -1, -1));

        txt_bookid5.setFont(new java.awt.Font("Glass Antiqua", 0, 18)); // NOI18N
        txt_bookid5.setForeground(new java.awt.Color(255, 255, 255));
        txt_bookid5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 102, 255)));
        txt_bookid5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookid5ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookid5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 240, 230, 30));

        rSMaterialButtonCircle1.setText("Add");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 190, 70));

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 25, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-close-50.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, -1, -1));

        title.setFont(new java.awt.Font("Glass Antiqua", 1, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Add Retailer");
        jPanel4.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 270, 90));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 100));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookidActionPerformed

    private void txt_bookid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookid1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookid1ActionPerformed

    private void txt_bookid4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookid4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookid4ActionPerformed

    private void txt_bookid5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookid5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookid5ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(AddRetailer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRetailer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRetailer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRetailer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRetailer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private necesario.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txt_bookid;
    private javax.swing.JTextField txt_bookid1;
    private javax.swing.JTextField txt_bookid4;
    private javax.swing.JTextField txt_bookid5;
    // End of variables declaration//GEN-END:variables
}
