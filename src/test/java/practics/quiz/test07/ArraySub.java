package practics.quiz.test07;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Реализовать метод возвращающий диапазон элементов массива с start индеска длиной length
 */
public class ArraySub {

    public int[] arraySub(int[] arr1, int start, int length) {
        // TODO реализовать метод
        int arrLen = arr1.length;
        if (arrLen == 0)
            throw new IllegalArgumentException();
        if ((start > arrLen - 1) || (start + length > arrLen))
            throw new IllegalArgumentException();
        return Arrays.copyOfRange(arr1, start, start + length);
        //throw new UnsupportedOperationException("to do implementation");
    }

    @Test
    public void testArraySubAll() {
        int[] arr1 = {1, 3, 2, 5};
        int[] arr2 = {1, 3, 2, 5};
        assertArrayEquals(arraySub(arr1, 0, 4), arr2);
    }

    @Test
    public void testArraySub1_2() {
        int[] arr1 = {1, 3, 2, 5};
        int[] arr2 = {3, 2};
        assertArrayEquals(arraySub(arr1, 1, 2), arr2);
    }

    @Test
    public void testArraySub4_2() {
        int[] arr1 = {1, 3, 2, 5, 1, 7};
        int[] arr2 = {1, 7};
        assertArrayEquals(arraySub(arr1, 4, 2), arr2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArraySub_EmptyArray() {
        int[] arr1 = {};
        arraySub(arr1, 4, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testArraySub0_4() {
        int[] arr1 = {1, 3, 2};
        arraySub(arr1, 0, 4);
    }
}
