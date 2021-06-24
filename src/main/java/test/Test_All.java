package test;

import hibernate.dao.AlumnoDAO;
import hibernate.dao.ContactoDAO;
import hibernate.dao.DomicilioDAO;

public class Test_All {

    public static void main(String[] args) {
        
        DomicilioDAO dom=new DomicilioDAO();
        
        System.out.println("Domicilio:");
        dom.listar();
        
        ContactoDAO con=new ContactoDAO();
        System.out.println("Contacto:");
        con.listar();

        AlumnoDAO alu=new AlumnoDAO();
        System.out.println("Alumno:");
        alu.listar();
    }
    
}
