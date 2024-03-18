import java.util.HashMap;

public abstract class Cont {
    private String valuta;
    private double sold;
    private String iban;
    private HashMap<String, Double> rataConversie;
    public Cont(String valuta, double sold, String iban) {
        this.valuta = valuta;
        this.sold = sold;
        this.iban = iban;
        rataConversie.put("EUR",5.0);
        rataConversie.put("USD",4.5);
    }

    public String getValuta() {
        return valuta;
    }
    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public String getIban() {
        return iban;
    }

    public HashMap<String, Double> getRataConversie() {
        return rataConversie;
    }
}
