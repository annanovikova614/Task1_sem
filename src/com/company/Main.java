package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        work();
    }

    public static void work() {
        Scanner scanner = new Scanner(System.in);
        NumericalSystem valueOfNumericalSystem = null;
        while (valueOfNumericalSystem == null) {
            valueOfNumericalSystem = Menu.changeNumericalSystem(valueOfNumericalSystem);
        }

        int option = 0;
        while (option != 4) {
            System.out.println("Выберите команду\n" +
                    "1.Перевести число в это основание системы\n" +
                    "2.Перевести в десятеричную систему\n" +
                    "3.Изменить систему\n" +
                    "4.Завершить программу");

            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Ошибка ввода. Введите число");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("Число в выбранном основании: " + Menu.printTheBaseSystem(valueOfNumericalSystem));
                    break;
                case 2:
                    System.out.println("Число в десятеричной системе: " + Menu.printTheDecimalSystem(valueOfNumericalSystem));
                    break;
                case 3:
                    valueOfNumericalSystem = Menu.changeNumericalSystem(valueOfNumericalSystem);
                    break;
            }
            System.out.println();
        }
    }
}
