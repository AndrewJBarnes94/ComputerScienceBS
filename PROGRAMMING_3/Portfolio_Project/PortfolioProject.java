package PROGRAMMING_3.Portfolio_Project;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class PortfolioProject {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static int count = 0;
    private static boolean countingUpCompleted = false;

    public static void main(String[] args) {
        int upStart = 0;
        int upEnd = 20;
        int downStart = 19;
        int downEnd = 0;
        int sleepDuration = 50; // milliseconds

        Thread firstThread = new Thread(() -> countUp(upStart, upEnd, sleepDuration));
        Thread secondThread = new Thread(() -> countDown(downStart, downEnd, sleepDuration));

        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void countUp(int start, int end, int sleepDuration) {
        for (int i = start; i <= end; i++) {
            lock.lock();
            try {
                count = i;
                System.out.println("Count: " + count);
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        lock.lock();
        try {
            countingUpCompleted = true;
            condition.signal();  // Notify the waiting thread for count down execution
        } finally {
            lock.unlock();
        }
    }

    private static void countDown(int start, int end, int sleepDuration) {
        lock.lock();
        try {
            while (!countingUpCompleted) {
                condition.await();  // Wait until countingUpCompleted is true
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }

        for (int i = start; i >= end; i--) {
            lock.lock();
            try {
                count = i;
                System.out.println("Count: " + count);
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

