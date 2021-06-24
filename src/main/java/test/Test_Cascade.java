package test;

import hibernate.dao.AlumnoDAO;
import hibernate.domain.*;

public class Test_Cascade {

    public static void main(String[] args) {
        
        Domicilio dom=new Domicilio();
        dom.setCalle("PRUEBA");
        dom.setNoCalle("PRUEBA");
        dom.setPais("PRUEBA");
        
        Contacto con=new Contacto();
        con.setEmail("PRUEBA");
        con.setTelefono("PRUEBA");
        
        Alumno alu=new Alumno();
        alu.setNombre("PRUEBA");
        alu.setApellido("PRUEBA");
        alu.setDomicilio(dom);
        alu.setContacto(con);
        
        AlumnoDAO alum=new AlumnoDAO();
        alum.agregar(alu);
        
        
    }
    
}
