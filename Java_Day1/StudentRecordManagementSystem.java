public class StudentRecordManagementSystem{
    class Student{
        int RollNumber;
        String name;
        int age;
        double grade;
        Student next;
        Student(int RollNumber, String name, int age, double grade){
            this.RollNumber = RollNumber;
            this.name = name;
            this.age = age;
            this.grade = grade;
        }
    }
    Student head = null;
    public void insertatbeginning(int RollNumber, String name, int age, double grade){
        Student s1 = new Student(RollNumber, name, age, grade);
        if(head == null){
            head = s1;
        }
        else{
            s1.next = head;
            head = s1;
        }
        }
    public void insertatend(int RollNumber, String name, int age, double grade){
        Student s1 = new Student(RollNumber, name, age, grade);
        if(head == null){
            head = s1;
        }
        else{
            Student current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = s1;
        }
    }
    public void insertatSpecificPosition(int position, int RollNumber, String name, int age, double grade){
        Student s1 = new Student(RollNumber, name, age, grade);
        if(head == null){
            head = s1;
        }
        else{
            Student current = head;
            int i = 1;
            while(current != null && i < position - 1){
                current = current.next;
                i++;
            }
            s1.next = current.next;
            current.next = s1;
        }
    }
    @SuppressWarnings("unused")
    public void delete(int RollNumber){
        if(head == null){
            System.out.println("List is empty");
        }
        if(head.RollNumber == RollNumber){
            head = head.next;
        }
        Student current = head;
    
        while(current.next != null && current.next.RollNumber != RollNumber){
            current = current.next;
        }
        if(current == null){
            System.out.println("Roll Number is not found");
        }
        else{
            current.next = current.next.next;
            System.out.println("Student node deleted Successfully");
        }
    }
    public void search(int RollNumber){
        if(head == null){
            System.out.println("List is empty");
        }
        Student current = head;
        while(current != head){
            if(current.RollNumber == RollNumber){
                System.out.println("Roll Number found");
                return;
            }
            current = current.next;
        }
        System.out.println("Roll number not found");
    }
    public void update(int RollNumber, double grade){
        Student current = head;
        while(current != null){
            if(current.RollNumber == RollNumber){
                current.grade = grade;
                break;
            }
            current = current.next;
        }
    }
    public void display(){
        Student current = head;
        while(current != null){
            System.out.println(" Roll Number: " + current.RollNumber + " Name: " + current.name + " Age: " + current.age + " Grade: " + current.grade);
            current = current.next;
        }
    }
    public static void main(String[] args){
        StudentRecordManagementSystem data = new StudentRecordManagementSystem();
        data.insertatbeginning(123," Abhinaya ", 21, 10);
        data.insertatend(234, "Sasanka", 20, 7);
        data.insertatSpecificPosition(2, 420, "Bharath", 21, 5);
        data.delete(420);
        data.search(123);
        data.update(234, 9);
        data.display();
    }
}

