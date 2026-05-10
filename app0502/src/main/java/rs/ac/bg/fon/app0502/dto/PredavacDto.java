/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.dto;

import java.time.LocalDate;

/**
 *
 * @author student2
 */
public class PredavacDto {
    private Long id;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private KatedraDto katedra;
    private ZvanjeDto zvanje;

    public PredavacDto() {
        
    }

    public PredavacDto(String ime, String prezime, LocalDate datumRodjenja, KatedraDto katedra, ZvanjeDto zvanje) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.katedra = katedra;
        this.zvanje = zvanje;
    }
    
    public PredavacDto(Long id, String ime, String prezime, LocalDate datumRodjenja, KatedraDto katedra, ZvanjeDto zvanje) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodjenja = datumRodjenja;
        this.katedra = katedra;
        this.zvanje = zvanje;
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

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public KatedraDto getKatedra() {
        return katedra;
    }

    public void setKatedra(KatedraDto katedra) {
        this.katedra = katedra;
    }

    public ZvanjeDto getZvanje() {
        return zvanje;
    }

    public void setZvanje(ZvanjeDto zvanje) {
        this.zvanje = zvanje;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PredavacDto{");
        sb.append("id=").append(id);
        sb.append(", ime=").append(ime);
        sb.append(", prezime=").append(prezime);
        sb.append(", datumRodjenja=").append(datumRodjenja);
        sb.append(", katedra=").append(katedra);
        sb.append(", zvanje=").append(zvanje);
        sb.append('}');
        return sb.toString();
    }
    

}
