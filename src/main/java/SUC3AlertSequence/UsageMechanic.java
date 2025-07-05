package SUC3AlertSequence;

// === UsageMechanic.java ===
public class UsageMechanic {
    public void receiveMaintenanceRequest(Alert alert) {
        System.out.println("Mechanic received maintenance request for: " + alert.getMessage());
    }

    public void requestVehicleData() {
        System.out.println("Mechanic requested vehicle data access from driver.");
    }

    public void receiveVehicleData(String data) {
        System.out.println("Mechanic received vehicle data: " + data);
    }
}
