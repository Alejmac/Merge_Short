/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package mergesort;
 
import java.util.Random;
import java.util.Scanner;
import static mergesort.MergeSort.mergeSort;


 public class Main {

     
     
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese el tamaño del arreglo: ");
        int size = scanner.nextInt();

        int[] a =  new int[size];
        Integer[] b = convertirIntArray(a);
       // System.out.println(" el arreglo b es " + b);
        
        System.out.println("Lista desordenada:");
        for (int i = 0; i < size; i++) {
            a[i] = random.nextInt(100); // Generar número aleatorio sin límite superior
                    
        }
        
        // Imprimir el arreglo
        System.out.print("El arreglo es: [");
        for (int i = 0; i < size; i++) {
            System.out.print(a[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
          System.out.println();
          MergeSortForkJoin  mergeSortForkJoin = new  MergeSortForkJoin();
          MergeSort mergesort = new MergeSort(); 
          
        mergeSortForkJoin.sort(b);   
        mergeSort(a);
        
        System.out.println("Lista ordenada a :");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n\n\n");
        System.out.println("Lista ordenada b:");
        
         for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
            
        }
         System.out.println("\n\n\n");
    }

    private static Integer[] convertirIntArray(int[] a) {
       
   Integer[] arrayInteger = new Integer[a.length];       
          for (int i = 0; i < a.length; i++) {
        arrayInteger[i] = Integer.valueOf(a[i]);
    }
    return arrayInteger;
    }
      
}