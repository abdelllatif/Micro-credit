package Utils;

import Models.Credit;
import Models.Echeance;
import java.util.List;

public class VerifierClient {

    public Credit.DecisionType verifierCredit(int clientId, boolean estEmploye,
                                              List<Credit> credits, List<Echeance> echeances,
                                              double salaireOuRevenu, int score, int anneesExperience) {

        boolean aUnCredit = !credits.isEmpty();

        if (!aUnCredit) {
            // زبون جديد
            if (estEmploye) {
                // موظف: خاصو على الأقل عامين ديال التجربة
                if (anneesExperience < 2) return Credit.DecisionType.REFUS_AUTOMATIQUE;
            }

            // القرار كيتم على حساب score
            if (score >= 80) return Credit.DecisionType.ACCORDIMMEDIAT;
            else if (score >= 70) return Credit.DecisionType.ETUDEMANUELLE;
            else return Credit.DecisionType.REFUS_AUTOMATIQUE;

        } else {
            // زبون قديم: نشوفو واش عندو إمبايات
            boolean aDesImpayes = echeances.stream()
                    .anyMatch(e -> e.getStatutPaiement().name().equals("IMPAYENONREGLE"));

            if (aDesImpayes) return Credit.DecisionType.REFUS_AUTOMATIQUE;

            if (score >= 80) return Credit.DecisionType.ACCORDIMMEDIAT;
            else if (score >= 60) return Credit.DecisionType.ETUDEMANUELLE;
            else return Credit.DecisionType.REFUS_AUTOMATIQUE;
        }
    }
}
