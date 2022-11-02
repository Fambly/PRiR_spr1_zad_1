public class Glowna {
    static int ilosc_pociagow = 300;
    static int ilosc_peronow = 7;
    static int ilosc_pasazerow = 450;
    static Dworzec dworzec;

    public Glowna() {
    }

    public static void main(String[] args) {
        dworzec = new Dworzec(ilosc_peronow, ilosc_pociagow);
        for (int i = 0; i < ilosc_pociagow; i++)
            new Pociag(i, ilosc_pasazerow, dworzec).start();
    }
}
