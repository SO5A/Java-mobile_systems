import java.util.Comparator;


public class ComparatorByName implements Comparator<Item> {
        public int compare(Item o1, Item o2) {
            int compare = o1.getNazwa().compareTo(o2.getNazwa());

            if (compare < 0) {
                return -1;
            }
            else if (compare > 0) {
                return 1;
            }
            else {
                return 0;
            }

        }
}

