package Models;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class Credit {
    enum CreditType{
        CONSOMMATION , IMMOBILIER, AUTOMOBILE, EQUIPMENT
    }
    enum DecisionType{
        ACCORDIMMEDIAT, ETUDEMANUELLE, REFUS_AUTOMATIQUE
    }
    private UUID id;
    private UUID clientId;
    private LocalDate dateDeCredit;
    private BigDecimal montantDemande;
    private BigDecimal montantOctroye;
    private double tauxInteret;
    private int dureeEnMois;
    private CreditType typeCredit;
    private DecisionType decision;
    private Instant createdAt;
    private String approverId;

    public Credit(UUID id, UUID clientId, LocalDate dateDeCredit, BigDecimal montantDemande,
                  BigDecimal montantOctroye, double tauxInteret, int dureeEnMois,
                  CreditType typeCredit, DecisionType decision, Instant createdAt, String approverId) {
        this.id = id;
        this.clientId = clientId;
        this.dateDeCredit = dateDeCredit;
        this.montantDemande = montantDemande;
        this.montantOctroye = montantOctroye;
        this.tauxInteret = tauxInteret;
        this.dureeEnMois = dureeEnMois;
        this.typeCredit = typeCredit;
        this.decision = decision;
        this.createdAt = createdAt;
        this.approverId = approverId;
    }

    public Credit(UUID clientId, LocalDate dateDeCredit, BigDecimal montantDemande,
                  BigDecimal montantOctroye, double tauxInteret, int dureeEnMois,
                  CreditType typeCredit, DecisionType decision, Instant createdAt, String approverId) {
        this.clientId = clientId;
        this.dateDeCredit = dateDeCredit;
        this.montantDemande = montantDemande;
        this.montantOctroye = montantOctroye;
        this.tauxInteret = tauxInteret;
        this.dureeEnMois = dureeEnMois;
        this.typeCredit = typeCredit;
        this.decision = decision;
        this.createdAt = createdAt;
        this.approverId = approverId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClientId() {
        return clientId;
    }

    public void setClientId(UUID clientId) {
        this.clientId = clientId;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getApproverId() {
        return approverId;
    }

    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }
}
