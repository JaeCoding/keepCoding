package com.jaecoding.keep.coding.algorithfasdasd.basic.sort;

/**
 * practice
 *
 * @author Jae
 * @date 2019/12/15
 * @since 1.8
 */
public class HeapSortPractice {


    public static void main(String[] args) {
        int[] ints = {1, 8, 4,7,6,9,2,3,5};

        new HeapSortPractice().heapSort(ints);

        System.out.println(ints);
    }

    private void exchange(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }

    public void heapSort(int[] array) {

        for (int i = array.length - 1; i >= 0; i--) {
            adjust(array, i);
            exchange(array,0, i);
        }

    }

    private void adjust(int[] array, int range) {
        for (int i = range; i > 0; i--) {
            // currant > father
            if (array[i] > array[(i - 1) / 2]) {
                exchange(array, i, (i - 1) / 2);
            }
        }
    }
}
