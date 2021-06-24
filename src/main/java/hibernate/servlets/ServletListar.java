package hibernate.servlets;

import hibernate.dao.AlumnoDAO;
import hibernate.domain.Alumno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.ws.Action;


@WebServlet("/Listar")
public class ServletListar extends HttpServlet{
      
    //ATRIBUTO ELIMINAR ALUMNO
    private String remove;
    
    int eliminado=0;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
  
        
        
        remove=req.getParameter("borrar");
        System.out.println("ID PARA ELIMINAR" + remove);
        
        AlumnoDAO alu=new AlumnoDAO();
        if(remove==null || "".equalsIgnoreCase(remove)){
        
            
        
        List<Alumno> personas=alu.listar();
        
        for(Alumno lista: personas){
            System.out.println(lista);
        }
        req.setAttribute("personas", personas);
        req.getRequestDispatcher("/WEB-INF/listaralumno.jsp").forward(req , res);
        
            
        }else{
            
            alu.eliminar(new Alumno(Integer.parseInt(remove)));
            
                PrintWriter out = res.getWriter();
      
      
        
                
      out.print("<html>");
      out.print("<head>");
      out.print("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
      out.print("<title>");
      out.print("Alumno Agregado");
      out.print("</title>");
      out.print("<link href=\"recursos/estiloBoton.css\" rel=\"stylesheet\"/>");
      out.print("</head>");
      
      out.print("<body>");
      out.print("<div>");
      out.print("<div>");
      out.print("<a href='/FormularioServletConHibernate/Listar' id='boton'><h1>Listar Alumnos</h1></a>");
      out.print("</div>");
      out.print("</br></br></br>");
      out.print("<div>");
      out.print("<a href='/FormularioServletConHibernate/ServletAgregar' id='boton'><h1>Agregar Alumno</h1></a>");
      out.print("</div>");
      out.print("</br></br></br>");
      out.print("<div>");
      out.print("<a href='/FormularioServletConHibernate/Modificar' id='boton'><h1>Modificar Alumno</h1></a>");
      out.print("</div>");
      out.print("</div>");
      out.print("</body>");
      out.print("</html>");      
      out.close();
            
        }
              
            
      
        
    }
    
   
    

}

