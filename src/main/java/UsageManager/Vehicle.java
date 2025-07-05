package UsageManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// === Vehicle.java ===
public class Vehicle {
    private float mileage;
    private String model;
    private Map<String, String> sensorData;
    private String status;
    private int year;

    public List<Alert> getAlerts() {
        return new ArrayList<>();
    }

    public void storeInDB() {
    }

    public void updateSensorData() {
    }
}
