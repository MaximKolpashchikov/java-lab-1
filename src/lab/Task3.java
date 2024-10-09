package lab;

import common.UI;

import java.util.Random;

public class Task3
{
    public void run()
    {
        int x, a, b;

        UI.putMessage("ЗАДАНИЕ 3");

        // Act 1

        UI.putQuestion("Числа наоборот");
        x = UI.getInt("положительное число", v -> v > 0);
        UI.putSuccess("Результат: " + reverseListNums(x));

        // End act 1
        // Act 2

        UI.putQuestion("Степень числа");
        a = UI.getInt("Введите целое число");
        b = UI.getInt("положительное число", v -> v >= 0);
        UI.putSuccess("Результат возведения в степень: " + pow(a, b));

        // End act 2
        // Act 3

        UI.putQuestion("Одинаковость");
        x = UI.getInt("Введите целое число");

        if (equalNum(x))
        {
            UI.putSuccess("Все цифры числа одинаковы");
        }
        else
        {
            UI.putSuccess("Не все цифры числа одинаковы");
        }

        // End act 3
        // Act 4

        UI.putQuestion("Левый треугольник");
        x = UI.getInt("положительное число", v -> v > 0);
        UI.putSuccess("Результат:");
        leftTriangle(x);

        // End act 4
        // Act 5

        UI.putQuestion("Угадайка");
        guessGame();

        // End act 5
    }

    // Action functions

    public String reverseListNums (int x)
    {
        StringBuilder s = new StringBuilder();

        for (int i = x; i >= 0; --i)
        {
            if (i < x) s.append(" ");
            s.append(i);
        }

        return s.toString();
    }

    public int pow (int x, int y)
    {
        if (y == 0) return 1;

        int r = x;
        int p;

        // Здесь r = x ^ (p / 2)
        for (p = 2; p <= y; p <<= 1)
        {
            r *= r;
        }
        // Здесь r = x ^ p
        for (p >>= 1; p < y; ++p)
        {
            r *= x;
        }

        return r;
    }

    public boolean equalNum (int x)
    {
        boolean r = true;
        int d = x % 10;
        int i = x / 10;

        while (r && i > 0)
        {
            r = i % 10 == d;
            d = i % 10;
            i = i / 10;
        }

        return r;
    }

    public void leftTriangle (int x)
    {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < x; ++i)
        {
            s.append("*");
            System.out.println(s.toString());
        }
    }

    public void guessGame()
    {
        Random r = new Random();
        int x = r.nextInt(0, 10);
        int k;
        boolean isGuessed = false;

        for (k = 0; !isGuessed; ++k)
        {
            int y = UI.getInt("число от 0 до 9", v -> v >= 0 && v <= 9);
            isGuessed = x == y;

            if (isGuessed)
            {
                UI.putSuccess("Вы угадали!");
            }
            else
            {
                UI.putWarning("Вы не угадали, попробуйте ещё раз");
            }
        }

        UI.putSuccess("Вы отгадали число за " + k + " попытки");
    }

    // End action functions
}
