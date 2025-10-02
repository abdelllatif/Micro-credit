package Service;

import Models.Person;
import Models.Professionnel;
import Repository.ProfessionnelRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class ProfessionnelService {

    private final ProfessionnelRepository repository;

    public ProfessionnelService() {
        this.repository = new ProfessionnelRepository();
    }

    private Professionnel mapResultSetToProfessionnel(ResultSet rs) throws SQLException {
        Professionnel p = new Professionnel(
                rs.getInt("id"),
                rs.getString("nom"),
                rs.getString("prenom"),
                rs.getString("email"),
                rs.getDate("dateNaissance").toLocalDate(),
                rs.getString("ville"),
                rs.getString("adresse"),
                rs.getString("telephone"),
                rs.getInt("nombreEnfants"),
                rs.getBoolean("investissement"),
                rs.getBoolean("placement"),
                Person.SituationFamilial.valueOf(rs.getString("situationFamiliale")),
                rs.getInt("score"),
                rs.getTimestamp("dateCreation").toLocalDateTime(),
                rs.getFloat("revenu"),
                rs.getString("immatriculationFiscale"),
                rs.getString("secteurActivite"),
                rs.getString("activite")
        );
        return p;
    }

    public List<Professionnel> getAllProfessionnels() throws SQLException {
        ResultSet rs = repository.findAll();
        List<Professionnel> professionnels = new ArrayList<>();
        while (rs.next()) {
            professionnels.add(mapResultSetToProfessionnel(rs));
        }
        return professionnels;
    }

    public Optional<Professionnel> getProfessionnelById(int id) throws SQLException {
        ResultSet rs = repository.findById(id);
        if (rs.next()) {
            return Optional.of(mapResultSetToProfessionnel(rs));
        }
        return Optional.empty();
    }

    public Professionnel addProfessionnel(Professionnel p) throws SQLException {
        int newId = repository.save(p);
        p.setId(newId);
        return p;
    }

    public void updateProfessionnel(Professionnel p) throws SQLException {
        repository.update(p);
    }

    public void deleteProfessionnel(int id) throws SQLException {
        repository.delete(id);
    }

    public List<Professionnel> getProfessionnelsSortedByRevenu() throws SQLException {
        return getAllProfessionnels().stream()
                .sorted(Comparator.comparingDouble(Professionnel::getRevenu).reversed())
                .collect(Collectors.toList());
    }

    public List<Professionnel> searchBySecteur(String secteur) throws SQLException {
        return getAllProfessionnels().stream()
                .filter(p -> p.getSecteurActivite() != null && p.getSecteurActivite().equalsIgnoreCase(secteur))
                .collect(Collectors.toList());
    }
}

