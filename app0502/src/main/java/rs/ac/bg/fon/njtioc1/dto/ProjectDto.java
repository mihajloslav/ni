/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.njtioc1.dto;

import java.time.LocalDate;

/**
 *
 * @author student2
 */
public class ProjectDto {
     private Long id;
    private String naziv;
    private LocalDate datumPocetka;
    private LocalDate datumZavrsetka;
    private MestoDto mesto;
    private InvestitorDto investitor;

    public ProjectDto(Long id, String naziv, LocalDate datumPocetka, LocalDate datumZavrsetka, MestoDto mesto, InvestitorDto investitor) {
        this.id = id;
        this.naziv = naziv;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.mesto = mesto;
        this.investitor = investitor;
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

    public MestoDto getMesto() {
        return mesto;
    }

    public void setMesto(MestoDto mesto) {
        this.mesto = mesto;
    }

    public InvestitorDto getInvestitor() {
        return investitor;
    }

    public void setInvestitor(InvestitorDto investitor) {
        this.investitor = investitor;
    }

    @Override
    public String toString() {
        return "ProjectDto{" + "id=" + id + ", naziv=" + naziv + ", datumPocetka=" + datumPocetka + ", datumZavrsetka=" + datumZavrsetka + ", mesto=" + mesto + ", investitor=" + investitor + '}';
    }
    
    
}
