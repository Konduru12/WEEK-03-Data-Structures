class Node{
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;
    Node next;
    Node prev;
    public Node(String title,String author,String genre,int bookId,boolean available){
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.bookId=bookId;
        this.available=available;
        this.next=null;
        this.prev=null;
    }
}
public class LibraryManagementSystem{
    Node head;
    Node tail;
    public void insertAtStart(String title,String author,String genre,int bookId,boolean available){
        Node newnode=new Node(title,author,genre,bookId,available);
        if (head==null){
            head=tail=newnode;
        }else{
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
        }
    }
    public void insertAtEnd(String title,String author,String genre,int bookId,boolean available){
        Node newnode=new Node(title,author,genre,bookId,available);
        if (head==null){
            head=tail=newnode;
        }else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
    }
    public void insertAtAny(int index,String title,String author,String genre,int bookId,boolean available){
        Node newnode=new Node(title,author,genre,bookId,available);
        if(index==0 || head==null){
            insertAtStart(title, author, genre, bookId, available);
            return;
        }
        Node temp=head;
        for(int i=0;i<index-1;i++){
            temp=temp.next;
        }
        newnode.next=temp.next;
        newnode.prev=temp;
        if(temp.next!=null){
            temp.next.prev=newnode;
        }else{
            tail=newnode;
        }
        temp.next=newnode;
    }
    public void removebyId(int bookId){
        Node temp=head;
        while(temp!=null){
            if(temp.bookId==bookId){
                if(temp==head){
                    head=head.next;
                    if(head!=null){
                        head.prev=null;
                    }else{
                        tail=null;
                    }
                }else if(temp==tail){
                    tail=tail.prev;
                    if(tail!=null){
                        tail.next=null;
                    }else{
                        head=null;
                    }
                }else{
                    temp.next.prev=temp.prev;
                    temp.prev.next=temp.next;
                }
                System.out.println("Book \"" + bookId + "\" is removed.");
                return;
            }
            temp=temp.next;
        }
    }   
    public void search(String title,String author){
        Node temp=head;
        boolean found=false;
        System.out.println("Search results:");
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title) || temp.author.equalsIgnoreCase(author)){
                System.out.println("Book found with title "+temp.title+" and author "+temp.author);
                
                return;
            }
            temp=temp.next;
        }
        if (!found){
            System.out.println("Book not found");
        }
    }
    public void update(String title,boolean newavailable){
        Node temp=head;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(title)){
                temp.available=newavailable;
                System.out.println("Availbe status updated for \"" + title + "\".");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Book not found");
    }
    public int count(){
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public void display(){
        Node temp=head;
        if(head==null){
            System.out.println("No books to display");
            return;
        }
        System.out.println("List of books:");
        while(temp!=null){
            System.out.println("Title: "+temp.title+", Author: "+temp.author+", Genre: "+ temp.genre+",BookID: "+temp.bookId+", Available: "+temp.available);
            temp=temp.next;
        }
        System.out.println();
    }
    public void displayreverse(){
        Node temp=tail;
        if(tail==null){
            System.out.println("No books");
        }
        System.out.println("List of books(reverse)");
        while(temp!=null){
            System.out.println("Title: "+temp.title+", Author: "+temp.author+", Genre: "+ temp.genre+",BookID: "+temp.bookId+", Available: "+temp.available);
            temp=temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        LibraryManagementSystem list=new LibraryManagementSystem();
        list.insertAtStart("My life","sasanka","Emotional",745,true);
        list.insertAtStart("The art of being human", "BHarath", "Normal", 2346,true);
        list.insertAtEnd("Wings", "Abhinaya", "normal", 7842, false);
        list.insertAtAny(2, "My love", "Shasank", "romantic", 486,true);
        list.search("My life", "sasanka");
        list.update("Wings",true);
        list.removebyId(7842);
        list.display();
        list.displayreverse();
        System.out.println("Total books in library: "+list.count());
    }
}

