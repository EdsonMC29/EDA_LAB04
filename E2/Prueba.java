import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import com.panayotis.gnuplot.JavaPlot;
import com.panayotis.gnuplot.plot.AbstractPlot;

public class Prueba {
    public static void main(String[] args) throws IOException {
        int tamano;

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduzca el tamaño máximo del último arreglo: ");
        tamano = teclado.nextInt();

        ArrayList<DoubleLinkedList> casos = new ArrayList<DoubleLinkedList>();
        String archivoInsercion = "insercion.txt";
        PrintWriter oS = new PrintWriter(archivoInsercion);

        for (int n = 1; n <= tamano; n++) {
            casos.add(generarPeorCaso(n));
        }

        Iterator<DoubleLinkedList> puntero = casos.iterator();
        while (puntero.hasNext()) {
            DoubleLinkedList lista = puntero.next();
            long tiempo = insertionSort(lista);
            oS.println(String.valueOf(tiempo));
        }

        oS.close();

        // plot "/path/to/insercion.txt" with lines
        JavaPlot p = new JavaPlot();
        p.addPlot("\"" + archivoInsercion + "\" with lines");
        p.plot();
    }

    public static DoubleLinkedList generarPeorCaso(int t) {
        DoubleLinkedList lista = new DoubleLinkedList();
        for (int i = t; i > 0; i--) {
            lista.addElem(i);
        }
        return lista;
    }

    public static long insertionSort(DoubleLinkedList lista) {
        Node<Integer> ptr = lista.ptr;
        long nano_startTime = System.nanoTime();
        while (ptr != null) {
            int key = ptr.data;
            Node<Integer> current = ptr;
            Node<Integer> prev = ptr.previousNode;
            while (prev != null && prev.data > key) {
                current.data = prev.data;
                current = prev;
                prev = prev.previousNode;
            }
            current.data = key;
            ptr = ptr.nextNode;
        }
        long nano_endTime = System.nanoTime();
        return nano_endTime - nano_startTime;
    }
}
