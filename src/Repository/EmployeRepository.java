package Repository;
import Config.DbConnection;
import Models.Employe;

import java.sql.*;

public class EmployeRepository {

    private final Connection connection;

    public EmployeRepository() {
        this.connection = new DbConnection().getConnection();
    }


    public ResultSet findAll() throws SQLException {
        String sql = "SELECT * FROM employes";
        PreparedStatement ps = connection.prepareStatement(sql);
        return ps.executeQuery();
    }

    public ResultSet findById(int id) throws SQLException {
        String sql = "SELECT * FROM employes WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public int save(Employe employe) throws SQLException {
        String sql = "INSERT INTO employes (nom, prenom, dateNaissance, ville, nombreEnfants, investissement, placement, situationFamiliale, score, salaire, anciennete, post, contractType, employmentSector) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, employe.getNom());
        ps.setString(2, employe.getPrenom());
        ps.setDate(3, java.sql.Date.valueOf(employe.getDateNaissance()));
        ps.setString(4, employe.getVille());
        ps.setInt(5, employe.getNombreEnfants());
        ps.setBoolean(6, employe.getInvestissement());
        ps.setBoolean(7, employe.getPlacement());
        ps.setString(8, employe.getSituationFamiliale().name());
        ps.setDouble(9, employe.getScore());
        ps.setFloat(10, employe.getSalaire());
        ps.setInt(11, employe.getAnciennete());
        ps.setString(12, employe.getPost());
        ps.setString(13, employe.getContractType().name());
        ps.setString(14, employe.getEmploymentSector().name());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public void update(Employe employe) throws SQLException {
        String sql = "UPDATE employes SET nom=?, prenom=?, ville=?, nombreEnfants=?, investissement=?, placement=?, situationFamiliale=?, score=?, salaire=?, anciennete=?, post=?, contractType=?, employmentSector=? WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, employe.getNom());
        ps.setString(2, employe.getPrenom());
        ps.setString(3, employe.getVille());
        ps.setInt(4, employe.getNombreEnfants());
        ps.setBoolean(5, employe.getInvestissement());
        ps.setBoolean(6, employe.getPlacement());
        ps.setString(7, employe.getSituationFamiliale().name());
        ps.setDouble(8, employe.getScore());
        ps.setFloat(9, employe.getSalaire());
        ps.setInt(10, employe.getAnciennete());
        ps.setString(11, employe.getPost());
        ps.setString(12, employe.getContractType().name());
        ps.setString(13, employe.getEmploymentSector().name());
        ps.setInt(14, employe.getId());
        ps.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM employes WHERE id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
