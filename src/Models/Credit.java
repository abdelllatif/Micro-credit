package Models;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.lang.Integer;

public class Credit {
   public enum CreditType{
        CONSOMMATION , IMMOBILIER, AUTOMOBILE, EQUIPMENT
    }
    public enum DecisionType{
        ACCORDIMMEDIAT, ETUDEMANUELLE, REFUS_AUTOMATIQUE
    }
    private Integer id;
    private Integer professionnelId;
    private Integer employeId;
    private LocalDate dateDeCredit;
    private BigDecimal montantDemande;
    private BigDecimal montantOctroye;
    private double tauxInteret;
    private int dureeEnMois;
    private CreditType typeCredit;
    private DecisionType decision;

    public Credit(Integer id, Integer professionnelId,Integer employeId, LocalDate dateDeCredit, BigDecimal montantDemande,
                  BigDecimal montantOctroye, double tauxInteret, int dureeEnMois,
                  CreditType typeCredit, DecisionType decision) {
        this.id = id;
        this.professionnelId = professionnelId;
        this.employeId = employeId;
        this.dateDeCredit = dateDeCredit;
        this.montantDemande = montantDemande;
        this.montantOctroye = montantOctroye;
        this.tauxInteret = tauxInteret;
        this.dureeEnMois = dureeEnMois;
        this.typeCredit = typeCredit;
        this.decision = decision;
    }

    public Credit(Integer professionnelId,Integer employeId, LocalDate dateDeCredit, BigDecimal montantDemande,
                  BigDecimal montantOctroye, double tauxInteret, int dureeEnMois,
                  CreditType typeCredit, DecisionType decision, String approverId) {
        this.professionnelId = professionnelId;
        this.employeId = employeId;
        this.dateDeCredit = dateDeCredit;
        this.montantDemande = montantDemande;
        this.montantOctroye = montantOctroye;
        this.tauxInteret = tauxInteret;
        this.dureeEnMois = dureeEnMois;
        this.typeCredit = typeCredit;
        this.decision = decision;
    }
    public Credit() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public LocalDate getDateDeCredit() {
        return dateDeCredit;
    }

    public void setDateDeCredit(LocalDate dateDeCredit) {
        this.dateDeCredit = dateDeCredit;
    }

    public BigDecimal getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(BigDecimal montantDemande) {
        this.montantDemande = montantDemande;
    }

    public BigDecimal getMontantOctroye() {
        return montantOctroye;
    }

    public void setMontantOctroye(BigDecimal montantOctroye) {
        this.montantOctroye = montantOctroye;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    public CreditType getTypeCredit() {
        return typeCredit;
    }

    public void setTypeCredit(CreditType typeCredit) {
        this.typeCredit = typeCredit;
    }

    public DecisionType getDecision() {
        return decision;
    }

    public void setDecision(DecisionType decision) {
        this.decision = decision;
    }


    public Integer getEmployeId() {
        return employeId;
    }

    public void setEmployeId(Integer employeId) {
        this.employeId = employeId;
    }

    public Integer getProfessionnelId() {
        return professionnelId;
    }

    public void setProfessionnelId(Integer professionnelId) {
        this.professionnelId = professionnelId;
    }
}
