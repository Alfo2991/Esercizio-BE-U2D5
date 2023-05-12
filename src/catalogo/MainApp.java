package catalogo;

import java.io.IOException;
import java.io.File;


public class MainApp {
    public static void main(String[] args) {
        Libro libro1 = new Libro("5225525255252", "Il nome della rosa", 1900, 300, "Umberto Eco", "Romanzo");
        Libro libro2 = new Libro("4114141441414", "Harry Potter e la pietra filosofale", 2000, 500, "J.K. Rowling", "Fantasy");
        Libro libro3 = new Libro("6363636363663", "1984", 1904, 500, "George Orwell", "Romanzo distopico");

        Rivista rivista1 = new Rivista("123456789", "National Geographic", 2021, 100, "Scienza");
        Rivista rivista2 = new Rivista("987654321", "Vanity Fair", 2022, 50, "Moda");

        Catalogo catalogo = new Catalogo();

        catalogo.aggiungiLibro(libro1);
        catalogo.aggiungiLibro(libro2);
        catalogo.aggiungiLibro(libro3);

        catalogo.aggiungiRivista(rivista1);
        catalogo.aggiungiRivista(rivista2);

        String autoreRicerca = "Umberto Eco";
        System.out.println("Risultati ricerca per autore: " + autoreRicerca);
        catalogo.cercaLibro(libro -> libro.getAutore().equals(autoreRicerca)).forEach(System.out::println);

        int annoRicerca = 2022;
        System.out.println("Risultati ricerca per anno di pubblicazione: " + annoRicerca);
        catalogo.cercaRivista(rivista -> rivista.getAnnoPubblicazione() == annoRicerca).forEach(System.out::println);
        
        Catalogo catalogo1 = new Catalogo();

        Libro libro = new Libro("ISBN456", "Titolo Libro", 2023, 200, "Autore Libro", "Genere Libro");
        catalogo1.aggiungiLibro(libro);

        try {
            catalogo.salvaCatalogoSuDisco();
            System.out.println("Catalogo salvato correttamente su disco.");
        } catch (IOException e) {
            System.out.println("Si è verificato un errore durante il salvataggio del catalogo su disco.");
            e.printStackTrace();
        }
        File fileLibri = new File("libri.txt");
        File fileRiviste = new File("riviste.txt");

        if (fileLibri.exists() && fileLibri.canWrite()) {
            System.out.println("Il file libri.txt esiste ed è accessibile in scrittura.");
        } else {
            System.out.println("Il file libri.txt non esiste o non è accessibile in scrittura.");
        }

        if (fileRiviste.exists() && fileRiviste.canWrite()) {
            System.out.println("Il file riviste.txt esiste ed è accessibile in scrittura.");
        } else {
            System.out.println("Il file riviste.txt non esiste o non è accessibile in scrittura.");
        }
}
}

    

