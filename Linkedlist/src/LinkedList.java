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
    public int deleteFirst() {
        // return -1, if no element is present
        if(head == null) return -1;

        // copy the element data
        int element = head.value;
        // move the head to next node
        head = head.next;
        size--;
        return  element;
    }

    public int deleteLast() {
        // return -1, if no element is present
        if (head == null) return  -1;
        if (size == 1) return deleteFirst();

        int element = tail.value;
        // get the previous node of the tail node:
        Node prevNode = getNode(size - 2);
        // point it to the null
        prevNode.next = null;

        // copy the element data
        tail = prevNode;
        size--;
        return  element;
    }

    public int deleteAtIndex(int index) {
        if (index < 0 || index >= size) return -1;

        if (index == 0) {
            return deleteFirst();
        } else if (index == size - 1) {
            return deleteLast();
        } else {
            Node prevNode = getNode(index - 1);
            int element = prevNode.next.value;
            prevNode.next = prevNode.next.next;
            size--;
            return element;
        }

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