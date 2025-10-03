package Repository;

import Config.DbConnection;
import Models.Incident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IncidentRepository {
    private final Connection connection;

    public IncidentRepository() {
        this.connection = new DbConnection().getConnection();
    }

    // Method to insert a new Incident
    public boolean ajout(Incident incident) {
        String sql = "INSERT INTO incidents (dateIncident, echeance_id, score, typeIncident) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(incident.getDateIncident()));
            ps.setInt(2, incident.getEcheanceId());
            ps.setInt(3, incident.getScore());
            ps.setString(4, incident.getTypeIncident().name());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Method to find an Incident by its ID
    public Incident findById(int id) {
        String sql = "SELECT * FROM incidents WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Incident incident = new Incident();
                incident.setId(rs.getInt("id"));
                incident.setDateIncident(rs.getDate("dateIncident").toLocalDate());
                incident.setEcheanceId(rs.getInt("echeance_id"));
                incident.setScore(rs.getInt("score"));
                incident.setTypeIncident(
                        Incident.IncidentType.valueOf(rs.getString("typeIncident"))
                );
                return incident;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // not found
    }
}
