
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    //variables que guardan datos de la base de datos
    static String bd="veterinaria";
    static String user="root";
    static String pass ="";
    static String url="jdbc:mysql://localhost:3306/"+ bd;
    
    Connection conn = null;
    
    /*------------------Conexion-------------------------------*/
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if(conn!=null){
                System.out.println("La conexión fue exitosa");
            }
        }catch(Exception e){
            System.out.println("Error de conexion" + e);
        }
    }
    
    
    public Connection conectar(){
        return conn;
    }
    
    public void desconectar()throws Exception{ 
        conn.close();
    }
}
