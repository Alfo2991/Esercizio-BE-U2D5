package catalogo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Catalogo {
    private List<Libro> listaLibri;
    private List<Rivista> listaRiviste;
    private static final String FILE_LIBRI = "libri.txt";
    private static final String FILE_RIVISTE = "riviste.txt";

    public Catalogo() {
        listaLibri = new ArrayList<>();
        listaRiviste = new ArrayList<>();
    }

    public void aggiungiLibro(Libro libro) {
        listaLibri.add(libro);
    }

    public void aggiungiRivista(Rivista rivista) {
        listaRiviste.add(rivista);
    }

    public List<Libro> cercaLibro(Predicate<Libro> p) {
        return listaLibri.stream().filter(p).collect(Collectors.toList());
    }

    public List<Rivista> cercaRivista(Predicate<Rivista> p) {
        return listaRiviste.stream().filter(p).collect(Collectors.toList());
    }
    
    public void rimuoviElemento(String isbn) {
        listaLibri.removeIf(libro -> libro.getIsbn().equals(isbn));
        listaRiviste.removeIf(rivista -> rivista.getIsbn().equals(isbn));
    }

    public void salvaCatalogoSuDisco() throws IOException {
        try (BufferedWriter libriWriter = new BufferedWriter(new FileWriter(FILE_LIBRI))) {
            for (Libro libro : listaLibri) {
                String linea = libro.getIsbn() + "," + libro.getTitolo() + "," + libro.getAutore() + ","
                        + libro.getAnnoPubblicazione();
                libriWriter.write(linea);
                libriWriter.newLine();
            }
        }

        try (BufferedWriter rivisteWriter = new BufferedWriter(new FileWriter(FILE_RIVISTE))) {
            for (Rivista rivista : listaRiviste) {
                String linea = rivista.getIsbn() + "," + rivista.getTitolo() + "," + rivista.getAutore() + ","
                        + rivista.getAnnoPubblicazione();
                rivisteWriter.write(linea);
                rivisteWriter.newLine();
            }
        }
    }
    public void caricaCatalogoDaDisco() throws IOException {
        try (BufferedReader libriReader = new BufferedReader(new FileReader(FILE_LIBRI))) {
            String line;
            while ((line = libriReader.readLine()) != null) {
                String[] tokens = line.split(",");
                String isbn = tokens[0];
                String titolo = tokens[1];
                int annoPubblicazione = Integer.parseInt(tokens[2]);
                int numeroPagine = Integer.parseInt(tokens[3]);
                String autore = tokens[4];
                String genere = tokens[5];

                Libro libro = new Libro(isbn, titolo, annoPubblicazione, numeroPagine, autore, genere);
                listaLibri.add(libro);
            }
        }

        try (BufferedReader rivisteReader = new BufferedReader(new FileReader(FILE_RIVISTE))) {
            String line;
            while ((line = rivisteReader.readLine()) != null) {
                String[] tokens = line.split(",");
                String codiceISBN = tokens[0];
                String titolo = tokens[1];
                int annoPubblicazione = Integer.parseInt(tokens[2]);
                int numeroPagine = Integer.parseInt(tokens[3]);
                String periodicita = tokens[4];

                Rivista rivista = new Rivista(codiceISBN, titolo, annoPubblicazione, numeroPagine, periodicita);
                listaRiviste.add(rivista);
            }
        }
    }




}
