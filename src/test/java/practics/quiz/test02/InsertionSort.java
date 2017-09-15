package practics.quiz.test02;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Реализовать сортировку вставкой
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        // TODO реализовать метод
        for (int i = 0; i < arr.length; i++) {
            int inserted = arr[i];
            int j = i;
            while ((j > 0) && (arr[j-1] > inserted)) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = inserted;
        }
        //throw new UnsupportedOperationException("to do implementation");
    }

    @Test
    public void testInsertionSortEmptyArray() {
        int[] actual = {};
        int[] expected = {};
        insertionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortOneElement() {
        int[] actual = {1};
        int[] expected = {1};
        insertionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortThreeElement() {
        int[] actual = {3,2,1,};
        int[] expected = {1,2,3};
        insertionSort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertionSortTenElement() {
        int[] actual = {-7,6,8,5,4,9,0,3,2,10};
        int[] expected = {-7,0,2,3,4,5,6,8,9,10};
        insertionSort(actual);
        assertArrayEquals(expected, actual);
    }

}
