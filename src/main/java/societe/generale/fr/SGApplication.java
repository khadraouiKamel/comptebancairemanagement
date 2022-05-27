package societe.generale.fr;

import societe.generale.fr.model.Compte;
import societe.generale.fr.model.Releve;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class SGApplication {

    public static void main(String[] args) throws ParseException{
        Compte compte = new Compte(new Releve());

        compte.verser(1000, new SimpleDateFormat("dd/MM/yyyy").parse("25/05/2022"));
        compte.verser(2000, new SimpleDateFormat("dd/MM/yyyy").parse("26/05/2022"));
        compte.retrait(500, new SimpleDateFormat("dd/MM/yyyy").parse("27/05/2022"));

        compte.imprimerLignesReleve(System.out);
    }

}
