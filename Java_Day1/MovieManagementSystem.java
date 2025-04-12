class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    int rating;
    MovieNode next;
    MovieNode prev;
    public MovieNode(String title, String director, int yearOfRelease, int rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
public class MovieManagementSystem {
    MovieNode head;
    MovieNode tail;
    public void insertAtStart(String title, String director, int yearOfRelease, int rating) {
        MovieNode newnode = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newnode;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }
    public void insertAtEnd(String title, String director, int yearOfRelease, int rating) {
        MovieNode newnode = new MovieNode(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    public void insertAtAny(int index, String title, String director, int yearOfRelease, int rating) {
        MovieNode newnode = new MovieNode(title, director, yearOfRelease, rating);
        if (index == 0 || head == null) {
            insertAtStart(title, director, yearOfRelease, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        newnode.next = temp.next;
        newnode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newnode;
        } else {
            tail = newnode; 
        }

        temp.next = newnode;
    }
    public void RemovebyTitle(String title) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) {
                        head.prev = null;
                    } else {
                        tail = null;
                    }
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Movie \"" + title + "\" is removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie \"" + title + "\" not found.");
    }
    public void search(String director, int rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if ((director != null && temp.director.equalsIgnoreCase(director)) || (temp.rating == rating)) {
                System.out.println("Found: Title: " + temp.title + ", Director: " + temp.director +
                        ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No matching movie found.");
        }
    }
    public void update(String title, int newrating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newrating;
                System.out.println("Rating updated for \"" + title + "\".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
    public void display() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies to display.");
            return;
        }
        System.out.println("List of movies:");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.next;
        }
        System.out.println();
    }
    public void displayreverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies to display in reverse.");
            return;
        }
        System.out.println("Movies (Reverse):");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.yearOfRelease + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MovieManagementSystem list = new MovieManagementSystem();
        list.insertAtStart("RRR", "Rajamouli", 2021, 4);
        list.insertAtStart("KGF", "Neel", 2022, 5);
        list.insertAtEnd("SVSC", "Mahesh", 2013, 4);
        list.insertAtAny(3, "Godavari", "Sekhar Kamula", 2004, 10);
        list.insertAtAny(1, "KGF 2", "Prasanth", 2023, 5);
        list.RemovebyTitle("SVSC");
        list.search("Neel", 0);
        list.update("RRR", 8);
        list.display();
        list.displayreverse();
    }
}
