package Repository;

import Config.DbConnection;
import Models.Professionnel;

import java.sql.*;

public class ProfessionnelRepository {

    private final Connection connection;

    public ProfessionnelRepository() {
        this.connection = new DbConnection().getConnection();
    }

    public ResultSet findAll() throws SQLException {
        String sql = "SELECT * FROM professionnels";
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    public ResultSet findById(int id) throws SQLException {
        String sql = "SELECT * FROM professionnels WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public int save(Professionnel p) throws SQLException {
        String sql = "INSERT INTO professionnels " +
                "(nom, prenom, email, dateNaissance, ville, adresse, telephone, " +
                "nombreEnfants, investissement, placement, situationFamiliale, score, " +
                "revenu, immatriculationFiscale, secteurActivite, activite) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.setString(3, p.getEmail());
        ps.setDate(4, java.sql.Date.valueOf(p.getDateNaissance()));
        ps.setString(5, p.getVille());
        ps.setString(6, p.getAdresse());
        ps.setString(7, p.getTelephone());
        ps.setInt(8, p.getNombreEnfants());
        ps.setBoolean(9, p.getInvestissement());
        ps.setBoolean(10, p.getPlacement());
        ps.setString(11, p.getSituationFamiliale());
        ps.setDouble(12, p.getScore());
        ps.setFloat(13, p.getRevenu());
        ps.setString(14, p.getImmatriculationFiscale());
        ps.setString(15, p.getSecteurActivite());
        ps.setString(16, p.getActivite());

        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void update(Professionnel p) throws SQLException {
        String sql = "UPDATE professionnels SET " +
                "nom=?, prenom=?, email=?, dateNaissance=?, ville=?, adresse=?, telephone=?, " +
                "nombreEnfants=?, investissement=?, placement=?, situationFamiliale=?, score=?, " +
                "revenu=?, immatriculationFiscale=?, secteurActivite=?, activite=? " +
                "WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, p.getNom());
        ps.setString(2, p.getPrenom());
        ps.setString(3, p.getEmail());
        ps.setDate(4, java.sql.Date.valueOf(p.getDateNaissance()));
        ps.setString(5, p.getVille());
        ps.setString(6, p.getAdresse());
        ps.setString(7, p.getTelephone());
        ps.setInt(8, p.getNombreEnfants());
        ps.setBoolean(9, p.getInvestissement());
        ps.setBoolean(10, p.getPlacement());
        ps.setString(11, p.getSituationFamiliale());
        ps.setDouble(12, p.getScore());
        ps.setFloat(13, p.getRevenu());
        ps.setString(14, p.getImmatriculationFiscale());
        ps.setString(15, p.getSecteurActivite());
        ps.setString(16, p.getActivite());
        ps.setInt(17, p.getId());

        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM professionnels WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
