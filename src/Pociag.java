import java.util.Random;

public class Pociag extends Thread {
    static int Dworzec = 1;
    static int START = 2;
    static int JAZDA = 3;
    static int Koniec_Trasy = 4;
    static int AWARIA = 5;
    static int INIT = 6;
    int numer;
    int pasazerowie;
    int stan;
    String[] stacje = {"Lublin","Gdańsk","Kraków","Warszawa","Łódź","Suwałki","Malbork","Szczecin","Poznań","Rzeszów","Wrocław","Sosnowiec","Katowice","Jelenia Góra"};
    int stc_len = stacje.length;
    Dworzec d;
    Random rand;
    String cel;
    int peron;

    public Pociag(int numer, int pasazerowie, Dworzec d) {
        this.numer = numer;
        this.pasazerowie = pasazerowie;
        this.stan = INIT;
        this.d = d;
        rand = new Random();
        cel = stacje[rand.nextInt(stc_len)];
        this.peron = Math.abs(d.peron_zajety-(rand.nextInt(6))+1);
    }

    public void run() {
        while (true) {
            if (stan == Dworzec) {
                if (rand.nextInt(999) % 13 != 0) {
                    stan = JAZDA;
                    pasazerowie += rand.nextInt(250);
                    int out = rand.nextInt(180);
                    if (pasazerowie - out >= 0){
                        pasazerowie -= out;
                    }

                    System.out.println("Pociąg numer " + numer+" do stacji: "+cel+" ODJEDZIE z peronu "+peron);
                    peron = Math.abs(d.peron_zajety-(rand.nextInt(7))+1);
                    stan = d.start(numer);
                    try {
                        sleep(rand.nextInt(1000));
                    } catch (Exception e) {

                    }
                } else {
                    System.out.println("UWAGA! Pociąg numer "+numer+" przejedzie przez peron "+Math.abs(d.peron_zajety-(rand.nextInt(6))+1)+" bez zatrzymywania, prosimy nie zbliżać się do krawędzi peronu!");
                }
            }
            else if (stan == INIT) {
                stan = START;
                try {
                    sleep(rand.nextInt(1000));
                } catch (Exception e) {

                }
            }
            else if (stan == START) {
                System.out.println("Pociąg numer " + numer + " jedzie");
                stan = JAZDA;
            } else if (stan == Koniec_Trasy) {
                System.out.println("Pociąg numer " + numer+" do stacji: "+cel+" PRZYJEDZIE na peron "+peron);
                stan = d.stop();
            } else if(stan==JAZDA) {
                pasazerowie-=rand.nextInt(250);
                if (pasazerowie % 7 == 0) {
                    stan = Koniec_Trasy;
                } else if (pasazerowie % 77 == 0){
                    stan = AWARIA;
                }
            } else if (stan == AWARIA) {
                System.out.println("AWARIA pociągu " + numer);
                d.zmniejsz();
            }
        }
    }
}
