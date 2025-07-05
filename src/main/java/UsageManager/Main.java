package UsageManager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        ComboBox<String> selector = new ComboBox<>();
        selector.getItems().addAll(
                "Driver", "Mechanic", "Manufacturer",
                "Insurance Company", "Vehicle",
                "Sensor Unit Proxy", "Vehicle Proxy", "Alert",
                "Usage Driver", "Usage Mechanic", "Usage Manufacturer", "Usage Insurance Company"
        );
        selector.setValue("Driver");

        VBox formArea = new VBox(10);
        Label output = new Label();

        Button actionButton = new Button("Run");
        VBox root = new VBox(15, selector, formArea, actionButton, output);
        root.setPrefSize(450, 400);

        selector.setOnAction(e -> {
            formArea.getChildren().clear();
            output.setText("");
            switch (selector.getValue()) {
                case "Driver" -> setupDriverForm(formArea, output);
                case "Mechanic" -> setupMechanicForm(formArea, output);
                case "Manufacturer" -> setupManufacturerForm(formArea, output);
                case "Insurance Company" -> setupInsuranceForm(formArea, output);
                case "Vehicle" -> setupVehicleForm(formArea, output);
                case "Sensor Unit Proxy" -> setupSensorForm(formArea, output);
                case "Vehicle Proxy" -> setupVehicleProxyForm(formArea, output);
                case "Alert" -> setupAlertForm(formArea, output);
                case "Usage Driver" -> setupUsageDriverForm(formArea, output);
                case "Usage Mechanic" -> setupUsageMechanicForm(formArea, output);
                case "Usage Manufacturer" -> setupUsageManufacturerForm(formArea, output);
                case "Usage Insurance Company" -> setupUsageInsuranceCompanyForm(formArea, output);
            }
        });

        selector.getOnAction().handle(null); // Load initial form
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Usage Manager Demo");
        stage.show();
    }

    // --- Existing setup methods omitted for brevity ---

    private void setupDriverForm(VBox form, Label output) {
        TextField name = new TextField("Ali");
        TextField license = new TextField("123456");
        TextField vehicleData = new TextField("Mileage: 14,000km | Status: Healthy");
        form.getChildren().addAll(new Label("Name:"), name, new Label("License No:"), license,
                new Label("Vehicle Data:"), vehicleData);
        form.getChildren().add(createRunButton(() -> {
            Driver d = new Driver(1, Integer.parseInt(license.getText()), name.getText());
            UsageDriver u = new UsageDriver() {
                public String accessVehicleData() {
                    return vehicleData.getText();
                }
            };
            output.setText("Driver Name: " + d.getName() + "\nVehicle: " + u.accessVehicleData());
        }));
    }

    private void setupMechanicForm(VBox form, Label output) {
        TextField id = new TextField("2001");
        TextField name = new TextField("Ahmad");
        TextField expertise = new TextField("Engine");
        form.getChildren().addAll(new Label("Mechanic ID:"), id, new Label("Name:"), name,
                new Label("Expertise:"), expertise);
        form.getChildren().add(createRunButton(() -> output.setText("Mechanic: " + name.getText() +
                "\nExpertise: " + expertise.getText())));
    }

    private void setupManufacturerForm(VBox form, Label output) {
        TextField name = new TextField("Toyota");
        TextField model = new TextField("Corolla, Yaris");
        form.getChildren().addAll(new Label("Company Name:"), name, new Label("Models Tracked:"), model);
        form.getChildren().add(createRunButton(() -> output.setText("Manufacturer: " + name.getText() +
                "\nModels: " + model.getText())));
    }

    private void setupInsuranceForm(VBox form, Label output) {
        TextField name = new TextField("Axa Insurance");
        TextField policy = new TextField("P001, P002");
        form.getChildren().addAll(new Label("Company Name:"), name, new Label("Policy List:"), policy);
        form.getChildren().add(createRunButton(() -> output.setText("Insurance: " + name.getText() +
                "\nPolicies: " + policy.getText())));
    }

    private void setupVehicleForm(VBox form, Label output) {
        TextField model = new TextField("Corolla");
        TextField year = new TextField("2020");
        TextField mileage = new TextField("15000");
        TextField status = new TextField("Running");
        form.getChildren().addAll(new Label("Model:"), model, new Label("Year:"), year,
                new Label("Mileage:"), mileage, new Label("Status:"), status);
        form.getChildren().add(createRunButton(() -> output.setText(
                "Model: " + model.getText() +
                        "\nYear: " + year.getText() +
                        "\nMileage: " + mileage.getText() +
                        "\nStatus: " + status.getText())));
    }

    private void setupSensorForm(VBox form, Label output) {
        TextField sensorID = new TextField("S123");
        TextField reading = new TextField("38.5");
        TextField type = new TextField("Temp");
        TextField status = new TextField("Normal");
        form.getChildren().addAll(new Label("Sensor ID:"), sensorID, new Label("Reading:"), reading,
                new Label("Type:"), type, new Label("Status:"), status);
        form.getChildren().add(createRunButton(() -> output.setText("Sensor: " + sensorID.getText() +
                "\nReading: " + reading.getText() + " | Type: " + type.getText() + " | Status: " + status.getText())));
    }

    private void setupVehicleProxyForm(VBox form, Label output) {
        TextField vin = new TextField("1HGCM82633A123456");
        TextField location = new TextField("Jerusalem");
        form.getChildren().addAll(new Label("VIN:"), vin, new Label("Location:"), location);
        form.getChildren().add(createRunButton(() -> output.setText("Vehicle Proxy:\nVIN: " + vin.getText() +
                "\nLocation: " + location.getText())));
    }

    private void setupAlertForm(VBox form, Label output) {
        TextField alertID = new TextField("A001");
        TextField type = new TextField("Engine");
        TextField severity = new TextField("High");
        form.getChildren().addAll(new Label("Alert ID:"), alertID,
                new Label("Type:"), type,
                new Label("Severity:"), severity);
        form.getChildren().add(createRunButton(() -> output.setText("Alert: " + alertID.getText() +
                "\nType: " + type.getText() + " | Severity: " + severity.getText())));
    }

    private void setupUsageDriverForm(VBox form, Label output) {
        form.getChildren().add(createRunButton(() -> {
            UsageDriver ud = new UsageDriver();
            String data = ud.accessVehicleData();
            String service = ud.scheduleService();
            String alerts = ud.viewAlerts();
            output.setText(data + "\n" + service + "\n" + alerts);
        }));
    }
    private void setupUsageMechanicForm(VBox form, Label output) {
        form.getChildren().add(createRunButton(() -> {
            UsageMechanic um = new UsageMechanic();
            String fix = um.confirmFix();
            String diag = um.readDiagnostic();
            String repair = um.updateRepairAct();
            output.setText(fix + "\n" + diag + "\n" + repair);
        }));
    }

    private void setupUsageManufacturerForm(VBox form, Label output) {
        form.getChildren().add(createRunButton(() -> {
            UsageManufacturer um = new UsageManufacturer();
            String msg1 = um.receiveTrend();
            String msg2 = um.requestUsageAnalytics();
            output.setText(msg1 + "\n" + msg2);
        }));
    }

    private void setupUsageInsuranceCompanyForm(VBox form, Label output) {
        form.getChildren().add(createRunButton(() -> {
            UsageInsuranceCompany uic = new UsageInsuranceCompany();
            String calc = uic.calculatePolicyCover();
            String report = uic.viewVehicleReport();
            output.setText(calc + "\n" + report);
        }));
    }

    private Button createRunButton(Runnable action) {
        Button b = new Button("Submit");
        b.setOnAction(e -> action.run());
        return b;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
