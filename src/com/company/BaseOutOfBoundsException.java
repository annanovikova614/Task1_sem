package com.company;

public class BaseOutOfBoundsException extends Exception {
    public BaseOutOfBoundsException() {
        super("Основание выходит за допустимые границы [2;32]");
    }
}
