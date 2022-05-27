package societe.generale.fr;

import societe.generale.fr.model.Compte;
import societe.generale.fr.model.Releve;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class SGApplication {

    public static void main(String[] args) throws ParseException{
        Compte compte = new Compte(new Releve());

        compte.verser(1000, new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2012"));
        compte.verser(2000, new SimpleDateFormat("dd/MM/yyyy").parse("13/01/2012"));
        compte.retrait(500, new SimpleDateFormat("dd/MM/yyyy").parse("14/01/2012"));
    }

}
