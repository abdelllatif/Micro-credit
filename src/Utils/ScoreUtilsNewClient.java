package Utils;

import Models.Employe;
import Models.Person;
import Models.Professionnel;

import java.time.LocalDate;
import java.time.Period;

public class ScoreUtilsNewClient {

    public static int calculerScore(Person p) {
        int score = 0;

        if (p.getDateNaissance() != null) {
            int age = Period.between(p.getDateNaissance(), LocalDate.now()).getYears();
            if (age >= 18 && age <= 25) {
                score += 4;
            } else if (age >= 26 && age <= 35) {
                score += 8;
            } else if (age >= 36 && age <= 55) {
                score += 10;
            } else if (age > 55) {
                score += 6;
            }
        }

        if (p.getSituationFamiliale() != null) {
            String sf = p.getSituationFamiliale().toLowerCase();
            if (sf.equals("marié")) {
                score += 3;
            } else if (sf.equals("célibataire")) {
                score += 2;
            }
        }

        if (p.getNombreEnfants() != null) {
            if (p.getNombreEnfants() == 0) {
                score += 2;
            } else if (p.getNombreEnfants() >= 1 && p.getNombreEnfants() <= 2) {
                score += 1;
            } else if (p.getNombreEnfants() > 2) {
                score += 0;
            }
        }

        if (Boolean.TRUE.equals(p.getInvestissement())) {
            score += 10;
        }
        if (Boolean.TRUE.equals(p.getPlacement())) {
            score += 10;
        }

        if (p instanceof Employe) {
            Employe e = (Employe) p;

            if (e.getContractType() != null) {
                switch (e.getContractType()) {
                    case CDI_PUBLIC:
                        score += 25;
                        break;
                    case CDI_PRIVEE_GRANDE_ENTREPRISE:
                        score += 15;
                        break;
                    case CDI_PRIVEE_PME:
                        score += 12;
                        break;
                    case CDD_INTERIM:
                        score += 10;
                        break;
                    case PROFESSION_LIBERALE_STABLE:
                        score += 18;
                        break;
                    case AUTO_ENTREPRENEUR:
                        score += 12;
                        break;
                }
            }

            if (e.getAnciennete() != null) {
                if (e.getAnciennete() >= 5) {
                    score += 5;
                } else if (e.getAnciennete() >= 2 && e.getAnciennete() < 5) {
                    score += 3;
                } else if (e.getAnciennete() >= 1 && e.getAnciennete() < 2) {
                    score += 1;
                } else if (e.getAnciennete() < 1) {
                    score += 0;
                }
            }

            if (e.getSalaire() != null) {
                float revenu = e.getSalaire();
                if (revenu >= 10000) {
                    score += 30;
                } else if (revenu >= 8000 && revenu < 10000) {
                    score += 25;
                } else if (revenu >= 5000 && revenu < 8000) {
                    score += 20;
                } else if (revenu >= 3000 && revenu < 5000) {
                    score += 15;
                } else if (revenu < 3000) {
                    score += 10;
                }
            }
        }

        if (p instanceof Professionnel) {
            Professionnel pr = (Professionnel) p;
            if (pr.getRevenu() != null) {
                float revenu = pr.getRevenu();
                if (revenu >= 10000) {
                    score += 30;
                } else if (revenu >= 8000 && revenu < 10000) {
                    score += 25;
                } else if (revenu >= 5000 && revenu < 8000) {
                    score += 20;
                } else if (revenu >= 3000 && revenu < 5000) {
                    score += 15;
                } else if (revenu < 3000) {
                    score += 10;
                }
            }
        }

        return score;
    }
}
