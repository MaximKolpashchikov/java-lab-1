package lab;

import common.UI;

public class Task2
{
    public void run()
    {
        int x, a, b, c;
        String s;

        UI.putMessage("ЗАДАНИЕ 2");

        // Act 1

        UI.putQuestion("Безопасное деление");
        a = UI.getInt("Введите первое целое число");
        b = UI.getInt("Введите второе целое число");
        UI.putSuccess("Результат безопасного деления равен " + safeDiv(a, b));

        // End act 1
        // Act 2

        UI.putQuestion("Строка сравнения");
        a = UI.getInt("Введите первое целое число");
        b = UI.getInt("Введите второе целое число");
        UI.putSuccess("Результирующая строка сравнения: " + makeDecision(a, b));

        // End act 2
        // Act 3

        UI.putQuestion("Тройная сумма");
        a = UI.getInt("Введите первое целое число");
        b = UI.getInt("Введите второе целое число");
        c = UI.getInt("Введите третье целое число");

        if (sum3(a, b, c))
        {
            UI.putSuccess("Можно сложить два числа так, чтобы получить третье");
        }
        else
        {
            UI.putSuccess("Нельзя сложить два числа так, чтобы получить третье");
        }

        // End act 3
        // Act 4

        UI.putQuestion("Возраст");
        x = UI.getInt("Введите целое число");
        UI.putSuccess("Результирующая строка: " + age(x));

        // End act 4
        // Act 5

        UI.putQuestion("Вывод дней недели");
        s = UI.getString("Введите наименование дня недели");
        UI.putSuccess("Результат:");
        printDays(s);

        // End act 5
    }

    // Action functions

    public double safeDiv (int x, int y)
    {
        return Math.abs(y) == 0 ? 0 : (double)x / y;
    }

    public String makeDecision (int x, int y)
    {
        String sign = " == ";

        if (x < y) sign = " < ";
        else
        if (x > y) sign = " > ";

        return x + sign + y;
    }

    public boolean sum3 (int x, int y, int z)
    {
        return (x + y == z) || (x + z == y) || (y + z == x);
    }

    public String age (int x)
    {
        int l = Math.abs(x % 10);
        int u = Math.abs(x / 10 % 10);
        String s = "лет";

        if (u != 1)
        {
            if (l == 1) s = "год";
            else
            if (l > 1 && l < 5) s = "года";
        }

        return x + " " + s;
    }

    public void printDays (String x)
    {
        switch (x.toLowerCase())
        {
            case "понедельник": System.out.println("Понедельник");
            case "вторник":     System.out.println("Вторник");
            case "среда":       System.out.println("Среда");
            case "четверг":     System.out.println("Четверг");
            case "пятница":     System.out.println("Пятница");
            case "суббота":     System.out.println("Суббота");
            case "воскресенье": System.out.println("Воскресенье");
            break;
            default:            System.out.println("Это не день недели");
        }
    }

    // End action functions
}