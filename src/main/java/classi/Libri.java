package classi;

import java.time.LocalDate;
import java.util.Objects;

public class Libri extends Catalogo {
    private String autore;
    private String genere;

    public Libri(Integer codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() + "," +
                "di " + autore +
                ", Genere -> " + genere;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Libri libri = (Libri) o;
        return Objects.equals(autore, libri.autore) && Objects.equals(genere, libri.genere);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autore, genere);
    }
}
