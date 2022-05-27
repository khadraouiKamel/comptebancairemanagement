package societe.generale.fr.model.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import societe.generale.fr.model.Compte;
import societe.generale.fr.model.Releve;
import societe.generale.fr.model.TypeOperation;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class ReleveTest {

    @Mock
    PrintStream printer;
    private Releve releve;
    private Compte compte;

    @Before
    public void initialise() {
        releve = new Releve();
        compte = new Compte(releve);
    }

    @Test
    public void imprimer_releve_en_tete() {
        compte.imprimerLignesReleve(printer);
        verify(printer).println("Operation | Date        | Montant   | Solde");
    }

    @Test
    public void imprimer_depot() throws ParseException {
        Date dateDepot = new SimpleDateFormat("dd/MM/yyyy").parse("25/05/2022");
        releve.ajouterLigneTransaction(TypeOperation.VERSER,dateDepot,1000, 1000);
        compte.imprimerLignesReleve(printer);
        verify(printer).println("VERSER    | 25/05/2022  | 1000.00   | 1000.00");
    }

    @Test public void imprimer_retrait() throws ParseException {
        Date dateRetrait = new SimpleDateFormat("dd/MM/yyyy").parse("27/05/2022");
        releve.ajouterLigneTransaction(TypeOperation.RETRAIT,dateRetrait,500, 500);
        compte.imprimerLignesReleve(printer);

        verify(printer).println("RETRAIT   | 27/05/2022  | 500.00    | 500.00");
    }

    @Test
    public void imprimer_deux_depots_order_inverser() throws ParseException {

        Date dateDepot1 = new SimpleDateFormat("dd/MM/yyyy").parse("25/05/2022");
        Date dateDepot2 = new SimpleDateFormat("dd/MM/yyyy").parse("26/05/2022");
        releve.ajouterLigneTransaction(TypeOperation.VERSER,dateDepot1,1000, 1000);
        releve.ajouterLigneTransaction(TypeOperation.VERSER,dateDepot2,2000, 3000);

        compte.imprimerLignesReleve(printer);

        InOrder inOrder = Mockito.inOrder(printer);
        inOrder.verify(printer).println("VERSER    | 26/05/2022  | 2000.00   | 3000.00");
        inOrder.verify(printer).println("VERSER    | 25/05/2022  | 1000.00   | 1000.00");

    }


}
