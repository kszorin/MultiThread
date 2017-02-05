/**
 * Created by kszorin on 05.02.2017.
 */
public class Poet implements Runnable {
    public Thread t;
    private int nThread;
    private String constantMsg;
    private Poema poema;
    private int delay=1000;


    public Poet (int nThread, String constantMsg) {
        this.nThread = nThread;
        this.constantMsg = constantMsg;

        t = new Thread(this, "Поток №" + nThread);
        System.out.println("Создан поток №" + nThread);
        t.start();
    }

    public Poet (int nThread, int delay, Poema poema) {
        this.nThread = nThread;
        this.poema = poema;
        this.delay = delay;
        t = new Thread(this, "Поток №" + nThread);
        System.out.println("Создан поток №" + nThread);
        t.start();
    }

    @Override
    public void run() {
        String str;
        try {
            while (true) {
                synchronized (poema) {
                    str = poema.getNext();
                    if (str != null)
                        System.out.println(t.getName() + ": " + str);
                    else
                        break;
                }
                System.out.println(t.getName() + ": засыпаю.");
                Thread.sleep(delay);
                System.out.println(t.getName() + ": просыпаюсь.");
            }
        } catch (InterruptedException e) {
            System.out.println("Поток " + nThread + " прерван!");
        }
        System.out.println("Поток " + nThread + " завершён.");
    }
}
