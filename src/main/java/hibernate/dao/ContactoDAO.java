package hibernate.dao;

import hibernate.domain.Contacto;
import java.util.List;
import javax.persistence.*;


public class ContactoDAO {

    EntityManagerFactory emf;
    
    EntityManager em;
    
    public ContactoDAO(){
        emf=Persistence.createEntityManagerFactory("HibernateDB");
        em=emf.createEntityManager();
    }
    
    public List<Contacto> listar(){
        String hql = "SELECT p FROM Contacto p";
        Query query=em.createQuery(hql);
        List<Contacto> list=query.getResultList();
        
        return list;
    }
    
    public void agregar(Contacto contacto){
        try{
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
            System.out.println("Se ha agregado un registro");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public void modificar(Contacto contacto){
        try{
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
            System.out.println("Se ha modificado un registro");
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }
    
    public void eliminar(Contacto contacto){
        try{
            em.getTransaction().begin();
            em.remove(em.find(Contacto.class, contacto.getIdContacto()));
            em.getTransaction().commit();
            System.out.println("El registro se ha eliminado: " + contacto);
        }catch(Exception ex){
            em.getTransaction().rollback();
            ex.printStackTrace(System.out);
        }
    }

    
}
