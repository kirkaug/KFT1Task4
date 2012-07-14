/*
 * Student class
 */
package abttask4;

import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author kirk
 */
public abstract class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private double GPA;
    private String status;
    private String mentor;
    
    /**
     * Constructs student with student attributes validated and filled in
     * @param studentFirst the student's studentFirst name
     * @param studentLast the student's studentLast name
     * @param studentIDNumber the student's ID number
     * @param studentGPA the student's GPA
     * @param isResident is the student a resident or non-resident
     * @param studentMentor  the student's mentor name
     */
    public Student(String studentFirst, String studentLast, int studentIDNumber, 
            double studentGPA, String resStatus, String studentMentor) {
        
        // Check to make sure all passed values are not empty
        if(String.valueOf(studentFirst).isEmpty()){
            throw new IllegalArgumentException("ERROR: Enter first name");
        }
        if(String.valueOf(studentLast).isEmpty()) {
            throw new IllegalArgumentException("ERROR: Enter last name");
        }
        if(String.valueOf(studentIDNumber).isEmpty()) {
            throw new IllegalArgumentException("ERROR: Enter ID number");
        }
        if(String.valueOf(studentGPA).isEmpty()) {
            throw new IllegalArgumentException("ERROR: Enter GPA");
        }
        if(String.valueOf(studentMentor).isEmpty()) {
            throw new IllegalArgumentException("ERROR: Enter Mentor Name");
        }
        
        // Assign values to class variables
        firstName = studentFirst;
        lastName = studentLast;
        studentID = studentIDNumber;
        GPA = studentGPA;
        status = resStatus;
        mentor = studentMentor;
    }
    
    /**
     * Constructs a student with default empty attributes
     */
    public Student(){
        firstName = "";
        lastName = "";
        studentID = 0;
        GPA = 0.0;
        status = "non-resident";
        mentor = "";
    }
    
    /**
     * Getter for First Name attribute
     * @return First Name
     */
    public String getFirstName(){
        return firstName;
    }
    
    /**
     * Getter for Last Name attribute
     * @return Last Name
     */
    public String getLastName(){
        return lastName;
    }
    
    /**
     * Getter for Student ID number attribute
     * @return Student ID
     */
    public int getStudentID(){
        return studentID;
    }
    
    /**
     * Getter for GPA attribute
     * @return Grade Point Average
     */
    public double getGPA(){
        return GPA;
    }
    
    /**
     * Getter for Status attribute
     * @return Status
     */
    public String getStatus(){
        return status;
    }
    
    /**
     * Getter for Mentor attribute
     * @return Mentor Name
     */
    public String getMentor(){
        return mentor;
    }
    
    /**
     * Setter for first name
     * @param studentFirstName the students first name 
     */
    public void setFirstName(String studentFirstName){
        firstName = studentFirstName;
    }
    
    /**
     * Setter for last name
     * @param studentLastName the students last name 
     */
    public void setLastName(String studentLastName){
        lastName = studentLastName;
    }
    
    /**
     * Setter for Student ID
     * @param studentIDNumber the students ID number 
     */
    public void setStudentID(int studentIDNumber){
        studentID = studentIDNumber;
    }
    
    /**
     * Setter for GPA
     * @param studentGPA the students grade point average
     */
    public void setGPA(double studentGPA){
        GPA = studentGPA;
    }
    
    /**
     * Setter for status
     * @param resStatus the students status as a resident or non-resident
     */
    public void setStatus(String resStatus){
        status = resStatus;
    }
    
    /**
     * Setter for mentor
     * @param studentMentor the name of the students mentor
     */
    public void setMentor(String studentMentor){
        mentor = studentMentor;
    }
    
    /**
     * abstract method to update records in the database
     * @return result of the UPDATE statement
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public abstract String update() 
            throws SQLException, IOException, ClassNotFoundException;
    
    /**
     * abstract method to add records to the database
     * @return result of the INSERT statement
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public abstract String add() 
            throws SQLException, IOException, ClassNotFoundException;
    
    /**
     * abstract method to delete records from the database
     * @return result of the DELETE statement
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public abstract String delete() 
            throws SQLException, IOException, ClassNotFoundException;
    
    /**
     * abstract method to query the database
     * @return result of the SELECT statement
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public abstract String query() 
            throws SQLException, IOException, ClassNotFoundException;
    
    /**
     * abstract method to calculate the student tuition
     * @return Student tuition
     */
    public abstract double calculateTuition(int creditHours);
    
    /**
     * Convert the Student object to a human readable string
     * @return firstName, lastName, studentID, GPA, status, and mentor
     */
    @Override public String toString(){
        String student;
        student = firstName + " " + lastName + " " + studentID + " " + GPA 
                + " " + status + " " + mentor;
        return student;
    }
}
