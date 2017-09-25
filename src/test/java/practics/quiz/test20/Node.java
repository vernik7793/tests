package practics.quiz.test20;

public class Node {
    private int value;
    private Node next;
    private boolean lock = false;
    private NodeException e = new NodeException();

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public void lock() throws InterruptedException {
        // TODO реализовать метод
        try {
            if (isLock()) {
                e.inc();
            } else {
                lock = true;
                e.reset();
            }
        } catch (NodeException ne) {
            throw new InterruptedException();
        }
        //throw new UnsupportedOperationException("to do implementation");
    }

    public void unlock() throws InterruptedException {
        // TODO реализовать метод
        try {
            if (!isLock()) {
                e.inc();
            } else {
                lock = false;
                e.reset();
            }
        } catch (NodeException ne) {
            throw new InterruptedException();
        }
        //throw new UnsupportedOperationException("to do implementation");
    }

    public int getValue() throws InterruptedException {
        // TODO реализовать метод
        lock();
        return value;
        //throw new UnsupportedOperationException("to do implementation");
    }

    public void setValue(int value) throws InterruptedException {
        // TODO реализовать метод
        lock();
        this.value = value;
        //throw new UnsupportedOperationException("to do implementation");
    }

    public Node getNext() throws InterruptedException {
        // TODO реализовать метод
        lock();
        return next;
        //throw new UnsupportedOperationException("to do implementation");
    }

    public void setNext(Node next) throws InterruptedException {
        // TODO реализовать метод
        lock();
        this.next = next;
        //throw new UnsupportedOperationException("to do implementation");
    }
    
    public boolean isLock() {
        // TODO реализовать метод
        return lock == true;
        //throw new UnsupportedOperationException("to do implementation");
	}
}