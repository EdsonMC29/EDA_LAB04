    import java.util.*;
    public class Prueba{

        public static void main(String[] args) {		
            int tamano;
            
            Scanner teclado = new Scanner( System.in );
            System.out.print( "Introduzca el tamaño del arreglo: " );
            tamano = teclado.nextInt();
            
            int arreglo[] = generarPeorCaso(tamano);
            imprimirArreglo(arreglo);
            insertionSort(arreglo);
        }

        public static DoubleLinkedList generarPeorCaso(int t) {
            DoubleLinkedList lista = new DoubleLinkedList();
            for (int i=0; i<t; i++) {
                lista[i] = t-i;		
            }
            return lista;		
        }

        public static long insertionSort(int[] A) {
        int key;
        int i;
        long nano_startTime = System.nanoTime(); 
        for(int j=1; j<A.length; j=j+1) {
            key = A[j];
            //Insertar A[j] en la secuencia ordenada A[1..j-1]
            i = j-1;
            while(i>-1 && A[i]>key) {
                A[i+1] = A[i];
                i = i-1;
            }
            A[i+1] = key;
            //imprimirArreglo(A);
        }
        long nano_endTime = System.nanoTime();		
        return nano_endTime - nano_startTime;		
        }


    }