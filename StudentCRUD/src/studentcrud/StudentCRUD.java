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
import studentcrud.controller.StudentController;
import studentcrud.entity.StudentEntity;

/**
 *
 * @author ssara
 */
public class StudentCRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        try{
            StudentController studController = new StudentController();
                    
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

                    StudentEntity student = new StudentEntity(firstName,lastName,rollNo,gender,email);
                    
                    studController.controllerInsert(student);
                   
                }

                else if(ch == 2){
                    
                    System.out.println("Enter stud roll no to delete : ");
                    int rollNo = in.nextInt();

                    studController.controllerDelete(rollNo);
                    
                    
                }

                else if(ch == 3){
                    
                    System.out.println("Enter stud rollNo to update");
                    int rollNo = in.nextInt();
                    System.out.println("Enter email: ");
                    String email = in.next();    

                    studController.controllerUpdate(rollNo,email);
        
                }

                else if(ch == 4){
                        
                    System.out.println("Enter stud rollNo to search: ");
                    int rollNo = in.nextInt();

                    StudentEntity student = studController.controllerSearch(rollNo);
                    System.out.println("id\tfirst_name\tlast_name\trollNo\tgender\temail");
                    System.out.println(student.getId());
                    System.out.println(student.getFirstName());
                    System.out.println(student.getLastName());
                    System.out.println(student.getRollNo());
                    System.out.println(student.getGender());
                    System.out.println(student.getEmail());
                    
                }

                else if(ch == 5){
                    studController.controllerDisplay();
                }

                else {
                    System.out.println("Invalid choice");
                }
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    
}
