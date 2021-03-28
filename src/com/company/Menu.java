package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static String printTheBaseSystem(NumericalSystem valueOfNumericalSystem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число :");
        int num;
        try {
            num = scanner.nextInt();
        }catch (InputMismatchException e) {
            scanner.nextLine();
            return "не может быть определено";
        }
        return valueOfNumericalSystem.convertToBaseSystem(num);
    }

    public static int printTheDecimalSystem(NumericalSystem valueOfNumericalSystem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число :");
        return valueOfNumericalSystem.convertToDecimalSystem(scanner.nextLine());
    }

    public static NumericalSystem changeNumericalSystem(NumericalSystem valueOfNumericalSystem) {
        NumericalSystem changedValueOfNumericalSystem;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите основание системы:");
        int base = scanner.nextInt();
        try {
            changedValueOfNumericalSystem = new NumericalSystem(base);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите число");
            return valueOfNumericalSystem;
        } catch (BaseOutOfBoundsException e) {
            System.out.println("Основание системы счисления выходит за рамки [2;32]");
            return valueOfNumericalSystem;
        }
        return changedValueOfNumericalSystem;
    }

}
