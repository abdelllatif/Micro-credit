package Service;

import Models.Credit;
import Repository.CreditRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditService {

    private final CreditRepository creditRepo;

    public CreditService() {
        this.creditRepo = new CreditRepository();
    }

    public int addCredit(Credit credit) {
        try (ResultSet rs = creditRepo.addCredit(credit)) {
            if (rs.next()) {
                return rs.getInt(1); // return generated id
            }
        } catch (SQLException e) {
            System.err.println("Error adding credit: " + e.getMessage());
        }
        return -1;
    }

    public boolean updateCredit(Credit credit, int id) {
        try {
            return creditRepo.updateCredit(credit, id);
        } catch (SQLException e) {
            System.err.println("Error updating credit: " + e.getMessage());
        }
        return false;
    }

    public List<Credit> getCreditsByEmployee(int employeeId) {
        List<Credit> credits = new ArrayList<>();
        try (ResultSet rs = creditRepo.CheekByEmploye(employeeId)) {
            while (rs.next()) {
                credits.add(mapResultSetToCredit(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching credits by employee: " + e.getMessage());
        }
        return credits;
    }

    public List<Credit> getCreditsByProfessional(int professionalId) {
        List<Credit> credits = new ArrayList<>();
        try (ResultSet rs = creditRepo.CheekByProfitionnel(professionalId)) {
            while (rs.next()) {
                credits.add(mapResultSetToCredit(rs));
            }
        } catch (SQLException e) {
            System.err.println("Error fetching credits by professional: " + e.getMessage());
        }
        return credits;
    }

    private Credit mapResultSetToCredit(ResultSet rs) throws SQLException {
        Credit credit = new Credit();
        credit.setId(rs.getInt("id"));
        credit.setProfessionnelId(rs.getInt("professionnel_id"));
        credit.setEmployeId(rs.getInt("employe_id"));
        credit.setDateDeCredit(rs.getDate("date_de_credit").toLocalDate());
        credit.setMontantOctroye(rs.getBigDecimal("montant_octroye"));
        credit.setTauxInteret(rs.getDouble("taux_interet"));
        credit.setDureeEnMois(rs.getInt("duree_en_mois"));
        credit.setTypeCredit(Credit.CreditType.valueOf(rs.getString("type_credit")));
        credit.setDecision(Credit.DecisionType.valueOf(rs.getString("decision")));
        return credit;
    }
}
