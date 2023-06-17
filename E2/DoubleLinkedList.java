class DoubleLinkedList {
    Node<Integer> ptr;

    public DoubleLinkedList() {
        ptr = null;
    }

    void addElem(int elem) {
        Node<Integer> nuevo = new Node<>(elem);
        if (ptr == null) {
            ptr = nuevo;
        } else {
            Node<Integer> p = ptr;
            while (p.nextNode != null) {
                p = p.nextNode;
            }
            p.nextNode = nuevo;
            nuevo.previousNode = p;
        }
    }
}