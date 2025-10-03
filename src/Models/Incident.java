package Models;

import java.time.LocalDate;
import java.lang.Integer;

public class Incident {

    public enum IncidentType{
        INCIDENT_DE_CREDIT, INCIDENT_DE_DEBITEMENT
    }
    private Integer id;
    private LocalDate dateIncident;
    private Integer echeanceId;
    private Integer score;
    private IncidentType typeIncident;
    private String note;

    public Incident(Integer id, LocalDate dateIncident, Integer echeanceId, Integer scoreImpact,
                    IncidentType typeIncident, String note) {
        this.id = id;
        this.dateIncident = dateIncident;
        this.echeanceId = echeanceId;
        this.score = scoreImpact;
        this.typeIncident = typeIncident;
        this.note = note;
    }

    public Incident(LocalDate dateIncident, Integer echeanceId, Integer score,
                    IncidentType typeIncident, String note) {
        this.dateIncident = dateIncident;
        this.echeanceId = echeanceId;
        this.score = score;
        this.typeIncident = typeIncident;
        this.note = note;
    }
    public Incident() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDateIncident() {
        return dateIncident;
    }

    public void setDateIncident(LocalDate dateIncident) {
        this.dateIncident = dateIncident;
    }

    public Integer getEcheanceId() {
        return echeanceId;
    }

    public void setEcheanceId(Integer echeanceId) {
        this.echeanceId = echeanceId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public IncidentType getTypeIncident() {
        return typeIncident;
    }

    public void setTypeIncident(IncidentType typeIncident) {
        this.typeIncident = typeIncident;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
