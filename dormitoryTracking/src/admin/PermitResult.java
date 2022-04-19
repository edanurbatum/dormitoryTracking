
package admin;

import connection.*;
import java.sql.*;
import javax.swing.JOptionPane;
import pages.AdminDormitoryOperation;

public class PermitResult extends javax.swing.JFrame {
    ConnectionStudents connectionStudents=new ConnectionStudents();
    String queryStudents="select * from students";
    
    ConnectionPermit connectionPermit=new ConnectionPermit();
    
    ConnectionPermitRequests connectionPermitRequests=new ConnectionPermitRequests();
    String query="select * from permitRequests where response='Beklemede'";   
    String queryPermitRequests="select * from permitRequests where response='Onaylandı' OR response='Reddedildi';";
    
    
    public PermitResult() {
        initComponents();
        connectionStudents.populateTable(queryStudents, tblStudents);
        connectionPermitRequests.populateTable(query, tblPermitRequests);
        connectionPermitRequests.populateTable(queryPermitRequests, tblOldPermitRequests);
    }
    
    public void response(String response,String tc){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            String sql="UPDATE permitRequests SET response ='"+response+"' where requestId=?";
            statement=connection.prepareStatement(sql);
            
            statement.setString(1, tbxId.getText());
            statement.executeUpdate();
            connectionPermitRequests.populateTable(queryPermitRequests, tblOldPermitRequests);
            connectionPermitRequests.populateTable(query, tblPermitRequests);         
            
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try{
               statement.close();
               connection.close(); 
               //clean();
               
            }catch(SQLException exception){
           
           dbHelper.showErrorMessage(exception);
            }           
        }
    }

    
    public void add(){
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;
        
        try{
            connection=dbHelper.getConnection();
            String sql="INSERT INTO permits (tc,name,lastname,remainingPermitAmount,permitStart,permitFinish,permitAddress,usedPermitAmount) VALUES (?,?,?,?,?,?,?,?)";
            statement=connection.prepareStatement(sql);
            
            updateRemainingPermit();//kalan izin miktarını güncellesin 
            
            statement.setString(1, tbxTc.getText());
            statement.setString(2, tbxName.getText());
            statement.setString(3, tbxLastName.getText());
            statement.setInt(4, Integer.valueOf(tbxRemainingPermit.getText()));
            statement.setString(5, tbxPermitStart.getText());
            statement.setString(6, tbxPermitFinish.getText());
            statement.setString(7, tbxPermitAddress.getText());
            statement.setInt(8, Integer.valueOf(tbxUsedPermit.getText()));
            statement.executeUpdate();
           
            String tc=tbxTc.getText();
            response("Onaylandı",tc); 
          
        }catch(SQLException exception){
            dbHelper.showErrorMessage(exception);
        }finally{
            try{
               statement.close();
               connection.close(); 
               
       }catch(SQLException exception){
            }           
        }
    }
    public void clean(){
        tbxTc.setText("");
        tbxName.setText("");
        tbxLastName.setText("");
        tbxRemainingPermit.setText("");
        tbxPermitStart.setText("");
        tbxPermitFinish.setText("");
        tbxPermitAddress.setText("");
        tbxUsedPermit.setText("");
    }
    
    public void updateRemainingPermit(){
        
        int remainingPermit=Integer.valueOf(tbxRemainingPermit.getText());
        int usedPermit=Integer.valueOf(tbxUsedPermit.getText());
        remainingPermit=remainingPermit-usedPermit;
        
        
        String queryStudent="UPDATE students SET remainingPermitAmount='"+remainingPermit+"' WHERE tc='"+tbxTc.getText()+"'";
        String queryPermitRequest="UPDATE permitRequests SET remainingPermitAmount='"+remainingPermit+"' WHERE requestId='"+tbxId.getText()+"'";
        
        Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        PreparedStatement statement=null;

        try{
            
            connection=dbHelper.getConnection();
            statement=connection.prepareStatement(queryStudent);
            statement.executeUpdate();
            
            statement=connection.prepareStatement(queryPermitRequest);
            statement.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Kalan izin miktarı güncellendi: "+remainingPermit);
            tbxRemainingPermit.setText(String.valueOf(remainingPermit));
            
        }catch(SQLException exception){
                dbHelper.showErrorMessage(exception);
            }finally{
                try{
                   statement.close();
                   connection.close(); 
                   
                }catch(SQLException exception){
                }           
            } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPermitRequests = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tbxTc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbxName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbxLastName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbxRemainingPermit = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tbxPermitStart = new javax.swing.JTextField();
        tbxPermitFinish = new javax.swing.JTextField();
        tbxPermitAddress = new javax.swing.JTextField();
        tbxUsedPermit = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnDecline = new javax.swing.JButton();
        btnComeBack = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        tbxId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDetail = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOldPermitRequests = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tblPermitRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "TC", "İsim", "Soyisim", "Kalan İzin", "İzin Başlangıç", "İzin Bitiş", "İzin Adresi", "Kullanılacak İzin ", "Yanıt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPermitRequests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPermitRequestsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPermitRequests);
        if (tblPermitRequests.getColumnModel().getColumnCount() > 0) {
            tblPermitRequests.getColumnModel().getColumn(0).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(1).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(2).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(3).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(4).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(5).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(6).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(7).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(8).setResizable(false);
            tblPermitRequests.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel1.setText("Tc");

        jLabel2.setText("İsim");

        jLabel3.setText("Soyisim");

        jLabel4.setText("Kalan İzin");

        jLabel5.setText("İzin Başlangıç");

        jLabel6.setText("İzin Bitiş");

        jLabel7.setText("İzin Adresi");

        jLabel8.setText("Kullanılacak İzin Miktarı");

        btnConfirm.setText("ONAYLA");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnDecline.setText("REDDET");
        btnDecline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineActionPerformed(evt);
            }
        });

        btnComeBack.setText("GERİ DÖN");
        btnComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComeBackActionPerformed(evt);
            }
        });

        lblId.setText("Id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnConfirm)
                        .addGap(78, 78, 78))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblId))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbxTc)
                            .addComponent(tbxName)
                            .addComponent(tbxLastName)
                            .addComponent(tbxRemainingPermit, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(tbxId))
                        .addGap(69, 69, 69)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbxUsedPermit, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxPermitStart, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxPermitFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxPermitAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnDecline)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnComeBack)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tbxPermitStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblId)
                    .addComponent(tbxId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tbxPermitFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxTc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tbxPermitAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUsedPermit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(tbxLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxRemainingPermit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirm)
                    .addComponent(btnDecline)
                    .addComponent(btnComeBack))
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Bekleyen İzin Talepleri", jPanel1);

        tblDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TC", "İsim", "Soyisim", "Kalan İzin", "İzin Başlangıç", "İzin Bitiş", "İzin Türü", "Kullanılan İzin"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDetail);

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TC", "İsim", "Soyisim"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblStudents);
        if (tblStudents.getColumnModel().getColumnCount() > 0) {
            tblStudents.getColumnModel().getColumn(0).setResizable(false);
            tblStudents.getColumnModel().getColumn(1).setResizable(false);
            tblStudents.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("İzinler", jPanel2);

        tblOldPermitRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "TC", "İsim", "Soyisim", "Kalan İzin", "İzin Başlangıç", "İzin Bitiş", "İzin Adresi", "Kullanılacak İzin ", "Yanıt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblOldPermitRequests);
        if (tblOldPermitRequests.getColumnModel().getColumnCount() > 0) {
            tblOldPermitRequests.getColumnModel().getColumn(0).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(1).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(2).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(3).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(4).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(5).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(6).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(7).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(8).setResizable(false);
            tblOldPermitRequests.getColumnModel().getColumn(9).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1021, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geçmiş İzin Talepleri", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        add();      
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void tblPermitRequestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPermitRequestsMouseClicked
        tbxId.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 0).toString());
        tbxTc.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 1).toString());
        tbxName.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 2).toString());
        tbxLastName.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 3).toString());
        tbxRemainingPermit.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 4).toString());
        tbxPermitStart.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 5).toString());
        tbxPermitFinish.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 6).toString());
        tbxPermitAddress.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 7).toString());
        tbxUsedPermit.setText(tblPermitRequests.getValueAt(tblPermitRequests.getSelectedRow(), 8).toString());
    }//GEN-LAST:event_tblPermitRequestsMouseClicked

    private void btnComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComeBackActionPerformed
        this.setVisible(false);
        new AdminDormitoryOperation().setVisible(true);
    }//GEN-LAST:event_btnComeBackActionPerformed

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
        String tc=(tblStudents.getValueAt(tblStudents.getSelectedRow(), 0).toString());
        String sql="select * from permits where tc='"+tc+"'";
        connectionPermit.populateTable(sql, tblDetail);
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void btnDeclineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineActionPerformed
        String tc=tbxTc.getText();
        response("Reddedildi",tc);     
    }//GEN-LAST:event_btnDeclineActionPerformed

  
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
            java.util.logging.Logger.getLogger(PermitResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PermitResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PermitResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PermitResult.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PermitResult().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComeBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnDecline;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tblDetail;
    private javax.swing.JTable tblOldPermitRequests;
    private javax.swing.JTable tblPermitRequests;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField tbxId;
    private javax.swing.JTextField tbxLastName;
    private javax.swing.JTextField tbxName;
    private javax.swing.JTextField tbxPermitAddress;
    private javax.swing.JTextField tbxPermitFinish;
    private javax.swing.JTextField tbxPermitStart;
    private javax.swing.JTextField tbxRemainingPermit;
    private javax.swing.JTextField tbxTc;
    private javax.swing.JTextField tbxUsedPermit;
    // End of variables declaration//GEN-END:variables
}
