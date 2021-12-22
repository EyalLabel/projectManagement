package Threads;

import java.util.ArrayList;
import java.util.List;

public class TestingGround {
    public static void main(String[] args) {
Runnable c1=new ThRad();
Thread t1=new Thread(c1);
t1.start();
       List<Thread> clocks=new ArrayList<>();
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
