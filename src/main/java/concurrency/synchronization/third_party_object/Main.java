package concurrency.synchronization.third_party_object;

public class Main {

    public static void main(String[] args) {
        Resource resourceA = new Resource();
        Resource resourceB = new Resource();

        Runnable actionPerformer1 = new ActionPerformer(resourceA, resourceB);
        Runnable actionPerformer2 = new ActionPerformer(resourceB, resourceA);

        Thread thread0 = new Thread(actionPerformer1);
        Thread thread1 = new Thread(actionPerformer2);

        thread0.start();
        thread1.start();
    }
}
