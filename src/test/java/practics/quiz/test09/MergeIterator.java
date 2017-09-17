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

	private Integer oneWaitedElem;
	private Integer twoWaitedElem;

	public MergeIterator(Iterable<Integer> one, Iterable<Integer> two) {
		this.one = one.iterator();
		this.two = two.iterator();
	}

	@Override
	public boolean hasNext() {
        // TODO реализовать метод
		return one.hasNext() || two.hasNext() || (oneWaitedElem != null) || (twoWaitedElem != null);

		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public Integer next() {
        // TODO реализовать метод
		Integer oneElem = null;
		Integer twoElem = null;
		if (oneWaitedElem != null)
			oneElem = oneWaitedElem;
		else if (one.hasNext())
			oneElem = one.next();
		if (twoWaitedElem != null)
			twoElem = twoWaitedElem;
		else if (two.hasNext())
			twoElem = two.next();
		if ((oneElem == null) && (twoElem == null))
			throw new NoSuchElementException();
		else if ((oneElem != null) && ((twoElem == null) || (twoElem >= oneElem))){
			twoWaitedElem = twoElem;
			oneWaitedElem = null;
			return oneElem;
		}
		else {
			oneWaitedElem = oneElem;
			twoWaitedElem = null;
			return twoElem;
		}
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
