package sample;

public class Phillosopher implements Runnable {

    private Object left_fork;
    private Object right_fork;

    Phillosopher(Object left,Object right){
        this.left_fork = left;
        this.right_fork = right;
    }

    @Override
    public void run() {

    }
}
