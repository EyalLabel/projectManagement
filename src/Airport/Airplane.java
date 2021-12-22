package Airport;

public class Airplane implements Runnable{
   protected static int counter=1001;
private int planeId;
    @Override
    public void run() {
        synchronized (Airplane.class){
            takeOff();
        }
        flying();
        synchronized (Airplane.class){
            landing();
        }
    }

    private void landing() {
        System.out.println("Plane #"+planeId+" is requesting to land");
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            System.out.println("Was not able to land");
        }
        System.out.println("Plane #"+planeId+" begins landing process");
        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            System.out.println("Was not able to land");
        }
        System.out.println("Plane #"+planeId+" landed successfully");
    }

    private void flying() {
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            System.out.println("MAYDAY");
        }
        System.out.println("Plane #"+planeId+" is flying at a speed of "+(int)(Math.random()*1000+200)+"ms");
    }

    public void  takeOff(){
        System.out.println("Plane#"+planeId+" Requesting take off");
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            System.out.println("Take off interrupted");
        }
        System.out.println("Plane#"+planeId+" Taking off");
        try {
            Thread.sleep(1000*2);
        } catch (InterruptedException e) {
            System.out.println("Take off interrupted");
        }
        System.out.println("Plane#"+planeId+" finished taking off");
    }

    public Airplane() {
        this.planeId = counter;
        counter+=1;
    }
}
