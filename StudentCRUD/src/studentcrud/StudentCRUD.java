/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ssara
 */

class StudentDetails{
    
    private int id, rollNo;
    private String firstName,lastName,email;
    private char gender;
    
    public StudentDetails(){
        
    }
    
    public StudentDetails(String firstName, String lastName, int rollNo, char gender, String email){
        
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.rollNo = rollNo;
        this.gender = gender;
        this.email = email;
                
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
    
    
    
    
    public void insertStudent(StudentDetails student, PreparedStatement pstmt){
        try{

            pstmt.setString(1, student.firstName);
            pstmt.setString(2,student.lastName);
            pstmt.setInt(3,student.rollNo);
            pstmt.setString(4,String.valueOf(student.gender));
            pstmt.setString(5, student.email);
            
            
            pstmt.executeUpdate();
        
        
          
        }catch(SQLException e){
            System.out.println("insertStudent exception");
        }
        
    }
    
    public void deleteStudent(PreparedStatement pstmt){
        try{
            pstmt.executeUpdate();
            System.out.println("Deleted successfully");
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void updateStudent(PreparedStatement pstmt){
        
        try{
//            System.out.println(pstmt);
            pstmt.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            
        }
        
    }
    
    public void displayStudent(PreparedStatement pstmt){
        
        try{
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
        }catch(SQLException e){
            System.out.println("displayStudent method exception");
        }
    }
    
    public void searchStudent(PreparedStatement pstmt,int rollNo){
        
        try{
            ResultSet resultSet = pstmt.executeQuery();
            
            while(resultSet.next()){
                
                if(rollNo == resultSet.getInt("rollNo")){
                    System.out.println(resultSet.getInt("id"));
                    System.out.println(resultSet.getString("first_name"));
                    System.out.println(resultSet.getString("last_name"));
                    System.out.println(resultSet.getInt("rollNo"));
                    System.out.println(resultSet.getString("gender"));
                    System.out.println(resultSet.getString("email"));
                    
                    break;

                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
public class StudentCRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        
        Connection conn;
        try{
            String url = "jdbc:mysql://localhost:3306/StudentCrud";
            String user = "root";
            String password = "Sharu@1229";



            //Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establish connection
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to MySQL database");
            
            StudentDetails stud = new StudentDetails();

            
            while(true){
            
                System.out.println("1.Insert student\n2.Delete Student\n3.Update Student\n4.Search\n5.Display All Students\nEnter choice: ");
                int ch = in.nextInt();

                if(ch == 1){
                    System.out.println("Enter student first name: ");
                    String firstName = in.next();
                    System.out.println("Enter student last name: ");
                    String lastName = in.next();
                    System.out.println("Enter student roll no: ");
                    int rollNo = in.nextInt();
                    System.out.println("Enter gender: ");
                    char gender = in.next().charAt(0);
                    System.out.println("Enter email: ");
                    String email = in.next();

                    StudentDetails student = new StudentDetails(firstName,lastName,rollNo,gender,email);

                    String insertQuery = "INSERT INTO student_details (first_name,last_name,rollNo,gender,email) VALUES(?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(insertQuery);

                    
                    student.insertStudent(student,pstmt);


                }

                else if(ch == 2){
                    
                    System.out.println("Enter stud roll no to delete : ");
                    int rollNo = in.nextInt();
                    String deleteQuery = "DELETE FROM student_details WHERE rollNo = ?";
                    PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
                    pstmt.setInt(1,rollNo);
                    stud.deleteStudent(pstmt);
                    
                }

                else if(ch == 3){
                    
                    System.out.println("Enter stud rollNo to update");
                    int rollNo = in.nextInt();
                    System.out.println("Enter email: ");
                    String email = in.next();                   
                    String updateQuery = "UPDATE student_details SET email = ? where rollNo = ?";
                    PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                    pstmt.setString(1,email);
                    pstmt.setInt(2,rollNo);
                    stud.updateStudent(pstmt);
                    System.out.println("Successfully updated");
                    break;

                        
                }

                    
                

                else if(ch == 4){
                        
                    System.out.println("Enter stud rollNo to search: ");
                    int rollNo = in.nextInt();
                    String selectQuery = "Select * from student_details";
                    PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                    stud.searchStudent(pstmt,rollNo);
                }

                else if(ch == 5){
                    
                    String selectQuery = "Select * from student_details";
                    PreparedStatement pstmt = conn.prepareStatement(selectQuery);
                    stud.displayStudent(pstmt);
                    break;
                }

                else {
                    System.out.println("Invalid choice");
                }
            }

            
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }
    
}
