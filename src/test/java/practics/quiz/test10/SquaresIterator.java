package practics.quiz.test10;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Дописать SquaresIterator чтобы возвращал квадраты целых чисел
 * большие или равные left и меньшие right
 */

public class SquaresIterator implements Iterator<Integer> {
	int left;
	int current;
	int right;

	public SquaresIterator(int left, int right) {
		this.left = left;
		this.right = right;
		this.current = (int)Math.ceil(Math.sqrt(left)) - 1;
        // TODO реализовать метод
        //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public boolean hasNext() {
        // TODO реализовать метод
        if ((int)Math.pow(current+1 , 2) < right)
        	return true;
        return false;
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public Integer next() {
        // TODO реализовать метод
		int sqr = (int)Math.pow(++current , 2);
		if (sqr < right)
			return sqr;
		throw new NoSuchElementException();
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
