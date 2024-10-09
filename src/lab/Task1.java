package lab;

import common.UI;

public class Task1
{
    public void run()
    {
        int x, a, b;
        char c;

        UI.putMessage("ЗАДАНИЕ 1");

        // Act 1

        UI.putQuestion("Сумма знаков");
        x = UI.getInt("число из 2 разрядов и более", v -> Math.abs(v) >= 10);
        UI.putSuccess("Сумма двух последних цифр числа равна " + sumLastNums(x));

        // End act 1
        // Act 2

        UI.putQuestion("Есть ли позитив");
        x = UI.getInt("Введите целое число");

        if (isPositive(x))
        {
            UI.putSuccess("Это положительное число");
        }
        else
        {
            UI.putSuccess("Это не положительное число");
        }

        // End act 2
        // Act 3

        UI.putQuestion("Большая буква");
        c = UI.getChar("Введите один символ");

        if (isUpperCase(c))
        {
            UI.putSuccess("Это заглавная буква");
        }
        else
        {
            UI.putSuccess("Это не заглавная буква");
        }

        // End act 3
        // Act 4

        UI.putQuestion("Делитель");
        a = UI.getInt("первое число не равное 0", v -> v != 0);
        b = UI.getInt("второе число не равное 0", v -> v != 0);

        if (isDivisor(a, b))
        {
            UI.putSuccess("Одно из введенных чисел делит другое нацело");
        }
        else
        {
            UI.putSuccess("Ни одно из введенных чисел не делит другое нацело");
        }

        // End act 4
        // Act 5

        UI.putQuestion("Многократный вызов");
        a = UI.getInt("Введите 1-е целое число");

        for (int i = 1; i < 5; ++i)
        {
            b = UI.getInt(String.format("Введите %d-е целое число", i + 1));
            a = lastNumSum(a, b);
        }

        UI.putSuccess("Сумма цифр введенных чисел из разряда единиц равна " + a);

        // End act 5
    }

    // Action functions

    public int sumLastNums (int x)
    {
        return Math.abs(x % 10) + Math.abs(x / 10 % 10);
    }

    public boolean isPositive (int x)
    {
        return x > 0;
    }

    public boolean isUpperCase (char x)
    {
        return x >= 'A' && x <= 'Z';
    }

    public boolean isDivisor (int a, int b)
    {
        return (a % b) == 0 || (b % a) == 0;
    }

    public int lastNumSum (int a, int b)
    {
        return Math.abs(a % 10) + Math.abs(b % 10);
    }

    // End action functions
}