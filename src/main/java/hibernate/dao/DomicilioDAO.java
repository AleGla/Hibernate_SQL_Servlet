package hibernate.dao;

import hibernate.domain.Domicilio;
import java.util.List;
import javax.persistence.*;

public class DomicilioDAO {

EntityManagerFactory emf;

EntityManager em;

public DomicilioDAO(){
    emf=Persistence.createEntityManagerFactory("HibernateDB");
    em=emf.createEntityManager();
}


public List<Domicilio> listar(){
    String hql="SELECT p FROM Domicilio p";
    Query query=em.createQuery(hql);
    List<Domicilio> lista=query.getResultList();
    
    return lista;
}

public void agregar(Domicilio domicilio){
    try{
        em.getTransaction().begin();
        em.persist(domicilio);
        em.getTransaction().commit();
        System.out.println("Se ha Agregado un Registro Nuevo");
    }catch(Exception ex){
        em.getTransaction().rollback();
        ex.printStackTrace(System.out);
    }
}

public void modificar(Domicilio domicilio){
    try{
        em.getTransaction().begin();
        em.merge(domicilio);
        em.getTransaction().commit();
        System.out.println("Se ha modoficado un registro");
    }catch(Exception ex){
        em.getTransaction().rollback();
        ex.printStackTrace(System.out);
    }
}

public void eliminar(Domicilio domicilio){
    try{
        em.getTransaction().begin();
        em.remove(em.merge(em.find(Domicilio.class, domicilio.getIdDomicilio())));
        em.getTransaction().commit();
        System.out.println("El registro se ha eliminado");
    }catch(Exception ex){
        em.getTransaction().rollback();
        ex.printStackTrace(System.out);
    }
}



    
}
