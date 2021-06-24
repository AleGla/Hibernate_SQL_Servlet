package hibernate.servlets;

import hibernate.dao.AlumnoDAO;
import hibernate.domain.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Modificar")
public class ServletModificar extends HttpServlet {

    //Atributos Alumno
    private String nombre;
    private String apellido;
    private String idString;
    private int id;

    //Atributos Domicilio
    private String calle;
    private String noCalle;
    private String pais;

    //Atributos Contacto
    private String email;
    private String telefono;

    //Alumno
    private Alumno alu = new Alumno();

    //Domicilio
    private Domicilio dom = new Domicilio();

    //Contacto 
    private Contacto con = new Contacto();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        idString = req.getParameter("id");

        nombre = req.getParameter("nombre");
        apellido = req.getParameter("apellido");
        calle = req.getParameter("calle");
        noCalle = req.getParameter("noCalle");
        pais = req.getParameter("pais");
        email = req.getParameter("email");
        telefono = req.getParameter("telefono");

        if (isEmpty()) {
            req.getRequestDispatcher("/WEB-INF/modificaralumno.jsp").forward(req, res);
        } else {
            AlumnoDAO alum = new AlumnoDAO();

            //DATOS DEFAULT DE LA TABLA AL CARGAR
            Alumno datos = alum.datosAlumno(Integer.parseInt(this.idString));

            String nombreDefault = datos.getNombre();
            String apellidoDefault = datos.getApellido();

            String calleDefault = datos.getDomicilio().getCalle();
            String numeroCalleDefault = datos.getDomicilio().getNoCalle();
            String paisDefault = datos.getDomicilio().getPais();

            String emailDefault = datos.getContacto().getEmail();
            String telefonoDefault = datos.getContacto().getTelefono();
            //---------------------------------------------------------------------  

            dom.setIdDomicilio(Integer.parseInt(idString));
            con.setIdContacto(Integer.parseInt(idString));
            alu.setIdAlumno(Integer.parseInt(idString));

            if (this.calle.equalsIgnoreCase("")) {
                dom.setCalle(calleDefault);
            } else {
                dom.setCalle(this.calle);
            }

            if (this.noCalle.equalsIgnoreCase("")) {
                dom.setNoCalle(numeroCalleDefault);
            } else {
                dom.setNoCalle(this.noCalle);
            }

            if (this.pais.equalsIgnoreCase("")) {
                dom.setPais(paisDefault);
            } else {
                dom.setPais(pais);
            }

            if (this.email.equalsIgnoreCase("")) {
                con.setEmail(emailDefault);
            } else {
                con.setEmail(email);
            }

            if (this.telefono.equalsIgnoreCase("")) {
                con.setTelefono(telefonoDefault);
            } else {
                con.setTelefono(telefono);
            }

            if (this.nombre.equalsIgnoreCase("")) {
                alu.setNombre(nombreDefault);
            } else {
                alu.setNombre(nombre);
            }

            if (this.apellido.equalsIgnoreCase("")) {
                alu.setNombre(apellidoDefault);
            } else {
                alu.setApellido(apellido);
            }

            alu.setContacto(con);
            alu.setDomicilio(dom);
            System.out.println("ALUMNO: " + alu);
            alum.modificar(alu);

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
      out.print("Datos Modificados del Alumno");
      out.print("</h1>");
      
      out.print("<table width='200' id='table'>");
  
      out.print("<tr>");
      out.print("<td id='columna'>ID ALUMNO: </td>");
      out.print("<td id='atributo'>" + this.idString + "</td>");
      out.print("</tr>");
      
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

    private boolean isEmpty() {
        if (this.nombre == null && this.apellido == null && this.calle == null && this.noCalle == null && this.pais == null && this.email == null && this.telefono == null) {
            return true;
        } else {
            return false;
        }
    }
}
