//Lab 3 zadanie 2
//Aleksandra Chrustek nr indeksu 263900
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Main {
    public static List<LiteryImionaCounter> list = new ArrayList<>();
    public static void main(String[]args){
        int arg=0;
        for(String s:args){
            arg++;
        }
        if(arg==3){
            File plik1=new File(args[0]);
            File plik2=new File(args[1]);
            File plik3=new File(args[2]);
            new Reading(plik1,plik2,plik3);
            new PrintingOut(list);
        }
        else {System.out.println("Podana liczba argumentow jest niepoprawna");}
    }
}
