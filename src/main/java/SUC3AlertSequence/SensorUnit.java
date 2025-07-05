package SUC3AlertSequence;

// === SensorUnit.java ===
public class SensorUnit {
    public Alert detectAlert() {
        System.out.println("SensorUnit: Detecting alert...");
        return new Alert("High", "Engine overheating");
    }
}

