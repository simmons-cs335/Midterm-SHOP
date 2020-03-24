/**
 * @author Clara Carleton
 */

public class MultithreadingMain {
    public static void main(String[] args) throws InterruptedException {
        MultithreadingProducer p1 = new MultithreadingProducer(1);
        MultithreadingProducer p2 = new MultithreadingProducer(2);
        MultithreadingProducer p3 = new MultithreadingProducer(3);
        MultithreadingProducer p4 = new MultithreadingProducer(4);
        MultithreadingProducer p5 = new MultithreadingProducer(5);
        MultithreadingProducer p6 = new MultithreadingProducer(6);
        MultithreadingProducer p7 = new MultithreadingProducer(7);
        MultithreadingProducer p8 = new MultithreadingProducer(8);
        MultithreadingProducer p9 = new MultithreadingProducer(9);
        MultithreadingProducer p10 = new MultithreadingProducer(10);

        MultithreadingUser m1 = new MultithreadingUser(1);
        MultithreadingUser m2 = new MultithreadingUser(2);
        MultithreadingUser m3 = new MultithreadingUser(3);
        MultithreadingUser m4 = new MultithreadingUser(4);

        m1.start();
        m2.start();
        m3.start();
        m4.start();

        p1.start();
        p2.start();
        p1.sleep(1000);
        p3.start();
        p4.start();
        p2.sleep(1000);
        p4.sleep(1000);
        p3.sleep(1000);


        m2.sleep(1000);
        m1.sleep(1000);

        p5.start();
        p6.start();
        p5.sleep(1000);
        p7.start();
        p8.start();
        p6.sleep(1000);
        p8.sleep(1000);
        p7.sleep(1000);

        m1.sleep(1000);

        p9.start();
        p10.start();
        p10.sleep(1000);
        p9.sleep(1000);


    }
}
