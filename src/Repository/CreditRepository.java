package Repository;

import Config.DbConnection;
import Models.Credit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditRepository {
    public final Connection conn;

    public CreditRepository() {
        this.conn = new DbConnection().getConnection();
        if (conn == null) {
            System.out.println(" Connection is null! Check your DbConnection.");
        } else {
            System.out.println(" Connection established successfully.");
        }
    }

    public ResultSet addCredit(Credit credit) throws SQLException {
        try {
            if (conn == null) throw new SQLException("Connection is null!");

            String query = "INSERT INTO credit " +
                    "(professionnel_id, employe_id, montant_demande, montant_octroye, taux_interet, duree_en_mois, type_credit, decision) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setObject(1, credit.getProfessionnelId() == 0 ? null : credit.getProfessionnelId());
            ps.setObject(2, credit.getEmployeId() == 0 ? null : credit.getEmployeId());
            ps.setBigDecimal(3, credit.getMontantDemande());
            ps.setBigDecimal(4, credit.getMontantOctroye());
            ps.setDouble(5, credit.getTauxInteret());
            ps.setInt(6, credit.getDureeEnMois());
            ps.setString(7, credit.getTypeCredit().name());
            ps.setString(8, credit.getDecision().name());

            int rows = ps.executeUpdate();
            if (rows == 0) {
                System.out.println("No rows inserted.");
            } else {
                System.out.println("Credit inserted successfully.");
            }

            return ps.getGeneratedKeys();

        } catch (SQLException e) {
            System.out.println(" SQLException in addCredit: " + e.getMessage());
            throw e;
        } catch (NullPointerException e) {
            System.out.println(" NullPointerException in addCredit: " + e.getMessage());
            throw e;
        }
    }

    public boolean updateCredit(Credit credit, int id) throws SQLException {
        try {
            if (conn == null) throw new SQLException("Connection is null!");

            String query = "UPDATE credit SET " +
                    "professionnel_id = ?, " +
                    "employe_id = ?, " +
                    "date_de_credit = ?, " +
                    "montant_demande = ?, " +
                    "montant_octroye = ?, " +
                    "taux_interet = ?, " +
                    "duree_en_mois = ?, " +
                    "type_credit = ?, " +
                    "decision = ? " +
                    "WHERE id = ?"; // لاحظت هنا كنت عندك comma زايد قبل WHERE

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setObject(1, credit.getProfessionnelId() == 0 ? null : credit.getProfessionnelId());
            ps.setObject(2, credit.getEmployeId() == 0 ? null : credit.getEmployeId());
            ps.setDate(3, java.sql.Date.valueOf(credit.getDateDeCredit()));
            ps.setBigDecimal(4, credit.getMontantDemande());
            ps.setBigDecimal(5, credit.getMontantOctroye());
            ps.setDouble(6, credit.getTauxInteret());
            ps.setInt(7, credit.getDureeEnMois());
            ps.setString(8, credit.getTypeCredit().name());
            ps.setString(9, credit.getDecision().name());
            ps.setInt(10, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println(" No rows updated.");
            } else {
                System.out.println("Credit updated successfully.");
            }

            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println(" SQLException in updateCredit: " + e.getMessage());
            throw e;
        } catch (NullPointerException e) {
            System.out.println(" NullPointerException in updateCredit: " + e.getMessage());
            throw e;
        }
    }

    public ResultSet CheekByEmploye(int id) throws SQLException {
        try {
            if (conn == null) throw new SQLException("Connection is null!");

            String query = "SELECT * FROM credit WHERE employe_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println(" SQLException in CheekByEmploye: " + e.getMessage());
            throw e;
        } catch (NullPointerException e) {
            System.out.println(" NullPointerException in CheekByEmploye: " + e.getMessage());
            throw e;
        }
    }

    public ResultSet CheekByProfitionnel(int id) throws SQLException {
        try {
            if (conn == null) throw new SQLException("Connection is null!");

            String query = "SELECT * FROM credit WHERE professionnel_id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            return ps.executeQuery();

        } catch (SQLException e) {
            System.out.println(" SQLException in CheekByProfitionnel: " + e.getMessage());
            throw e;
        } catch (NullPointerException e) {
            System.out.println(" NullPointerException in CheekByProfitionnel: " + e.getMessage());
            throw e;
        }
    }
}
