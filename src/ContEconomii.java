public class ContEconomii extends Cont{
    private final double comisionRetragere = 0.05;
    public ContEconomii(String valuta, double sold, String iban) {
        super(valuta, sold, iban);
    }
    public void depunere (double suma)throws ValoareInvalidaException{
        if(suma<=0) {
            throw new ValoareInvalidaException("Suma depusa trebuie sa fie mai mare ca 0");
        }else {
            super.setSold(super.getSold()+suma);
        }
    }

    public void retragere(double suma) throws ValoareInvalidaException,FonduriInsuficienteException{
        double sumaDeRetras =suma +suma*comisionRetragere;
        if(suma<=0){
            throw new ValoareInvalidaException("Suma retrasa trebuie sa fie mai mare ca 0");
        }else if(super.getSold()<sumaDeRetras){
            throw new FonduriInsuficienteException("Soldul tau este insuficient pentru retragerea sumei");
        }
    }
}
