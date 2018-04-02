import java.util.List;

public class Item implements Comparable<Item> {
    private String nazwa;
    private ItemCondition stan;
    private Integer ilosc;
    private Double masa;

    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String toString() {
        return '{' +
                " " + nazwa + '\'' +
                ",  " + stan +
                ",  " + ilosc +
                ",  " + masa +
                '}';
    }

    public Item() {
        this.nazwa = "";
        this.stan = ItemCondition.NEW;
        this.masa = 1.0;
        this.ilosc = 1;
    }

    public Item(String nazwa, ItemCondition stan, Double masa, Integer ilosc) {
        this.nazwa = nazwa;
        this.stan = stan;
        this.masa = masa;
        this.ilosc = ilosc;
    }

    public void print() {
        System.out.println("  " + nazwa + "  " + stan + "  " + masa + "  " + ilosc);
    }

    public Double getMasa() {
        return masa;
    }

    public void setMasa(Double masa) {
        this.masa = masa;
    }

    public Integer getIlosc() {
        return ilosc;
    }

    public void setIlosc(Integer ilosc) {
        this.ilosc = ilosc;
    }

    public ItemCondition getStan() {
        return stan;
    }

    @Override
    public int compareTo(Item o) {
        return this.nazwa.compareTo(o.getNazwa());

    }
}
