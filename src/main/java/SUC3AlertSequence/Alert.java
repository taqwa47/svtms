package SUC3AlertSequence;

// === Alert.java ===
public class Alert {
    private String severity;
    private String message;

    public Alert(String severity, String message) {
        this.severity = severity;
        this.message = message;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }
}
