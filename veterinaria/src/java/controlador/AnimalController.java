
package controlador;
import java.util.Date;
import conexion.Conexion;
import dao.AnimalDao;
import modelo.Animal;

import java.util.Scanner;

public class AnimalController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Conexion conn = new Conexion();
        AnimalDao ad = new AnimalDao(conn);
      
   /*--------------------Insertar----------------------------------*/
        Animal an = new Animal(0);
        System.out.println("Escriba el nombre del animal: ");
        an.setNombre(scan.next());
        
        System.out.println("Escriba el tipo de animal:");
        an.setTipo(scan.next());
        
        //Fecha de registro
        Date fecha = new Date();
        java.sql.Date sqlDate = new java.sql.Date(fecha.getTime());
        an.setFechaRegistro(sqlDate);
        
      
        System.out.println("Escriba el peso del animal: ");
        an.setPeso(scan.nextFloat());
        
        boolean respuesta = ad.insert(an);
        if(respuesta){
            System.out.println("\n----Registro guardado----");
        }else{
            System.out.println("\n----Registro no guardado----");
        }
  /*-------------------------Mostrar----------------------------------------*/      
        for(Animal an1: ad.selectAll()){
            an.getId();
            System.out.println("\n**************************");
            System.out.println("El id es: " + an1.getId());
            System.out.println("El nombre es: " + an1.getNombre());
            System.out.println("El tipo de animal es: " + an1.getTipo());
            System.out.println("La fecha de resgitro es: " + an1.getFechaRegistro());
            System.out.println("El peso es: " + an1.getPeso());
            System.out.println("\n**************************");
        }
        
    }
}
