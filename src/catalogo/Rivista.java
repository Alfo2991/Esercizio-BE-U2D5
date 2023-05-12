package catalogo;

public class Rivista extends ElementoCatalogo {
    private String periodicita;

    public Rivista(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String periodicita) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }

    public String getPeriodicita() {
        return periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
               ", Periodicità: " + periodicita;
    }

	@Override
	public String getAutore() {
		return null;
	}

	@Override
	public String getIsbn() {
		return null;
	}
}
