import java.io.IOException;

/**
 * Created by kszorin on 05.02.2017.
 */
public class Appearance {
    public static void main (String[] args) {
        Poema poema = new Poema();

        System.out.println("Старт программы. Создание потоков:");

        Poet p0 = new Poet (0, 500, poema);
        Poet p1 = new Poet (1, 500, poema);
        Poet p2 = new Poet (2, 500, poema);

        try {
            p0.t.join();
            p1.t.join();
            p2.t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Стихотворение в главном потоке
        /*String str;
        while ((str=poema.getNext()) != null)
            System.out.println(str + " ");*/
        System.out.println("Завершение программы.");
    }
}
