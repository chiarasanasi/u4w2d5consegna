package classi;


import java.time.LocalDate;

public class Riviste extends Catalogo {
   private Periodicita periodicita;

    public Riviste(Integer codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, Periodicita periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                "periodicità =" + periodicita +
                '}';
    }
}
