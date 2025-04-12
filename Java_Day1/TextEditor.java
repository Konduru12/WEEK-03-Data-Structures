class TextStateNode {
    String content;
    TextStateNode prev, next;

    public TextStateNode(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
public class TextEditor {
    private TextStateNode head, current;
    private int size = 0;
    private final int MAX_HISTORY = 10;
    public void addState(String newText) {
        TextStateNode newNode = new TextStateNode(newText);
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }
        if (current == null) {
            head = newNode;
        } else {
            current.next = newNode;
            newNode.prev = current;
        }
        current = newNode;
        size++;
        while (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed.");
        } else {
            System.out.println("No more undo steps available.");
        }
    }
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed.");
        } else {
            System.out.println("No more redo steps available.");
        }
    }
    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("Text is empty.");
        }
    }
    public void printHistory() {
        TextStateNode temp = head;
        System.out.print("Text History: ");
        while (temp != null) {
            System.out.print("[" + temp.content + "] ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("Hello Abhinaya");
        editor.addState("Hello Abhinaya!");
        editor.addState("Hello Abhinaya! This is a test.");
        editor.showCurrentState(); 
        editor.undo();
        editor.showCurrentState(); 
        editor.undo();
        editor.showCurrentState(); 
        editor.redo();
        editor.showCurrentState(); 
        editor.addState("New branch after undo"); 
        editor.showCurrentState();

        editor.printHistory(); 
    }
}
