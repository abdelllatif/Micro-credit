package Models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employe extends Person {

  public  enum ContractType{
        CDI_PUBLIC,
        CDI_PRIVEE_GRANDE_ENTREPRISE,
        CDI_PRIVEE_PME,
        CDD_INTERIM,
        PROFESSION_LIBERALE_STABLE,
        AUTO_ENTREPRENEUR
    }
  public   enum EmploymentSector {
        PUBLIC,
        GRANDE_ENTREPRISE,
        PME
    }
    private Integer anciennete;
    private Float salaire;
    private String post;
    private ContractType contractType;
    private EmploymentSector employmentSector;

    public Employe(String nom, String prenom, String email, LocalDate dateNaissance, String ville, String adresse, String telephone, Integer nombreEnfants, Boolean investissement, Boolean placement, SituationFamilial situationFamiliale, Integer score, Integer anciennete, Float salaire, String post, ContractType contractType, EmploymentSector employmentSector) {
        super(nom, prenom, email, dateNaissance, ville, adresse, telephone, nombreEnfants, investissement, placement, situationFamiliale, score);
        this.anciennete = anciennete;
        this.salaire = salaire;
        this.post = post;
        this.contractType = contractType;
        this.employmentSector = employmentSector;
    }


    public Employe(Integer id, String nom, String prenom, String email, LocalDate dateNaissance, String ville, String adresse, String telephone, Integer nombreEnfants, Boolean investissement, Boolean placement, SituationFamilial situationFamiliale, Integer score, LocalDateTime dateCreation, Integer anciennete, Float salaire, String post, ContractType contractType, EmploymentSector employmentSector) {
        super(id, nom, prenom, email, dateNaissance, ville, adresse, telephone, nombreEnfants, investissement, placement, situationFamiliale, score, dateCreation);
        this.anciennete = anciennete;
        this.salaire = salaire;
        this.post = post;
        this.contractType = contractType;
        this.employmentSector = employmentSector;
    }
    public Employe() {
    }

    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }

    public Float getSalaire() {
        return salaire;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public EmploymentSector getEmploymentSector() {
        return employmentSector;
    }

    public void setEmploymentSector(EmploymentSector employmentSector) {
        this.employmentSector = employmentSector;
    }
}
