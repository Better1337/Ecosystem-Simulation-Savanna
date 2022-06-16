import java.util.HashMap;
import java.util.Scanner;

public class ApplicationData {
    private final HashMap<String, Integer> ilosc = new HashMap<>(); //Stworzenie HashMapy
    public HashMap<String,Integer>getIlosc(){
        return ilosc;
    }

   public void Plansza() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj rozmiar planszy");
        Scanner sc1 = new Scanner(System.in);
        ilosc.put("RozmiarPlanszy", sc1.nextInt());
    }

    public void Lwy() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj ilosc lwów");
        Scanner sc2 = new Scanner(System.in);
        ilosc.put("IloscLwow", sc2.nextInt());
    }

    public void Hieny() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj ilosc hien");
        Scanner sc3 = new Scanner(System.in);
        ilosc.put("IloscHien", sc3.nextInt());
    }

    public void Tygrysy() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj ilosc tygrysow");
        Scanner sc4 = new Scanner(System.in);
        ilosc.put("IloscTygrysow", sc4.nextInt());
    }

    public void Antylopy() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj ilosc antylop");
        Scanner sc5 = new Scanner(System.in);
        ilosc.put("IloscAntylop", sc5.nextInt());
    }
    public void WysokaTrawa() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj ilosc wysokich traw");
        Scanner sc6 = new Scanner(System.in);
        ilosc.put("IloscWysokie", sc6.nextInt());
    }
    public void NiskaTrawa() { //Metoda w której użytownik wprowadza dane
        System.out.println("Podaj ilosc niskich traw");
        Scanner sc7 = new Scanner(System.in);
        ilosc.put("IloscNiskie", sc7.nextInt());
    }
}

