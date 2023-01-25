import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reading {
    Reading(File plik1, File plik2, File plik3) {
        List<ImionaCounter> list = new ArrayList<>();
        int ile;

        for (Imiona imie : Imiona.values()) {
            ile=0;
            String i = String.valueOf(imie);
            ile=ileRazy(ile,i,plik1);
            list.add(new ImionaCounter(i,ile,plik1.getName()));
            ile=0;
            ile=ileRazy(ile,i,plik2);
            list.add(new ImionaCounter(i,ile,plik2.getName()));
            ile=0;
            ile=ileRazy(ile,i,plik3);
            list.add(new ImionaCounter(i,ile,plik3.getName()));
        }
        list.sort(new ComparatorImion());
        new LiteryImionaCounter(list,Main.list);
    }
    public static int ileRazy(int n,String i,File plik){
        EasyReader reader = new EasyReader(plik.getName());
        while (!reader.isEOF()){
            String buf=reader.stringInput();
            if(buf.equals(String.valueOf(i))){n++;}
        }
        return n;
    }
}