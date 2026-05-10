/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.ac.bg.fon.app0502.dto;

/**
 *
 * @author student2
 */
public class ZvanjeDto {
    private Long id;
    private String srpskiNaziv;
    private String engleskiNaziv;

    public ZvanjeDto(Long id, String srpskiNaziv, String engleskiNaziv) {
        this.id = id;
        this.srpskiNaziv = srpskiNaziv;
        this.engleskiNaziv = engleskiNaziv;
    }

    public ZvanjeDto(Long id) {
        this.id = id;
    }

    public ZvanjeDto() {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ZvanjeDto{");
        sb.append("id=").append(id);
        sb.append(", srpskiNaziv=").append(srpskiNaziv);
        sb.append(", engleskiNaziv=").append(engleskiNaziv);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
