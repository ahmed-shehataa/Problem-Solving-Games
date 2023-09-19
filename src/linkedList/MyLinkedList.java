package linkedList;

public class MyLinkedList<T> {


    private int size = 0;
    private Node<T> head;


    public MyLinkedList() {

    }

    public MyLinkedList(Node head) {
        this.head = head;
    }

    public void add(Node<T> node) {
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }
        size++;
    }

    public void remove(Node nodeToRemove) {
        if (head == null || nodeToRemove == null) {
            return;
        }

        // Check if the node to remove is the head node
        if (head == nodeToRemove) {
            head = head.getNext();
            size--;
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            // Check if the next node is the one to remove
            if (current.getNext() == nodeToRemove) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }

    }


    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println("print ->" + currentNode.getValue());
            currentNode = currentNode.getNext();
        }

    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }
}