package AdvJava;

public class MultiThreadConcurrency {
    public static void main(String[] args) {
        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());

        // for (int i = 0; i < 10; i++) {
        //     Thread thread = new Thread(new DownloadingTask());
        //     thread.start();
        // }

        // Joining Threads (wait for completion)
        Thread thread = new Thread(new DownloadingTask());
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("File is ready to be scanned.");
    }
}

class DownloadingTask implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Downloading Task - " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Downloading Completed - " + Thread.currentThread().getName());

    }
}
