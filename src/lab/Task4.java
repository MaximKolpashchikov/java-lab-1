package lab;

import common.UI;

import java.util.Arrays;
import java.util.Random;

public class Task4
{
    public void run()
    {
        int[] a1, a2, a3;
        int x, y;

        UI.putMessage("ЗАДАНИЕ 4");
        UI.putQuestion("Задайте параметры генерации массива, по порядку: размер, минимум, максимум");

        int c = UI.getInt("положительное число", v -> v > 0);
        int l = UI.getInt("Введите целое число");
        int u = UI.getInt("число больше " + l, v -> v > l);

        a1 = generate(c, l, u);
        a2 = generate(c, l, u);

        UI.putSuccess("Сгенерирован массив А: " + printArray(a1));
        UI.putSuccess("Сгенерирован массив Б: " + printArray(a2));

        // Act 1

        UI.putQuestion("Поиск последнего значения");
        x = UI.getInt("Введите целое число");
        UI.putSuccess("Индекс последнего вхождения в массиве А: " + findLast(a1, x));

        // End act 1
        // Act 2

        UI.putQuestion("Добавление в массив");
        x = UI.getInt("Введите целое число");
        y = UI.getInt("индекс в массиве А", v -> v >= 0 && v <= c);
        a3 = add(a1, x, y);
        UI.putSuccess("Измененный массив: " + printArray(a3));

        // End act 2
        // Act 3

        UI.putQuestion("Реверс");
        reverse(a1);
        UI.putSuccess("Обращенный массив А: " + printArray(a1));

        // End act 3
        // Act 4

        UI.putQuestion("Объединение");
        a3 = concat(a1, a2);
        UI.putSuccess("Объединение массивов А и Б: " + printArray(a3));

        // End act 4
        // Act 5

        UI.putQuestion("Удалить негатив");
        a3 = deleteNegative(a1);
        UI.putSuccess("Массив А после удаления негатива: " + printArray(a3));

        // End act 5
    }

    private int[] generate(int count, int lower, int upper)
    {
        Random r = new Random();
        int[] a = new int[count];

        for (int i = 0; i < count; ++i)
        {
            a[i] = r.nextInt(lower, upper);
        }

        return a;
    }

    private String printArray(int[] a)
    {
        StringBuilder s = new StringBuilder();
        s.append("[ ");

        for (int i = 0; i < a.length; ++i)
        {
            if (i > 0) s.append(", ");
            s.append(a[i]);
        }

        s.append(" ]");
        return s.toString();
    }

    // Action functions

    public int findLast (int[] arr, int x)
    {
        for (int i = arr.length - 1; i >= 0; --i)
        {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    public int[] add (int[] arr, int x, int pos)
    {
        int l = arr.length + 1;
        int[] r = new int[l];

        for (int i = 0; i < l; ++i)
        {
            if (i < pos) r[i] = arr[i];
            else
            if (i > pos) r[i] = arr[i - 1];
            else r[i] = x;
        }

        return r;
    }

    public void reverse (int[] arr)
    {
        int j, t;

        for (int i = 0; i < arr.length / 2; ++i)
        {
            j = arr.length - i - 1;
            t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        }
    }

    public int[] concat (int[] arr1, int[] arr2)
    {
        int l = arr1.length + arr2.length;
        int[] r = new int[l];

        for (int i = 0; i < l; ++i)
        {
            r[i] = i < arr1.length ? arr1[i] : arr2[i - arr1.length];
        }

        return r;
    }

    public int[] deleteNegative (int[] arr)
    {
        return Arrays.stream(arr).filter(x -> x >= 0).toArray();
    }

    // End action functions
}
