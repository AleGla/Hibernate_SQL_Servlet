package hibernate.dao;

import hibernate.domain.Alumno;
import java.util.List;
import javax.persistence.*;

public class AlumnoDAO {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public AlumnoDAO(){
        emf=Persistence.createEntityManagerFactory("HibernateDB");
        em=emf.createEntityManager();
    }
    
    public List<Alumno> listar(){
        String hql= "SELECT a FROM Alumno a";
        Query query=em.createQuery(hql);
        List<Alumno> list=query.getResultList();
        
        return list;
    }
    
    public void agregar(Alumno alumno){
        try{
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
            System.out.println("Se ha agregado un registro");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }finally{
            em.close();
        }
    }
    
    public void modificar(Alumno alumno){
        try{
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
            System.out.println("El registro se ha modificado");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }finally{
            em.close();
        }
    }
    
    public void eliminar(Alumno alumno){
        try{
            em.getTransaction().begin();
            em.remove(em.merge(em.find(Alumno.class, alumno.getIdAlumno())));
            em.getTransaction().commit();
            System.out.println("El registro se ha eliminado: " + alumno);
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }finally{
            em.close();
        }
    }
    
    public Alumno datosAlumno(int idAlumno){
        return em.find(Alumno.class, idAlumno);
    }

}
