package SUC3AlertSequence;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    private TextArea outputArea;
    private ComboBox<String> severitySelector;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("SUC-3: Receive Alerts Simulation");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);

        severitySelector = new ComboBox<>();
        severitySelector.getItems().addAll("High", "Medium", "Low");
        severitySelector.setPromptText("Select Alert Severity");

        Button simulateButton = new Button("Simulate Alert");
        simulateButton.setOnAction(e -> simulate());

        Button resetButton = new Button("Reset");
        resetButton.setOnAction(e -> outputArea.clear());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(severitySelector, simulateButton, resetButton, outputArea);

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void simulate() {
        String severity = severitySelector.getValue();
        if (severity == null) {
            outputArea.appendText("Please select an alert severity level.\n");
            return;
        }

        outputArea.appendText("SensorUnit: Detecting alert...\n");
        outputArea.appendText("Driver received alert: Engine overheating\n");

        switch (severity) {
            case "High":
                outputArea.appendText("Driver requested maintenance for: Engine overheating\n");
                outputArea.appendText("Mechanic received maintenance request for: Engine overheating\n");
                outputArea.appendText("Mechanic requested vehicle data access from driver.\n");
                outputArea.appendText("Driver granted vehicle data access to mechanic.\n");
                outputArea.appendText("VehicleProxy: Retrieving vehicle data...\n");
                outputArea.appendText("Mechanic received vehicle data: Vehicle Data: {Speed=90, Temp=105C}\n");
                break;
            case "Medium":
                outputArea.appendText("Driver noted the issue and chose to monitor the situation.\n");
                outputArea.appendText("Alert stored in system.\n");
                break;
            case "Low":
                outputArea.appendText("Driver received minor alert. No action taken.\n");
                break;
        }

        outputArea.appendText("Simulation complete.\n\n");
    }
}
