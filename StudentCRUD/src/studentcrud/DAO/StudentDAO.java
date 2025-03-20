/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcrud.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import studentcrud.entity.StudentEntity;
import studentcrud.util.StudentUtil;

/**
 *
 * @author ssara
 */
public class StudentDAO {
    
    StudentUtil studUtil = new StudentUtil();
    Connection conn;
    
    public StudentDAO() throws ClassNotFoundException, SQLException{
        conn = studUtil.connection();
    }
    
    public void daoInsert(StudentEntity student) throws SQLException{
        String insertQuery = "INSERT INTO student_details (first_name,last_name,rollNo,gender,email) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(insertQuery);
        pstmt.setString(1, student.getFirstName());
        pstmt.setString(2, student.getLastName());
        pstmt.setInt(3, student.getRollNo());
        pstmt.setString(4, String.valueOf(student.getGender()));
        pstmt.setString(5, student.getEmail());
        pstmt.executeUpdate();
        System.out.println("Inserted successfully");
    }
    
    public void daoDelete(int rollNo) throws SQLException{
        
        String deleteQuery = "DELETE FROM student_details WHERE rollNo = ?";
        PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
        pstmt.setInt(1,rollNo);
        pstmt.executeUpdate();
        System.out.println("Deleted successfully");
                    
        
    }
    
    public void daoUpdate(int rollNo, String email) throws SQLException{
        String updateQuery = "UPDATE student_details SET email = ? where rollNo = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateQuery);
        pstmt.setString(1,email);
        pstmt.setInt(2,rollNo);
        pstmt.executeUpdate();
        System.out.println("Successfully updated");

    }
    
    public StudentEntity daoSearch(int rollNo) throws SQLException{
        
        StudentEntity student = new StudentEntity();
        String selectQuery = "Select * from student_details";
        PreparedStatement pstmt = conn.prepareStatement(selectQuery);
        ResultSet resultSet = pstmt.executeQuery();
            
        while(resultSet.next()){

            if(rollNo == resultSet.getInt("rollNo")){
                
                student.setId(resultSet.getInt("id"));
                student.setFirstName(resultSet.getString("first_name"));
                student.setLastName(resultSet.getString("last_name"));
                student.setRollNo(resultSet.getInt("rollNo"));
                student.setGender(resultSet.getString("gender").charAt(0));
                student.setEmail(resultSet.getString("email"));
                break;
            }
        }
        return student;

    }
    
    public void daoDisplay() throws SQLException{
        String selectQuery = "Select * from student_details";
        PreparedStatement pstmt = conn.prepareStatement(selectQuery);
        ResultSet resultSet = pstmt.executeQuery();

        System.out.println("id\tfirst_name\tlast_name\trollNo\tgender\temail");
        while(resultSet.next()){

            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            int rollNo = resultSet.getInt("rollNo");
            String gender = resultSet.getString("gender");
            String email = resultSet.getString("email");

            System.out.println(id+"\t"+firstName+"\t"+lastName+"\t"+rollNo+"\t"+gender+"\t"+email);
        }
    }
}
