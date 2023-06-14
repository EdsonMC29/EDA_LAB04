public class DoubleLinkedList {

    static Node ptr; // Primer elemento de la lista
    
    /**
     * Añadir elemento a la lista.
     * @param elem Elemento que sera añadido.
     */
    void addElem(int elem) {
        Node nuevo = new Node(); // Crear nuevo nodo

        if (ptr == null) { // Si la lista esta vacía
            nuevo.data = elem;
            ptr = nuevo;
        } else {
          // Si la lista no está vacía la recorremos hasta llegar al final, para agregar el nuevo elemento de último.
            Node ant = ptr;
            Node p = ptr.RLink;

            while (p != null) {
                ant = p;
                p = p.RLink;
            }
			
          /**
          * null <-|n|=|ant|-> null
          * =|ant|<-|nuevo|
          * -|nuevo|-> null
          * =|ant|=|nuevo|->null
          */
            if (p == null) {
                nuevo.num = elem;
                nuevo.LLink = ant;
                nuevo.RLink = null;
                ant.RLink = nuevo;
            }
        }
    }

    /**
     * Mostrar en consola los elementos de la lista.
     */
    void mostrarLista() {
        if (ptr == null) {
            System.out.println("No hay elementos en la lista");
        } else {
            Nodo p = ptr;
            while (p != null) {
                System.out.println(p.num);
            }
            p = p.RLink;
        }
    }
    
    /**
     * Buscar un elemento en la lista.
     * @param elem Elemento que sera buscado.
     * @return Falso si no fue encontrado. Verdadero si fue encontrado.
     */
    boolean buscarElem(int elem) {
        Node temp = ptr;
        while (temp != null) {
            if (temp.num == elem)
                return true;
            temp = temp.RLink;
        }
        
        return false;
    }
}