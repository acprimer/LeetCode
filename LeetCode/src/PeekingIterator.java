import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> itr;
    private int peeked;
    private boolean hasPeeked;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        itr = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peeked = itr.next();
            hasPeeked = true;
        }
        return peeked;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (hasPeeked) {
            hasPeeked = false;
            return peeked;
        }
        return itr.next();
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || itr.hasNext();
    }
}
