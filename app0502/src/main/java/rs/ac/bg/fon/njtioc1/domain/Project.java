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
import java.time.LocalDate;


/**
 *
 * @author student2
 */
@Entity
@Table(name = "project")
@NamedQueries({
    @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p"),
    @NamedQuery(name = "Project.findById", query = "SELECT p FROM Project p WHERE p.id = :id"),
    @NamedQuery(name = "Project.findByNaziv", query = "SELECT p FROM Project p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Project.findByDatumPocetka", query = "SELECT p FROM Project p WHERE p.datumPocetka = :datumPocetka"),
    @NamedQuery(name = "Project.findByDatumZavrsetka", query = "SELECT p FROM Project p WHERE p.datumZavrsetka = :datumZavrsetka")})
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "datum_pocetka")
    private LocalDate datumPocetka;
    @Basic(optional = false)
    @Column(name = "datum_zavrsetka")
    private LocalDate datumZavrsetka;
    @JoinColumn(name = "mesto", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mesto mesto;
    @JoinColumn(name = "investitor", referencedColumnName = "id")
    @ManyToOne(optional = false) /*@ManyToOne(optional = false,
           cascade = {CascadeType.PERSIST, CascadeType.MERGE})*/
    private Investitor investitor;

    public Project() {
    }

    public Project(Long id) {
        this.id = id;
    }

    public Project(Long id, String naziv, LocalDate datumPocetka, LocalDate datumZavrsetka, Mesto mesto, Investitor investitor) {
        this.id = id;
        this.naziv = naziv;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.mesto = mesto;
        this.investitor = investitor;
    }
    
    public Project(Long id, String naziv, LocalDate datumPocetka, LocalDate datumZavrsetka) {
        this.id = id;
        this.naziv = naziv;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
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

    public LocalDate getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(LocalDate datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public LocalDate getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(LocalDate datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
    }

    public Investitor getInvestitor() {
        return investitor;
    }

    public void setInvestitor(Investitor investitor) {
        this.investitor = investitor;
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
        if (!(object instanceof Project)) {
            return false;
        }
        Project other = (Project) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rs.ac.bg.fon.njtioc1.domain.Project[ id=" + id + " ]";
    }
    
}
