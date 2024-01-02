public class Main {
    public static void main(String[] args) {
        /*
        SinglyLinkedList ll = new SinglyLinkedList();
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
         */

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtFirst(12);
        dll.insertAtFirst(13);
        dll.insertAtFirst(14);
        dll.insertAtFirst(15);
        dll.traverse();
        dll.insertAtLast(3);
        dll.insertAtLast(322);
        dll.traverse();

        dll.insertAtIndex(200, 2);
        dll.insertAtIndex(190, 5);
        dll.traverse();
        dll.deleteFirst();
        dll.deleteFirst();
        dll.deleteFirst();
        dll.traverse();
        dll.deleteLast();
        dll.deleteLast();
        dll.traverse();
        dll.traverseInReverseOrder();
    }
}
