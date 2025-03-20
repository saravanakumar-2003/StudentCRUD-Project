/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentcrud.entity;

/**
 *
 * @author ssara
 */
public class StudentEntity {
    private int id, rollNo;
    private String firstName,lastName,email;
    private char gender;
    
    public StudentEntity(){
        
    }
    
    public StudentEntity(String firstName, String lastName, int rollNo, char gender, String email){
        
        
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
}
