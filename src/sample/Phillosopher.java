package sample;

public class Phillosopher implements Runnable {

    private final Object left_fork;
    private final Object right_fork;

    Phillosopher(Object left,Object right){
        this.left_fork = left;
        this.right_fork = right;
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    @Override
    public void run() {
        try {
            while (true) {

                // mysli
                doAction(System.nanoTime() + ": Thinking");

                synchronized (left_fork) {

                    doAction(System.nanoTime()+ ": Picked up left fork");

                    synchronized (right_fork) {
                        // zaczyna jesc
                        doAction(System.nanoTime() + ": Picked up right fork - eating");

                        doAction(System.nanoTime()+ ": Put down right fork");
                    }

                    // konczy jesc i mysli
                    doAction(System.nanoTime()+ ": Put down left fork. Back to thinking");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
