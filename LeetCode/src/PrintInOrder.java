public class PrintInOrder {
    private final Object lock = new Object();
    private volatile int index = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            index++;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (index < 1) lock.wait();
            printSecond.run();
            index++;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (index < 2) lock.wait();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }

    public static void main(String[] args) {
        PrintInOrder order = new PrintInOrder();
        f1(order);
        f2(order);
        f3(order);
    }

    private static void f1(PrintInOrder order) {
        new Thread() {
            @Override
            public void run() {
                try {
                    order.first(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("first");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void f2(PrintInOrder order) {
        new Thread() {
            @Override
            public void run() {
                try {
                    order.second(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("second");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private static void f3(PrintInOrder order) {
        new Thread() {
            @Override
            public void run() {
                try {
                    order.third(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("third");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
