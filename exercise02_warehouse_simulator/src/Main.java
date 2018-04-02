public class Main {

    public static void main(String[] args) {
        Item newItem = new Item("a",ItemCondition.NEW,2.5,3);
        Item newItem2 = new Item("b",ItemCondition.USED,2.0,3);
        Item newItem3 = new Item("c",ItemCondition.NEW,1.0,5);
        Item newItem4 = new Item("d",ItemCondition.NEW,5.0,8);
        Item newItem5 = new Item("e",ItemCondition.NEW,1.0,1);
        newItem.print();
        newItem2.print();
        FulfillmentCenter newmagazyn= new FulfillmentCenter("Magazyn mięsny");
        newmagazyn.addProduct(newItem5);
        newmagazyn.addProduct(newItem4);
        newmagazyn.addProduct(newItem);
        newmagazyn.search("nazwa");
        newmagazyn.addProduct(newItem2);
        newmagazyn.addProduct(newItem3);
        newmagazyn.summary();
        newmagazyn.removeProduct(newItem3);
        newmagazyn.getProduct(newItem);
        newmagazyn.searchPartial("b");
        newmagazyn.countByCondition(ItemCondition.NEW);
        newmagazyn.summary();
        newmagazyn.sort();
        newmagazyn.sortByAmount();


         FulfillmentCenterContiainer magazyny= new FulfillmentCenterContiainer();
       magazyny.addNewCenter("nowymagazyn",1000);
       magazyny.addCenter(newmagazyn,100);
        magazyny.findEmpty();
        magazyny.summary();
    }
}
