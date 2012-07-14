/*
 * Graduate subclass of the Student class
 */
package abttask4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kirk
 */
public class Graduate extends Student {
    private String thesisTitle; // thesis title
    private String thesisAdvisor; // thesis advisor
    
    /**
     * Constructor for graduate subclass of student class with attributes
     * validated and filled in
     * @param studentFirst the student's first name
     * @param studentLast the student's last name
     * @param studentIDNumber the student's ID number
     * @param studentGPA the student's GPA
     * @param resStatus residential status of student
     * @param studentMentor the student's mentor's name
     * @param theThesisTitle the thesis title
     * @param thesisAdvisorName the thesis advisor name
     */
    public Graduate(String studentFirst, String studentLast,
            int studentIDNumber, double studentGPA, String resStatus, 
            String studentMentor, String theThesisTitle,
            String thesisAdvisorName){
        super(studentFirst, studentLast, studentIDNumber, studentGPA, 
                resStatus, studentMentor);
        thesisTitle = theThesisTitle;
        thesisAdvisor = thesisAdvisorName;
    }
    
    /**
     * Constructor with for a student subclass with default blank attributes
     */
    public Graduate(){
        super();
        thesisTitle = "";
        thesisAdvisor = "";
    }
    
    /**
     * Setter for thesisTitle attribute
     * @param theThesisTitle the title of the thesis
     */
    public void setThesisTitle(String theThesisTitle){
        thesisTitle = theThesisTitle;
    }
    
    /**
     * Setter for thesisAdvisor attribute
     * @param thesisAdvisorName the name of the thesis advisor
     */
    public void setThesisAdvisor(String thesisAdvisorName){
        thesisAdvisor = thesisAdvisorName;
    }
    
    /**
     * Getter for thesisTitle
     * @return thesisTitle
     */
    public String getThesisTitle(){
        return thesisTitle;
    }
    
    /**
     * Getter for thesisAdvisor
     * @return thesisAdvisor
     */
    public String getThesisAdvisor(){
        return thesisAdvisor;
    }
    
    /**
     * Calculates student tuition based on credit hours
     * @param creditHours Number of credit hours the student is taking
     * @return Student Tuition
     */
    @Override public double calculateTuition(int creditHours){
        double tuition;
        if(super.getStatus().equals("resident")){
            tuition = creditHours * 300;
        }else{
            tuition = creditHours * 350;
        }
        return tuition;
    }
    
    @Override public String query()
            throws SQLException, IOException, ClassNotFoundException
    {
        String queryStudent = "SELECT * FROM student WHERE studentID = ?";
        String result;
        
        try {
            SimpleDataSource.init("database.properties");
            Connection conn = SimpleDataSource.getConnection();
            PreparedStatement st = conn.prepareStatement(queryStudent);
            st.setInt(1, super.getStudentID());
            st.execute();
            ResultSet rs = st.getResultSet();
            result = "";
            while (rs.next()) {
                result = rs.getString("studentID") 
                        + ", " + rs.getString("firstName")
                        + ", " + rs.getString("lastName")
                        + ", " + rs.getString("gpa")
                        + ", " + rs.getString("status")
                        + ", " + rs.getString("mentor")
                        + ", " + rs.getString("level")
                        + ", " + rs.getString("thesisTitle")
                        + ", " + rs.getString("thesisAdvisor")
                        + ", " + rs.getString("company") + "\n";
                super.setFirstName(rs.getString("firstName"));
                super.setLastName(rs.getString("lastName"));
                super.setGPA(Double.valueOf(rs.getString("gpa")));
                super.setStatus(rs.getString("status"));
                super.setMentor(rs.getString("mentor"));
                setThesisTitle(rs.getString("thesisTitle"));
                setThesisAdvisor(rs.getString("thesisAdvisor"));
            }
            conn.close();
        } catch (IOException ex) {
            result = ex.toString();
        } catch (SQLException ex) {
            result = ex.toString();
        }
        
        return result;
    }
    
    @Override public String add()
            throws SQLException, IOException, ClassNotFoundException
    {
        String insertStudent = "INSERT INTO student "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String result; // The value returned from the class
        
        try {
            SimpleDataSource.init("database.properties");
            Connection conn = SimpleDataSource.getConnection();
            PreparedStatement st = conn.prepareStatement(insertStudent);
            st.setInt(1, super.getStudentID());
            st.setString(2, super.getFirstName());
            st.setString(3, super.getLastName());
            st.setDouble(4, super.getGPA());
            st.setString(5, super.getStatus());
            st.setString(6, super.getMentor());
            st.setString(7, "");
            st.setString(8, thesisTitle);
            st.setString(9, thesisAdvisor);
            st.setString(10, "");
            st.execute();
            conn.close();
            result = "Student added successfully";
        } catch (IOException ex) {
            result = ex.toString();
        } catch (SQLException ex) {
            result = ex.toString();
        }
       
        return result;
    }
    
    @Override public String delete()
            throws SQLException, IOException, ClassNotFoundException
    {
        String queryStudent = "DELETE FROM student WHERE studentID = ?";
        String result;
        
        try {
            SimpleDataSource.init("database.properties");
            Connection conn = SimpleDataSource.getConnection();
            PreparedStatement st = conn.prepareStatement(queryStudent);
            st.setInt(1, super.getStudentID());
            result = "";
            if (st.execute()) result = "Student successfully deleted";
            conn.close();
        } catch (IOException ex) {
            result = "Student not deleted: " + ex.getMessage();
        } catch (SQLException ex) {
            result = "Student not deleted: " + ex.getMessage();
        }
        
        return result;
    }
    
    @Override public String update(){
        String result = "";
        return result;
    }
    
    @Override public String toString(){
        String student = super.toString() + " " + thesisTitle +
                " " + thesisAdvisor;
        return student;
    }
}
