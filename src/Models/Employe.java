package Models;

public class Employe extends Person {

    enum ContractType{
        CDI_PUBLIC,
        CDI_PRIVEE_GRANDE_ENTREPRISE,
        CDI_PRIVEE_PME,
        CDD_INTERIM,
        PROFESSION_LIBERALE_STABLE,
        AUTO_ENTREPRENEUR
    };
    enum EmploymentSector {
        PUBLIC,
        GRANDE_ENTREPRISE,
        PME
    }
    private Integer anciennete;
    private Integer salaire;
    private String post;
    private ContractType contractType;
    private EmploymentSector employmentSector;




    public Integer getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(Integer anciennete) {
        this.anciennete = anciennete;
    }

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
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
