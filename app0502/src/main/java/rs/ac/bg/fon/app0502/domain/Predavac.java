/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mihajlo
 */
@Entity
@Table(name = "predavac")
@NamedQueries({
    @NamedQuery(name = "Predavac.findAll", query = "SELECT p FROM Predavac p"),
    @NamedQuery(name = "Predavac.findById", query = "SELECT p FROM Predavac p WHERE p.id = :id"),
    @NamedQuery(name = "Predavac.findByIme", query = "SELECT p FROM Predavac p WHERE p.ime = :ime"),
    @NamedQuery(name = "Predavac.findByPrezime", query = "SELECT p FROM Predavac p WHERE p.prezime = :prezime"),
    @NamedQuery(name = "Predavac.findByDatumRodjenja", query = "SELECT p FROM Predavac p WHERE p.datumRodjenja = :datumRodjenja")})
public class Predavac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "ime")
    private String ime;
    @Basic(optional = false)
    @Column(name = "prezime")
    private String prezime;
    @Basic(optional = false)
    @Column(name = "datum_rodjenja")
    @Temporal(TemporalType.DATE)
    private Date datumRodjenja;
    @JoinColumn(name = "katedra_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Katedra katedra;
    @JoinColumn(name = "zvanje_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Zvanje zvanje;

    public Predavac() {
    }

    public Predavac(String ime, String prezime, Date datumRodjenja, Katedra katedra, Zvanje zvanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.katedra = katedra;
        this.zvanje = zvanje;
    }
    
    public Predavac(Long id, String ime, String prezime, Date datumRodjenja, Katedra katedra, Zvanje zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.katedra = katedra;
        this.zvanje = zvanje;
    }

    public Predavac(Long id) {
        this.id = id;
    }

    public Predavac(Long id, String ime, String prezime, Date datumRodjenja) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public Katedra getKatedra() {
        return katedra;
    }

    public void setKatedra(Katedra katedra) {
        this.katedra = katedra;
    }

    public Zvanje getZvanje() {
        return zvanje;
    }

    public void setZvanjeId(Zvanje zvanje) {
        this.zvanje = zvanje;
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
        if (!(object instanceof Predavac)) {
            return false;
        }
        Predavac other = (Predavac) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.app0502.domain.Predavac[ id=" + id + " ]";
    }
    
}
