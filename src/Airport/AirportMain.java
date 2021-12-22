package Airport;

public class AirportMain {
    public static void main(String[] args) {
        Runnable p1 = new Airplane();
        Thread t1 = new Thread(p1);
        Runnable p2 = new Airplane();
        Thread t2 = new Thread(p2);
        Runnable p3 = new Airplane();
        Thread t3 = new Thread(p3);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Airport is closing down");
    }
}
