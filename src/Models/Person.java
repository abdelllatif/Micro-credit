package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person {
    protected  Integer id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected LocalDate dateNaissance;
    protected String ville;
    protected String adresse;
    protected String telephone;
    protected Integer nombreEnfants;
    protected Boolean investissement;
    protected Boolean placement;
    protected String situationFamiliale;
    protected Double score;
    protected LocalDateTime dateCreation;

    public Person(String nom, String prenom, String email, LocalDate dateNaissance, String ville, String adresse, String telephone, Integer nombreEnfants, Boolean investissement, Boolean placement, String situationFamiliale, Double score) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.adresse = adresse;
        this.telephone = telephone;
        this.nombreEnfants = nombreEnfants;
        this.investissement = investissement;
        this.placement = placement;
        this.situationFamiliale = situationFamiliale;
        this.score = score;
    }

    public Person(Integer id, String nom, String prenom, String email, LocalDate dateNaissance, String ville, String adresse, String telephone, Integer nombreEnfants, Boolean investissement, Boolean placement, String situationFamiliale, Double score, LocalDateTime dateCreation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.ville = ville;
        this.adresse = adresse;
        this.telephone = telephone;
        this.nombreEnfants = nombreEnfants;
        this.investissement = investissement;
        this.placement = placement;
        this.situationFamiliale = situationFamiliale;
        this.score = score;
        this.dateCreation = dateCreation;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(Integer nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public Boolean getInvestissement() {
        return investissement;
    }

    public void setInvestissement(Boolean investissement) {
        this.investissement = investissement;
    }

    public Boolean getPlacement() {
        return placement;
    }

    public void setPlacement(Boolean placement) {
        this.placement = placement;
    }

    public String getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(String situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}
