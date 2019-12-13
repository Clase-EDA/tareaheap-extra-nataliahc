/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaheap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import tareatries.MergeSort;
import tareatries.Trie;

/**
 *
 * @author Natalia
 */
public class TareaHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap heap = new Heap();
//        heap.inserta(-5);
//        heap.inserta(1);
//        heap.inserta(25);
//        heap.inserta(50);
//        heap.inserta(75);
//        heap.inserta(80);
//        heap.inserta(7000);
//        heap.inserta(5000);
//        heap.inserta(10);
//        heap.inserta(-30);
//        System.out.println(heap.toString());
//        
//        System.out.println(heap.eliminaMin());
//        System.out.println(heap.toString());
//        
//        Heap heap2=new Heap();
//        heap2.inserta(1);
//        heap2.inserta(12);
//        heap2.inserta(2);
//        heap2.inserta(13);
//        heap2.inserta(15);
//        heap2.inserta(23);
//        heap2.inserta(50);
//        heap2.inserta(16);
//        heap2.inserta(17);
//        heap2.inserta(18);
//        heap2.inserta(19);
//        heap2.inserta(60);
//        heap2.inserta(65);
//        System.out.println(heap2.toString());
//        heap2.eliminaMin();
//        System.out.println(heap2.toString());

        Character[] simbolos = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        Trie trie = new Trie(simbolos);

        Scanner sc = null;

        try {
            File file = new File("C:\\Users\\Natalia\\Documents\\ITAM\\Estructuras de Datos Avanzadas\\palabras.txt");
            sc = new Scanner(new FileReader(file));

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            System.exit(1);
        }

        String[] arre;
        int i;
        int promMerge = 0, promTrie = 0, promHeap = 0;
        long TInicio, tiempoTrie, tiempoMerge, tiempoHeap;

//        int cont = 0;
//        String palabra;
//        for (int j = 5000; j <= 50000; j = j + 5000) {
//            arre = new String[j];
//            i=0;
//            while (sc.hasNext() && cont<j) {
//                palabra=sc.nextLine();
//                if ((palabra != null) && (!palabra.equals("")) && (palabra.matches("^[a-zA-Z]*$"))) {
//                    arre[i] = palabra.toLowerCase();
//                    i++;
//                }
//                cont++;
//            }
//            System.out.println(cont);
//            
//            TInicio = System.currentTimeMillis();
//            MergeSort.mergeSort(arre);
//            tiempoMerge = System.currentTimeMillis() - TInicio;
//            System.out.println("MergeSort tardó " + tiempoMerge + " milisegundos con " + i + " entradas.");
//
//            TInicio = System.currentTimeMillis();
//            trie.insertaArre(arre);
//            trie.ordLex();
//            tiempoTrie = System.currentTimeMillis() - TInicio;
//            System.out.println("TrieSort tardó " + tiempoTrie + " milisegundos con " + i + " entradas.");
//
//            TInicio = System.currentTimeMillis();
//            heap.heapSort(arre);
//            tiempoHeap = System.currentTimeMillis() - TInicio;
//            System.out.println("HeapSort tardó " + tiempoHeap + " milisegundos con " + i + " entradas." + "\n");
//        }

        for (int j = 10000; j <= 30000; j = j + 10000) {
            arre = new String[j];
            i = 0;
            while (i < j) {
                String text = sc.nextLine();
                if ((text != null) && (!text.equals("")) && (text.matches("^[a-zA-Z]*$"))) {
                    arre[i] = text.toLowerCase();
                    i++;
                }
            }

            TInicio = System.currentTimeMillis();
            MergeSort.mergeSort(arre);
            tiempoMerge = System.currentTimeMillis() - TInicio;
            System.out.println("MergeSort tardó " + tiempoMerge + " milisegundos con " + i + " entradas.");

            TInicio = System.currentTimeMillis();
            trie.insertaArre(arre);
            trie.ordLex();
            tiempoTrie = System.currentTimeMillis() - TInicio;
            System.out.println("TrieSort tardó " + tiempoTrie + " milisegundos con " + i + " entradas.");

            TInicio = System.currentTimeMillis();
            heap.heapSort(arre);
            tiempoHeap = System.currentTimeMillis() - TInicio;
            System.out.println("HeapSort tardó " + tiempoHeap + " milisegundos con " + i + " entradas." + "\n");

            promMerge += tiempoMerge / (j / 5000);
            promTrie += tiempoTrie / (j / 5000);
            promHeap += tiempoHeap / (j / 5000);
        }
        System.out.println("Promedio MergeSort: " + promMerge / 6);
        System.out.println("Promedio TrieSort: " + promTrie / 6);
        System.out.println("Promedio HeapSort: " + promHeap / 6);
    }

}
