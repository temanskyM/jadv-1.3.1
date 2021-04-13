public class Box implements Runnable {
    private static volatile boolean toggle;
    private final int COUNT_RETRY = 10;
    private final long DELAY_USER = 500;

    public void run() {
        try {
            if (Thread.currentThread().getName().equals("User")) {
                userWork();
            } else {
                computerWork();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void userWork() throws InterruptedException {
        for (int i = 0; i < COUNT_RETRY; i++) {
            System.out.println(Thread.currentThread().getName() + ". включаю переключатель");
            toggle = true;
            Thread.sleep(DELAY_USER);
        }
    }

    private void computerWork() throws InterruptedException {
        while (true) {
            if (toggle) {
                System.out.println(Thread.currentThread().getName() + ". выключаю переключатель");
                toggle = false;
                Thread.yield();
            }
        }
    }
}
