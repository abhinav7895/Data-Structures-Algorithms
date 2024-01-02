public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void insertAtFirst(int value) {
        if (head == null) {
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
        } else {
            Node newNode = new Node(value);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertAtLast(int value) {
        if (head == null) {
            insertAtFirst(value);
            return;
        }
        Node lastNode = getNode(size - 1);
        Node newNode = new Node(value);
        lastNode.next = newNode;
        newNode.prev = lastNode;
        tail = newNode;
        size++;
    }

    public void insertAtIndex(int value, int index) {
        if (index >= size || index < 0) {
            throw new InvalidIndexException("Invalid Index");
        } else if (index == 0) {
            insertAtFirst(value);
            return;
        } else if(index == size - 1) {
            insertAtLast(value);
            return;
        }

        Node prevNode = getNode(index - 1);
        Node newNode = new Node(value, prevNode, prevNode.next);

        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        size++;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        }
        int deleteElement = head.value;
        head = head.next;
        head.prev = null;
        size--;
        return deleteElement;
    }

    public int deleteLast() {
        if (head == null) {
            throw new EmptyListException("List is Empty");
        }
        Node prevNode = getNode(size - 2);
        int deleteElement = prevNode.next.value;
        prevNode.next = null;
        tail = prevNode;
        size--;
        return deleteElement;
    }

    public void traverseInReverseOrder() {
        if (head == null) {
            throw new EmptyListException("List is empty");
        }

        Node lastNode = getNode(size - 1);
        while (lastNode != null) {
            System.out.print(lastNode.value + " <- ");
            lastNode = lastNode.prev;
        }
        System.out.println("Start");
    }

    public void traverse() {
        if (head == null) {
            throw new EmptyListException("List is empty");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private Node getNode(int index) {
        if (head == null || index >= size || index < 0) {
            throw new InvalidIndexException("Invalid index");
        }
        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    private static class Node {
        private Node prev;
        private Node next;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node prev, Node next) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private static class InvalidIndexException extends RuntimeException {
        public InvalidIndexException(String message) {
            super(message);
        }
    }

    private static class EmptyListException extends RuntimeException {
        public EmptyListException(String message) {
            super(message);
        }
    }
}
