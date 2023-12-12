package Pr21;

// Тесты
public class Main {
    public static void main(String[] args) {
        // Тесты для ArrayQueueModule
        ArrayQueueModule.enqueue(1);
        ArrayQueueModule.enqueue(2);
        System.out.println(ArrayQueueModule.element()); // Ожидаем 1
        System.out.println(ArrayQueueModule.dequeue()); // Ожидаем 1
        System.out.println(ArrayQueueModule.size());    // Ожидаем 1
        System.out.println(ArrayQueueModule.isEmpty());  // Ожидаем false
        ArrayQueueModule.clear();
        System.out.println(ArrayQueueModule.isEmpty());  // Ожидаем true

        // Тесты для ArrayQueueADT
        ArrayQueueADT<Integer> queue = new ArrayQueueADT<>();
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.element()); // Ожидаем 3
        System.out.println(queue.dequeue()); // Ожидаем 3
        System.out.println(queue.size());    // Ожидаем 1
        System.out.println(queue.isEmpty());  // Ожидаем false
        queue.clear();
        System.out.println(queue.isEmpty());  // Ожидаем true

        // Тесты для ArrayQueue
        ArrayQueue<Integer> queue2 = new ArrayQueue<>();
        queue2.enqueue(5);
        queue2.enqueue(6);
        System.out.println(queue2.element()); // Ожидаем 5
        System.out.println(queue2.dequeue()); // Ожидаем 5
        System.out.println(queue2.size());    // Ожидаем 1
        System.out.println(queue2.isEmpty());  // Ожидаем false
        queue2.clear();
        System.out.println(queue2.isEmpty());  // Ожидаем true
    }
}
