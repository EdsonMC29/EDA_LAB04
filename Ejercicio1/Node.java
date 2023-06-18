package EDA_LAB04.Ejercicio1;
import javax.naming.NotContextException;

public class Node<T>{ //Definimos nuestra clase Nodo como generica con parametro T.

    private T data; //Almacena el dato del nodo.
    private Node<T> nextNode; // Siguiente nodo.

    //Se inicia el dato con el valor proporcionado y node como null.
    public Node (T data){
        this.data = data;
        nextNode = null;
    }       
    // Creamo nuestros metodos Getters and Setters
    public T getData(){
        return data;//Retrona el nodo con el dato proporcionado.
    }
    public void setData(){
        this.data = data;//Se establece el valor proporcionado.
    }
    public Node<T> getNextNode(){
        return nextNode;//Retornamos la referencia al siguiente nodo
    }
    public void setNextNode(Node<T> nextNode){
        this.nextNode = nextNode;//Siguiente nodo con el valor proporcionado.
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.data.toString(); //Devuelve la cadena con el dato proporcionado.
    }
}