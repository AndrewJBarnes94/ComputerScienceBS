#include <iostream>
#include <thread>
#include <mutex>
#include <condition_variable>

std::mutex mutex;
std::condition_variable conditionVariable;
int count = 0;
bool countingUpCompleted = false;

void countUp(int start, int end, int sleepDuration) {
    for (int i = start; i <= end; ++i) {
        {
            std::lock_guard<std::mutex> lock(mutex);
            count = i;
            std::cout << "Count: " << count << std::endl;
        }
        std::this_thread::sleep_for(std::chrono::milliseconds(sleepDuration));
    }
    {
        std::lock_guard<std::mutex> lock(mutex);
        countingUpCompleted = true;
    }
    conditionVariable.notify_one();  // Notify the waiting thread for count down execution
}

void countDown(int start, int end, int sleepDuration) {
    std::unique_lock<std::mutex> lock(mutex);
    conditionVariable.wait(lock, [] { return countingUpCompleted; });
    for (int i = start; i >= end; --i) {
        count = i;
        std::cout << "Count: " << count << std::endl;
        lock.unlock();
        std::this_thread::sleep_for(std::chrono::milliseconds(sleepDuration));
        lock.lock();
    }
}

int main() {
    int upStart = 0;
    int upEnd = 20;
    int downStart = 19;
    int downEnd = 0;
    int sleepDuration = 50; // milliseconds

    std::thread firstThread(countUp, upStart, upEnd, sleepDuration);
    std::thread secondThread(countDown, downStart, downEnd, sleepDuration);

    firstThread.join();
    secondThread.join();

    return 0;
}
