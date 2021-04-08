package ru.job4j.pojo;

/**
 * 3. Массивы и модели. [#468439]
 */
public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Shildt Java", 1200);
        books[1] = new Book("Horstman Java", 900);
        books[2] = new Book("Head First Java", 700);
        books[3] = new Book("Clean Code", 650);

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCountPage());
        }

        //меняем местами
        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getCountPage());
        }

        //выывод книг с именем Clean Code
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean Code")) {
                System.out.println(books[i].getName() + " - " + books[i].getCountPage());
            }
        }
    }
}
