import java.util.ArrayList;
import java.util.List;
public abstract class ATM {
    public static List<Client> listaClientiBanca= new ArrayList<>();
    public static Client clientlogat;

    public static void adaugaClient(Client client)throws ClientExistentException{
        //daca exista deja clientul? daca da, arunca o exceptie
        for(Client clientExistent:listaClientiBanca){
            if(clientExistent.equals(client)){
                throw new ClientExistentException("Clientul este deja inregistrat");
            }
        }
        listaClientiBanca.add(client);
    }
    //partea de log in
    public static boolean loginAtm(String username, String password)throws DateClientException{
        //trebuie sa verificam daca exista vreun client cu acelasi username
        //si sa verifcam si partea de parola
        boolean logged=false;
        for(Client clientExistent:listaClientiBanca) {
            if (clientExistent.getUsername().equals(username) && clientExistent.getPassword().equals(password)) {
                logged = true;
                clientlogat=clientExistent;
            }
        }
        if(!logged ){
                throw new DateClientException("Username sau parola incorecte");
        }else{
            System.out.println("Login success");

        }
        return logged;
    }

    public static void adaugaClientiInLista() {
        Client client1 = new Client("Popescu", "Andrei", "12345678");
        Client client2 = new Client("Ionescu", "Ana", "51645454");
        Client client3 = new Client("Ionescu", "Ana", "51645454");

        try {
            client1.valideazaSiSeteazaUsernamePassword("andrei", "123554");
            client2.valideazaSiSeteazaUsernamePassword("anamaria", "545455");
            client3.valideazaSiSeteazaUsernamePassword("anamaria", "545455");
            adaugaClient(client1);
            adaugaClient(client2);
            adaugaClient(client3);
        } catch (DateClientException | ClientExistentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void actiuneATM(int optiuneAleasa){
        switch (optiuneAleasa){
            case 1: System.out.println(clientlogat.getListaConturi());
            break;
            case 2:System.out.println("Alege contul din care sa retragi bani");
            //trebuie sa afisam conturile clientului logat
                //clientul trebuie sa aleaga un cont din care vrea sa faca retragere
                //daca vrea sa retraga din depozit--eroare
            case 3: System.out.println("Alege contul din care sa depui bani");
            //pe ce cont vrei sa depui bani?
                break;

        }
    }
}
