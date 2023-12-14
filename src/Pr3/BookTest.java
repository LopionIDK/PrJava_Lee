package Pr3;

// Класс для тестирования Book:
public class BookTest {
    public static void main(String[] args) {
        Book book = new Book("Автор книги", "Название книги", 2077);
        System.out.println("Автор: " + book.getAuthor());
        System.out.println("Название: " + book.getTitle());
        System.out.println("Год написания: " + book.getYear());
    }
}