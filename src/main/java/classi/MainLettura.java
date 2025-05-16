package classi;

import java.util.*;
import java.util.stream.Collectors;

public class MainLettura{
    public static void main(String[] args) {
        Catalogo libro1 = new Libri(1001,"Il giorno della civetta", 1961,160,"Leonardo Sciascia","Giallo");
        Catalogo libro2 = new Libri(1002,"1984", 1949,328,"George Orwell","Distopico");
        Catalogo libro3 = new Libri(1003,"Gomorra", 2006,331,"Roberto Saviano","Inchiesta");
        Catalogo libro4 = new Libri(1004,"Anime silenziose", 2020,210,"Marta Fiori","Narrativa");
        Catalogo libro5 = new Libri(1005,"Vento del Sud", 2018,245,"Luca Greco","Drammatico");
        Catalogo libro6 = new Libri(1006,"Il nome della rosa", 1980,512,"Umberto Eco","Giallo");
        Catalogo libro7 = new Libri(1007,"Fahrenheit 451", 1953,190,"Ray Bradbury","Distopico");
        Catalogo libro8 = new Libri(1008,"ZeroZeroZero", 2013,448,"Roberto Saviano","Inchiesta");
        Catalogo libro9 = new Libri(1009,"Vite parallele", 2019,265,"Marta Fiori","Narrativa");
        Catalogo libro10 = new Libri(1010,"Il mare e il vento", 2016,245,"Luca Greco","Drammatico");

        Catalogo rivista1 = new Riviste(2001,"Focus",2023,98,Periodicita.MENSILE);
        Catalogo rivista2 = new Riviste(2002,"Internazionale",2024,120,Periodicita.SETTIMANALE);
        Catalogo rivista3 = new Riviste(2003,"Scienza Oggi",2022,80,Periodicita.MENSILE);
        Catalogo rivista4 = new Riviste(2004,"La Voce Quotidiana",2025,40,Periodicita.SEMESTRALE);
        Catalogo rivista5 = new Riviste(2005,"Vivere Verde",2023,76,Periodicita.MENSILE);
        Catalogo rivista6 = new Riviste(2006,"Scienza e Vita",1985,60,Periodicita.MENSILE);
        Catalogo rivista7 = new Riviste(2007,"La Settimana Illustrata",1978,48,Periodicita.SETTIMANALE);
        Catalogo rivista8 = new Riviste(2008,"Notizie del Mattino",1990,36,Periodicita.SEMESTRALE);

        Archivio archivio = new Archivio();

        //AGGIUNGO GLI ELEMENTI CREATI QUI COSì DA AVERE PIù DATI SU CUI FARE LE DIVERSE RICERCHE E STATISTICHE
        archivio.aggiungi(libro1);
        archivio.aggiungi(libro2);
        archivio.aggiungi(libro3);
        archivio.aggiungi(libro4);
        archivio.aggiungi(libro5);
        archivio.aggiungi(libro6);
        archivio.aggiungi(libro7);
        archivio.aggiungi(libro8);
        archivio.aggiungi(libro9);
        archivio.aggiungi(libro10);

        archivio.aggiungi(rivista1);
        archivio.aggiungi(rivista2);
        archivio.aggiungi(rivista3);
        archivio.aggiungi(rivista4);
        archivio.aggiungi(rivista5);
        archivio.aggiungi(rivista6);
        archivio.aggiungi(rivista7);
        archivio.aggiungi(rivista8);

        Scanner scanner = new Scanner(System.in);
        String comando = "";
        try {
            while (!comando.equals("0")) {
                System.out.println("Scegli un numero :" + "\n" +
                        "1 -> Aggiungi Libro o Rivista all'archivio" + "\n" +
                        "2 -> Ricerca Libro o Rivista tramite ISBN" + "\n" +
                        "3 -> Rimuovi Libro o Rivista tramite ISBN" + "\n" +
                        "4 -> Ricerca Libro o Rivista tramite Anno di pubblicazione" + "\n" +
                        "5 -> Ricerca Libro o Rivista tramite Autore" + "\n" +
                        "7 -> Statistiche dell'archivio");
                comando = scanner.nextLine();

                Periodicita perScelta = null;


                switch (comando) {
                    case "1" -> {
                        System.out.println("Digita LIBRO o RIVISTA in base a cosa vuoi aggiungere");
                        String cosaVuoiAggiungere = scanner.nextLine();
                        if (cosaVuoiAggiungere.equals("LIBRO")) {
                            System.out.println("Titolo ?");
                            String titolo = scanner.nextLine();

                            System.out.println("ISBN ?");
                            Integer isbn = scanner.nextInt();

                            System.out.println("Numero di pagine ?");
                            Integer numeroPagine = scanner.nextInt();

                            System.out.println("Anno di pubblicazione ?");
                            Integer anno = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Autore ?");
                            String autore = scanner.nextLine();

                            System.out.println("Genere ?");
                            String genere = scanner.nextLine();

                            Catalogo elemento = new Libri(isbn, titolo, anno, numeroPagine, autore, genere);
                            archivio.aggiungi(elemento);

                            System.out.println("Libro " + titolo + " aggiunto all'archivio");

                        } else if (cosaVuoiAggiungere.equals("RIVISTA")) {
                            System.out.println("Titolo ?");
                            String titolo = scanner.nextLine();

                            System.out.println("ISBN ?");
                            Integer isbn = scanner.nextInt();

                            System.out.println("Numero di pagine ?");
                            Integer numeroPagine = scanner.nextInt();

                            System.out.println("Anno di pubblicazione ?");
                            Integer anno = scanner.nextInt();

                            System.out.println("Periodicità : 1 per SETTIMANALE, 2 per SEMESTRALE, 3 per MENSILE ?");
                            int periodicita = scanner.nextInt();
                            scanner.nextLine();

                            switch (periodicita) {
                                case 1 -> {
                                    perScelta = Periodicita.SETTIMANALE;
                                }
                                case 2 -> {
                                    perScelta = Periodicita.SEMESTRALE;
                                }
                                case 3 -> {
                                    perScelta = Periodicita.MENSILE;
                                }
                            }

                            Catalogo elemento = new Riviste(isbn, titolo, anno, numeroPagine, perScelta);
                            archivio.aggiungi(elemento);

                            System.out.println("Rivista " + titolo + " aggiunta all'archivio");

                        }

                    }
                    case "2" -> {
                        System.out.println("Indicami l'ISBN dell'elemento che vuoi cercare");
                        Integer isbn = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(archivio.ricercaTramiteIsbn(isbn));
                    }
                    case "3" -> {
                        System.out.println("Indicami l'ISBN dell'elemento che vuoi eliminare");
                        Integer isbn = scanner.nextInt();
                        scanner.nextLine();
                        archivio.rimuoviTramiteIsbn(isbn);
                        System.out.println("Elemento Rimosso se presente");
                    }
                    case "4" -> {
                        System.out.println("Ricerca tramite anno di pubblicazione. Indicami l'anno");
                        Integer anno = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(archivio.ricercaTramiteAnno(anno));
                    }
                    case "5" -> {
                        System.out.println("Ricerca tramite autore. Indicami un autore");
                        String autore = scanner.nextLine();
                        System.out.println(archivio.ricercaTramiteAutore(autore));
                    }
                    case "7" -> {
                        System.out.println("STATISTICHE DELL'ARCHIVIO");
                        System.out.println(archivio.statistiche());
                    }
                }
            }
        }
        catch (InputMismatchException e){
            e.getMessage();
        }


    }
}
