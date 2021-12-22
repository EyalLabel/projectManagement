package Threads;

public class ThRad implements Runnable {


    @Override
    public void run() {
        for (int i = 10; i > 0; i -= 1) {
            System.out.println(i);
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                for (int j=i+1;j<11;j+=1){
                    try {
                        Thread.sleep(1000*1);
                    } catch (InterruptedException interruptedException) {
                        return;
                    }
                    System.out.println(j);
                }
                return;
            }

        }

    }
}



