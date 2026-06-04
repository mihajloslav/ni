/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.dto;

/**
 *
 * @author student2
 */
public class InvestitorDto {
    private Long id;
    private String naziv;
    private String pib;
    private String maticniBroj;
    private MestoDto srediste;

    public InvestitorDto(Long id, String naziv, String pib, String maticniBroj, MestoDto srediste) {
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

    public MestoDto getSrediste() {
        return srediste;
    }

    public void setSrediste(MestoDto srediste) {
        this.srediste = srediste;
    }

    @Override
    public String toString() {
        return "InvestitorDto{" + "id=" + id + ", naziv=" + naziv + ", pib=" + pib + ", maticniBroj=" + maticniBroj + ", srediste=" + srediste + '}';
    }
    
    
}
