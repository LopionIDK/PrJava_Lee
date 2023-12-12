package Pr21;

// Класс для представления элементов в связанном списке
class Node<E> {
    E value;
    Node<E> next;

    Node(E value) {
        this.value = value;
        this.next = null;
    }
}
