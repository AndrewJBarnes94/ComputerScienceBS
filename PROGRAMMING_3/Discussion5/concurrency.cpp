#include <iostream>
#include <map>
#include <mutex>
#include <thread>
#include <vector>

class ThreadSafeKVStore {
public:
    // Inserting the key-value pair
    void insert(const std::string& key, int value) {
        std::lock_guard<std::mutex> lock(mutex_);
        store_[key] = value;
        std::cout << "Inserted key: " << key << ", value: " << value << std::endl;
    }

    // Get the value for a provided key
    bool get(const std::string& key, int& value) const {
        std::lock_guard<std::mutex> lock(mutex_);
        auto it = store_.find(key);
        if (it != store_.end()) {
            value = it->second;
            std::cout << "Read key: " << key << ", value: " << value << std::endl;
            return true;
        }
        std::cout << "Key: " << key << " not found." << std::endl;
        return false;
    }

private:
    mutable std::mutex mutex_;
    std::map<std::string, int> store_;
};

void writer(ThreadSafeKVStore& store, const std::string& key, int value) {
    store.insert(key, value);
}

void reader(const ThreadSafeKVStore& store, const std::string& key) {
    int value;
    store.get(key, value);
}

int main() {
    ThreadSafeKVStore store;

    // Make writer threads
    std::vector<std::thread> writers;
    writers.emplace_back(writer, std::ref(store), "apple", 100);
    writers.emplace_back(writer, std::ref(store), "banana", 200);
    writers.emplace_back(writer, std::ref(store), "cherry", 300);

    // Bring together writer threads
    for (auto& writer : writers) {
        writer.join();
    }

    // Make reader threads
    std::vector<std::thread> readers;
    readers.emplace_back(reader, std::cref(store), "apple");
    readers.emplace_back(reader, std::cref(store), "banana");
    readers.emplace_back(reader, std::cref(store), "cherry");
    readers.emplace_back(reader, std::cref(store), "date"); // This key does not exist

    // Bring together reader threads
    for (auto& reader : readers) {
        reader.join();
    }

    return 0;
}
