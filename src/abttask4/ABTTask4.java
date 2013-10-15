/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abttask4;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

/**
 *
 * @author kirk
 */
public class ABTTask4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  

        Integer swValue = 0;
        Scanner menuint = new Scanner(System.in);

        do {
            // Display main menu graphics
            System.out.println("===============================");
            System.out.println("|   MAIN MENU                 |");
            System.out.println("===============================");
            System.out.println("| Options:                    |");
            System.out.println("|      1. Add Record          |");
            System.out.println("|      2. Delete Record       |");
            System.out.println("|      3. Query student by ID |");
            System.out.println("|      4. Calc Tuition        |");
            System.out.println("|      5. Exit                |");
            System.out.println("===============================");
            System.out.print(" Select option: ");

            try {
                swValue = menuint.nextInt();
                Integer.valueOf(swValue).intValue();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Not an integer");
            }


            // Switch construct
            switch (swValue) {
                case 5:
                    System.exit(0);
                case 1:      // add student record
                    addStudent();
                    break;
                case 2:      // delete student record by id
                    deleteStudent();
                    break;
                case 3:
                    queryStudent();//show media by id
                    break;
                case 4:
                    calcTuition();   // calculate tuition by id
                    break;

                default:
                    break;

            }
        } while (swValue != 5);  // while loop  
    }
    
    public static void addStudent(){
        
        Scanner studentInfo = new Scanner(System.in);
        String firstName;
        String lastName;
        Integer studentID;
        String mentor;
        Double gpa;
        Integer resInt;
        
        System.out.print("Student ID: ");
        studentID = studentInfo.nextInt(); // get student ID from user
        System.out.print("First Name: ");
        firstName = studentInfo.next(); // get first name from user
        System.out.print("Last Name: ");
        lastName = studentInfo.next(); // get last name from user
        System.out.print("Mentor: ");
        mentor = studentInfo.next(); //get mentor from user
        System.out.print("GPA: ");
        gpa = studentInfo.nextDouble(); //get GPA from user
        System.out.print("Resident? (1) Yes (2) No: ");
        resInt = studentInfo.nextInt(); //get resident status
        
        Scanner studentType = new Scanner(System.in);
        Integer swValue = 0;
        
        // Ask what the student type is
        System.out.println("+++++++++++++++++++");
        System.out.println("+  Student Type   +");
        System.out.println("+++++++++++++++++++");
        System.out.println("+ 1. Undergrad    +");
        System.out.println("+ 2. Graduate     +");
        System.out.println("+ 3. Parttime     +");
        System.out.println("+++++++++++++++++++");
        System.out.print(" Select option: ");
        
        try {
            
            swValue = studentType.nextInt();
            Integer.valueOf(swValue).intValue();
            
        } catch (NumberFormatException e) {
            
            System.out.println("Invalid option. Please enter integer: " + e);
            
        }
        switch (swValue) {
            case 1:
                addUndergrad();
            case 2:
                addGraduate();
            case 3:
                addParttime();
        }
        Parttime me = new Parttime();
        me.setFirstName("Mister");
        me.setLastName("Canoe");
        me.setGPA(3.8);
        me.setMentor("Cranberry");
        me.setStatus("nonresident");
        me.setStudentID(1);
        me.setCompany("progstuff");
        String meString = me.toString();
        System.out.println(meString);
        try {
            System.out.println(me.add());
        } catch (SQLException ex) {
            Logger.getLogger(ABTTask4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ABTTask4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABTTask4.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            System.out.println(me.query());
        } catch (SQLException ex) {
            Logger.getLogger(ABTTask4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ABTTask4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ABTTask4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void addUndergrad(){
        
    }
    
    public static void addGraduate(){
        
    }
    
    public static void addParttime(){
        
    }
    
    public static void deleteStudent(){
    
    }
    
    public static void queryStudent(){
        
    }
    
    public static void calcTuition(){
        
    }
}
