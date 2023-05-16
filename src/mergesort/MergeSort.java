/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mergesort;
 
import java.util.Random;
import java.util.Scanner;

 public class MergeSort {

  

    public static void mergeSort(int a[]) {
        int tmpArray[] = new int[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
    }

    public static void mergeSort(int a[], int tmpArray[], int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    public static void merge(int a[], int tmpArray[], int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] <= a[rightPos]) {
                tmpArray[tempPos++] = a[leftPos++];
            } else {
                tmpArray[tempPos++] = a[rightPos++];
            }
        }
        while (leftPos <= leftEnd) {
            tmpArray[tempPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tempPos++] = a[rightPos++];
        }
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }


}
