package practics.quiz.test09;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Получает два Iterable, возвращающие итераторы на сортированные последовательности,
 * и сливает в Iterable возвращающий итератор на сортированную
 * последовательность образованную в результате слияния
 */
public class MergeIterator implements Iterator<Integer> {
	
	Iterator<Integer> one;
	Iterator<Integer> two;

	private Integer oneElemWaited;
	private Integer twoElemWaited;

	public MergeIterator(Iterable<Integer> one, Iterable<Integer> two) {
		this.one = one.iterator();
		this.two = two.iterator();
	}

	@Override
	public boolean hasNext() {
        // TODO реализовать метод
		return one.hasNext() || two.hasNext() || (oneElemWaited != null) || (twoElemWaited != null);

		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public Integer next() {
        // TODO реализовать метод
		Integer oneElem = null;
		Integer twoElem = null;
		Integer oElem = null;

		if (oneElemWaited != null)
			oneElem = oneElemWaited;
		else if (one.hasNext())
			oneElem = one.next();
		if (twoElemWaited != null)
			twoElem = twoElemWaited;
		else if (two.hasNext())
			twoElem = one.next();
		if ((oneElem == null) && (twoElem == null))
			throw new NoSuchElementException();
		if (oneElem < twoElem) {
			twoElemWaited = twoElem;
			oneElemWaited = null;
			return oneElem;
		}
		else {
			oneElemWaited = oneElem;
			twoElemWaited = null;
			return twoElem;
		}

		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
