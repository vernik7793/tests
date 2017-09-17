package practics.quiz.test11;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Сделать адаптер к InputStream, чтобы его можно было использовать как итератор
 */
public class ISToIteratorAdapter implements Iterator<Integer> {

	InputStream is;
	int oneByte;
	Boolean oneByteReturned;
	
	public ISToIteratorAdapter(InputStream is) {
		oneByteReturned = true;
		this.is = is;
	}

	@Override
	public boolean hasNext() {
        // TODO реализовать метод
		try {
			if (oneByteReturned) {
				oneByte = is.read();
				oneByteReturned = false;
			}
			if (oneByte == -1)
				return false;
			return true;
		} catch (IOException e) {
			return false;
		}
	    //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public Integer next() {
        // TODO реализовать метод
			if (oneByte == -1)
				throw new NoSuchElementException();
			oneByteReturned = true;
			return oneByte;
        //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
