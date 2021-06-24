package hibernate.servlets;

import hibernate.dao.AlumnoDAO;
import hibernate.domain.Alumno;
import hibernate.domain.Contacto;
import hibernate.domain.Domicilio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletAgregar")
public class ServletAgregar extends HttpServlet{
    
    //ATRIBUTOS CONTACTO
    private String email, telefono;
    
    //ATRIBUTOS DOMICILIO
    private String calle, noCalle, pais;
    
    //ATRIBUTOS ALUMNO
    private String nombre, apellido;
    
    //CONTACTO
    private Contacto con=new Contacto();
    
    //DOMICILIO
    private Domicilio dom=new Domicilio();
    
    //ALUMNO
    private Alumno alu=new Alumno();
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
       
        
        
        email=req.getParameter("email");
        telefono=req.getParameter("telefono");
        
        calle=req.getParameter("calle");
        noCalle=req.getParameter("noCalle");
        pais=req.getParameter("pais");
        
        nombre=req.getParameter("nombre");
        apellido=req.getParameter("apellido");
        
       dom.setIdDomicilio(0);
       dom.setCalle(calle);
       dom.setNoCalle(noCalle);
       dom.setPais(pais);
       
       con.setIdContacto(0);
       con.setEmail(email);
       con.setTelefono(telefono);
       
       alu.setIdAlumno(0);
       alu.setNombre(nombre);
       alu.setApellido(apellido);
       alu.setContacto(con);
       alu.setDomicilio(dom);
        
        if(isEmpty() || isEmpty2()){
            req.getRequestDispatcher("/WEB-INF/agregaralumno.jsp").forward(req, res);
                       
        }else{
            System.out.println(alu);
            AlumnoDAO alum=new AlumnoDAO();   
            alum.agregar(alu);
            
      PrintWriter out = res.getWriter();
      
      out.print("<html>");
      out.print("<head>");
      out.print("<title>");
      out.print("Alumno Agregado");
      out.print("</title>");
      out.print("<link href='recursos/estiloDatos.css' rel='stylesheet'/>");
      out.print("</head>");
      
      out.print("<body>");
      out.print("<h1>");
      out.print("Datos del Alumno Agregado");
      out.print("</h1>");
      
      out.print("<table width='200' id='table'>");
      
      out.print("<tr>");
      out.print("<td id='columna'>Nombre: </td>");
      out.print("<td id='atributo'>" + this.nombre + "</td>");
      out.print("</tr>");
      
      out.print("<tr>");
      out.print("<td id='columna'>Apellido: </td>");
      out.print("<td id='atributo'>" + this.apellido + "</td>");
      out.print("</tr>");
     
      out.print("<tr>");
      out.print("<td id='columna'>Calle: </td>");
      out.print("<td id='atributo'>" + this.calle + "</td>");
      out.print("</tr>");
     
      out.print("<tr>");
      out.print("<td id='columna'>NoCalle: </td>");
      out.print("<td id='atributo'>" + this.noCalle + "</td>");
      out.print("</tr>");
     
      out.print("<tr>");
      out.print("<td id='columna'>Pais: </td>");
      out.print("<td id='atributo'>" + this.pais + "</td>");
      out.print("</tr>");
     
      out.print("<tr>");
      out.print("<td id='columna'>Email: </td>");
      out.print("<td id='atributo'>" + this.email + "</td>");
      out.print("</tr>");
     
      out.print("<tr>");
      out.print("<td id='columna'>Telefono: </td>");
      out.print("<td id='atributo'>" + this.telefono + "</td>");
      out.print("</tr>");
     
      out.print("</table>");      
      
      out.print("<div>");
      out.print("<a href='/FormularioServletConHibernate/Listar'id='boton'>Ir a Lista de Alumnos</a>");
      out.print("<a href='/FormularioServletConHibernate/ServletAgregar' id='boton'>Ir a Agregar Nuevo Alumno</a>");
      out.print("<a href='/FormularioServletConHibernate/Modificar' id='boton'>Ir a Modificar un Alumno</a>");
      out.print("</div>");
      
      out.print("</body>");
      out.print("</html>");
      out.close();
      
        
    }
        
        
        
}
    
    
    
    private boolean isEmpty(){
        if(this.apellido==null || this.calle==null || this.con==null || this.dom==null || this.email==null 
                || this.noCalle==null || this.nombre==null || this.pais==null || this.telefono==null){
            return true;
        }else{
            return false;
        }            
    }
    
    private boolean isEmpty2(){
        if("".equalsIgnoreCase(this.nombre) || "".equalsIgnoreCase(this.apellido) || "".equalsIgnoreCase(this.calle) || 
            "".equalsIgnoreCase(this.noCalle) || "".equalsIgnoreCase(this.pais) || "".equalsIgnoreCase(this.email) || "".equalsIgnoreCase(this.telefono)){
            return true;
        }else{
            return false;
    }
    }
}
