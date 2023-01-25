import java.util.*;

class Samochod{

    public enum firma{
        POLONEZ,
        FIAT,
        SYRENA
    }
    private firma marka;
    private double cena;
    private int rocznik;

    public Samochod(firma m, double c, int r){
        marka=m;
        cena=c;
        rocznik=r;
    }

    public void Wyswietlanie (){
        System.out.println("Marka: "+ marka + " Cena: "+cena+" Rocznik "+rocznik);
    }

    public int rok (){
        return rocznik;
    }
}

class Sortowanie implements Comparator<Samochod>
{
    public int compare (Samochod a, Samochod b){
        return a.rok()-b.rok();
    }
}
class Wybor {
    public static void wybieranie(ArrayList<Samochod> lista) {
        int wybieranie = -1;


        System.out.println("\n\n0. Wyswietl cala liste wygenerowanych samochodow");
        System.out.println("1. Najstarszy");
        System.out.println("2. Nie starszy niż ROK");
        System.out.println("3. Najmlodszy");
        System.out.println("4. Nie mlodszy niż ROK");

        EasyReader reader=new EasyReader(System.in);

        wybieranie = reader.intInputLine();

        switch (wybieranie) {
            case 0: {
                lista.forEach(Samochod::Wyswietlanie);
                wybieranie(lista);
            }
            break;

            case 1: {
                lista.sort(new Sortowanie());
                lista.get(0).Wyswietlanie();

            }
            break;

            case 2: {
                System.out.println("Podaj ROK: ");
                wybieranie = reader.intInputLine( );
                for (Samochod samochod : lista) {
                    if (samochod.rok() >= wybieranie) {
                        samochod.Wyswietlanie();
                    }
                }

            }
            break;

            case 3: {
                lista.sort(new Sortowanie());
                lista.get(lista.size() - 1).Wyswietlanie();

            }
            break;

            case 4: {
                System.out.println("Podaj ROK: ");
                wybieranie = reader.intInputLine( );
                for (int i = lista.size() - 1; i >= 0; i--) {
                    if (lista.get(i).rok() <= wybieranie) {
                        lista.get(i).Wyswietlanie();
                    }
                }
            }
            break;

            default:
                System.out.println("Zly numer");
                wybieranie(lista);
        }
    }
}
class Wyjatek extends Exception{
    public Wyjatek(ArrayList<Samochod> list){
        Wybor.wybieranie(list);
    }
}


public class Main {

    public static void main(String[] args) throws Wyjatek {
        ArrayList<Samochod> lista = new ArrayList<Samochod>(Integer.parseInt(args[0]));
        Random liczba = new Random();
        for(int i=0;i<Integer.parseInt(args[0]);i++){
            double cena = liczba.nextDouble()*10000+1500;
            cena = Math.round(cena*100);
            cena/=100;
            int rok = liczba.nextInt(62)+1960;
            int los = liczba.nextInt(3);
            if(los==0){
                lista.add( new Samochod(Samochod.firma.POLONEZ,cena,rok));
            }
            if(los==1){
                lista.add( new Samochod(Samochod.firma.FIAT,cena,rok));
            }
            if(los==2){
                lista.add( new Samochod(Samochod.firma.SYRENA,cena,rok));
            }
        }


        switch (args[1]){
            case "R":  Wybor.wybieranie(lista); break;
            case "W": throw new Wyjatek(lista);
            default: System.out.println("Zly parametr");
        }
    }
}