package classi;

import java.util.*;
import java.util.stream.Collectors;

public class Archivio<letture> {
    private Set<Catalogo> letture = new HashSet<>();

    private Set<Libri> libri = new HashSet<>();

    public Set<Catalogo> getLetture() {
        return letture;
    }


    @Override
    public String toString() {
        return "Archivio --> " +
                letture;
    }

    //metodi
    //punto 1
    public void aggiungi(Catalogo cosaDaLeggere){
        letture.add(cosaDaLeggere);
    }

    //punto 2
    public List<Catalogo> ricercaTramiteIsbn(Integer isbn){
        return
        letture.stream().filter(c->c.getCodiceISBN().equals(isbn)).collect(Collectors.toList());
    }

    //punto 3
    public void rimuoviTramiteIsbn(Integer isbn){
        letture.removeIf(catalogo -> catalogo.getCodiceISBN().equals(isbn));
    }

    //punto 4
    public List<Catalogo> ricercaTramiteAnno(Integer anno){
        return letture.stream().filter(c->c.getAnnoPubblicazione().equals(anno)).collect(Collectors.toList());
    }

    //punto 5
    public List<Libri> ricercaTramiteAutore(String autore){
        return  letture.stream().filter(c->c instanceof Libri).map(c->(Libri) c).filter(l->l.getAutore().equals(autore)).collect(Collectors.toList());
    }

    //punto 7
    public String statistiche(){
        long numeroDiLibri = letture.stream().filter(c->c instanceof Libri).count();
        long numeroDiRiviste = letture.stream().filter(c->c instanceof Riviste).count();

        IntSummaryStatistics stats = letture.stream().collect(Collectors.summarizingInt(Catalogo::getNumeroPagine));

        int numeroMaggDiPag = stats.getMax();

        Optional<Catalogo> elementoConMaggPag = letture.stream()
                .filter(c -> c.getNumeroPagine().equals(numeroMaggDiPag))
                .findFirst();

        return  "Numero totale di libri : " + numeroDiLibri + "\n" +
                "Numero totale di riviste : " + numeroDiRiviste + "\n" +
                "Elemento con maggior numero di pagine : " + elementoConMaggPag
                .map(Object::toString)
                .orElse("Nessun elemento trovato") + "\n" +
                "Media delle pagine di tutti gli elementi : " + stats.getAverage();
    }
}
