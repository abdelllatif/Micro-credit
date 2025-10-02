package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Professionnel extends Person{

    private Float revenu;
    private String immatriculationFiscale;
    private String secteurActivite;
    private String activite;

    public Professionnel(String nom, String prenom, String email, LocalDate dateNaissance, String ville, String adresse, String telephone, Integer nombreEnfants, Boolean investissement, Boolean placement, String situationFamiliale, Integer score, Float revenu, String immatriculationFiscale, String secteurActivite, String activite) {
        super(nom, prenom, email, dateNaissance, ville, adresse, telephone, nombreEnfants, investissement, placement, situationFamiliale, score);
        this.revenu = revenu;
        this.immatriculationFiscale = immatriculationFiscale;
        this.secteurActivite = secteurActivite;
        this.activite = activite;
    }

    public Professionnel(Integer id, String nom, String prenom, String email, LocalDate dateNaissance, String ville, String adresse, String telephone, Integer nombreEnfants, Boolean investissement, Boolean placement, String situationFamiliale, Integer score, LocalDateTime dateCreation, Float revenu, String immatriculationFiscale, String secteurActivite, String activite) {
        super(id, nom, prenom, email, dateNaissance, ville, adresse, telephone, nombreEnfants, investissement, placement, situationFamiliale, score, dateCreation);
        this.revenu = revenu;
        this.immatriculationFiscale = immatriculationFiscale;
        this.secteurActivite = secteurActivite;
        this.activite = activite;
    }
    public Professionnel(){}


    public Float getRevenu() {
        return revenu;
    }

    public void setRevenu(Float revenu) {
        this.revenu = revenu;
    }

    public String getImmatriculationFiscale() {
        return immatriculationFiscale;
    }

    public void setImmatriculationFiscale(String immatriculationFiscale) {
        this.immatriculationFiscale = immatriculationFiscale;
    }

    public String getSecteurActivite() {
        return secteurActivite;
    }

    public void setSecteurActivite(String secteurActivite) {
        this.secteurActivite = secteurActivite;
    }

    public String getActivite() {
        return activite;
    }

    public void setActivite(String activite) {
        this.activite = activite;
    }
}
