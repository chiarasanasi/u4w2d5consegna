package classi;

import java.time.LocalDate;
import java.util.Objects;

public class Catalogo {
    private Integer codiceISBN;
    private String titolo;
    private Integer annoPubblicazione;
    private Integer numeroPagine;

    public Catalogo(Integer codiceISBN, String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public Integer getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(Integer codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public Integer getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(Integer numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "{ ISBN ->" + codiceISBN +
                ", " + titolo +
                ", " + annoPubblicazione +
                ", Pagina -> " + numeroPagine + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Catalogo catalogo = (Catalogo) o;
        return Objects.equals(codiceISBN, catalogo.codiceISBN) && Objects.equals(titolo, catalogo.titolo) && Objects.equals(annoPubblicazione, catalogo.annoPubblicazione) && Objects.equals(numeroPagine, catalogo.numeroPagine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codiceISBN, titolo, annoPubblicazione, numeroPagine);
    }
}
