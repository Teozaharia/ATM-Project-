import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //rulam clientii si sa adauge in lista
        ATM.adaugaClientiInLista();

        Scanner scanner =new Scanner(System.in);
        System.out.println("Bine ai venit la ATM");
        System.out.println("Introdu User si Parola");

        String username =scanner.next();
        String password= scanner.next();
        try{
            ATM.loginAtm(username,password);
            System.out.println("Alege din optiunile de mai jos");
            System.out.println("1-afisare sold curent");
            System.out.println("2-retragere");
            System.out.println("3-depunere");
        }catch (DateClientException e){
            System.out.println(e.getMessage());
        }



    }
}