package societe.generale.fr.model.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import societe.generale.fr.model.LigneReleve;
import societe.generale.fr.model.TypeOperation;

import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(MockitoJUnitRunner.class)
public class LingeReleveTest {

    @Mock
    PrintStream printer;

    @Test
    public void imprimer_lui_meme() throws ParseException {
        Date dateDepot = new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2012");
        LigneReleve ligneReleve = new LigneReleve(TypeOperation.VERSER,dateDepot,1000, 1000);

        ligneReleve.toStringBuilder(printer);

        verify(printer).println("VERSER    | 10/01/2012  | 1000.00   | 1000.00");
    }

    @Test
    public void imprimer_retrait() throws ParseException {
        Date dateRetrait = new SimpleDateFormat("dd/MM/yyyy").parse("14/01/2012");
        LigneReleve ligneReleve = new LigneReleve(TypeOperation.RETRAIT,dateRetrait,500, 500);

        ligneReleve.toStringBuilder(printer);

        verify(printer).println("RETRAIT   | 14/01/2012  | 500.00    | 500.00");
    }

}
