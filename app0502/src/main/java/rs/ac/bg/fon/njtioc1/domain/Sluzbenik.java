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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;


/**
 *
 * @author student2
 */
@Entity
@Table(name = "sluzbenik")
@NamedQueries({
    @NamedQuery(name = "Sluzbenik.findAll", query = "SELECT s FROM Sluzbenik s"),
    @NamedQuery(name = "Sluzbenik.findById", query = "SELECT s FROM Sluzbenik s WHERE s.id = :id"),
    @NamedQuery(name = "Sluzbenik.findByEmail", query = "SELECT s FROM Sluzbenik s WHERE s.email = :email"),
    @NamedQuery(name = "Sluzbenik.findBySifra", query = "SELECT s FROM Sluzbenik s WHERE s.sifra = :sifra"),
    @NamedQuery(name = "Sluzbenik.findByIme", query = "SELECT s FROM Sluzbenik s WHERE s.ime = :ime"),
    @NamedQuery(name = "Sluzbenik.findByPrezime", query = "SELECT s FROM Sluzbenik s WHERE s.prezime = :prezime"),
    @NamedQuery(name = "Sluzbenik.findByDatumRodjenja", query = "SELECT s FROM Sluzbenik s WHERE s.datumRodjenja = :datumRodjenja")})
public class Sluzbenik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "sifra")
    private String sifra;
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

    public Sluzbenik() {
    }

    public Sluzbenik(Long id) {
        this.id = id;
    }

    public Sluzbenik(Long id, String email, String sifra, String ime, String prezime, Date datumRodjenja) {
        this.id = id;
        this.email = email;
        this.sifra = sifra;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sluzbenik)) {
            return false;
        }
        Sluzbenik other = (Sluzbenik) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.njtioc1.domain.Sluzbenik[ id=" + id + " ]";
    }
    
}
