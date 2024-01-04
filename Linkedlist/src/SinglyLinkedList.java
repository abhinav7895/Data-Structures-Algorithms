/**
 * SinglyLinkedList class represents a singly linked list with various operations.
 */
public class SinglyLinkedList {
    private Node head; // Head of the singly linked list.
    private Node tail; // Tail of the singly linked list.
    private int size;  // Size of the singly linked list.

    /**
     * Constructor to initialize an empty singly linked list.
     */
    public SinglyLinkedList() {
        this.size = 0;
    }

    /**
     * Inserts a new node with the given value at the beginning of the linked list.
     *
     * @param value The value to be inserted.
     */
    public void insertAtHead(int value) {
        // If the head is null, create a new node and set it as both head and tail.
        // Otherwise, insert a new node at the beginning and update the head.
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        // Increase the size.
        size++;
    }

    /**
     * Inserts a new node with the given value at the end of the linked list.
     *
     * @param value The value to be inserted.
     */
    public void insertAtLast(int value) {
        // If the list is empty, insert the node at the first position.
        // Otherwise, insert a new node at the end and update the tail.
        if (head == null) {
            insertAtHead(value);
            return;
        }

        // Get the last node and update the tail.
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(value);
        temp.next = newNode;
        tail = newNode;

        size++;
    }

    /**
     * Inserts a new node with the given value at the specified index in the linked list.
     *
     * @param index The index at which the node should be inserted.
     * @param value The value to be inserted.
     */
    public void insertAtIndex(int index, int value) {
        // Check for valid index range and non-empty list.
        if (index >= size || index < 0 || head == null) {
            System.out.println("Enter the valid index ⚠️");
            return;
        } else if (index == 0) {
            // If index is 0, insert at the beginning.
            insertAtHead(value);
            return;
        } else if (index == size - 1) {
            // If index is at the end, insert at the last position.
            insertAtLast(value);
            return;
        }

        // Insert the new node at the specified index and update the size.
        Node node = getNode(index - 1);
        Node newNode = new Node(value, node.next);
        node.next = newNode;
        size++;
    }

    /**
     * Deletes the first node in the linked list.
     *
     * @return The value of the deleted node.
     */
    public int deleteFirst() {
        // Return -1 if no element is present.
        if (head == null) return -1;

        // Copy the element data and move the head to the next node.
        int element = head.value;
        head = head.next;
        size--;
        return element;
    }

    /**
     * Deletes the last node in the linked list.
     *
     * @return The value of the deleted node.
     */
    public int deleteLast() {
        // Return -1 if no element is present.
        if (head == null) return -1;
        if (size == 1) return deleteFirst();

        // Copy the element data and update tail and size.
        int element = tail.value;
        Node prevNode = getNode(size - 2);
        prevNode.next = null;
        tail = prevNode;

        // Update head if size is reduced to 1.
        if (size == 1) {
            head = tail;
        }
        size--;
        return element;
    }

    /**
     * Deletes the node at the specified index in the linked list.
     *
     * @param index The index of the node to be deleted.
     * @return The value of the deleted node.
     */
    public int deleteAtIndex(int index) {
        // Return -1 for invalid index or empty list.
        if (index < 0 || index >= size) return -1;
        if (head == null) return -1;

        if (index == 0) {
            // If index is 0, delete the first node.
            return deleteFirst();
        } else if (index == size - 1) {
            // If index is at the end, delete the last node.
            return deleteLast();
        } else {
            // Delete the node at the specified index and update size.
            Node prevNode = getNode(index - 1);
            int element = prevNode.next.value;
            prevNode.next = prevNode.next.next;
            size--;
            return element;
        }
    }

    /**
     * Retrieves the node at the specified index in the linked list.
     *
     * @param index The index of the node to be retrieved.
     * @return The node at the specified index.
     */
    public Node getNode(int index) {
        // Return null for invalid index or empty list.
        if (head == null && index < size) return null;

        // Traverse the list to find the node at the specified index.
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    /**
     * Traverses and prints the elements of the linked list.
     */
    public void transverseOnLinkedList() {
        // Return if the list is empty.
        if (head == null) return;

        // Traverse the linked list and print each element.
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    /**
     * Node class represents a node in the singly linked list.
     */
    private class Node {
        private int value;   // Value stored in the node.
        private Node next;   // Pointer to the next node in the list.

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
