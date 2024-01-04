/**
 * CircularLinkedList class represents a circular linked list with various operations.
 */
public class CircularLinkedList {
    // Head and tail pointers for the circular linked list.
    private Node head;
    private Node tail;

    // Size of the linked list.
    private int size;

    /**
     * Constructor to initialize an empty circular linked list.
     */
    public CircularLinkedList() {
        this.size = 0;
    }

    /**
     * Inserts a new node with the given value at the beginning of the linked list.
     *
     * @param value The value to be inserted.
     */
    public void insertAtFirst(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            // If the list is empty, set both head and tail to the new node.
            head = newNode;
            tail = head;
        } else {
            // Otherwise, insert the new node at the beginning and update the tail.
            Node lastNode = getNode(size - 1);
            lastNode.next = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Inserts a new node with the given value at the end of the linked list.
     *
     * @param value The value to be inserted.
     */
    public void insertAtLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            // If the list is empty, insert the node at the first position.
            insertAtFirst(value);
            return;
        } else {
            // Otherwise, insert the new node at the end and update the tail.
            Node lastNode = getNode(size - 1);
            lastNode.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts a new node with the given value at the specified index in the linked list.
     *
     * @param value The value to be inserted.
     * @param index The index at which the node should be inserted.
     */
    public void insertAtIndex(int value, int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid Index");
        } else if (index == 0) {
            // If index is 0, insert at the beginning.
            insertAtFirst(value);
            return;
        } else if (index == size - 1) {
            // If index is at the end, insert at the last position.
            insertAtLast(value);
            return;
        }

        // Insert the new node at the specified index and update the size.
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(value, prevNode.next);
        prevNode.next = newNode;
        size++;
    }

    /**
     * Deletes the first node in the linked list.
     *
     * @return The value of the deleted node.
     */
    public int deleteFirst() {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        } else if (head.next == head) {
            // If there is only one node, delete it and update head and tail.
            int deleteElement = head.value;
            head = null;
            tail = null;
            size--;
            return deleteElement;
        }

        // Delete the first node and update head, tail, and size.
        Node lastNode = getNode(size - 1);
        int deleteElement = head.value;
        lastNode.next = head.next;
        head = head.next;
        size--;
        return deleteElement;
    }

    /**
     * Deletes the last node in the linked list.
     *
     * @return The value of the deleted node.
     */
    public int deleteLast() {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        } else if (head.next == head) {
            // If there is only one node, delete it using deleteFirst.
            return deleteFirst();
        }

        // Delete the last node and update tail and size.
        Node prevOfLastNode = getNode(size - 2);
        int deleteElement = prevOfLastNode.next.value;
        prevOfLastNode.next = head;
        tail = prevOfLastNode;
        size--;
        return deleteElement;
    }

    /**
     * Deletes the node at the specified index in the linked list.
     *
     * @param index The index of the node to be deleted.
     * @return The value of the deleted node.
     */
    public int deleteAtIndex(int index) {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        } else if (head.next == head) {
            // If there is only one node, delete it using deleteFirst.
            return deleteFirst();
        } else if (index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid Index");
        } else if (index == 0) {
            // If index is 0, delete the first node.
            return deleteFirst();
        } else if (index == size - 1) {
            // If index is at the end, delete the last node.
            return deleteLast();
        }

        // Delete the node at the specified index and update size.
        Node prevNode = getNode(index - 1);
        int deleteElement = prevNode.next.value;
        prevNode.next = prevNode.next.next;
        size--;
        return deleteElement;
    }

    /**
     * Traverses and prints the elements of the linked list.
     */
    public void traverse() {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        }

        // Traverse the circular linked list and print each element.
        Node temp = head;
        do {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("END");
    }

    /**
     * Retrieves the node at the specified index in the linked list.
     *
     * @param index The index of the node to be retrieved.
     * @return The node at the specified index.
     */
    public Node getNode(int index) {
        if (head == null || index < 0 || index >= size) {
            throw new InvalidIndexException("Index is invalid");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Exception class for invalid index access.
     */
    private static class InvalidIndexException extends RuntimeException {
        public InvalidIndexException(String message) {
            super(message);
        }
    }

    /**
     * Exception class for attempting operations on an empty list.
     */
    private static class EmptyListException extends RuntimeException {
        public EmptyListException(String message) {
            super(message);
        }
    }

    /**
     * Node class represents a node in the circular linked list.
     */
    private static class Node {
        // Pointer to the next node in the list.
        Node next;

        // Value stored in the node.
        int value;

        /**
         * Constructor to initialize a node with a given value.
         *
         * @param value The value to be stored in the node.
         */
        public Node(int value) {
            this.value = value;
        }

        /**
         * Constructor to initialize a node with a given value and next node.
         *
         * @param value The value to be stored in the node.
         * @param next The next node in the list.
         */
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
