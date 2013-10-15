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
        // TODO code application logic here
        Undergraduate me = new Undergraduate();
        me.setFirstName("Eric");
        me.setLastName("Cartman");
        me.setGPA(1.8);
        me.setMentor("Buffalo");
        me.setStatus("non-resident");
        me.setStudentID(10794);
        me.setLevel("freshman");
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
