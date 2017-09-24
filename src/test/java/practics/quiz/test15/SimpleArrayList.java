package practics.quiz.test15;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.max;

/**
 * 
 * В классе SimpleArrayList реализовать методы:
 * 1) remove(Object value)
 * 2) iterator()
 * 3) toString()
 * 4) equals(Object other)
 * 5) hashCode()
 * 6) contains()
 * Они должны вести себя так же, как и соответствующие методы java.util.ArrayList.
 *  
 */
public class SimpleArrayList<E> implements SimpleList<E> {
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	private E[] data;
	private int size = 0;

	public SimpleArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public SimpleArrayList(int initialCapacity) {
		this.data = (E[]) new Object[initialCapacity];
	}

	// *** *** *** ADD *** *** ***
	@Override
	public boolean add(E newElement) {
		ensureCapacity(size + 1);
		data[size] = newElement;
		size++;
		return true;
	}

	@Override
	public void add(int index, E element) {
		rangeCheck(index);
		System.arraycopy(data, index, data, index + 1, size - index);
		data[index] = element;
		size++;
	}

	// *** *** *** READ *** *** ***
	@Override
	public E get(int index) {
		rangeCheck(index);
		return data[index];
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int current = 0;
			int lastRet = -1;
			int expectedModCount = modCount;

			@Override
			public boolean hasNext() {
                // TODO реализовать метод
				return current != size;
                //throw new UnsupportedOperationException("to do implementation");
			}

			@Override
			@SuppressWarnings("unchecked")
			public E next() {
                // TODO реализовать метод
				checkForComodification();
				int i = current;
				if (i >= size)
					throw new NoSuchElementException();
				Object[] elementData = SimpleArrayList.this.data;
				if (i >= elementData.length)
					throw new ConcurrentModificationException();
				current = i + 1;
				return (E) elementData[lastRet = i];
                //throw new UnsupportedOperationException("to do implementation");
			}

			@Override
			public void remove() {
                // TODO реализовать метод
				if (lastRet < 0)
					throw new IllegalStateException();
				checkForComodification();

				try {
					SimpleArrayList.this.remove(lastRet);
					current = lastRet;
					lastRet = -1;
					expectedModCount = modCount;
				} catch (IndexOutOfBoundsException ex) {
					throw new ConcurrentModificationException();
				}
				//throw new UnsupportedOperationException("to do implementation");
			}

			final void checkForComodification() {
				if (modCount != expectedModCount)
					throw new ConcurrentModificationException();
			}
		};
	}

	// *** *** *** CHECK *** *** ***
	@Override
	public boolean contains(Object element) {
        // TODO реализовать метод
		//return indexOf(o) >= 0;
		if (element == null) {
			for (int i = 0; i < size; i++)
				if (data[i]==null)
					return true;
		} else {
			for (int i = 0; i < size; i++)
				if (element.equals(data[i]))
					return true;
		}
		return false;

        //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// *** *** *** MUTATE *** *** ***
	@Override
	public E set(int index, E newElement) {
		rangeCheck(index);
		E oldElement = data[index];
		data[index] = newElement;
		return oldElement;
	}

	// *** *** *** REMOVE *** *** ***
	@Override
	public boolean remove(Object element) {
        // TODO реализовать метод
		if (element == null) {
			for (int index = 0; index < size; index++)
				if (data[index] == null) {
					remove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (element.equals(data[index])) {
					remove(index);
					return true;
				}
		}
		return false;
        //throw new UnsupportedOperationException("to do implementation");
	}

	private void shift(int index) {
		int numMoved = size - index - 1;
		System.arraycopy(data, index + 1, data, index, numMoved);
		data[--size] = null;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E oldValue = data[index];
		shift(index);
		return oldValue;
	}

	// *** *** *** OBJECT METHODS *** *** ***
	@Override
	public boolean equals(Object o) {
        // TODO реализовать метод
		if (o == this)
			return true;
		if (!(o instanceof SimpleArrayList))
			return false;

		Iterator<E> e1 = iterator();
		Iterator<?> e2 = ((SimpleArrayList<?>) o).iterator();
		while (e1.hasNext() && e2.hasNext()) {
			E o1 = e1.next();
			Object o2 = e2.next();
			if (!(o1==null ? o2==null : o1.equals(o2)))
				return false;
		}
		return !(e1.hasNext() || e2.hasNext());
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public int hashCode() {
        // TODO реализовать метод
		int hashCode = 1;
		for (int i = 0; i < size; i++)
			hashCode = 31*hashCode + (data[i]==null ? 0 : data[i].hashCode());
		return hashCode;
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public String toString() {
        // TODO реализовать метод
		Iterator<E> it = iterator();
		if (! it.hasNext())
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append('[');
		for (;;) {
			E e = it.next();
			sb.append(e == this ? "(this Collection)" : e);
			if (! it.hasNext())
				return sb.append(']').toString();
			sb.append(',');
		}
        //throw new UnsupportedOperationException("to do implementation");
	}

	// ---------- internals ----------
	private void rangeCheck(int index) {
		if (index < 0 || size < index) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity > data.length) {
			int newCapacity = max(minCapacity, data.length + (data.length >> 1));
			E[] newData = (E[]) new Object[newCapacity];
			System.arraycopy(data, 0, newData, 0, data.length);
			this.data = newData;
		}
	}

	protected transient int modCount = 0;

	/*ArrayList a = new ArrayList();
	void aa(){
		a.contains();
	}*/
}