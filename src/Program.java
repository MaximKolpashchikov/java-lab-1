import common.UI;
import lab.Task1;
import lab.Task2;
import lab.Task3;
import lab.Task4;

public class Program
{
    public static void main(String[] args)
    {
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();
        Task3 t3 = new Task3();
        Task4 t4 = new Task4();

        String[] menu = {
            "Методы",
            "Условия",
            "Циклы",
            "Массивы"
        };

        int sel;

        do
        {
            sel = UI.getChoice("Выберите задание", menu);

            switch (sel)
            {
                case 0: t1.run(); break;
                case 1: t2.run(); break;
                case 2: t3.run(); break;
                case 3: t4.run(); break;
            }

            UI.pause();
        }
        while (sel < menu.length);

        UI.close();
    }
}