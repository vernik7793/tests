package practics.quiz.test01;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Реализовать пузырьковую сортировку
 */
public class BubbleSort {

	public static void bubbleSort(int[] arr)  {
        // TODO реализовать метод
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Test
	public void testBubbleSortEmptyArray() {
		int[] actual = {};
		int[] expected = {};
		bubbleSort(actual);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testBubbleSortOneElement() {
		int[] actual = {1};
		int[] expected = {1};
		bubbleSort(actual);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testBubbleSortThreeElement() {
		int[] actual = {3,2,1,};
		int[] expected = {1,2,3};
		bubbleSort(actual);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testBubbleSortTenElement() {
		int[] actual = {-7,6,8,5,4,9,0,3,2,10};
		int[] expected = {-7,0,2,3,4,5,6,8,9,10};
		bubbleSort(actual);
		assertArrayEquals(expected, actual);
	}

}
