package propagation;

public class VolatileTest implements Runnable {

    // boolean flag = false;
    volatile boolean flag = false;

    public void loop() {
        while (!flag) {
            continue;
        }
        System.exit(0);
    }

    public void set() {
        flag = true;
        System.out.println("set");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest target = new VolatileTest();
        Thread t1 = new Thread(target, "t1");
        Thread t2 = new Thread(target, "t2");
        t1.start();
        Thread.sleep(5);
        t2.start();
    }

    @Override
    public void run() {

        if (Thread.currentThread().getName().equals("t1")) {
            loop();
        }
        if (Thread.currentThread().getName().equals("t2")) {
            set();
        }
    }
}