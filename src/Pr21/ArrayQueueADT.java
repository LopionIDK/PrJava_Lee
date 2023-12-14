package Pr21;

import java.util.NoSuchElementException;
// Реализация очереди на массиве с явной передачей ссылки на экземпляр очереди
class ArrayQueueADT<E> extends AbstractQueue<E> {
    private Object[] elements = new Object[10];
    private int head = 0;
    private int tail = 0;

    // Добавить элемент в очередь
    public void enqueue(E element) {
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    // Получить первый элемент в очереди
    public E element() {
        if (size == 0) throw new NoSuchElementException();
        return (E) elements[head];
    }

    // Удалить и вернуть первый элемент в очереди
    public E dequeue() {
        if (size == 0) throw new NoSuchElementException();
        E element = (E) elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    // Получить текущий размер очереди
    public int size() {
        return size;
    }

    // Увеличить емкость массива, если необходимо
    private void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = size;
        }
    }
}
