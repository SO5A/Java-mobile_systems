import java.util.Comparator;

public class ComparatorAmount implements Comparator<Item> {
    public int compare(Item o1, Item o2){
        int wynik = o1.getIlosc() -o2.getIlosc();
        if(wynik == 0){
            return o1.compareTo(o2);
        }
        return wynik;
    }

}
