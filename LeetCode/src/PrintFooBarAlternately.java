public class PrintFooBarAlternately {
    class FooBar {
        private final Object lock = new Object();
        private volatile boolean start = false;
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            synchronized (lock) {
                for (int i = 0; i < n; i++) {
                    while (start) lock.wait();
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    start = true;
                    lock.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (lock) {
                for (int i = 0; i < n; i++) {
                    while (!start) lock.wait();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    start = false;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        FooBar bar = new PrintFooBarAlternately().new FooBar(10);
        new Thread() {
            @Override
            public void run() {
                try {
                    bar.bar(() -> System.out.println("bar"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    bar.foo(() -> System.out.println("foo"));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
