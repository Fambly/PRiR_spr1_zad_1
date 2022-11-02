import java.util.Random;
public class Dworzec {
    static int Dworzec = 1;
    static int START = 2;
    static int JAZDA = 3;
    static int Koniec_Trasy = 4;
    static int AWARIA = 5;
    int ilosc_torow;
    int ilosc_peronow;
    int peron_zajety;
    int ilosc_pociagow;
    Dworzec(int ilosc_peronow, int ilosc_pociagow){
        this.ilosc_peronow=ilosc_peronow;
        this.ilosc_pociagow=ilosc_pociagow;
        Random rand = new Random();
        this.peron_zajety=(rand.nextInt(ilosc_peronow)+ilosc_pociagow)%7;
    }
    synchronized int start(int numer){
        System.out.println("Konduktor pociągu numer "+numer+" robi *GWIIZD*");
        return START;
    }

    synchronized int stop(){
        if(peron_zajety<ilosc_peronow){
            System.out.println("Szanowni Państwo, zbliżamy się do stacji Białystok. Prosimy o zabranie bagaży i rzeczy osobistych.");
            return Dworzec;
        }
        else
        {return Koniec_Trasy;}
    }
    synchronized void zmniejsz(){
        ilosc_pociagow--;
        System.out.println("Pociąg uległ awarii - zostaje wyłączony z użytku.");
//        System.out.println(ilosc_pociagow);
        if (ilosc_pociagow == 0){
            System.out.println("Nie ma pociagow!");
            System.exit(9);
        }
    }
}

