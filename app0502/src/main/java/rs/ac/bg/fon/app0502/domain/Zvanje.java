/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.domain;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
/**
 *
 * @author student2
 */
@Entity
@Table(name = "zvanje")
@NamedQueries({
    @NamedQuery(name = "Zvanje.findAll", query = "SELECT z FROM Zvanje z"),
    @NamedQuery(name = "Zvanje.findById", query = "SELECT z FROM Zvanje z WHERE z.id = :id"),
    @NamedQuery(name = "Zvanje.findBySrpskiNaziv", query = "SELECT z FROM Zvanje z WHERE z.srpskiNaziv = :srpskiNaziv"),
    @NamedQuery(name = "Zvanje.findByEngleskiNaziv", query = "SELECT z FROM Zvanje z WHERE z.engleskiNaziv = :engleskiNaziv")})
public class Zvanje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "srpski_naziv")
    private String srpskiNaziv;
    @Basic(optional = false)
    @Column(name = "engleski_naziv")
    private String engleskiNaziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zvanje")
    private Collection<Predavac> predavacCollection;

    public Zvanje() {
    }
    

    public Zvanje(Long id) {
        this.id = id;
    }

    public Zvanje(Long id, String srpskiNaziv, String engleskiNaziv) {
        this.id = id;
        this.srpskiNaziv = srpskiNaziv;
        this.engleskiNaziv = engleskiNaziv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSrpskiNaziv() {
        return srpskiNaziv;
    }

    public void setSrpskiNaziv(String srpskiNaziv) {
        this.srpskiNaziv = srpskiNaziv;
    }

    public String getEngleskiNaziv() {
        return engleskiNaziv;
    }

    public void setEngleskiNaziv(String engleskiNaziv) {
        this.engleskiNaziv = engleskiNaziv;
    }

    public Collection<Predavac> getPredavacCollection() {
        return predavacCollection;
    }

    public void setPredavacCollection(Collection<Predavac> predavacCollection) {
        this.predavacCollection = predavacCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zvanje)) {
            return false;
        }
        Zvanje other = (Zvanje) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.app0502.domain.Zvanje[ id=" + id + " ]";
    }
    
}
