import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Predicate;

public class Program
{
    private static final Scanner _scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        String[] menu = {
            "Методы",
            "Условия",
            "Циклы",
            "Массивы"
        };

        Program p = new Program();
        int sel;

        do
        {
            sel = getChoice("Выберите задание", menu);

            switch (sel)
            {
                case 0: p.run1(); break;
                case 1: p.run2(); break;
                case 2: p.run3(); break;
                case 3: p.run4(); break;
            }

            pause();
        }
        while (sel < menu.length);

        _scan.close();
    }

    public void run1()
    {
        int x, a, b;
        char c;

        putMessage("ЗАДАНИЕ 1");

        // Act 1

        putQuestion("Сумма знаков");
        x = getInt("число из 2 разрядов и более", v -> Math.abs(v) >= 10);
        putSuccess("Сумма двух последних цифр числа равна " + sumLastNums(x));

        // End act 1
        // Act 2

        putQuestion("Есть ли позитив");
        x = getInt("Введите целое число");

        if (isPositive(x))
        {
            putSuccess("Это положительное число");
        }
        else
        {
            putSuccess("Это не положительное число");
        }

        // End act 2
        // Act 3

        putQuestion("Большая буква");
        c = getChar("Введите один символ");

        if (isUpperCase(c))
        {
            putSuccess("Это заглавная буква");
        }
        else
        {
            putSuccess("Это не заглавная буква");
        }

        // End act 3
        // Act 4

        putQuestion("Делитель");
        a = getInt("первое число не равное 0", v -> v != 0);
        b = getInt("второе число не равное 0", v -> v != 0);

        if (isDivisor(a, b))
        {
            putSuccess("Одно из введенных чисел делит другое нацело");
        }
        else
        {
            putSuccess("Ни одно из введенных чисел не делит другое нацело");
        }

        // End act 4
        // Act 5

        putQuestion("Многократный вызов");
        a = getInt("Введите 1-е целое число");

        for (int i = 1; i < 5; ++i)
        {
            b = getInt(String.format("Введите %d-е целое число", i + 1));
            a = lastNumSum(a, b);
        }

        putSuccess("Сумма цифр введенных чисел из разряда единиц равна " + a);

        // End act 5
    }

    public void run2()
    {
        int x, a, b, c;
        String s;

        putMessage("ЗАДАНИЕ 2");

        // Act 1

        putQuestion("Безопасное деление");
        a = getInt("Введите первое целое число");
        b = getInt("Введите второе целое число");
        putSuccess("Результат безопасного деления равен " + safeDiv(a, b));

        // End act 1
        // Act 2

        putQuestion("Строка сравнения");
        a = getInt("Введите первое целое число");
        b = getInt("Введите второе целое число");
        putSuccess("Результирующая строка сравнения: " + makeDecision(a, b));

        // End act 2
        // Act 3

        putQuestion("Тройная сумма");
        a = getInt("Введите первое целое число");
        b = getInt("Введите второе целое число");
        c = getInt("Введите третье целое число");

        if (sum3(a, b, c))
        {
            putSuccess("Можно сложить два числа так, чтобы получить третье");
        }
        else
        {
            putSuccess("Нельзя сложить два числа так, чтобы получить третье");
        }

        // End act 3
        // Act 4

        putQuestion("Возраст");
        x = getInt("Введите целое число");
        putSuccess("Результирующая строка: " + age(x));

        // End act 4
        // Act 5

        putQuestion("Вывод дней недели");
        s = getString("Введите наименование дня недели");
        putSuccess("Результат:");
        printDays(s);

        // End act 5
    }

    public void run3()
    {
        int x, a, b;

        putMessage("ЗАДАНИЕ 3");

        // Act 1

        putQuestion("Числа наоборот");
        x = getInt("положительное число", v -> v > 0);
        putSuccess("Результат: " + reverseListNums(x));

        // End act 1
        // Act 2

        putQuestion("Степень числа");
        a = getInt("Введите целое число");
        b = getInt("положительное число", v -> v >= 0);
        putSuccess("Результат возведения в степень: " + pow(a, b));

        // End act 2
        // Act 3

        putQuestion("Одинаковость");
        x = getInt("Введите целое число");

        if (equalNum(x))
        {
            putSuccess("Все цифры числа одинаковы");
        }
        else
        {
            putSuccess("Не все цифры числа одинаковы");
        }

        // End act 3
        // Act 4

        putQuestion("Левый треугольник");
        x = getInt("положительное число", v -> v > 0);
        putSuccess("Результат:");
        leftTriangle(x);

        // End act 4
        // Act 5

        putQuestion("Угадайка");
        guessGame();

        // End act 5
    }

    public void run4()
    {
        int[] a1, a2, a3;
        int x, y;

        putMessage("ЗАДАНИЕ 4");
        putQuestion("Задайте параметры генерации массива, по порядку: размер, минимум, максимум");

        int c = getInt("положительное число", v -> v > 0);
        int l = getInt("Введите целое число");
        int u = getInt("число больше " + l, v -> v > l);

        a1 = generate(c, l, u);
        a2 = generate(c, l, u);

        putSuccess("Сгенерирован массив А: " + printArray(a1));
        putSuccess("Сгенерирован массив Б: " + printArray(a2));

        // Act 1

        putQuestion("Поиск последнего значения");
        x = getInt("Введите целое число");
        putSuccess("Индекс последнего вхождения в массиве А: " + findLast(a1, x));

        // End act 1
        // Act 2

        putQuestion("Добавление в массив");
        x = getInt("Введите целое число");
        y = getInt("индекс в массиве А", v -> v >= 0 && v <= c);
        a3 = add(a1, x, y);
        putSuccess("Измененный массив: " + printArray(a3));

        // End act 2
        // Act 3

        putQuestion("Реверс");
        reverse(a1);
        putSuccess("Обращенный массив А: " + printArray(a1));

        // End act 3
        // Act 4

        putQuestion("Объединение");
        a3 = concat(a1, a2);
        putSuccess("Объединение массивов А и Б: " + printArray(a3));

        // End act 4
        // Act 5

        putQuestion("Удалить негатив");
        a3 = deleteNegative(a1);
        putSuccess("Массив А после удаления негатива: " + printArray(a3));

        // End act 5
    }

    // Action functions 1

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

    // End action functions 1

    // Action functions 2

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

    // End action functions 2

    // Action functions 3

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
            int y = getInt("число от 0 до 9", v -> v >= 0 && v <= 9);
            isGuessed = x == y;

            if (isGuessed)
            {
                putSuccess("Вы угадали!");
            }
            else
            {
                putWarning("Вы не угадали, попробуйте ещё раз");
            }
        }

        putSuccess("Вы отгадали число за " + k + " попытки");
    }

    // End action functions 3

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

    // Action functions 4

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

    // End action functions 4

    // Output functions

    public static void putSuccess(String text)
    {
        System.out.println(Colour.GREEN + ">> " + Colour.RESET + text);
    }

    public static void putWarning(String text)
    {
        System.out.println(Colour.YELLOW + "## " + Colour.RESET + text);
    }

    public static void putError(String text)
    {
        System.out.println(Colour.RED + "!! " + Colour.RESET + text);
    }

    public static void putMessage(String text)
    {
        System.out.println(Colour.MAGENTA + "\n:: " + Colour.RESET + text);
    }

    public static void putQuestion(String text)
    {
        System.out.println(Colour.CYAN + "\n?? " + Colour.RESET + text);
    }

    public static void putPrompt(String text)
    {
        System.out.print("\n" + text + ": ");
    }

    // End output functions
    // Input functions

    public static void pause()
    {
        System.out.print("Нажмите Enter для продолжения...");
        _scan.nextLine();
    }

    public static String getString(String prompt)
    {
        boolean e;
        String x = "";

        do
        {
            try
            {
                putPrompt(prompt);
                x = _scan.nextLine();
                e = false;

                if (x.isEmpty())
                {
                    putError("Ожидается непустая строка");
                    e = true;
                }
            }
            catch (Exception ex)
            {
                putError("Неизвестная ошибка, возврат значения по умолчанию");
                e = false;
            }
        }
        while (e);

        return x;
    }

    public static int getInt(String prompt)
    {
        String q;
        boolean e;
        int x = 0;

        do
        {
            try
            {
                putPrompt(prompt);
                q = _scan.nextLine();
                x = Integer.parseInt(q);
                e = false;
            }
            catch (NumberFormatException ex)
            {
                putError("Ожидается целое число");
                e = true;
            }
            catch (Exception ex)
            {
                putError("Неизвестная ошибка, возврат значения по умолчанию");
                e = false;
            }
        }
        while (e);

        return x;
    }

    public static char getChar(String prompt)
    {
        String q;
        boolean e;
        char x = 0;

        do
        {
            try
            {
                putPrompt(prompt);
                q = _scan.nextLine();

                if (!q.isEmpty())
                {
                    if (q.length() > 1)
                    {
                        putWarning("Лишние символы игнорируются");
                    }
                    x = q.charAt(0);
                    e = false;
                }
                else
                {
                    putError("Ожидается символ");
                    e = true;
                }
            }
            catch (Exception ex)
            {
                putError("Неизвестная ошибка, возврат значения по умолчанию");
                e = false;
            }
        }
        while (e);

        return x;
    }

    public static int getInt(String prompt, Predicate<Integer> cond)
    {
        boolean e;
        int x = 0;

        do
        {
            x = getInt("Введите " + prompt);
            e = false;

            if (!cond.test(x))
            {
                putError("Ожидается " + prompt);
                e = true;
            }
        }
        while (e);

        return x;
    }

    public static int getChoice(String prompt, String[] items)
    {
        int x = 0;

        int c = items.length;
        StringBuilder s = new StringBuilder();

        s.append(prompt);
        s.append('\n');

        for (int i = 0; i < c; ++i)
        {
            s.append(i + 1);
            s.append(": ");
            s.append(items[i]);
            s.append('\n');
        }

        s.append(c + 1);
        s.append(": Отмена");

        putQuestion(s.toString());
        x = getInt("номер элемента", v -> v >= 1 && v <= c + 1);

        return x - 1;
    }

    // End input functions
}