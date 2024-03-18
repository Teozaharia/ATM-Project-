import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String nume;
    private String prenume;
    private String cnp;
    private List<Cont> listaConturi = new ArrayList<>();
    private String username;
    private String password;

    public Client(String nume, String prenume, String cnp) {
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }
    public List<Cont> getListaConturi() {
        return listaConturi;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void adaugaCont(Cont cont){
        listaConturi.add(cont);
    }

    public void valideazaSiSeteazaUsernamePassword(String username,String password) throws DateClientException{
        if(username.length()<5 && password.length()<5) {
            throw new DateClientException("EROARE,username-ul trebuie sa contina mai mult de 5 caractere");
        }else {
            this.username =username;
            this.password=password;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(nume, client.nume) && Objects.equals(prenume, client.prenume) && Objects.equals(cnp, client.cnp) && Objects.equals(listaConturi, client.listaConturi) && Objects.equals(username, client.username) && Objects.equals(password, client.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, prenume, cnp, listaConturi, username, password);
    }
}
