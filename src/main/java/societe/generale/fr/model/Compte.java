package societe.generale.fr.model;


import java.io.PrintStream;
import java.util.Date;

public class Compte {

    private Releve releve;
    private int solde = 0;

    public Compte(Releve releve) {
        this.releve = releve;
    }

    public void verser(int montant, Date date) {
        if(montant > 0) {
            ajouterTransaction(TypeOperation.VERSER, montant, date);
        }else {
            System.err.println("Tu peux pas faire un virement avec une somme moins de zero");
        }
    }

    public void retrait(int montant, Date date) {
        if(solde < montant){
            System.err.println("Votre solde est insuffisant pour effectuer l'operation de retrait");
        }else {
            ajouterTransaction(TypeOperation.RETRAIT,-montant, date);
        }
    }

    private void ajouterTransaction(TypeOperation op,int montant, Date date) {
        this.solde = montant + this.solde;
        montant = montant < 0 ? montant * -1 : montant;
        releve.ajouterLigneTransaction(op, date, montant, this.solde);
    }

    public void imprimerLignesReleve(PrintStream printer) {
        String enteteReleve = String.format("%1$-" + 10 + "s", "Operation").concat("| ")+String.format("%1$-" + 12 + "s", "Date").concat("| ")+String.format("%1$-" + 10 + "s", "Montant").concat("| Solde");
        printer.println(enteteReleve);
        for (LigneReleve ligneReleve : releve.getLignesReleve()) {
            ligneReleve.toStringBuilder(printer);
        }
    }

    //Setter solde pour test unitaire de la methode retrait
    public void setSolde(int solde) {
        this.solde = solde;
    }

}
