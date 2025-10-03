package Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.lang.Integer;

public class Echeance {

    public enum PaymentStatus{
        PAYEATEMPS,ENRETARD, PAYEENRETARD, IMPAYENONREGLE, IMPAYEREGLE
    }
    private Integer id;
    private Integer creditId;
    private LocalDate dateEcheance;
    private BigDecimal mensualite;
    private LocalDate dateDePaiement;
    private PaymentStatus statutPaiement;

    public Echeance(Integer id, Integer creditId, LocalDate dateEcheance, BigDecimal mensualite,
                    LocalDate dateDePaiement, PaymentStatus statutPaiement) {
        this.id = id;
        this.creditId = creditId;
        this.dateEcheance = dateEcheance;
        this.mensualite = mensualite;
        this.dateDePaiement = dateDePaiement;
        this.statutPaiement = statutPaiement;
    }

    public Echeance(Integer creditId, LocalDate dateEcheance, BigDecimal mensualite,
                    LocalDate dateDePaiement, PaymentStatus statutPaiement) {
        this.creditId = creditId;
        this.dateEcheance = dateEcheance;
        this.mensualite = mensualite;
        this.dateDePaiement = dateDePaiement;
        this.statutPaiement = statutPaiement;
    }


    public Echeance() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreditId() {
        return creditId;
    }

    public void setCreditId(Integer creditId) {
        this.creditId = creditId;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public BigDecimal getMensualite() {
        return mensualite;
    }

    public void setMensualite(BigDecimal mensualite) {
        this.mensualite = mensualite;
    }

    public LocalDate getDateDePaiement() {
        return dateDePaiement;
    }

    public void setDateDePaiement(LocalDate dateDePaiement) {
        this.dateDePaiement = dateDePaiement;
    }

    public PaymentStatus getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(PaymentStatus statutPaiement) {
        this.statutPaiement = statutPaiement;
    }


}