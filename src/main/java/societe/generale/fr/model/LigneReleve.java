package societe.generale.fr.model;

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LigneReleve {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
    private DecimalFormat decimalMontantFormat = new DecimalFormat("#.00");

    private TypeOperation op;
    private Date dateTransaction;
    private int montant;
    private int soldActuel;

    public LigneReleve(TypeOperation op, Date dateTransaction, int montant, int soldActuel) {
        this.op = op;
        this.dateTransaction = dateTransaction;
        this.montant = montant;
        this.soldActuel = soldActuel;
    }

    public void toStringBuilder(PrintStream printer){

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%1$-" + 10 + "s", this.op)).append("| ");
        builder.append(String.format("%1$-" + 12 + "s", sdf.format(this.dateTransaction))).append("| ");
        builder.append(String.format("%1$-" + 10 + "s", decimalMontantFormat.format(this.montant))).append("| ");
        builder.append(decimalMontantFormat.format(this.soldActuel));
        printer.println(builder.toString());

    }
}
