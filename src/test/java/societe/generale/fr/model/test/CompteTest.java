package societe.generale.fr.model.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import societe.generale.fr.model.Compte;
import societe.generale.fr.model.Releve;
import societe.generale.fr.model.TypeOperation;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class CompteTest {

    @Mock
    private Releve releve;
    private Compte compte;

    @Before
    public void initialise() {
        compte = new Compte(releve);
    }

    @Test
    public void ajout_ligne_depot_to_releve() throws ParseException {
        Date dateDepot = new SimpleDateFormat("dd/MM/yyyy").parse("25/05/2022");

        compte.verser(1000, dateDepot);

        verify(releve).ajouterLigneTransaction(TypeOperation.VERSER,dateDepot,1000, 1000);
    }

    @Test public void ajout_ligne_retrait_to_releve() throws ParseException {
        Date dateRetrait = new SimpleDateFormat("dd/MM/yyyy").parse("12/01/2012");

        compte.setSolde(1000);
        compte.retrait(500, dateRetrait);

        verify(releve).ajouterLigneTransaction(TypeOperation.RETRAIT,dateRetrait,500, 500);
    }

    @Test public void imprimer_lignes_releve() {
        String expectedOutput = String.format("%1$-" + 10 + "s", "Operation").concat("| ")+String.format("%1$-" + 12 + "s", "Date").concat("| ")+String.format("%1$-" + 10 + "s", "Montant").concat("| Solde");
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        compte.imprimerLignesReleve(System.out);
        assertEquals(expectedOutput.trim(), outContent.toString().trim());
    }

}
