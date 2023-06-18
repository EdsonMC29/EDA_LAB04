package EDA_LAB04.Ejercicio1;

public class LinkedList<T> {
    private Node<T> head;  // Referencia al primer nodo de la lista
    private int size;      // Tamaño actual de la lista

    //Constructor
    public LinkedList() {
        head = null;  // Inicializa la lista vacía
        size = 0;
    }

    public int size() {
        return size;  // Devuelve el tamaño actual de la lista
    }

    public boolean isEmpty() {
        return size == 0;  // Verifica si la lista está vacía
    }

    public Node<T> get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNextNode();  // Avanza al siguiente nodo en la lista
        }
        return current;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;  // Si la lista está vacía, el nuevo nodo se convierte en la raíz
        } else {
            Node<T> lastNode = get(size - 1);  // Obtiene el último nodo en la lista
            lastNode.setNextNode(newNode);     // Establece el siguiente nodo del último nodo como el nuevo nodo
        }
        size++;  // Incrementa el tamaño de la lista
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (index == 0) {
            head = head.getNextNode();  // Si se elimina el primer nodo, actualiza la referencia a la raíz
        } else {
            Node<T> prevNode = get(index - 1);  // Obtiene el nodo anterior al que se eliminará
            Node<T> currentNode = prevNode.getNextNode();  // Obtiene el nodo que se eliminará
            prevNode.setNextNode(currentNode.getNextNode());  // Enlaza el nodo anterior al siguiente nodo
        }
        size--;  // Reduce el tamaño de la lista
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();//Construye cadenas
        //Apunta el primer nodo de la lista
        Node<T> current = head;
        //se recorre la lista enlazada nodo por nodo hasta que se alcance el final de la lista.
        while (current != null) {
            sb.append(current.getData());
            if (current.getNextNode() != null) {
                sb.append(", "); //Se agrega los datos de cada nodo al StringBuilder, separándolos por comas y espacios.
            }
            current = current.getNextNode();
        }
        return sb.toString();//Se obtenie la representación en forma de cadena construida.
    }
}
