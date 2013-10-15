/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abttask4;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kirk
 */
public class ABTTask4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ask what the user would like to do
        System.out.println("What would you like to do? \nAdd record, Query, " +
                "Delete record, Calculate tuition: ");
        
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
}
