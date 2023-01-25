import java.util.*;

public class PrintingOut{
    PrintingOut(List<LiteryImionaCounter> list){
        for (LiteryImionaCounter literyImionaCounter : list) {
            System.out.println("\nLitera: " + literyImionaCounter.litera);
            for (int j = 0; j < literyImionaCounter.imie_ilosc.size(); j++) {
                int ile = literyImionaCounter.imie_ilosc.get(j).ilosc;
                if (j % 3 == 0) {
                    String im = literyImionaCounter.imie_ilosc.get(j).imie;
                    System.out.println("Imie: " + im);
                }
                if (ile > 0) {
                    String plik = literyImionaCounter.imie_ilosc.get(j).plik;
                    System.out.println("W pliku " + plik + ":    " + ile);
                }
            }
        }
    }
}
