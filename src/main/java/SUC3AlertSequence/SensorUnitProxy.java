package SUC3AlertSequence;

// === SensorUnitProxy.java ===
public class SensorUnitProxy {
    private SensorUnit sensor;

    public SensorUnitProxy(SensorUnit sensor) {
        this.sensor = sensor;
    }

    public Alert getAlert() {
        return sensor.detectAlert();
    }
}
