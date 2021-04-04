package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println();
        System.out.println("Active : " + active);
        System.out.println("Status : " + status);
        System.out.println("Message : " + message);
    }

    public static void main(String[] args) {
        Error err0 = new Error();
        Error err1 = new Error(true, 32, "Err1");
        Error err2 = new Error(false, 17, "Err2");
        Error err3 = new Error(true, 1, "Err3");

        err0.showInfo();
        err1.showInfo();
        err2.showInfo();
        err3.showInfo();
    }

}
