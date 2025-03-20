/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcrud.controller;

import java.sql.SQLException;
import studentcrud.entity.StudentEntity;
import studentcrud.service.StudentService;

/**
 *
 * @author ssara
 */
public class StudentController {
    
    StudentService studService; 

    public StudentController() throws SQLException, ClassNotFoundException {
        this.studService = new StudentService();
    }
    
    public void controllerInsert(StudentEntity student) throws SQLException{
        studService.serviceInsert(student);
    }
    
    public void controllerDelete(int rollNo) throws SQLException{
        studService.serviceDelete(rollNo);
    }
    
    public void controllerUpdate(int rollNo, String email) throws SQLException{
        studService.serviceUpdate(rollNo, email);
    }
    
    public StudentEntity controllerSearch(int rollNo) throws SQLException{
        return studService.serviceSearch(rollNo);
    }
    
    public void controllerDisplay() throws SQLException{
        studService.serviceDisplay();
    }
}
