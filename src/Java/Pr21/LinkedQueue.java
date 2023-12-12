package Pr21;

import java.util.NoSuchElementException;

// Реализация очереди на связанном списке
class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    // Конструктор
    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    // Добавить элемент в очередь
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Получить первый элемент в очереди
    public E element() {
        if (isEmpty()) throw new NoSuchElementException();
        return front.value;
    }

    // Удалить и вернуть первый элемент в очереди
    public E dequeue() {
        if (isEmpty()) throw new NoSuchElementException();
        E element = front.value;
        front = front.next;
        size--;
        return element;
    }

    // Получить текущий размер очереди
    public int size() {
        return size;
    }

    // Проверить, является ли очередь пустой
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистить очередь
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }
}
