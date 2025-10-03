package Repository;

import Config.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EcheanceRepository {
    private final Connection connection;

    public EcheanceRepository(){
        this.connection = new DbConnection().getConnection();
    }

    public ResultSet findByCreditId(int id) throws Exception {
        String sql = "SELECT * FROM echeances WHERE credit_id=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeQuery();
    }

    public Boolean addEcheance(String dateEcheance, int mensualite, String dateDePaiement, int creditId, String statutPaiement) throws Exception {
        String sql = "INSERT INTO echeances (dateEcheance, mensualite, dateDePaiement, credit_id, statutPaiement) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, dateEcheance);
        ps.setInt(2, mensualite);
        ps.setString(3, dateDePaiement);
        ps.setInt(4, creditId);
        ps.setString(5, statutPaiement);
        return ps.executeUpdate() > 0;
    }
}
