package Sort_3;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array) {
        //[0, array.length)需要合并排序的区间
        mergeSortHelper(array, 0, array.length);
    }

    public static void mergeSortHelper(int[] array, int left, int right) {
        //[left, right)
        if(left >= right || right - left == 1) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSortHelper(array, left, mid - 1);
        mergeSortHelper(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int length = right - left;
        int[] output = new int[length];
        int outputIndex = 0;
        int i = left;
        int j = right;

        while(i < mid && j < right) {
            if(array[i] <= array[j]) {
                output[outputIndex++] = array[i++];
            }else {
                output[outputIndex++] = array[j++];
            }
        }

        while(i < mid) {
            output[outputIndex++] = array[i++];
        }
        while(j < right) {
            output[outputIndex++] = array[j++];
        }

        for(int k = 0; k < length; k++) {
            array[left + k] = output[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 5, 2, 7, 3, 6, 8, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
