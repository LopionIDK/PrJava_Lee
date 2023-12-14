package Pr21;

// Реализация абстрактного класса AbstractQueue
abstract class AbstractQueue<E> implements Queue<E> {
    protected int size = 0;

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }
}
