/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcrud.service;

import java.sql.SQLException;
import studentcrud.DAO.StudentDAO;
import studentcrud.entity.StudentEntity;

/**
 *
 * @author ssara
 */
public class StudentService {
    
    StudentDAO studDAO;

    public StudentService() throws SQLException, ClassNotFoundException {
        this.studDAO = new StudentDAO();
    }
    
    public void serviceInsert(StudentEntity student) throws SQLException{
        studDAO.daoInsert(student);
    }
    
    public void serviceDelete(int rollNo) throws SQLException{
        studDAO.daoDelete(rollNo);
    }
    
    public void serviceUpdate(int rollNo, String email) throws SQLException{
        studDAO.daoUpdate(rollNo, email);
    }
    
    public StudentEntity serviceSearch(int rollNo) throws SQLException{
        return studDAO.daoSearch(rollNo);
    }
    
    public void serviceDisplay() throws SQLException{
        studDAO.daoDisplay();
    }
}
