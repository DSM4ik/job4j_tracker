package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Java", 1000);
        books[1] = new Book("Python", 600);
        books[2] = new Book("Assembler", 200);
        books[3] = new Book("Qlik", 800);

        books[2].setName("Clean code");
        for (int index = 0; index < books.length; index++) {
            System.out.println("name book:" + books[index].getName() + ", count pages:" + books[index].getCountPages());
        }

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int index = 0; index < books.length; index++) {
            System.out.println("name book:" + books[index].getName() + ", count pages:" + books[index].getCountPages());
        }

        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println("name book:" + books[index].getName() + ", count pages:" + books[index].getCountPages());
            }
        }

    }
}
