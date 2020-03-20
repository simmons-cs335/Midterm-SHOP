/**
 * @ author Clara Carleton
 */

public class MultithreadingMain {
    public static void main(String[] args) throws InterruptedException {
        Multithreading m1 = new Multithreading(1);
        Multithreading m2 = new Multithreading(2);
        Multithreading m3 = new Multithreading(3);
        Multithreading m4 = new Multithreading(4);
        m1.start();
        m2.start();
        m1.sleep(1000);
        m3.start();
        m4.start();
        m2.sleep(1000);
    }
}
