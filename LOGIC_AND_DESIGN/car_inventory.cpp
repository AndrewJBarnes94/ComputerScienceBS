#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

class Car {

private:

    std::string make;
    std::string model;
    int year;
    std::string color;
    double mileage;
    std::string vin;

public:

    // Constructor
    Car(
        std::string mk,
        std::string mdl,
        int yr,
        std::string clr,
        double mlg,
        std::string vn
    )
    : make(mk), model(mdl), year(yr), color(clr), mileage(mlg), vin(vn) {}

    // Getters
    std::string getMake() const {return make;}
    std::string getModel() const {return model;}
    int getYear() const {return year;}
    std::string getColor() const {return color;}
    double getMileage() const {return mileage;}    
    std::string getVIN() const {return vin;}

    // Setters    
    void setMake(std::string mk) {make = mk;}
    void setModel(std::string mdl) {model = mdl;}
    void setYear(int yr) {year = yr;}
    void setColor(std::string clr) {color = clr;}
    void setMileage(double mlg) {mileage = mlg;}
    void setVIN(std::string vn) {vin = vn;}

};

class Inventory {
    
private:

std::vector<Car> cars;

public:

void addCar(const Car& car) {
    cars.push_back(car);
}

void removeCar(const std::string& vin) {
        cars.erase(std::remove_if(cars.begin(), cars.end(), [&vin](const Car& car) {
            return car.getVIN() == vin;
        }), cars.end());
    }

int getTotalCars() const {
    return cars.size();
}

};

int main() {
    
}
