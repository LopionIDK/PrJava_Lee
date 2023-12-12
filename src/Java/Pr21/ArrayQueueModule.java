package Pr21;

import java.util.NoSuchElementException;

public class ArrayQueueModule {
    private static Object[] elements = new Object[10];
    private static int size = 0;
    private static int head = 0;
    private static int tail = 0;

    // Добавить элемент в очередь
    public static void enqueue(Object element) {
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    // Получить первый элемент в очереди
    public static Object element() {
        if (size == 0) throw new NoSuchElementException();
        return elements[head];
    }

    // Удалить и вернуть первый элемент в очереди
    public static Object dequeue() {
        if (size == 0) throw new NoSuchElementException();
        Object element = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return element;
    }

    // Получить текущий размер очереди
    public static int size() {
        return size;
    }

    // Проверить, является ли очередь пустой
    public static boolean isEmpty() {
        return size == 0;
    }

    // Очистить очередь
    public static void clear() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    // Увеличить емкость массива, если необходимо
    private static void ensureCapacity(int capacity) {
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
