package practics.quiz.test21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SparseMatrixOnListTest {

	SparseMatrix matrix = null;
		
	@Before
	public void setUp() {
		matrix = new SparseMatrixOnList();
	}

	@Test
	public void testSet1() {
		matrix.set(0, 0);
		assertEquals(1, matrix.get(0, 0));
		assertEquals(0, matrix.get(1, 1));
	}
	
	@Test
	public void testSetMax() {
		matrix.set(Integer.MAX_VALUE, Integer.MAX_VALUE);
		assertEquals(1, matrix.get(Integer.MAX_VALUE, Integer.MAX_VALUE));
		assertEquals(0, matrix.get(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1));
		assertEquals(0, matrix.get(0, 0));
	}
	
	@Test
	public void testSet100500() {
		matrix.set(100500, 1);
		assertEquals(1, matrix.get(100500, 1));
		assertEquals(0, matrix.get(0, 0));
		assertEquals(0, matrix.get(100499, 1));
		assertEquals(0, matrix.get(100500, 0));
	}

	@Test
	public void testSet10() {
		matrix.set(5, 10);
		assertEquals(1, matrix.get(5, 10));
		assertEquals(0, matrix.get(10, 5));
		assertEquals(0, matrix.get(10, 10));
		assertEquals(0, matrix.get(5, 5));
	}
	
	@Test
	public void testSetLineOne() {
		matrix.set(1, 1);
		matrix.set(1, 2);
		matrix.set(1, 3);
		matrix.set(2, 10);
		assertEquals(0, matrix.get(1, 0));
		assertEquals(1, matrix.get(1, 1));
		assertEquals(1, matrix.get(1, 2));
		assertEquals(1, matrix.get(1, 3));
		assertEquals(0, matrix.get(1, 4));
		assertEquals(1, matrix.get(2, 10));
		assertEquals(0, matrix.get(2, 20));
		assertEquals(0, matrix.get(3, 1));
		assertEquals(0, matrix.get(0, 1));
	}

	// Проверка граничных значений для Set
	@Test(expected = IllegalArgumentException.class)
	public void testSetIndexOutOfBoundsBothMaх() {
		matrix.set(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIndexOutOfBoundsOneMaх() {
		matrix.set(Integer.MAX_VALUE + 1, Integer.MAX_VALUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIndexOutOfBoundsTwoMaх() {
		matrix.set(Integer.MAX_VALUE, Integer.MAX_VALUE + 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIndexOutOfBoundsBothMin() {
		matrix.set(-1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIndexOutOfBoundsOneMin() {
		matrix.set(-1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIndexOutOfBoundsTwoMin() {
		matrix.set(0, -1);
	}
	
	// Проверка граничных значений для Get
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexOutOfBoundsBothMaх() {
		matrix.get(Integer.MAX_VALUE + 1, Integer.MAX_VALUE + 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexOutOfBoundsOneMaх() {
		matrix.get(Integer.MAX_VALUE + 1, Integer.MAX_VALUE);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexOutOfBoundsTwoMaх() {
		matrix.get(Integer.MAX_VALUE, Integer.MAX_VALUE + 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexOutOfBoundsBothMin() {
		matrix.get(-1, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexOutOfBoundsOneMin() {
		matrix.get(-1, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetIndexOutOfBoundsTwoMin() {
		matrix.get(0, -1);
	}
	
	//	Такая проверка ОШИБОЧНА, и не удовлетворяет правилам TDD!
	//	- она долго работает (тест должен работать бысто)
	//	- хотя она и проверяет все значения, но это НЕ нужно (проверять только граничные)	
	//	@Test
	//	public void testGetEmpty() {
	//		for (int i = 0; i <= Integer.MAX_VALUE; i++) {
	//			for (int j = 0; i <= Integer.MAX_VALUE; i++) {
	//				assertEquals(0, matrix.get(i, j));
	//			}
	//		}
	//	}
}
