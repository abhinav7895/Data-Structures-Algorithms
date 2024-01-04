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
//
//        DoublyLinkedList dll = new DoublyLinkedList();
//        dll.insertAtFirst(12);
//        dll.insertAtFirst(13);
//        dll.insertAtFirst(14);
//        dll.insertAtFirst(15);
//        dll.insertAtLast(3);
//        dll.insertAtLast(322);
//
//        dll.insertAtIndex(200, 2);
//        dll.insertAtIndex(190, 5);
//        dll.deleteFirst();
//        dll.traverse();
//        dll.deleteAtIndex(2);
//        dll.deleteAtIndex(2);
//        dll.traverse();
//        dll.traverseInReverseOrder();

        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtFirst(12);
        cll.insertAtFirst(13);
        cll.insertAtFirst(14);
        cll.insertAtLast(20);
        cll.insertAtLast(21);
        cll.insertAtLast(22);
        cll.insertAtLast(23);
        cll.insertAtFirst(24);
        cll.traverse();
        cll.insertAtIndex(100, 3);
        cll.traverse();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.deleteFirst();
        cll.traverse();
        cll.deleteLast();
        cll.deleteLast();
        cll.deleteLast();
        cll.deleteLast();
        cll.deleteLast();
        cll.traverse();
    }
}
