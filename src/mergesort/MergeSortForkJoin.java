/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mergesort;
 
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import static java.util.concurrent.ForkJoinTask.invokeAll;
import java.util.concurrent.RecursiveAction;
import static mergesort.MergeSort.mergeSort;

 public class MergeSortForkJoin { 


    public void sort(Integer[] a) {
        Integer[] helper = new Integer[a.length];
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(new MergeSortTask(a, helper, 0, a.length - 1));
    }


    private class MergeSortTask extends RecursiveAction {

        //private static final long serialVersionUID = -749935399568367268L;
        private final Integer[] a;
        private final Integer[] helper;
        private final int lo;
        private final int hi;

        public MergeSortTask(Integer[] a, Integer[] helper, int lo, int hi) {
            this.a = a;
            this.helper = helper;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        public void compute() {
            if (lo >= hi) {
                return;
            }

            int mid = (lo + hi) / 2;
            MergeSortTask left = new MergeSortTask(a, helper, lo, mid);
            MergeSortTask right = new MergeSortTask(a, helper, mid + 1, hi);
            invokeAll(left, right);

            merge(lo, mid, hi);
        }

        private void merge(int lo, int mid, int hi) {
            System.arraycopy(a, lo, helper, lo, hi + 1 - lo);

            int i = lo;
            int j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = helper[j++];
                } else if (j > hi) {
                    a[k] = helper[i++];
                } else if (helper[j] < helper[i]) {
                    a[k] = helper[j++];
                } else {
                    a[k] = helper[i++];
                }
            }
        }
    }

      /**     public static void main(String[] args) {
               
        Integer[] a = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("Lista desordenada:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        MergeSortForkJoin mergeSortForkJoin = new MergeSortForkJoin();
        mergeSortForkJoin.sort(a);
        System.out.println("Lista ordenada:");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    **/
}