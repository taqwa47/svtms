package SUC3AlertSequence;

// === UsageDriver.java ===
public class UsageDriver {
    public void receiveAlert(Alert alert) {
        System.out.println("Driver received alert: " + alert.getMessage());
    }

    public void requestMaintenance(Alert alert) {
        System.out.println("Driver requested maintenance for: " + alert.getMessage());
    }

    public void grantAccess() {
        System.out.println("Driver granted vehicle data access to mechanic.");
    }
}
