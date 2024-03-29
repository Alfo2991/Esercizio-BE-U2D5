package catalogo;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class ElementoCatalogo {
    private String codiceISBN;
    private String titolo;
    private int annoPubblicazione;
    private int numeroPagine;

    public ElementoCatalogo(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public abstract String getAutore();

    public abstract String getIsbn();

    public abstract void scriviSuFile(BufferedWriter writer) throws IOException;

    @Override
    public String toString() {
        return "Codice ISBN: " + codiceISBN +
                ", Titolo: " + titolo +
                ", Anno di pubblicazione: " + annoPubblicazione +
                ", Numero di pagine: " + numeroPagine;
    }
}
