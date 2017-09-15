package practics.quiz.test05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



/**
 * Реализовать поиск масмилального элемента в массиве
 */
public class SearchMax {

    public int max(int[] arr) {
        // TODO реализовать метод
        throw new UnsupportedOperationException("to do implementation");
    }

    @Test
    public void testSearchMaxElement21() {
        int[] arr = {1, 7, 19, -8, 12, 21, -5, 0};
         assertEquals(max(arr), 21);
    }

    @Test
    public void testSearchMaxElement0() {
        int[] arr = {-1, -7, -19, -21, -5, 0};
        assertEquals(max(arr), 0);
    }

    @Test
    public void testSearchMaxElementMinus7() {
        int[] arr = {-8, -7, -19, -8, -12, -21, -77};
        assertEquals(max(arr), -7);
    }


    @Test (expected = IllegalArgumentException.class)
    public void testSearchInEmptyArray() {
        int[] arr = new int[]{};
        max(arr);
    }

}
