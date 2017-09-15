package practics.quiz.test21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SparseMatrixOnSetTest {

	SparseMatrix matrix;
	
	@Before
	public void setUp() {
		matrix = new SparseMatrixOnSet();
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

}
