import java.util.Map;
import java.util.TreeMap;

public class FulfillmentCenterContiainer {
Map<String,FulfillmentCenter>magazyny =new TreeMap<>();

public void addCenter(FulfillmentCenter tmp,double number){
    for(Map.Entry<String,FulfillmentCenter> entry : magazyny.entrySet()){
        if(tmp.nazwa_magazynu.equals(entry.getKey())){
            return;
        }
    }
    magazyny.put(tmp.nazwa_magazynu,tmp);
    tmp.setMax_pojemnosc_magazynu(number);
}
public void addNewCenter(String text, double number){
   FulfillmentCenter newFulfillment = new FulfillmentCenter();
   newFulfillment.setMax_pojemnosc_magazynu(number);
    magazyny.put(text,newFulfillment);
}
public void removeCenter(String fulfillmentName){
    magazyny.remove(fulfillmentName);
}
public void findEmpty(){
    for(Map.Entry<String,FulfillmentCenter> entry : magazyny.entrySet()){
        if(entry.getValue().getLista_produktow().size()==0){
            System.out.println("\nMagazyn "+entry.getKey()+" jest pusty.");
        }
    }
}
public void summary(){
    double summ =0;
    for(Map.Entry<String,FulfillmentCenter> entry : magazyny.entrySet()){
        for(int i=0;i<entry.getValue().getLista_produktow().size();i++ ) {
           summ+= entry.getValue().getLista_produktow().get(i).getMasa()*
                   entry.getValue().getLista_produktow().get(i).getIlosc();
        }
        System.out.println(entry.getKey()+" jest w "+summ/entry.getValue().getMax_pojemnosc_magazynu()*100+"% zapelmiony.");
        summ = 0;
    }

}

}
