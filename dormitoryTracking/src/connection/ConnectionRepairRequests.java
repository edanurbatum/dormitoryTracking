
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionRepairRequests {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<RepairRequest>repairRequests=getRepairRequest(sql);
            for (RepairRequest repairRequest:repairRequests) {
                Object[]row={
                    repairRequest.getRepairId(),repairRequest.getName(),repairRequest.getLastName(),
                    repairRequest.getRoomNumber(),repairRequest.getBedNumber(),
                    repairRequest.getProblemDefinition(),repairRequest.getResult()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<RepairRequest>getRepairRequest(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<RepairRequest>repairRequests=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            repairRequests=new ArrayList<RepairRequest>();
            
            while(resultSet.next()){
                repairRequests.add(new RepairRequest(
                        resultSet.getInt("repairId"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("roomNumber"),
                        resultSet.getString("bedNumber"),
                        resultSet.getString("problemDefinition"),
                        resultSet.getString("result")
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return repairRequests;
    }
}
