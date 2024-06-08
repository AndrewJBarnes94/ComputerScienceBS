package PROGRAMMING_3.Discussion8;

class SensorReadException extends Exception {
    public SensorReadException(String message) {
        super(message);
    }
}

class Sensor {
    private String sensorId;
    private double sensorValue;

    public Sensor(String sensorId) {
        this.sensorId = sensorId;
    }

    public void readSensor() throws SensorReadException {
        if (Math.random() > 0.7) {
            throw new SensorReadException("Failed to read sensor with ID: " + sensorId);
        }

        this.sensorValue = Math.random() * 100; // Simulate a sensor value
    }

    public double getSensorValue() {
        return sensorValue;
    }

    public String getSensorId() {
        return sensorId;
    }
}

public class Sensors {
    public static void main(String[] args) {
        Sensor temperatureSensor = new Sensor("T-100");

        try {
            temperatureSensor.readSensor();
            System.out.println("Sensor " + temperatureSensor.getSensorId() + " value: " + temperatureSensor.getSensorValue());
        } catch (SensorReadException e) {
            System.err.println("Error: " + e.getMessage());
        }

        Sensor pressureSensor = new Sensor("P-200");

        try {
            pressureSensor.readSensor();
            System.out.println("Sensor " + pressureSensor.getSensorId() + " value: " + pressureSensor.getSensorValue());
        } catch (SensorReadException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
