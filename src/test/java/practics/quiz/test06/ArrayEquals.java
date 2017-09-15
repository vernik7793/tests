package practics.quiz.test06;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Реализовать метод сравнения элеметнов двух массивой
 * true - если массивы содержат одинаковые элементы
 */
public class ArrayEquals {

    public boolean arrayEquals(int[] arr1, int[] arr2) {
        // TODO реализовать метод
        throw new UnsupportedOperationException("to do implementation");
    }

    @Test
    public void testEqualsIntOneElement() {
        int[] arr1 = {1};
        int[] arr2 = {1};
        assertTrue(arrayEquals(arr1, arr2));
    }

    @Test
    public void testEqualsIntEightElement() {
        int[] arr1 = {1, 7, 0, 21, 12, -8, -5, 19};
        int[] arr2 = {7, 1, 19, -8, 12, 21, -5, 0};
        assertTrue(arrayEquals(arr1, arr2));
    }

    @Test
    public void testEqualsIntEmptyArray() {
        int[] arr1 = {};
        int[] arr2 = {};
        assertTrue(arrayEquals(arr1, arr2));
    }

    @Test
    public void testNotEqualsIntEmptyArray() {
        int[] arr1 = {};
        int[] arr2 = {1};
        assertFalse(arrayEquals(arr1, arr2));
    }

    @Test
    public void testNotEqualsIntOneElement() {
        int[] arr1 = {2};
        int[] arr2 = {1};
        assertFalse(arrayEquals(arr1, arr2));
    }

    @Test
    public void testNotEqualsIntDifferentElement() {
        int[] arr1 = {2, 5, 7};
        int[] arr2 = {2, 5};
        assertFalse(arrayEquals(arr1, arr2));
    }

    @Test
    public void testNotEqualsInt() {
        int[] arr1 = {2, 5, 7};
        int[] arr2 = {2, 5, 6};
        assertFalse(arrayEquals(arr1, arr2));
    }


}
