
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Animal;

public class AnimalDao {
    Conexion conn;
    
    //Constructor
    public AnimalDao(Conexion conn){
        this.conn = conn;
    }
   /*----------------------Insertar--------------------------------*/
    public boolean insert(Animal an){
        String sql = "insert into animal values(?,?,?,?,?)";
        try{
            PreparedStatement ps = conn.conectar().prepareCall(sql);
            ps.setInt(1, an.getId());
            ps.setString(2, an.getNombre());
            ps.setString(3, an.getTipo());
            ps.setDate(4, an.getFechaRegistro());
            ps.setFloat(5, an.getPeso());
            ps.executeUpdate();
            return true;
        }catch(Exception e){
            return false;
        }
    
    }
   /*----------------------Listar---------------------------------------*/ 
    public List<Animal> selectAll(){
        String sql = "select * from animal";
        try{
              PreparedStatement ps = conn.conectar().prepareCall(sql);
              ResultSet rs = ps.executeQuery();
              List<Animal> lista = new LinkedList<>();
              Animal an;
              while(rs.next()){
              an = new Animal(rs.getInt("id"));
              an.setNombre(rs.getString("nombre"));
              an.setTipo(rs.getString("tipo"));
              an.setFechaRegistro(rs.getDate("fecha_registro"));
              an.setPeso(rs.getFloat("peso"));
              lista.add(an);
              }
              
            return lista;
        }catch(Exception e){
            return null;
        }
    
    }
}
