package com.company;

public class NumericalSystem {
    private int base;
    final char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };

    public NumericalSystem(int base) throws BaseOutOfBoundsException {
        if (base >= 2 && base <=32) {
            this.base = base;
        } else throw new BaseOutOfBoundsException();
    }

    public String convertToBaseSystem(int num) {
        char buffer[] = new char[33];
        boolean negative = (num < 0);
        int charPositive = 32;

        if (!negative) {
            num = -num;
        }

        while (num <= -base) {
            buffer[charPositive--] = digits[-(num % base)];
            num = num / base;
        }
        buffer[charPositive] = digits[-num];

        if (negative) {
            buffer[--charPositive] = '-';
        }

        return new String(buffer, charPositive, (33 - charPositive)).toUpperCase();
    }

    public int convertToDecimalSystem(String stringValue) {
        stringValue = stringValue.toUpperCase();

        if (stringValue.length() == 0) {
            System.out.println("Ничего не введено");
            return -1;
        }

        int length = stringValue.length();
        int power = 1;
        int num = 0;
        int i;

        for (i = length - 1; i >= 0; i--) {
            num += useSymbolsForNumericalSystem(stringValue.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }
    
    public int useSymbolsForNumericalSystem(char symbolValue) {
        if (symbolValue >= '0' && symbolValue <= '9')
            return (int)symbolValue - '0';
        else
            return (int)symbolValue - 'A' + 10;
    }
}
