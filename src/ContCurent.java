import java.util.Map;

public class ContCurent extends Cont{
    public ContCurent(String valuta,double sold,String iban){
        super(valuta,sold,iban);
    }
    public void depunere (double suma)throws ValoareInvalidaException{
        if(suma<=0) {
            throw new ValoareInvalidaException("Suma depusa trebuie sa fie mai mare ca 0");
        }else {
            super.setSold(super.getSold()+suma);
        }
    }

    public void retragere(double suma) throws ValoareInvalidaException,FonduriInsuficienteException{
        if(suma<=0){
            throw new ValoareInvalidaException("Suma retrasa trebuie sa fie mai mare ca 0");
        }else if(super.getSold()<suma){
            throw new FonduriInsuficienteException("Soldul tau este insuficient pentru retragerea sumei");
        }
        //trebuie sa verificam daca suma din cont este in alta valuta
        if(super.getValuta() != "RON"){
            double sumaRetragereInValutaAferenta=0;
            for(Map.Entry<String, Double> entry: super.getRataConversie().entrySet()){
                if(entry.getKey().equals(super.getValuta())){
                   sumaRetragereInValutaAferenta= suma/entry.getValue();
                }
            }
            super.setSold(super.getSold()-sumaRetragereInValutaAferenta);
        }else{
            super.setSold(super.getSold()-suma);
        }
    }
}
