package practics.quiz.test04;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Реализовать бинарный поиск элемента в отсоритированном массие
 * Позиции в массиве начинаются с нулевого индекса
 * Если элемент найден, возвращаем его позицию
 * Если элемент не найден, возвращаем позицию (со знаком "-")
 * в которую его можно вставить, не нарущая сортировку массива
 */
public class BinarySearch {

    int[] arr = {10,20,30,40,50,60,70};

    private int binarySearch(int[] arr, int i) {
        // TODO реализовать метод
        if (arr.length == 0)
            return 0;
        if (i < arr[0])
            return 0;
        int rigth = arr.length - 1;
        if (i > arr[rigth])
            return -rigth;
        int left = 0;
        int middle = (rigth + left) / 2;
        Boolean found = false;
        while (!found && (rigth - left > 1)) {
            if (i == arr[middle])
                found = true;
            else {
                if (i < arr[middle])
                    rigth = middle;
                else if (i > arr[middle])
                    left = middle;
                middle = (rigth + left) / 2;
            }
        }
        if (found)
            return middle;
        if (i == arr[rigth])
            return -rigth;
        return -left;
        //throw new UnsupportedOperationException("to do implementation");
    }

    @Test
    public void testSearchConstrainElement10() {
         assertEquals(binarySearch(arr, 10), 0);
    }

    @Test
    public void testSearchConstrainElement50() {
        assertEquals(binarySearch(arr, 15), -2);
    }

    @Test
    public void testSearchConstrainElement70() {
        assertEquals(binarySearch(arr, 70), 6);
    }

    @Test
    public void testSearchNotConstrainElement5() {
        assertEquals(binarySearch(arr, 5), -1);
    }

    @Test
    public void testSearchNotConstrainElement15() {
        assertEquals(binarySearch(arr, 15), -2);
    }

    @Test
    public void testSearchNotConstrainElement100() {
        assertEquals(binarySearch(arr, 100), -8);
    }

    @Test
    public void testSearchInEmptyArray() {
        arr = new int[]{};
        assertEquals(binarySearch(arr, 1), -1);
    }

}
