package societe.generale.fr.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Releve {

    private static final int index = 0;
    private List<LigneReleve> lignesReleve = new LinkedList<LigneReleve>();

    public void ajouterLigneTransaction(TypeOperation op, Date date, int montant, int soldActuel) {
        lignesReleve.add(index, new LigneReleve(op, date, montant, soldActuel));
    }

}
