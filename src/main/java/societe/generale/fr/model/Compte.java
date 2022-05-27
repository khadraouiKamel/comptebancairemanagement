package societe.generale.fr.model;


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

    public void imprimerLignesReleve() {
    }

}
