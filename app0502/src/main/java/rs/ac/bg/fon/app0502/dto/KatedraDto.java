/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.dto;

/**
 *
 * @author mihajlo
 */
public class KatedraDto {
     private Long id;
    private String naziv;
    private String skraceniNaziv;

    public KatedraDto() {
    }

    public KatedraDto(Long id) {
        this.id = id;
    }
    

    public KatedraDto(Long id, String naziv, String skraceniNaziv) {
        this.id = id;
        this.naziv = naziv;
        this.skraceniNaziv = skraceniNaziv;
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

    public String getSkraceniNaziv() {
        return skraceniNaziv;
    }

    public void setSkraceniNaziv(String skraceniNaziv) {
        this.skraceniNaziv = skraceniNaziv;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KatedraDto{");
        sb.append("id=").append(id);
        sb.append(", naziv=").append(naziv);
        sb.append(", skraceniNaziv=").append(skraceniNaziv);
        sb.append('}');
        return sb.toString();
    }
    
    
}
