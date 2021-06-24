package hibernate.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Domicilio implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_domicilio")
    private int idDomicilio;
    
    private String calle;
    
    @Column(name="no_calle")
    private String noCalle;
    
    private String pais;

    public Domicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }
    
    public Domicilio(){
        
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(String noCalle) {
        this.noCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + noCalle + ", pais=" + pais + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.idDomicilio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        if (this.idDomicilio != other.idDomicilio) {
            return false;
        }
        return true;
    }
    
    
            
}
