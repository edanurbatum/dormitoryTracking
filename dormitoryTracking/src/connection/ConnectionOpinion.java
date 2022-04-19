
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionOpinion {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable table) throws SQLException{
        
        model=(DefaultTableModel) table.getModel();
        model.setRowCount(0);
        ArrayList<Opinion>opinions=getOpinion(sql);
        for (Opinion opinion:opinions) {
            Object[]row={
                opinion.getId(),opinion.getTc(),opinion.getName(),opinion.getLastName(),
                opinion.getRoomNumber(),opinion.getBedNumber(),opinion.getText()
            }; 
            model.addRow(row);
        }
    }
    
    public ArrayList<Opinion>getOpinion(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Opinion>opinions=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            opinions=new ArrayList<Opinion>();
            
            while(resultSet.next()){
                opinions.add(new Opinion(
                        resultSet.getInt("opinionId"),
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("roomNumber"),
                        resultSet.getString("bedNumber"),
                        resultSet.getString("text")                      
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return opinions;
    }
}
