
package pages;

import admin.AddStudent;
import admin.PermitResult;
import admin.RefectoryCrud;
import admin.RepairResult;
import admin.ViewOpinions;

public class AdminDormitoryOperation extends javax.swing.JFrame {

    /** Creates new form AdminDormitoryOperation */
    public AdminDormitoryOperation() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPermits = new javax.swing.JButton();
        btnComeBack = new javax.swing.JButton();
        btnOpinions = new javax.swing.JButton();
        btnRepairResult = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAddStudent = new javax.swing.JButton();
        btnRefectory = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnPermits.setBackground(new java.awt.Color(153, 153, 255));
        btnPermits.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnPermits.setText("İzinler");
        btnPermits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermitsActionPerformed(evt);
            }
        });

        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        btnOpinions.setBackground(new java.awt.Color(153, 153, 255));
        btnOpinions.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnOpinions.setText("Şikayet/Öneri/Talepler");
        btnOpinions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpinionsActionPerformed(evt);
            }
        });

        btnRepairResult.setBackground(new java.awt.Color(153, 153, 255));
        btnRepairResult.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnRepairResult.setText("Tamir Talepleri");
        btnRepairResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRepairResultActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel1.setText("Admin İşlemleri");

        btnAddStudent.setBackground(new java.awt.Color(153, 153, 255));
        btnAddStudent.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnAddStudent.setText("Öğrenci Kayıt");
        btnAddStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStudentActionPerformed(evt);
            }
        });

        btnRefectory.setBackground(new java.awt.Color(153, 153, 255));
        btnRefectory.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        btnRefectory.setText("Yemekhane İşlemleri");
        btnRefectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefectoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPermits, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOpinions, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnComeBack)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnRepairResult, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)))
                        .addComponent(btnAddStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefectory, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addComponent(btnAddStudent)
                .addGap(18, 18, 18)
                .addComponent(btnPermits)
                .addGap(18, 18, 18)
                .addComponent(btnOpinions)
                .addGap(18, 18, 18)
                .addComponent(btnRepairResult)
                .addGap(18, 18, 18)
                .addComponent(btnRefectory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnComeBack)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPermitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermitsActionPerformed
        new PermitResult().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnPermitsActionPerformed

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        new HomePage().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void btnOpinionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpinionsActionPerformed
        new ViewOpinions().setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_btnOpinionsActionPerformed

    private void btnRepairResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRepairResultActionPerformed
        new RepairResult().setVisible(true);
        this.setVisible(false);      
    }//GEN-LAST:event_btnRepairResultActionPerformed

    private void btnAddStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStudentActionPerformed
        new AddStudent().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddStudentActionPerformed

    private void btnRefectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefectoryActionPerformed
        new RefectoryCrud().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRefectoryActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDormitoryOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDormitoryOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDormitoryOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDormitoryOperation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDormitoryOperation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStudent;
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnOpinions;
    private javax.swing.JButton btnPermits;
    private javax.swing.JButton btnRefectory;
    private javax.swing.JButton btnRepairResult;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

}
