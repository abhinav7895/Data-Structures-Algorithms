/**
 * DoublyLinkedList class represents a doubly linked list with various operations.
 */
public class DoublyLinkedList {
    private Node head; // Head of the doubly linked list.
    private Node tail; // Tail of the doubly linked list.
    private int size;  // Size of the doubly linked list.

    /**
     * Constructor to initialize an empty doubly linked list.
     */
    public DoublyLinkedList() {
        this.size = 0;
    }

    /**
     * Inserts a new node with the given value at the beginning of the linked list.
     *
     * @param value The value to be inserted.
     */
    public void insertAtFirst(int value) {
        if (head == null) {
            // If the list is empty, create a new node and set it as both head and tail.
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        } else {
            // Otherwise, insert a new node at the beginning and update the head.
            Node newNode = new Node(value);
            head.prev = newNode;
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
        if (head == null) {
            // If the list is empty, insert the node at the first position.
            insertAtFirst(value);
            return;
        }
        // Otherwise, insert a new node at the end and update the tail.
        Node lastNode = getNode(size - 1);
        Node newNode = new Node(value);
        lastNode.next = newNode;
        newNode.prev = lastNode;
        tail = newNode;
        size++;
    }

    /**
     * Inserts a new node with the given value at the specified index in the linked list.
     *
     * @param value The value to be inserted.
     * @param index The index at which the node should be inserted.
     */
    public void insertAtIndex(int value, int index) {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Invalid Index");
        } else if (index == 0) {
            // If index is 0, insert at the beginning.
            insertAtFirst(value);
            return;
        } else if(index == size - 1) {
            // If index is at the end, insert at the last position.
            insertAtLast(value);
            return;
        }

        // Insert the new node at the specified index and update the size.
        Node prevNode = getNode(index - 1);
        Node newNode = new Node(value, prevNode, prevNode.next);
        prevNode.next.prev = newNode;
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
        }
        int deleteElement = head.value;
        if (head.next == null) {
            // If there is only one node, delete it and update head and tail.
            head = null;
            tail = null;
        } else {
            // Delete the first node and update head and its previous pointer.
            head = head.next;
            head.prev = null;
        }
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
        } else if (head.next == null) {
            // If there is only one node, delete it using deleteFirst.
            return deleteFirst();
        }
        // Delete the last node and update tail and size.
        Node prevNode = getNode(size - 2);
        int deleteElement = prevNode.next.value;
        prevNode.next = null;
        tail = prevNode;

        // Update head if size is reduced to 1.
        if(size == 1) {
            head = tail;
        }
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
        if(index >= size || index < 0) {
            throw new InvalidIndexException("Invalid Index");
        } else if(head == null) {
            throw new EmptyListException("List is Empty");
        } else if (index == 0) {
            // If index is 0, delete the first node.
            return deleteFirst();
        } else if(index == size - 1) {
            // If index is at the end, delete the last node.
            return deleteLast();
        }

        // Delete the node at the specified index and update size.
        Node prevNode = getNode(index - 1);
        int deleteElement = prevNode.next.value;
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;
        size--;
        return deleteElement;
    }

    /**
     * Traverses and prints the elements of the linked list in reverse order.
     */
    public void traverseInReverseOrder() {
        if (head == null) {
            throw new EmptyListException("List is empty");
        }

        // Traverse the linked list in reverse order and print each element.
        Node lastNode = getNode(size - 1);
        while (lastNode != null) {
            System.out.print(lastNode.value + " <- ");
            lastNode = lastNode.prev;
        }
        System.out.println("Start");
    }

    /**
     * Traverses and prints the elements of the linked list.
     */
    public void traverse() {
        if (head == null) {
            throw new EmptyListException("List is empty");
        }

        // Traverse the linked list and print each element.
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    /**
     * Retrieves the node at the specified index in the linked list.
     *
     * @param index The index of the node to be retrieved.
     * @return The node at the specified index.
     */
    private Node getNode(int index) {
        if (head == null || index < 0 || index >= size) {
            throw new InvalidIndexException("Invalid index");
        }

        Node temp;
        int middle = size / 2;

        if (index <= middle) {
            temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

        return temp;
    }

    /**
     * Node class represents a node in the doubly linked list.
     */
    private static class Node {
        private Node prev;  // Pointer to the previous node in the list.
        private Node next;  // Pointer to the next node in the list.
        private int value;   // Value stored in the node.

        /**
         * Constructor to initialize a node with a given value.
         *
         * @param value The value to be stored in the node.
         */
        public Node(int value) {
            this.value = value;
        }

        /**
         * Constructor to initialize a node with a given value, previous, and next nodes.
         *
         * @param value The value to be stored in the node.
         * @param prev The previous node in the list.
         * @param next The next node in the list.
         */
        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
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
}
