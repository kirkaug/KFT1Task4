/*
 * Parttime subclass of the Student class
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
public class Parttime extends Student {
    private String company; // name of the sponsoring employer
    
    /**
     * Constructor for part time student subclass which validates and
     * accepts attributes filled in
     * @param studentFirst the student's first name
     * @param studentLast the student's last name
     * @param studentIDNumber the student's ID number
     * @param studentGPA the student's GPA
     * @param isResident residential status of the student
     * @param studentMentor the name of the student's mentor
     * @param studentCompany the name of the student's company
     */
    public Parttime(String studentFirst, String studentLast,
            int studentIDNumber, double studentGPA, String resStatus,
            String studentMentor, String studentCompany){
        super(studentFirst, studentLast, studentIDNumber, studentGPA,
                resStatus, studentMentor);
        company = studentCompany;
    }
    
    /**
     * Constructor for a part time student subclass with default blank attributes
     */
    public Parttime(){
        super();
        company = "";
    }
    
    /**
     * Sets the company attribute
     * @param companyName the company name
     */
    public void setCompany(String companyName){
        company = companyName;
    }
    
    /**
     * Getter for company attribute
     * @return company
     */
    public String getCompany(){
        return company;
    }
    
    /**
     * Calculates student tuition based on credit hours
     * @param creditHours Number of credit hours the student is taking
     * @return Student Tuition
     */
    @Override public double calculateTuition(int creditHours){
        double tuition;
        if(super.getStatus().equals("resident")){
            tuition = creditHours * 250;
        }else{
            tuition = creditHours * 450;
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
                setCompany(rs.getString("company"));
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
            throws IOException, SQLException, ClassNotFoundException
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
            st.setString(8, "");
            st.setString(9, "");
            st.setString(10, company);
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
        String student = super.toString() + " " + company;
        return student;
    }
    
}
