package Pr21;

import java.util.NoSuchElementException;

// Определяем интерфейс Queue
interface Queue<E> {
    // Добавить элемент в очередь
    void enqueue(E element);

    // Получить первый элемент в очереди
    E element();

    // Удалить и вернуть первый элемент в очереди
    E dequeue();

    // Получить текущий размер очереди
    int size();

    // Проверить, является ли очередь пустой
    boolean isEmpty();

    // Очистить очередь
    void clear();
}
