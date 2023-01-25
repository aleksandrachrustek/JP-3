import java.util.Comparator;

class ComparatorImion implements Comparator<ImionaCounter> {
    public int compare(ImionaCounter l1,ImionaCounter l2){
        return l1.imie.compareTo(l2.imie);
    }
}