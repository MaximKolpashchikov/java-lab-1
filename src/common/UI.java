package common;

import java.util.Scanner;
import java.util.function.Predicate;

public final class UI
{
    private static final Scanner _scan = new Scanner(System.in);

    public static void close()
    {
        _scan.close();
    }

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