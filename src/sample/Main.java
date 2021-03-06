package sample;


public class Main  {

    public static void main(String[] args) throws Exception {

        Phillosopher[] philosophers = new Phillosopher[5];
        Object[] forks = new Object[philosophers.length];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {

            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Phillosopher(leftFork, rightFork);

            if (i == philosophers.length - 1) {
                // Ostatni bierze prawego pierwszego
                philosophers[i] = new Phillosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Phillosopher(leftFork, rightFork);
            }

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}