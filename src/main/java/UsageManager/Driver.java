package UsageManager;


public class Driver extends AppUser {
    private int driverID;
    private int licenseNo;
    private String name;

    public Driver(int driverID, int licenseNo, String name) {
        this.driverID = driverID;
        this.licenseNo = licenseNo;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void scheduleAppointment() {}
    public void shareDataConsent() {}
    public void viewVehicleData() {}
}

