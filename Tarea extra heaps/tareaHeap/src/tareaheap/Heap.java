/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaheap;

/**
 *
 * @author Natalia
 */
public class Heap<T extends Comparable<T>> {

    private T[] arre;
    private int cont;

    public Heap() { ///////// es minHeap 
        cont = 0;
        arre = ((T[]) new Comparable[1000]);
    }

    public void inserta(T elem) {
        int pos = cont + 1;
        if (pos >= arre.length) {
            expande();
        }
        arre[pos] = elem;
        while (pos > 1 && arre[pos / 2].compareTo(elem) > 0) {
            arre[pos] = arre[pos / 2];
            arre[pos / 2] = elem;
            pos = pos >> 1;
        }
        cont++;
    }

    private void expande() {
        int n = arre.length;
        T[] nuevo = ((T[]) new Comparable[n * 2]);
        for (int i = 0; i < n; i++) {
            nuevo[i] = arre[i];
        }
        arre = nuevo;
    }

    public T getMin() {
        T res;
        if (cont > 0) {
            res = arre[1];
        } else {
            res = null;
        }
        return res;
    }

    public T eliminaMin() {
        T res;
        if (cont == 0) {
            res = null;
        } else {
            res = arre[1];
            arre[1] = null;
            Integer papa = 1;
            Integer menor = min(papa);
            while (menor != null) {
                arre[papa] = arre[menor];
                papa = menor;
                menor = min(menor);
            }

            if (papa < cont) {
                arre[papa] = arre[cont];
                while (papa > 1 && arre[papa / 2].compareTo(arre[papa]) > 0) {
                    T aux = arre[papa];
                    arre[papa] = arre[papa / 2];
                    arre[papa / 2] = aux;
                    papa = papa >> 1;
                }
            }

            arre[cont] = null;
            cont--;

        }
        return res;
    }

    private Integer min(Integer papa) {  // te regresa el índice del hijo menor
        Integer res = null;
        int izq = papa << 1;
        int der = izq + 1;
        if (der < arre.length) {
            if (arre[der] != null) {
                if (arre[izq].compareTo(arre[der]) < 0) {
                    res = izq;
                } else {
                    res = der;
                }
            } else {
                if (arre[izq] != null) {
                    res = izq;
                }
            }
        } else {
            if (izq < arre.length && arre[izq] != null) {
                res = izq;
            }
        }
        return res;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i <= cont; i++) {
            res.append(arre[i]).append("  ");
        }
        return res.toString();
    }
    
    public void heapSort(T[] arre) {
        int n=arre.length;
        for(int i=0;i<n;i++)
            inserta(arre[i]);
        for(int i=0;i<n;i++)
            eliminaMin();
    }

}
