public class TwoLinkedList implements DirectionalList {
    private Node first;
    private Node last;

    public boolean isLastEmpty() { return last == null; }
    public boolean isFirstEmpty() { return first == null; }

    @Override
    public void addFirst(String val) {
        Node node = new Node(val);
        if (isFirstEmpty()) {
            last = node;
        }
            node.next = first;
            first = node;
    }

    @Override
    public void addLast(String val) {
        Node node = new Node(val);
        if (isLastEmpty()) {
            first = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }
        int size = 1;
        Node current = first;
        while (current.getNext() != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    @Override
    public void displayList() {
        System.out.println("TwoLinkedList");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    @Override
    public boolean remove(String val) {
        if (first.getVal().equals(val)) {
            if (first.getPrev() == null) {
                last = null;
                first = first.getNext();
            } else if (last.getNext() == null) {
                first = null;
                last = last.getPrev();
            } else if (first.getNext() != null) {
                first = first.getNext();
            } else {
                last = last.getPrev();
            }
            return true;
        }

        Node current = first.getNext();
        Node prev = first;
        Node next = last;

        while (current != null) {
            if (current.getVal().equals(val)) {
                prev.setNext(current.getNext());
                next.setPrev(current.getPrev());
                return true;
            } else {
                prev = current;
                current = current.getNext();
            }
        }
        return false;
    }

    public class Node {
        private String val;
        private Node next;
        private Node prev;

        public Node(String val) {
            this.val = val;
        }

        public void displayNode() {
            System.out.print(val + " ");
        }

        public String getVal() { return val; }

        public Node getNext() { return next; }

        public Node getPrev() { return prev; }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) { this.prev = prev; }
    }
}
