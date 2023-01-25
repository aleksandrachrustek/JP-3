import java.util.*;

public class LiteryImionaCounter {

    List<ImionaCounter> imie_ilosc;
    char litera;

    LiteryImionaCounter(char c, List<ImionaCounter> l) {
        litera = c;
        imie_ilosc = l;
    }
    public LiteryImionaCounter(List<ImionaCounter> l, List<LiteryImionaCounter> list) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            String b;
            List<ImionaCounter> bufor = new ArrayList<>();
            b = "" + l.get(i).imie.charAt(0);
            if (!a.toString().contains(b)) {
                bufor.add(l.get(i));
                for (int j = i + 1; j < l.size(); j++) {
                    if (l.get(j).imie.charAt(0) == l.get(i).imie.charAt(0)) {
                        bufor.add(l.get(j));
                    }
                    list.add(new LiteryImionaCounter(l.get(i).imie.charAt(0), bufor));
                    a.append(b);
                }
            }
        }
    }
}