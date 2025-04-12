class MyHashMap {
    private static class Entry {
        int key, value;
        Entry next;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int SIZE = 10;
    Entry[] buckets;
    public MyHashMap() {
        buckets = new Entry[SIZE];
    }
    private int getIndex(int key) {
        return key % SIZE;
    }
    public void put(int key, int value) {
        int index = getIndex(key);
        Entry head = buckets[index];
        while (head != null) {
            if (head.key == key) {
                head.value = value; 
                return;
            }
            head = head.next;
        }
        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
    }
    public int get(int key) {
        int index = getIndex(key);
        Entry head = buckets[index];
        while (head != null) {
            if (head.key == key)
                return head.value;
            head = head.next;
        }
        return -1; 
    }
    public void remove(int key) {
        int index = getIndex(key);
        Entry head = buckets[index];
        Entry prev = null;
        while (head != null) {
            if (head.key == key) {
                if (prev == null)
                    buckets[index] = head.next;
                else
                    prev.next = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            Entry head = buckets[i];
            System.out.print("Bucket " + i + ": ");
            while (head != null) {
                System.out.print("[" + head.key + "=" + head.value + "] -> ");
                head = head.next;
            }
            System.out.println("null");
        }
    }
    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, 10);
        map.put(11, 20); 
        map.put(2, 30);
        System.out.println("Get key 1: " + map.get(1));
        System.out.println("Get key 11: " + map.get(11));
        map.remove(1);
        System.out.println("Get key 1 after deletion: " + map.get(1));
        map.printMap();
    }
}
