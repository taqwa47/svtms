package SUC3AlertSequence;

// === VehicleProxy.java ===
public class VehicleProxy {
    public String getVehicleData() {
        System.out.println("VehicleProxy: Retrieving vehicle data...");
        return "Vehicle Data: {Speed=90, Temp=105C}";
    }
}
