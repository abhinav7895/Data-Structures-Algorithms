public class LinkedList {
    private  Node head;
    private  Node tail;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insertAtHead(int value) {
        // if the head is null
        // else update the head with the new NODE
        if (head == null) {
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
        // increase the size
        size++;
    }

    public void insertAtLast(int value) {
        if (head == null) {
            insertAtHead(value);
            return;
        }

        // get the last node
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        // update the tailNode
        Node newNode = new Node(value);
        temp.next = newNode;
        tail = newNode;

        size++;

        /*
         *      Another way to directly update the last :
         *     tail.next = newNode;
         *     tail = newNode;
         * */
    }

    public void insertAtIndex(int index, int value) {
        if (index >= size || index < 0 || head == null) {
            System.out.println("Enter the valid index ⚠️");
            return;
        } else if (index == 0) {
            insertAtHead(value);
            return;
        } else if (index == size - 1) {
            insertAtLast(value);
            return;
        }

        Node node = getNode(index - 1);
        Node newNode = new Node(value, node.next);
        node.next = newNode;
        size++;
    }

    public Node getNode(int index) {
        if (head == null && index < size) return null;
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public void transverseOnLinkedList() {
        if(head == null) return;

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public  Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}