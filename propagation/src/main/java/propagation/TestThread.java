package propagation;

public class TestThread {

    private void sync_fun1() throws InterruptedException {
        synchronized ("".getClass()) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    private void sync_fun2() throws InterruptedException {
        synchronized (String.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static void main(String args[]) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    new TestThread().sync_fun1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    new TestThread().sync_fun2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}