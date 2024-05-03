#include <iostream>
#include <array>
#include <string.h>

using namespace std;

constexpr size_t MAX_DEVICES = 5;
constexpr size_t BUFFER_SIZE = 32;

array<char, BUFFER_SIZE> buffers[MAX_DEVICES];

void processSensorData(int deviceId, const char* data) {
    if (deviceId < 0 || deviceId >= MAX_DEVICES) {
        cerr << "Incorrect Device ID" << endl;
        return;
    }

    // Buffer Overflow Simulation
    for (size_t i = 0; i < strlen(data); i++) {
        buffers[deviceId][i] = data[i]; // Doesn't check for boundary
    }
}

int main() {
    const char* dataFromDevice = "Long sensor data string from an IoT device exceeding the buffer size.";
    processSensorData(3, dataFromDevice);
}