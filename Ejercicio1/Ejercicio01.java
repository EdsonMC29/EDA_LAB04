import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio01 {
    public static void main(String[] args) throws IOException {
        int tamano;
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el tamaño máximo del último arreglo: ");
        tamano = teclado.nextInt();
        List<LinkedList<Integer>> casos = new LinkedList<>(); // Lista de LinkedList para almacenar los casos

        String archivoInsercion = "insercion.txt";
        PrintWriter oS = new PrintWriter(new FileWriter(archivoInsercion)); // Objeto para escribir en el archivo de inserción

        // Generar peores casos y agregarlos a la lista
        for (int n = 1; n <= tamano; n++) {
            casos.add(generarPeorCaso(n)); // Genera y agrega un peor caso a la lista
        }

        Iterator<LinkedList<Integer>> puntero = casos.iterator(); // Iterador para recorrer la lista de casos
        while (puntero.hasNext()) {
            LinkedList<Integer> caso = puntero.next(); // Obtiene el siguiente caso
            oS.println(insertionSort(caso)); // Ordena el caso y lo escribe en el archivo
        }
        oS.close(); // Cierra el archivo

        // Plot del archivo de inserción
        JavaPlot p = new JavaPlot(); // Objeto para generar la gráfica
        p.addPlot("\"" + archivoInsercion + "\" with lines"); // Añade el archivo de inserción como una línea en la gráfica
        p.plot(); // Muestra la gráfica
    }

    // Genera un peor caso de ordenamiento en una LinkedList
    public static LinkedList<Integer> generarPeorCaso(int t) {
        LinkedList<Integer> aux = new LinkedList<>();
        for (int i = 0; i < t; i++) {
            aux.add(t - i); // Agrega los elementos en orden descendente
        }
        return aux;
    }

    // Ordena una LinkedList de menor a mayor utilizando Insertion Sort y devuelve el tiempo de ejecución
    public static long insertionSort(LinkedList<Integer> list) {
        int key;
        int i;
        long nano_startTime = System.nanoTime(); // Tiempo de inicio del algoritmo de ordenamiento
        for (int j = 1; j < list.size(); j = j + 1) {
            key = list.get(j); // Elemento actual a insertar en la posición correcta
            i = j - 1;
            while (i > -1 && list.get(i) > key) { // Desplaza los elementos mayores hacia la derecha
                list.set(i + 1, list.get(i));
                i = i - 1;
            }
            list.set(i + 1, key); // Inserta el elemento en la posición correcta
            System.out.println(list); // Imprime el estado actual de la lista en cada iteración
        }
        long nano_endTime = System.nanoTime(); // Tiempo de finalización del algoritmo de ordenamiento
        return nano_endTime - nano_startTime; // Devuelve el tiempo total de ejecución
    }
}
