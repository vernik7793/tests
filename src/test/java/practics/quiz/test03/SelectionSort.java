package practics.quiz.test03;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Реализовать сортировку выбором
 */
public class SelectionSort {

    public static void selectionSort(int[] arr) {
        // TODO реализовать метод
        for (int i = arr.length - 1; i > 0; i--) {
            int max = arr[0];
            int indMax = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    indMax = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[indMax];
            arr[indMax] = tmp;
        }
        //throw new UnsupportedOperationException("to do implementation");
    }

    @Test
    public void testSelectionSortEmptyArray() {
        int[] actual = {};
        int[] expected = {};
        selectionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectionSortOneElement() {
        int[] actual = {1};
        int[] expected = {1};
        selectionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectionSortThreeElement() {
        int[] actual = {3,2,1,};
        int[] expected = {1,2,3};
        selectionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSelectionSortTenElement() {
        int[] actual = {-7,6,8,5,4,9,0,3,2,10};
        int[] expected = {-7,0,2,3,4,5,6,8,9,10};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}
