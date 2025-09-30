package Service;
import Models.Employe;
import Repository.EmployeRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeService {

    private final EmployeRepository repository;

    public EmployeService(EmployeRepository repository) {
        this.repository = repository;
    }

    private Employe mapResultSetToEmploye(ResultSet rs) throws SQLException {
        Employe e = new Employe();
        e.setId(rs.getInt("id"));
        e.setNom(rs.getString("nom"));
        e.setPrenom(rs.getString("prenom"));
        e.setDateNaissance(rs.getDate("datedenaissance").toLocalDate());
        e.setVille(rs.getString("ville"));
        e.setNombreEnfants(rs.getInt("nombreEnfants"));
        e.setInvestissement(rs.getBigDecimal("investissement"));
        e.setPlacement(rs.getBigDecimal("placement"));
        e.setSituationFamiliale(rs.getString("situation_familiale"));
        e.getDateCreation(rs.getTimestamp("createdAt").toInstant());
        e.setScore(rs.getvDouble("score"));
        e.setSalaire(rs.getBigDecimal("salaire"));
        e.setAnciennete(rs.getInt("anciennete"));
        e.setPoste(rs.getString("poste"));
        e.setTypeContrat(TypeContrat.valueOf(rs.getString("typecontrat")));
        e.setSecteur(Secteur.valueOf(rs.getString("secteur")));
        return e;
    }

    public List<Employe> getAllEmployes() throws SQLException {
        ResultSet rs = repository.findAll();
        List<Employe> employes = new ArrayList<>();
        while (rs.next()) {
            employes.add(mapResultSetToEmploye(rs));
        }
        return employes;
    }

    public Optional<Employe> getEmployeById(int id) throws SQLException {
        ResultSet rs = repository.findById(id);
        if (rs.next()) {
            return Optional.of(mapResultSetToEmploye(rs));
        }
        return Optional.empty();
    }

    public Employe addEmploye(Employe employe) throws SQLException {
        int newId = repository.save(employe);
        employe.setId(newId);
        return employe;
    }

    public void updateEmploye(Employe employe) throws SQLException {
        repository.update(employe);
    }

    public void deleteEmploye(int id) throws SQLException {
        repository.delete(id);
    }

    public List<Employe> getEmployesSortedByScore() throws SQLException {
        return getAllEmployes().stream()
                .sorted(Comparator.comparingDouble(Employe::getScore).reversed())
                .collect(Collectors.toList());
    }

    public List<Employe> searchByVille(String ville) throws SQLException {
        return getAllEmployes().stream()
                .filter(e -> e.getVille().equalsIgnoreCase(ville))
                .collect(Collectors.toList());
    }
}
