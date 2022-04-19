 
package connection;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnectionStudents {
    DefaultTableModel model;
    
    public void populateTable(String sql,JTable tbl){
        model=(DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        try {
            ArrayList<Student>students=getStudents(sql);
            for (Student student:students) {
                Object[]row={
                    student.getTc(),student.getName(),student.getLastName(),
                    student.getRoomNumber(),student.getBedNumber(), student.getRemainingPermitAmount(),
                    student.getResidenceAddress(), student.getDateOfBirth(),student.getDateOfRegistration(),
                    student.getBloodType(), student.getEmail(),student.getPhoneNumber(),student.getDisease()
                }; 
                model.addRow(row);
            }     
            
        } catch (SQLException exception) {
            System.out.println("Error: "+exception.getMessage());
        }        
    }
    
    public ArrayList<Student>getStudents(String sql)throws SQLException{
        java.sql.Connection connection=null;
        DbHelper dbHelper=new DbHelper();
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList<Student>students=null;
        
        try{
            connection=dbHelper.getConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            students=new ArrayList<Student>();
            
            while(resultSet.next()){
                students.add(new Student(
                        resultSet.getString("tc"),
                        resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        resultSet.getString("roomNumber"),
                        resultSet.getString("bedNumber"),
                        resultSet.getString("remainingPermitAmount"),
                        resultSet.getString("residenceAddress"),
                        resultSet.getString("dateOfBirth"),
                        resultSet.getString("dateOfRegistration"),
                        resultSet.getString("bloodType"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("disease")
                        
                ));
            }
            
        }catch(SQLException exception){
            System.out.println(exception.getMessage());
        }finally{
            statement.close();
            connection.close();
        }
        return students;
    }
}
