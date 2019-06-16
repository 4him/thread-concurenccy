package concurrency.synchronization.third_party_object;

public class ActionPerformer implements Runnable {

    private final Resource resource;

    public ActionPerformer(Resource resource){
        this.resource = resource;
    }

    public void run() {
        try {
            performAction();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void performAction() throws InterruptedException {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is going to get the lock for " + resource);
        synchronized (resource){ //TODO try it with (this)
            System.out.println(threadName + " possesses the lock for " + resource);
            Thread.sleep(10000);
            System.out.println(threadName + " is going to release the lock of " + resource);
        }
    }
}
