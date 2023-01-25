import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class main {
    static List<String> nazwy = new LinkedList<>();
    static List<Double> ceny = new LinkedList<>();
    static List<String> kody = new LinkedList<>();
    static Random random = new Random();
    static int iloscKanap = random.nextInt(4);
    static int iloscLamp = random.nextInt(4);
    static int iloscSzafek = random.nextInt(4);
    static int iloscLuster = random.nextInt(4);
    static int iloscPoduszek = random.nextInt(5);
    static List<String> wybraneNazwy = new LinkedList<>();
    static List<Double> wybraneCeny = new LinkedList<>();
    static int nr;
    static Scanner scan = new Scanner(System.in);
    static String nazwa;
    static StringJoiner joiner = new StringJoiner("");

    public static void main(String[] args) {
        stworzArtykulyPoczatkowe();
        zapiszArtykuly();
        System.out.println("Dzien dobry! Jestes klientem (wybierz K) czy pracownikiem (wybierz M)?");
        String odpowiedz = scan.nextLine();
        if (odpowiedz.equals("K")||odpowiedz.equals("k")){
            Klient();
        }
        else if (odpowiedz.equals("M")||odpowiedz.equals("m")){
            Magazynier();
        }
        else System.out.println("Wprowadzono niepoprawne dane!");
    }
    public static void Magazynier(){
        dodajArtykuly();
        zapiszArtykuly();
    }
    public static void Klient(){
        System.out.println("Wybierz co chcesz zrobic (podaj liczbe): ");
        System.out.println("1. Wyswietl liste dostepnych artykulow");
        System.out.println("2. Znajdz artykul");
        int n = scan.nextInt();
        switch (n) {
            case 1 -> Koszyk();
            case 2 -> {
                String a;
                do {
                    System.out.println("Podaj nazwe artykulu: ");
                    scan.nextLine();
                    nazwa = scan.nextLine();
                    ArrayList<String> znalezione;
                    znalezione=znajdzArtykul(nazwa);

                    for (String s : znalezione) {
                        System.out.println(s);
                    }

                    System.out.println("Czy chcesz znalezc kolejny artykuł? (T/N): ");
                    a = scan.nextLine();
                }
                while (a.equals("t") || a.equals("T"));
            }
        }

    }
    public static void stworzArtykulyPoczatkowe() {

        for (int i = 1; i <= iloscKanap; i++) {
            nazwy.add("kanapa");
            ceny.add(200.0);
            kody.add(String.valueOf(joiner.add("K").add("0").add(String.valueOf(i))));
            joiner = new StringJoiner("");
        }
        for (int i = 1; i <= iloscLamp; i++) {
            nazwy.add("lampa");
            ceny.add(89.99);
            kody.add(String.valueOf(joiner.add("L").add("0").add(String.valueOf(i))));
            joiner = new StringJoiner("");
        }
        for (int i = 1; i <= iloscSzafek; i++) {
            nazwy.add("szafka");
            ceny.add(399.99);
            kody.add(String.valueOf(joiner.add("S").add("0").add(String.valueOf(i))));
            joiner = new StringJoiner("");
        }
        for (int i = 1; i <= iloscLuster; i++) {
            nazwy.add("lustro");
            ceny.add(110.0);
            kody.add(String.valueOf(joiner.add("LS").add("0").add(String.valueOf(i))));
            joiner = new StringJoiner("");
        }
        for (int i = 1; i <= iloscPoduszek; i++) {
            nazwy.add("poduszka");
            ceny.add(38.0);
            kody.add(String.valueOf(joiner.add("P").add("0").add(String.valueOf(i))));
            joiner = new StringJoiner("");
        }
    }
    static void dodajArtykuly() {
        int b,c;
        System.out.println("Wybierz, który z artykułow chcesz dodac: ");
        System.out.println("1.Kanapa");
        System.out.println("2.Lampa");
        System.out.println("3.Szafka");
        System.out.println("4.Lustro");
        System.out.println("5.Poduszka");
        System.out.println("6.Nie chce dodac artykulow");
        b = scan.nextInt();
        if(b==6) return;
        System.out.println("Podaj ile: ");
        c = scan.nextInt();
        switch (b) {
            case 1: {
                for (int i = 1; i <= c; i++) {
                    nazwy.add("kanapa");
                    ceny.add(200.0);
                    kody.add(String.valueOf(joiner.add("K").add("0").add(String.valueOf(i+nazwy.size()))));
                    joiner = new StringJoiner("");
                }
            }
            case 2: {
                for (int i = 1; i <= c; i++) {
                    nazwy.add("lampa");
                    ceny.add(89.99);
                    kody.add(String.valueOf(joiner.add("L").add("0").add(String.valueOf(i+nazwy.size()))));
                    joiner = new StringJoiner("");
                }
            }
            case 3: {
                for (int i = 1; i <= iloscSzafek; i++) {
                    nazwy.add("szafka");
                    ceny.add(399.99);
                    kody.add(String.valueOf(joiner.add("S").add("0").add(String.valueOf(i+nazwy.size()))));
                    joiner = new StringJoiner("");
                }
            }
            case 4: {
                for (int i = 1; i <= iloscLuster; i++) {
                    nazwy.add("lustro");
                    ceny.add(110.0);
                    kody.add(String.valueOf(joiner.add("LS").add("0").add(String.valueOf(i+nazwy.size()))));
                    joiner = new StringJoiner("");
                }
            }
            case 5: {
                for (int i = 1; i <= iloscPoduszek; i++) {
                    nazwy.add("poduszka");
                    ceny.add(38.0);
                    kody.add(String.valueOf(joiner.add("P").add("0").add(String.valueOf(i+nazwy.size()))));
                    joiner = new StringJoiner("");
                }
            }
        }
        zapiszArtykuly();
        dodajArtykuly();
    }
    static void zapiszArtykuly() {
        try {
            PrintWriter out = new PrintWriter("magazyn.csv");
            int j = 0;
            while (j < nazwy.size()) {
                out.print(nazwy.get(j) + ";");
                out.flush();
                out.print(ceny.get(j) + ";");
                out.flush();
                out.print(kody.get(j) + ";");
                out.flush();
                j++;
            }
            out.close();
        } catch (FileNotFoundException exception) {
            System.out.println("Nie można utworzyć pliku");
        }
    }
    static void wczytanieDanychZpliku () {
        Path path = Paths.get("magazyn.csv");
        ArrayList<String> wczytane = new ArrayList<>();
        try {
            wczytane = (ArrayList<String>) Files.readAllLines(path);
        } catch (IOException exception) {
            System.out.println("Plik nie istnieje");
        }
        String[][] daneWczytane = new String[wczytane.size()][];
        int indeks = 0;
        for (String linia : wczytane) {
            String[] linia1 = linia.split(";");
            String[] linia2 = new String[linia1.length];
            System.arraycopy(linia1, 0, linia2, 0, linia2.length);
            daneWczytane[indeks] = linia2;
            indeks++;
        }
        List<String> elementy = new LinkedList<>();
        for (String[] linia : daneWczytane) {
            Collections.addAll(elementy, linia);
        }
        int k = 1;
        for (int i = 1; i <= elementy.size(); i++) {
            if (i == 1 || i == 4 || i == 7 || i == 10 || i == 13 || i == 16 || i == 19) {
                System.out.print(k + ". " + elementy.get(i - 1) + " ");
                continue;
            }
            if (i == 2 || i == 5 || i == 8 || i == 11 || i == 14 || i == 17 || i == 20) {
                System.out.print("cena: " + elementy.get(i - 1) + " ");
                System.out.println();
                k++;
            }
        }
    }
    static ArrayList<String> znajdzArtykul (String nazwa){
        ArrayList<String> znalezione = new ArrayList<>();
        for (String element: nazwy) {
            if(nazwa.matches(element)) znalezione.add(element);
        }
        return znalezione;
    }
    static void pobierzArtykul () {
        nazwy.remove(nr - 1);
        ceny.remove(nr - 1);
        kody.remove(nr - 1);
        zapiszArtykuly();
    }
    static void wycenaZamowienie (List < String > wybraneNazwy, List < Double > wybraneCeny){
        double suma = 0.0;
        String a;
        System.out.println("Zawartosc koszyka: ");
        for (int j = 0; j < wybraneNazwy.size(); j++) {
            suma += wybraneCeny.get(j);
            System.out.println(wybraneNazwy.get(j) + " : " + wybraneCeny.get(j));
        }
        System.out.println("Kwota do zaplaty: " + suma);
            System.out.println("Czy chcesz dokonac platności? (T/N)");
            a = scan.nextLine();
            if (a.equals("T") || a.equals("t")) {
                pobierzArtykul();
                System.out.println("Dziękujemy za zakupy!");
            } else if(a.equals("N") || a.equals("n")){
                System.out.println("Nie dokonano platnosci! Dziekujemy za wizyte.");
            }
    }
    static void Koszyk () {
        wczytanieDanychZpliku();
        for (int i = 0; i < 5; i++) {
            System.out.println("Podaj nr wybranego produktu: (jesli nie chcesz wybrac produktu wybierz 0/ jesli chcesz przejsc do koszyka wybierz 100)");
            nr = scan.nextInt();
            if (nr == 0) {
                wycenaZamowienie(wybraneNazwy, wybraneCeny);
            }
            else if (nr == 100) {
                wybraneNazwy.add(nazwy.get(nr - 1));
                wybraneCeny.add(ceny.get(nr - 1));
                wycenaZamowienie(wybraneNazwy, wybraneCeny);
                break;
            }
        }
    }
}