package custom.util;

public class ArrayList<E> implements custom.util.List<E> {
    private Object[] elements;
    private int size;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initialCapacity) {
        elements = new Object[initialCapacity];
        size = 0;
    }

    @Override
    public void add(E element) {
        if (size == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        elements[size++] = element;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        @SuppressWarnings("unchecked")
        E element = (E) elements[index];
        return element;
    }

    @Override
    public int size() {
        return size;
    }
}