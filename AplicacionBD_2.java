/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionbd_2;



import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class AplicacionBD_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String dbClass = "com.mysql.cj.jdbc.Driver";
        
        try {
            insertarAlumno("Manuel", "Del Rio", 99);
            Class.forName(dbClass);
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos_hazerta",
                    "root", "");
            Statement stmt=c.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM t_alumnos");
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                int  edad=rs.getInt("edad");
                System.out.println(nombre+" "+apellido+" "+edad);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AplicacionBD_2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AplicacionBD_2.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    private static void insertarAlumno(String nombre, String apellido, int edad)
    {
        String dbClass = "com.mysql.cj.jdbc.Driver";
    try{
        Class.forName(dbClass);
            Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/basedatos_hazerta",
                    "root", "");
            Statement stmt=c.createStatement();
            String insert="INSERT INTO t_alumnos VALUES ('"+nombre+"', '"+apellido+"' ,"+edad+")";
                    //INSERT INTO t_alumnos VALUES('Pepe', 'Gil', 35)
            stmt.executeUpdate(insert);
    }
    catch(Exception e)
        {

        }
    }
    
}
