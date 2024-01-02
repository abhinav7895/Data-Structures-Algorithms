public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtHead(12);
        ll.insertAtHead(34);
        ll.insertAtLast(123);
        ll.insertAtLast(1243);
        ll.insertAtHead(0);
        ll.transverseOnLinkedList();
        ll.deleteAtIndex(2);
        ll.deleteAtIndex(2);
        ll.deleteAtIndex(1);
        ll.deleteAtIndex(1);
        ll.deleteAtIndex(0);
        ll.transverseOnLinkedList();
    }
}
