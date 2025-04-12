public class InventoryManagementSystem {
    class Item{
        String itemName;
        int itemId;
        int quantity;
        int price;
        Item next;
        Item(String itemName, int itemId, int quantity, int price){
            this.itemName = itemName;
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }
    }
    Item head = null;
    public void insertatbeginning(String itemName, int itemId, int quantity, int price){
        Item i1 = new Item(itemName, itemId, quantity, price);
        if(head == null){
            head = i1;
        }
        else{
            i1.next = head;
            head = i1;
        }
    }
    public void insertatend(String itemName, int itemId, int quantity, int price){
        Item i1 = new Item(itemName, itemId, quantity, price);
        if(head == null){
            head = i1;
        }
        else{
            Item current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = i1;
        }
    }
    public void insertatSpecificPosition(int position, String itemName, int itemId, int quantity, int price){
        Item i1 = new Item(itemName, itemId, quantity, price);
        if(head == null){
            head = i1;
        }
        else{
            Item current = head;
            int i = 1;
            while(current.next != null && i < position - 1){
                current = current.next;
                i++;
            }
            i1.next = current.next;
            current.next = i1;
        }
    }
    public void delete(int itemId){
        if(head == null){
            System.out.println("List is empty");
        }
        else{
            Item current = head;
            if(head.itemId == itemId){
                head = head.next;
            }
            while(current.next != null && current.next.itemId != itemId){
                current = current.next;
            }
            if(current == null){
                System.out.println("Item ID is not found");
            }
            else{
                current.next = current.next.next;
            }
        }
    }
    public void search(String itemName) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Item current = head;
        boolean found = false;
        while (current != null) {
            if (current.itemName.equals(itemName)) {
                System.out.println("Item found: " + current.itemName +
                                   ", ID: " + current.itemId +
                                   ", Quantity: " + current.quantity +
                                   ", Price: " + current.price);
                found = true;
                break;
            }
            current = current.next;
        }
    
        if (!found) {
            System.out.println("Item not found");
        }
    }
    public void calculateTotalValue() {
        int totalValue = 0;
        Item current = head;
        while (current != null) {
            totalValue += current.price * current.quantity;
            current = current.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }
    public void sortInventory(String criteria, boolean ascending) {
        if (head == null || head.next == null) {
            return; // No need to sort
        }
        boolean swapped;
        do {
            swapped = false;
            Item current = head;
            while (current.next != null) {
                boolean shouldSwap = false;
                if (criteria.equalsIgnoreCase("name")) {
                    int cmp = current.itemName.compareToIgnoreCase(current.next.itemName);
                    shouldSwap = ascending ? cmp > 0 : cmp < 0;
                } else if (criteria.equalsIgnoreCase("price")) {
                    shouldSwap = ascending ? current.price > current.next.price : current.price < current.next.price;
                }
                if (shouldSwap) {
                    String tempName = current.itemName;
                    int tempId = current.itemId;
                    int tempQty = current.quantity;
                    int tempPrice = current.price;
    
                    current.itemName = current.next.itemName;
                    current.itemId = current.next.itemId;
                    current.quantity = current.next.quantity;
                    current.price = current.next.price;
    
                    current.next.itemName = tempName;
                    current.next.itemId = tempId;
                    current.next.quantity = tempQty;
                    current.next.price = tempPrice;
    
                    swapped = true;
                }
    
                current = current.next;
            }
        } while (swapped);
    }
    public void sortAscending (boolean ascending) {
        if (head == null || head.next == null) {
        return;
        }
        boolean swapped;
        do {
        swapped = false;
        Item ptr1 = head;
        Item ptr2 = head.next;
        while (ptr2 != null) {
        boolean shouldSwap = ascending? ptr1.price > ptr2.price:ptr2.price > ptr1.price;
        if (shouldSwap) {
        
        String tempName = ptr1.itemName;
        int tempId= ptr1.itemId;
        int tempquantity =  ptr1.quantity;
        int tempprice = ptr1.price;
        ptr1.itemName = ptr2.itemName;
        ptr1.itemId = ptr2.itemId;
        ptr1.quantity = ptr2.quantity;
        ptr1.price = ptr2.price;
        ptr2.itemName = tempName;
        ptr2.itemId = tempId;
        ptr2.quantity = tempquantity;
        ptr2.price = tempprice;
        swapped=true;
        }
        ptr1 = ptr2;
        ptr2 = ptr2.next;
        }
        
    }while (swapped);
    }
    public void display(){
        Item current = head;
        while(current != null){
            System.out.println("Item name: " + current.itemName + " Item ID: " + current.itemId + " Quantity: " + current.quantity + " Price: " + current.price );
            current = current.next;
        }
    }
    public static void main(String[] args){
        InventoryManagementSystem item = new InventoryManagementSystem();
        item.insertatbeginning("Ice cream", 123, 2, 250);
        System.out.println("Item node added successfully at the beginning.");
        item.insertatend("Chocolates", 234, 3, 100);
        System.out.println("Item node is added successfully at the end.");
        item.insertatSpecificPosition(2, "Fan", 980, 2, 230);
        System.out.println("Item node is added successfully at desired position.");
        item.delete(234);
        System.out.println("Item node deleted successfully");
        item.search("Chocolate");
        item.search("Fan");
        item.display();
        item.calculateTotalValue();
        item.sortAscending(false);
        item.display();
    }
}

