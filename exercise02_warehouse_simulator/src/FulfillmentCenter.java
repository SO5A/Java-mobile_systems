import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.text.Collator;
import java.util.Comparator;
import java.util.stream.StreamSupport;

public class FulfillmentCenter {
    public String nazwa_magazynu;
    public List<Item> lista_produktow = new LinkedList();
    private Double max_pojemnosc_magazynu;

    public List<Item> getLista_produktow() {
        return lista_produktow;
    }

    public Double getMax_pojemnosc_magazynu() {
        return max_pojemnosc_magazynu;
    }

    public void setMax_pojemnosc_magazynu(Double max_pojemnosc_magazynu) {
        this.max_pojemnosc_magazynu = max_pojemnosc_magazynu;
    }

    FulfillmentCenter() {
        this.nazwa_magazynu = "";
    }

    FulfillmentCenter(String fulfillmentName) {
        this.nazwa_magazynu = fulfillmentName;
    }

    public void addProduct(Item o) {
        for (int i = 0; i < lista_produktow.size(); i++) {
            if (lista_produktow.get(i).getNazwa().equals(o)) {
                Integer tmp = lista_produktow.get(i).getIlosc() + o.getIlosc();
                lista_produktow.get(i).setIlosc(tmp);
            }
        }
        lista_produktow.add(o);
    }

    public void getProduct(Item o) {
        if (o.getIlosc() == 1) {
            lista_produktow.remove(o);
            return;
        }
        Integer tmp = o.getIlosc() - 1;
        o.setIlosc(tmp);
    }

    public void removeProduct(Item o) {
        lista_produktow.remove(o);
    }

    public void search(String text) {
        for (int i = 0; i < lista_produktow.size(); i++) {
            if (lista_produktow.get(i).getNazwa().equals(text)) {
                System.out.println("\nProdukt jest dostepny:");
                lista_produktow.get(i).print();
                return;
            }
        }
    }

    public void searchPartial(String text) {
        System.out.println("\nWyszukano:");
        for (int i = 0; i < lista_produktow.size(); i++) {
            if (lista_produktow.get(i).getNazwa().contains(text)) {
                lista_produktow.get(i).print();
            }
        }
    }

    public void countByCondition(ItemCondition o) {
        System.out.println("Produkty o wyszukiwanym stanie:");
        for (int i = 0; i < lista_produktow.size(); i++) {
            if (lista_produktow.get(i).getStan() == o) {
                lista_produktow.get(i).print();
            }
        }
    }

    public void summary() {
        System.out.println("\nWszystkie produkty:");
        for (int i = 0; i < lista_produktow.size(); i++) {
            lista_produktow.get(i).print();
        }
    }

    public void sort() {
        Collections.sort(lista_produktow);
        System.out.println(lista_produktow);

    }
    public void sortByAmount(){
        Collections.sort(lista_produktow, new ComparatorAmount());
        for (int i=0;i<lista_produktow.size();i++)
         System.out.println("\n"+lista_produktow.get(i).getNazwa()+"  "+lista_produktow.get(i).getIlosc());
    }
}
