package sample;

public class Phillosopher implements Runnable {

    private final Object left_fork;
    private final Object right_fork;

    Phillosopher(Object left,Object right){
        this.left_fork = left;
        this.right_fork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 10000)));
    }

    @Override
    public void run() {
        try {
            while (true) {

                // mysli
                doAction(" Thinking");

                synchronized (left_fork) {

                    doAction(" Picked up left fork");

                    synchronized (right_fork) {
                        // zaczyna jesc
                        doAction(" Picked up right fork - eating");

                        doAction(" Put down right fork");
                    }

                    // konczy jesc i mysli
                    doAction(" Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
