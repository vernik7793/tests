package practics.quiz.test08;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Написать итератор для перебора интервала от left до right с шагом 1
 */
public class IntervalIterator implements Iterator<Integer> {
	private int current;
	private final int max;
	
	public IntervalIterator(int left, int right) {
		this.current = left;
		this.max = right;
	}

	@Override
	public boolean hasNext() {
        // TODO реализовать метод
		if (current < max)
			return true;
		return false;
        //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public Integer next() {
        // TODO реализовать метод
		if (current < max)
			return current++;
		throw new NoSuchElementException();
        //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public void remove() {
        throw new UnsupportedOperationException();
	}

}
