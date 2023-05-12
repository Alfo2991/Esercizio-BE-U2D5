package catalogo;

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

        int annoRicerca = 2021;
        System.out.println("Risultati ricerca per anno di pubblicazione: " + annoRicerca);
        catalogo.cercaRivista(rivista -> rivista.getAnnoPubblicazione() == annoRicerca).forEach(System.out::println);
    }
}
