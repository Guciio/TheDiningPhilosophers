package sample;

public class Phillosopher implements Runnable {

    private Object left_fork;
    private Object right_fork;

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

    }
}
