/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.domain;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author student2
 */
@Entity
@Table(name = "investitor")
@NamedQueries({
    @NamedQuery(name = "Investitor.findAll", query = "SELECT i FROM Investitor i"),
    @NamedQuery(name = "Investitor.findById", query = "SELECT i FROM Investitor i WHERE i.id = :id"),
    @NamedQuery(name = "Investitor.findByNaziv", query = "SELECT i FROM Investitor i WHERE i.naziv = :naziv"),
    @NamedQuery(name = "Investitor.findByPib", query = "SELECT i FROM Investitor i WHERE i.pib = :pib"),
    @NamedQuery(name = "Investitor.findByMaticniBroj", query = "SELECT i FROM Investitor i WHERE i.maticniBroj = :maticniBroj")})
public class Investitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "pib")
    private String pib;
    @Basic(optional = false)
    @Column(name = "maticni_broj")
    private String maticniBroj;
    @JoinColumn(name = "srediste", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mesto srediste;

    public Investitor() {
    }

    public Investitor(Long id) {
        this.id = id;
    }

    public Investitor(Long id, String naziv, String pib, String maticniBroj) {
        this.id = id;
        this.naziv = naziv;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
    }

    public Investitor(Long id, String naziv, String pib, String maticniBroj, Mesto srediste) {
        this.id = id;
        this.naziv = naziv;
        this.pib = pib;
        this.maticniBroj = maticniBroj;
        this.srediste = srediste;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }


    public Mesto getSrediste() {
        return srediste;
    }

    public void setSrediste(Mesto srediste) {
        this.srediste = srediste;
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
        if (!(object instanceof Investitor)) {
            return false;
        }
        Investitor other = (Investitor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.njtioc1.domain.Investitor[ id=" + id + " ]";
    }
    
}
