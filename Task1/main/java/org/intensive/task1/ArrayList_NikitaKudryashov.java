
import java.util.Arrays;
import java.util.Comparator;

    /**
     * Класс для реализации динамического списка.
     *
     * @param <E> тип элементов списка
     */
    public class ArrayList_NikitaKudryashov<E> implements IntensiveList<E> {
        private static final int DEFAULT_CAPACITY = 10;
        private E[] elements;
        private int size;

        /**
         * Конструктор по умолчанию.
         */
        @SuppressWarnings("unchecked")
        public ArrayList_NikitaKudryashov () {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
            this.size = 0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void add(E element) {
            ensureCapacity(size + 1);
            elements[size++] = element;
        }

        @Override
        public void add(int index, E element) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            ensureCapacity(size + 1);
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            return (E) elements[index];
        }

        @Override
        @SuppressWarnings("unchecked")
        public E set(int index, E element) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            var oldElement = (E) elements[index];
            elements[index] = element;
            return oldElement;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            var removedElement = (E) elements[index];
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elements, index + 1, elements, index, numMoved);
            }
            elements[--size] = null;
            return removedElement;
        }

        @Override
        public void clear() {
            for (int i = 0; i < size; i++) {
                elements[i] = null;
            }
            size = 0;
        }

        @Override
        public void quickSort(Comparator<E> comparator) {
            Arrays.sort(elements, 0, size, comparator);
        }

        @Override
        public boolean isSorted() {
            for (int i = 0; i < size - 1; i++) {
                if (((Comparable<E>) elements[i]).compareTo(elements[i + 1]) > 0) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public void split(int size) {
            if (size >= this.size) {
                return;
            }
            for (int i = size; i < this.size; i++) {
                elements[i] = null;
            }
            this.size = size;
        }

        private void ensureCapacity(int minCapacity) {
            if (minCapacity > elements.length) {
                elements = Arrays.copyOf(elements, Math.max(elements.length * 2, minCapacity));
            }
        }
    }